# -----------------------------------------------------------------------------
# update_legend.sh
#
# Copyright (C) 2018-2024  Andy Townsend
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with this program.  If not, see <https://www.gnu.org/licenses/>.
# -----------------------------------------------------------------------------
# Designed to update legend only to latest version.
# -----------------------------------------------------------------------------
#
# The local user account we are using
#
local_filesystem_user=ajtown
local_renderd_user=_renderd
#
# First things first - is another copy of the script already running?
#
cd /home/${local_filesystem_user}/data
if test -e update_legend.running
then
    echo update_legend.running exists; exiting
    exit
else
    touch update_legend.running
fi
#
# Next get the latest versions of each part of the map style
# A legend change may still depend on style changes.
#
# This is run from sudo without a connection to an authentication agent, 
# so it makes sense for the git config url to be "https" and the pushurl "git".  
# See https://stackoverflow.com/a/73836045/8145448
#
cd /home/${local_filesystem_user}/src/SomeoneElse-style
pwd
sudo -u ${local_filesystem_user} git pull
#
cd /home/${local_filesystem_user}/src/SomeoneElse-style-legend
pwd
sudo -u ${local_filesystem_user} git pull
#
cd /home/${local_filesystem_user}/src/openstreetmap-carto-AJT
pwd
sudo -u ${local_filesystem_user} git pull
carto project.mml > mapnik.xml
#
# How much disk space are we currently using?
#
df
#
# When was the target file last modified?
#
cd /home/${local_filesystem_user}/src/SomeoneElse-style-legend
rm generated_legend_pub.osm
javac generate_legend_01.java
java generate_legend_01
#
cd /home/${local_filesystem_user}/data
#
# Run osm2pgsql
#
sudo -u ${local_renderd_user} osm2pgsql --append --slim -d gis -C 250 --number-processes 2 -S /home/${local_filesystem_user}/src/openstreetmap-carto-AJT/openstreetmap-carto.style --multi-geometry --tag-transform-script /home/${local_filesystem_user}/src/SomeoneElse-style/style.lua /home/${local_filesystem_user}/src/SomeoneElse-style-legend/legend_roads.osm
#
sudo -u ${local_filesystem_user} osmium sort -O -o /home/${local_filesystem_user}/src/SomeoneElse-style-legend/generated_legend_pubs.osm /home/${local_filesystem_user}/src/SomeoneElse-style-legend/generated_legend_pub.osm
sudo -u ${local_renderd_user} osm2pgsql --append --slim -d gis -C 250 --number-processes 2 -S /home/${local_filesystem_user}/src/openstreetmap-carto-AJT/openstreetmap-carto.style --multi-geometry --tag-transform-script /home/${local_filesystem_user}/src/SomeoneElse-style/style.lua /home/${local_filesystem_user}/src/SomeoneElse-style-legend/generated_legend_pubs.osm
#
# Restart renderd so that we see new tiles
#
/etc/init.d/renderd restart
/etc/init.d/apache2 restart
#
# Remove already generated tiles
#
#rm -rf /var/lib/mod_tile/ajt/??
#rm -rf /var/lib/mod_tile/ajt/?
# 
# And final tidying up
#
#date | mail -s "Legend reload complete on `hostname`" ${local_filesystem_user}
rm update_legend.running
#
