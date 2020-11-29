# SomeoneElse-style-legend
A manually-curated legend for [SomeoneElse-style](https://github.com/SomeoneElseOSM/SomeoneElse-style) and [OpenStreetMap-carto-AJT](https://github.com/SomeoneElseOSM/openstreetmap-carto-AJT).

There are two files here:

* [legend_roads.osm](https://github.com/SomeoneElseOSM/SomeoneElse-style-legend/blob/master/legend_roads.osm) is a file containing roads and other linear feature.  It is manually edited.
* [generated_legend_pub.osm](https://github.com/SomeoneElseOSM/SomeoneElse-style-legend/blob/master/generated_legend_pub.osm) is generated by [generate_legend_01.java](https://github.com/SomeoneElseOSM/SomeoneElse-style-legend/blob/master/generate_legend_01.java).  It contains point features, and the java program that generates it arranges the various features into rows.

The iles are designed to be appended into a database rendering [SomeoneElse-style](https://github.com/SomeoneElseOSM/SomeoneElse-style).  A different map style could be used, but fewer features would appear.

The "location" of the data for this file is in the middle of Australia.  It's designed to be somewhere "not on the map" that no-one would go to by accident.  If you want to render Australia with this style, you'd want to move this data somewhere else - just change the co-ordinates from around -24 and 135 to something else.

