# -----------------------------------------------------------------------------
# rerender_legend.sh
# -----------------------------------------------------------------------------
#
# The local user account we are using
#
local_filesystem_user=renderaccount
local_renderd_user=renderaccount
#
PATH=/home/${local_filesystem_user}/bin:/home/${local_filesystem_user}/.local/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin
#
sudo -u ${local_renderd_user} /home/${local_filesystem_user}/src/render_list_geo.pl/render_list_geo.pl -n 1 -z 1 -Z 17 -x 135 -X 135.2 -y -25.1 -Y -24.9 -m ajt -f 1
#
