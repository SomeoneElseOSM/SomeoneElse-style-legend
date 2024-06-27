# -----------------------------------------------------------------------------
# rerender_legend.sh
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
#
# The local user account we are using
#
local_filesystem_user=ajtown
local_renderd_user=_renderd
#
PATH=/home/${local_filesystem_user}/bin:/home/${local_filesystem_user}/.local/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin
#
sudo -u ${local_renderd_user} /home/${local_filesystem_user}/src/render_list_geo.pl/render_list_geo.pl -n 1 -z 1 -Z 18 -x 135 -X 135.2 -y -25.1 -Y -24.9 -m ajt -f 1
#
