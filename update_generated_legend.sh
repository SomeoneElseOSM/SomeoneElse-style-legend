# -----------------------------------------------------------------------------
# update_legend.sh
# Designed to update legend only to latest version.
# -----------------------------------------------------------------------------
#
# The local user account we are using
#
local_user=renderaccount
#
# First things first - is another copy of the script already running?
#
cd /home/${local_user}/data
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
cd /home/${local_user}/src/SomeoneElse-style
pwd
sudo -u ${local_user} git pull
#
cd /home/${local_user}/src/SomeoneElse-style-legend
pwd
sudo -u ${local_user} git pull
#
cd /home/${local_user}/src/openstreetmap-carto-AJT
pwd
sudo -u ${local_user} git pull
carto project.mml > mapnik.xml
#
# How much disk space are we currently using?
#
df
#
# When was the target file last modified?
#
cd /home/${local_user}/src/SomeoneElse-style-legend
rm generated_legend_pub.osm
javac generate_legend_01.java
java generate_legend_01
#
cd /home/${local_user}/data
#
# Run osm2pgsql
#
sudo -u ${local_user} osm2pgsql --append --slim -d gis -C 250 --number-processes 2 -S /home/${local_user}/src/openstreetmap-carto-AJT/openstreetmap-carto.style --multi-geometry --tag-transform-script /home/${local_user}/src/SomeoneElse-style/style.lua /home/${local_user}/src/SomeoneElse-style-legend/legend_roads.osm
#
sudo -u ${local_user} osm2pgsql --append --slim -d gis -C 250 --number-processes 2 -S /home/${local_user}/src/openstreetmap-carto-AJT/openstreetmap-carto.style --multi-geometry --tag-transform-script /home/${local_user}/src/SomeoneElse-style/style.lua /home/${local_user}/src/SomeoneElse-style-legend/generated_legend_pub.osm
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
#date | mail -s "Legend reload complete on `hostname`" ${local_user}
rm update_legend.running
#
