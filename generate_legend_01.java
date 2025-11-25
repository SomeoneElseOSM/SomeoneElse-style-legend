/* --------------------------------------------------------------------------
   generate_legend_01.java

   Copyright (C) 2018-2025  Andy Townsend
  
   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.
  
   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.
  
   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <https://www.gnu.org/licenses/>.
   -------------------------------------------------------------------------- */

import java.io.*;
import java.net.*;

public class generate_legend_01
{
    final static int Log_Debug_Off = 0;  // Used to turn debug off
    final static int Log_Serious = 1;    // A serious error has occurred, or we always want to output something. 
    final static int Log_Error = 2;      // An error that we can work around has occurred
    final static int Log_Warning = 3;    // Not currently used
    final static int Log_Return = 4;     // Return values from top-level subroutines

    static PrintStream myOutputOsmStream;

    final static String osmHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<osm version=\"0.6\" generator=\"OpenStreetMap server\" copyright=\"OpenStreetMap and contributors\" attribution=\"http://www.openstreetmap.org/copyright\" license=\"http://opendatacommons.org/licenses/odbl/1-0/\">\n<bounds minlat=\"-24.98769\" minlon=\"135.03282\" maxlat=\"-24.98601\" maxlon=\"135.03509\"/>";
    final static String osmTrailer = "</osm>";

    static long   startNode = 29100000000L;
    static double startLat  = -24.9850;
    static double startLon  = 135.170;
    static double incLat   = -00.0010;
    static double incLon   = 000.001;

    // writeNodeLatLon

    private static void writeNodeLatLon( PrintStream passedOutputOsmStream, long passedNodeNumber, double passedNodeLat, double passedNodeLon, 
					 String tag01, String value01,
					 String tag02, String value02,
					 String tag03, String value03,
					 String tag04, String value04,
					 String tag05, String value05,
					 String tag06, String value06,
					 String tag07, String value07 )
    {
	String osmLine = "";

	osmLine = "  <node id=\"" + String.valueOf( passedNodeNumber ) + "\" changeset=\"101472\" timestamp=\"2017-04-30T13:03:17Z\" version=\"1\" visible=\"true\" user=\"SomeoneElse\" uid=\"112\" lat=\"" + String.valueOf( passedNodeLat ) + "\" lon=\"" + String.valueOf( passedNodeLon ) + "\">";
	passedOutputOsmStream.println( osmLine );

	if ( !tag01.equals( "" ))
	     {
		 osmLine = "    <tag k=\"" + tag01 + "\" v=\"" + value01 + "\"/>";
		 passedOutputOsmStream.println( osmLine );
	     }

	if ( !tag02.equals( "" ))
	     {
		 osmLine = "    <tag k=\"" + tag02 + "\" v=\"" + value02 + "\"/>";
		 passedOutputOsmStream.println( osmLine );
	     }

	if ( !tag03.equals( "" ))
	     {
		 osmLine = "    <tag k=\"" + tag03 + "\" v=\"" + value03 + "\"/>";
		 passedOutputOsmStream.println( osmLine );
	     }

	if ( !tag04.equals( "" ))
	     {
		 osmLine = "    <tag k=\"" + tag04 + "\" v=\"" + value04 + "\"/>";
		 passedOutputOsmStream.println( osmLine );
	     }

	if ( !tag05.equals( "" ))
	     {
		 osmLine = "    <tag k=\"" + tag05 + "\" v=\"" + value05 + "\"/>";
		 passedOutputOsmStream.println( osmLine );
	     }

	if ( !tag06.equals( "" ))
	     {
		 osmLine = "    <tag k=\"" + tag06 + "\" v=\"" + value06 + "\"/>";
		 passedOutputOsmStream.println( osmLine );
	     }

	if ( !tag07.equals( "" ))
	     {
		 osmLine = "    <tag k=\"" + tag07 + "\" v=\"" + value07 + "\"/>";
		 passedOutputOsmStream.println( osmLine );
	     }

	osmLine = "  </node>";
	passedOutputOsmStream.println( osmLine );
    }

    // writeNodeRowCol all 7 pairs of tags
    private static void writeNodeRowCol( PrintStream passedOutputOsmStream, long passedNodeNumber, int passedRow, int passedCol, 
					 String tag01, String value01, String tag02, String value02, String tag03, String value03, String tag04, String value04, String tag05, String value05, String tag06, String value06, String tag07, String value07 )
    {
	long   currentNode = startNode + ( passedRow * 10000000 ) + passedCol;
	double currentLat  = startLat  + ( incLat * passedRow );
	double currentLon  = startLon  + ( incLon * passedCol );

	writeNodeLatLon( myOutputOsmStream, currentNode, currentLat, currentLon, tag01, value01, tag02, value02, tag03, value03, tag04, value04, tag05, value05, tag06, value06, tag07, value07 );
    }

    // 2 pairs of tags
    private static void writeNodeRowCol( PrintStream passedOutputOsmStream, long passedNodeNumber, int passedRow, int passedCol, 
					 String tag01, String value01, String tag02, String value02 )
    {
	String tag03 = "";
	String value03 = "";
	String tag04   = "";
	String value04 = "";
	String tag05   = "";
	String value05 = "";
	String tag06   = "";
	String value06 = "";
	String tag07   = "";
	String value07 = "";

	writeNodeRowCol( myOutputOsmStream, startNode, passedRow, passedCol, 
			 tag01, value01, 
			 tag02, value02, 
			 tag03, value03, 
			 tag04, value04, 
			 tag05, value05, 
			 tag06, value06, 
			 tag07, value07 );
    }

    // writeNodeRowCol 3 pairs of tags
    private static void writeNodeRowCol( PrintStream passedOutputOsmStream, long passedNodeNumber, int passedRow, int passedCol, 
					 String tag01, String value01, String tag02, String value02, String tag03, String value03 )
    {
	String tag04   = "";
	String value04 = "";
	String tag05   = "";
	String value05 = "";
	String tag06   = "";
	String value06 = "";
	String tag07   = "";
	String value07 = "";

	writeNodeRowCol( myOutputOsmStream, startNode, passedRow, passedCol, 
			 tag01, value01, 
			 tag02, value02, 
			 tag03, value03, 
			 tag04, value04, 
			 tag05, value05, 
			 tag06, value06, 
			 tag07, value07 );
    }

    // writeNodeRowCol 4 pairs of tags
    private static void writeNodeRowCol( PrintStream passedOutputOsmStream, long passedNodeNumber, int passedRow, int passedCol, 
					 String tag01, String value01, String tag02, String value02, String tag03, String value03, String tag04, String value04 )
    {
	String tag05   = "";
	String value05 = "";
	String tag06   = "";
	String value06 = "";
	String tag07   = "";
	String value07 = "";

	writeNodeRowCol( myOutputOsmStream, startNode, passedRow, passedCol, 
			 tag01, value01, 
			 tag02, value02, 
			 tag03, value03, 
			 tag04, value04, 
			 tag05, value05, 
			 tag06, value06, 
			 tag07, value07 );
    }

    // writeLabelledNodeRowCol all 7 pairs of tags
    private static void writeLabelledNodeRowCol( PrintStream passedOutputOsmStream, long passedNodeNumber, int passedRow, int passedCol, String labelName, 
					 String tag01, String value01, String tag02, String value02, String tag03, String value03, String tag04, String value04, String tag05, String value05, String tag06, String value06, String tag07, String value07 )
    {
	long   currentNode = startNode + ( passedRow * 10000000 ) + passedCol;
	double currentLat  = startLat  + ( incLat * passedRow );
	double currentLon  = startLon  + ( incLon * passedCol );

	writeNodeLatLon( myOutputOsmStream, currentNode, currentLat, currentLon, tag01, value01, tag02, value02, tag03, value03, tag04, value04, tag05, value05, tag06, value06, tag07, value07 );

	currentNode = startNode + ( passedRow * 10000000 ) + 1000000 + passedCol;
	currentLat  = startLat  + ( incLat * passedRow ) + 0.0002;
	currentLon  = startLon  + ( incLon * passedCol );

	writeNodeLatLon( myOutputOsmStream, currentNode, currentLat, currentLon, "place", "legend_text", "name", labelName, "", "", "", "", "", "", "", "", "", "" );
    }

    // writeLabelledNodeRowCol 2 pairs of tags
    private static void writeLabelledNodeRowCol( PrintStream passedOutputOsmStream, long passedNodeNumber, int passedRow, int passedCol, String labelName, 
					 String tag01, String value01, String tag02, String value02 )
    {
	String tag03   = "";
	String value03 = "";
	String tag04   = "";
	String value04 = "";
	String tag05   = "";
	String value05 = "";
	String tag06   = "";
	String value06 = "";
	String tag07   = "";
	String value07 = "";

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, passedRow, passedCol, labelName, 
			 tag01, value01, 
			 tag02, value02, 
			 tag03, value03, 
			 tag04, value04, 
			 tag05, value05, 
			 tag06, value06, 
			 tag07, value07 );
    }

    // writeLabelledNodeRowCol 3 pairs of tags
    private static void writeLabelledNodeRowCol( PrintStream passedOutputOsmStream, long passedNodeNumber, int passedRow, int passedCol, String labelName, 
					 String tag01, String value01, String tag02, String value02, String tag03, String value03 )
    {
	String tag04   = "";
	String value04 = "";
	String tag05   = "";
	String value05 = "";
	String tag06   = "";
	String value06 = "";
	String tag07   = "";
	String value07 = "";

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, passedRow, passedCol, labelName, 
			 tag01, value01, 
			 tag02, value02, 
			 tag03, value03, 
			 tag04, value04, 
			 tag05, value05, 
			 tag06, value06, 
			 tag07, value07 );
    }

    // writeLabelledNodeRowCol 4 pairs of tags
    private static void writeLabelledNodeRowCol( PrintStream passedOutputOsmStream, long passedNodeNumber, int passedRow, int passedCol, String labelName, 
					 String tag01, String value01, String tag02, String value02, String tag03, String value03, String tag04, String value04 )
    {
	String tag05   = "";
	String value05 = "";
	String tag06   = "";
	String value06 = "";
	String tag07   = "";
	String value07 = "";

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, passedRow, passedCol, labelName, 
			 tag01, value01, 
			 tag02, value02, 
			 tag03, value03, 
			 tag04, value04, 
			 tag05, value05, 
			 tag06, value06, 
			 tag07, value07 );
    }

    // writeLabelledNodeRowCol 5 pairs of tags
    private static void writeLabelledNodeRowCol( PrintStream passedOutputOsmStream, long passedNodeNumber, int passedRow, int passedCol, String labelName, 
					 String tag01, String value01, String tag02, String value02, String tag03, String value03, String tag04, String value04, String tag05, String value05 )
    {
	String tag06   = "";
	String value06 = "";
	String tag07   = "";
	String value07 = "";

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, passedRow, passedCol, labelName, 
			 tag01, value01, 
			 tag02, value02, 
			 tag03, value03, 
			 tag04, value04, 
			 tag05, value05, 
			 tag06, value06, 
			 tag07, value07 );
    }

    public static void main(String[] args) throws Exception 
    {
	// No argument processing (yet)

	String osmLegendFile01 = "generated_legend_pub.osm"; 
	myOutputOsmStream = new PrintStream( osmLegendFile01 );
	myOutputOsmStream.println( osmHeader );

	// Row 0 - a descriptive label
	int currentRow = 0;
	int currentCol = 5; // Displayed at col 5 to shift to right
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "place", "village", 
			 "name", "Zoom in to see items rendered at each zoom level:" );

	// Row 1 - pubs
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Pubs", 
				 "amenity", "pub", 
				 "name", "Generic Pub" );
	
	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "pub", 
			 "name", "Real Ale", 
			 "real_ale", "An interesting selection" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "pub", 
			 "name", "No Real Ale", 
			 "real_ale", "no" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "pub", 
			 "name", "Food", 
			 "food", "Some sort of description" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "pub", 
			 "name", "Non-carpeted area", 
			 "description:floor", "Tiles or Stone" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "pub", 
			 "name", "with Microbrewery", 
			 "microbrewery", "yes" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "pub", 
			 "name", "Micropub", 
			 "micropub", "yes" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "pub", 
			 "name", "Accommodation", 
			 "accommodation", "yes" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "pub", 
			 "name", "Wheelchair accessible", 
			 "wheelchair", "yes" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "pub", 
			 "name", "Limited wheelchair access", 
			 "wheelchair", "limited" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "pub", 
			 "name", "No wheelchair access", 
			 "wheelchair", "no" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "pub", 
			 "name", "Beer Garden", 
			 "beer_garden", "yes" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "pub", 
			 "name", "Outdoor Seating", 
			 "outdoor_seating", "yes" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "pub", 
			 "name", "Combination", 
			 "real_ale", "An interesting selection", 
			 "food", "Some sort of description", 
			 "microbrewery", "yes", 
			 "floor:material", "tiles",
			 "wheelchair", "yes" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "disused:amenity", "pub", 
			 "name", "Shut");

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "pub", 
			 "name", "... due to Covid 19", 
			 "opening_hours:covid19", "off" );

	// Row 2 - fast food
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Fast Food", 
				 "amenity", "fast_food", 
				 "name", "Generic Fast Food" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Wheelchair accessible", 
			 "wheelchair", "yes" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Limited wheelchair access", 
			 "wheelchair", "limited" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "No wheelchair access", 
			 "wheelchair", "no" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Fish and Chips", 
			 "cuisine", "fish_and_chips" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Chinese, Japanese, etc.", 
			 "cuisine", "chinese" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Pizza, Italian", 
			 "cuisine", "pizza" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Sandwich", 
			 "cuisine", "sandwich" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "American, Burger", 
			 "cuisine", "burger" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Chicken", 
			 "cuisine", "chicken" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Indian", 
			 "cuisine", "indian" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Coffee", 
			 "cuisine", "coffee" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Kebab, Turkish", 
			 "cuisine", "kebab" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "British", 
			 "cuisine", "british" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Regional", 
			 "cuisine", "regional" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Mexican", 
			 "cuisine", "mexican" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Greek", 
			 "cuisine", "greek" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "French", 
			 "cuisine", "french" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Seafood rather than fish or fish and chips", 
			 "cuisine", "seafood" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Ice Cream", 
			 "cuisine", "ice_cream" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Caribbean or similar", 
			 "cuisine", "caribbean" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Lebanese or similar", 
			 "cuisine", "lebanese" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Desserts", 
			 "cuisine", "dessert" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Donut", 
			 "cuisine", "donut" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Spanish or tapas", 
			 "cuisine", "spanish" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "African", 
			 "cuisine", "african" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Pies, Pasties", 
			 "cuisine", "pie" );

	// Row 3 - restaurants
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Restaurants", 
			 "amenity", "restaurant", 
			 "name", "Generic Restaurant" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "restaurant", 
			 "name", "Wheelchair accessible", 
			 "wheelchair", "yes" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "restaurant", 
			 "name", "Limited wheelchair access", 
			 "wheelchair", "limited" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "restaurant", 
			 "name", "No wheelchair access", 
			 "wheelchair", "no" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "restaccomm", 
			 "name", "with rooms" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "restaurant", 
			 "cuisine", "indian", 
			 "name", "Indian" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "restaurant", 
			 "cuisine", "chinese", 
			 "name", "Chinese" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "restaurant", 
			 "cuisine", "italian", 
			 "name", "Italian" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "restaurant", 
			 "cuisine", "fish_and_chips", 
			 "name", "Fish and Chips" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "restaurant", 
			 "cuisine", "burger", 
			 "name", "Burger" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "restaurant", 
			 "cuisine", "coffee", 
			 "name", "Coffee" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "restaurant", 
			 "cuisine", "sandwich", 
			 "name", "Sandwich" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "restaurant", 
			 "cuisine", "chicken", 
			 "name", "Chicken" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "restaurant", 
			 "cuisine", "kebab", 
			 "name", "Kebab" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "restaurant", 
			 "cuisine", "british", 
			 "name", "British" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "restaurant", 
			 "cuisine", "regional", 
			 "name", "Regional" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "restaurant", 
			 "cuisine", "mexican", 
			 "name", "Mexican" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "restaurant", 
			 "cuisine", "greek", 
			 "name", "Greek" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "restaurant", 
			 "cuisine", "french", 
			 "name", "French" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "restaurant", 
			 "cuisine", "seafood", 
			 "name", "Seafood rather than fish or fish and chips" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "restaurant", 
			 "cuisine", "ice_cream", 
			 "name", "Ice Cream restaurant" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "restaurant", 
			 "cuisine", "caribbean", 
			 "name", "Caribbean or similar" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "restaurant", 
			 "cuisine", "lebanese", 
			 "name", "Lebanese or similar" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "restaurant", 
			 "cuisine", "dessert", 
			 "name", "Desserts" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "restaurant", 
			 "cuisine", "spanish", 
			 "name", "Spanish or tapas" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "restaurant", 
			 "cuisine", "african", 
			 "name", "African" );

	// Row 4 - other eating and drinking
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Other Eating and Drinking", 
				 "amenity", "bar", 
				 "name", "Bar" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "bar", 
			 "accommodation", "yes", 
			 "name", "Bar with rooms" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "bar", 
			 "wheelchair", "yes", 
			 "name", "with wheelchair access" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "bar", 
			 "outdoor_seating", "yes", 
			 "name", "with outdoor seating" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "nightclub", 
			 "name", "Nightclub" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "social_club", 
			 "name", "Social Club" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "cafe", 
			 "name", "Cafe" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "cafe", 
			 "accommodation", "yes", 
			 "name", "Cafe with rooms" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "cafe", 
			 "wheelchair", "yes", 
			 "name", "with wheelchair access" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "cafe", 
			 "outdoor_seating", "yes", 
			 "name", "with outdoor seating" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "cafe", 
			 "cuisine", "bubble_tea", 
			 "name", "Bubble Tea" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "cafe", 
			 "cuisine", "indian", 
			 "name", "Indian cafe" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "biergarten", 
			 "name", "Biergarten" );

	// Row 5 - food shops
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Food Shops", 
			 "shop", "convenience",
			 "name", "Convenience, Kiosk, Newsagent, Food" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "zero_waste", 
			 "name", "Zero Waste / Refill Shop" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "supermarket", 
			 "name", "Supermarket" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "supermarket", 
			 "zero_waste", "only", 
			 "name", "Zero Waste Supermarket" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "health_food",
			 "name", "Health Food" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "health_food",
			 "zero_waste", "only", 
			 "name", "Zero Waste Health Food" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "bakery", 
			 "name", "Bakery" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "butcher", 
			 "name", "Butcher" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "fish", 
			 "name", "Fish" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "greengrocer", 
			 "name", "Greengrocer" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "greengrocer", 
			 "zero_waste", "only", 
			 "name", "Zero Waste Greengrocer" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "farm", 
			 "name", "Farm Shop" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "deli", 
			 "name", "Deli" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "alcohol", 
			 "name", "Alcohol" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "coffee", 
			 "name", "Coffee, Tea, etc." );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "confectionery", 
			 "name", "Confectionery" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "variety_store", 
			 "name", "Variety, Discount" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "variety_store", 
			 "zero_waste", "only", 
			 "name", "Zero waste discount" );

	// Row 6 - other shops
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Other Shops", 
				 "shop", "yes", 
				 "name", "Generic Shop" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "catalogue", 
			 "name", "Catalogue" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "clothes", 
			 "name", "Clothes, Boutique, Tailor, Fashion, Baby Goods" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "shoes", 
			 "name", "Shoes" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "gift", 
			 "name", "Gift" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "gift", 
			 "zero_waste", "only", 
			 "name", "Zero waste gift" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "toys", 
			 "name", "Toys" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "furniture", 
			 "name", "Furniture" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "homeware", 
			 "name", "Homeware" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "florist", 
			 "name", "Florist" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "doityourself", 
			 "name", "Do-It-Yourself, Hardware" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "doityourself", 
			 "zero_waste", "only", 
			 "name", "Zero waste hardware" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "locksmith", 
			 "name", "Locksmith" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "shoe_repair_etc", 
			 "name", "Shoe Repair etc." );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "storage_rental", 
			 "name", "Storage Rental" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "electrical", 
			 "name", "Electrical" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "electronics", 
			 "name", "Electronics" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "mobile_phone", 
			 "name", "Mobile Phone" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "computer", 
			 "name", "Computer" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "bicycle", 
			 "name", "Bike Shop" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "jewellery", 
			 "name", "Jewellery, Watches" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "department_store", 
			 "name", "Department Store" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "sports", 
			 "name", "Sports, Fishing, Scuba Diving" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "garden_centre", 
			 "name", "Garden Centre" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "outdoor", 
			 "name", "Outdoor" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "art", 
			 "name", "Art" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "photo", 
			 "name", "Photo" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "charity", 
			 "name", "Charity" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "antiques", 
			 "name", "Antiques" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "e-cigarette", 
			 "name", "E-Cigarette" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "pet", 
			 "name", "Pet" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "pet", 
			 "zero_waste", "only", 
			 "name", "Zero waste pet" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "pet_food", 
			 "name", "Pet Food" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "books", 
			 "name", "Books" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "stationery", 
			 "name", "Stationery" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "music", 
			 "name", "Music" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "musical_instrument", 
			 "name", "Musical Instrument" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "motorcycle", 
			 "name", "Motorcycle" );

	// Row 7 - services (shops providing a service)
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Services", 
			 "shop", "hairdresser", 
			 "name", "Hairdresser" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "beauty", 
			 "name", "Beauty" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "beauty", 
			 "zero_waste", "only", 
			 "name", "Zero waste beauty" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "bookmaker", 
			 "name", "Bookmaker" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "pawnbroker", 
			 "name", "Pawnbroker, Money Lender" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "estate_agent", 
			 "name", "Estate Agent" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "tattoo", 
			 "name", "Tattoo" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "funeral_directors", 
			 "name", "Funerals, Stonemasons, etc." );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "laundry", 
			 "name", "Laundry, Dry Cleaning" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "travel_agent", 
			 "name", "Travel Agent" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "copyshop", 
			 "name", "Copyshop, Printers" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "pet_grooming", 
			 "name", "Pet Grooming" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "veterinary", 
			 "name", "Vet" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "animal_boarding", 
			 "name", "Animal Boarding" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "animal_shelter", 
			 "name", "Animal Shelter" );


	// Row 8 - cars and car related
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Petrol / Diesel", 
				 "amenity", "fuel", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Petrol / Electric", 
				 "amenity", "fuel", 
				 "fuel:diesel", "yes", 
				 "fuel:electricity", "yes", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "LPG", 
				 "amenity", "fuel", 
				 "fuel:lpg", "yes", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Hydrogen", 
				 "amenity", "fuel", 
				 "fuel:LH2", "yes", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Fuel Pump", 
				 "man_made", "fuel_pump", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Charging Station", 
				 "amenity", "charging_station", 
				 "name", "Operator" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Charge Point", 
				 "man_made", "charge_point", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Car Sales",
				 "shop", "car", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Car Repair",
				 "shop", "car_repair", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Car Parts",
				 "shop", "car_parts", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Car Wash",
				 "amenity", "car_wash", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Compressed Air",
				 "amenity", "compressed_air", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Caravan, Boat, etc.",
				 "shop", "caravan", 
				 "name", "Name" );

	// Row 9 - generic offices, breweries and other 
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Vacant", 
				 "shop", "vacant", 
				 "", "" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Various Offices", 
				 "office", "yes", 
				 "name", "Office Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Craft Brewery", 
				 "craft", "brewery", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Craft Cider", 
				 "craft", "cider", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Beehive", 
				 "man_made", "beehive", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Water Monitoring Station", 
				 "man_made", "monitoring_station", 
				 "monitoring:water_level", "yes", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Water Quality", 
				 "man_made", "monitoring_station", 
				 "monitoring:bathing_water", "yes", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Weather Monitoring Station", 
				 "man_made", "monitoring_station", 
				 "monitoring:weather", "yes", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Wind Monitoring Station", 
				 "man_made", "monitoring_station", 
				 "monitoring:wind_direction", "yes", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Rainfall Monitoring", 
				 "man_made", "monitoring_station", 
				 "monitoring:rainfall", "yes", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Seismic Monitoring", 
				 "man_made", "monitoring_station", 
				 "monitoring:seismic_activity", "yes", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Sky Brightness Monitoring", 
				 "man_made", "monitoring_station", 
				 "monitoring:sky_brightness", "yes", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Pipeline Marker", 
				 "man_made", "pipeline_marker", 
				 "Ref", "Ref" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Military Marker", 
				 "military", "range_marker", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Military Bunker", 
				 "military", "bunker", 
				 "name", "Name" );

	// Row 10 - medical
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Hospital", 
				 "amenity", "hospital", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Doctors",
				 "amenity", "doctors", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Dentist",
				 "amenity", "dentist", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Optician",
				 "shop", "optician", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Other Healthcare",
				 "shop", "chiropodist", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Pharmacy",
				 "amenity", "pharmacy", 
				 "name", "Name" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
				 "amenity", "pharmacy",
				 "wheelchair", "yes", 
				 "name", "wheelchair access" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
				 "amenity", "pharmacy", 
				 "wheelchair", "limited", 
				 "name", "limited wheelchair access" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
				 "amenity", "pharmacy", 
				 "wheelchair", "no", 
				 "name", "no wheelchair access" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Ambulance Station",
				 "amenity", "ambulance_station", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Lifeboat Station",
				 "emergency", "water_rescue", 
				 "building", "yes", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Lifeboat",
				 "amenity", "lifeboat", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Mountain Rescue",
				 "amenity", "mountain_rescue", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Mountain Rescue Supplies", 
				 "emergency", "rescue_box", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Defibrillator", 
				 "emergency", "defibrillator", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Life Ring", 
				 "emergency", "life_ring", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Fire Extinguisher", 
				 "emergency", "fire_extinguisher", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Fire Hydrant", 
				 "emergency", "fire_hydrant", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Emergency Access Point", 
				 "emergency", "access_point", 
				 "name", "Name" );

	// Row 11 - accommodation
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Hotel", 
				 "tourism", "hotel", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Motel", 
			 "tourism", "motel", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Resort", 
			 "leisure", "resort", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Guest House",
			 "tourism", "guest_house", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Bed and Breakfast",
			 "tourism", "bed_and_breakfast", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Chalet",
			 "tourism", "chalet", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Alpine Hut",
			 "tourism", "alpine_hut", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Hostel",
			 "tourism", "hostel", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Apartment",
			 "tourism", "apartment", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Apartment Hotel",
			 "tourism", "apartments", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Holiday Park",
			 "tourism", "holiday_park", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Self Catering",
			 "tourism", "self_catering", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Holiday Cottage",
			 "tourism", "holiday_cottage", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Caravan Site",
			 "tourism", "caravan_site", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Camp Site",
			 "tourism", "camp_site", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Camp Pitch",
			 "tourism", "camp_pitch", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Marina",
			 "leisure", "marina", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Boat Storage",
			 "amenity", "boat_storage", 
			 "name", "Name" );

	// Row 12 - big places you might want to visit
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Other Tourism", 
				 "amenity", "cinema", 
				 "name", "Cinema" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "concert_hall", 
			 "name", "Concert Hall" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "library", 
			 "name", "Library" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "theatre", 
			 "name", "Theatre" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "museum", 
			 "name", "Museum" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "gallery", 
			 "name", "Gallery" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "zoo", 
			 "name", "Zoo" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "aquarium", 
			 "name", "Aquarium" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "zooaviary", 
			 "name", "Aviary" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "zooenclosure", 
			 "name", "Zoo Enclosure" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "theme_park", 
			 "name", "Theme Park" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "attraction", 
			 "name", "Attraction" );

	// Row 13 - toilets and showers
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Toilets", 
				 "amenity", "toilets", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "(customers)", 
				 "amenity", "toilets", 
				 "access", "customers", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "(pay)", 
				 "amenity", "toilets", 
				 "fee", "yes", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "(male)", 
				 "amenity", "toilets", 
				 "male", "yes", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Shower", 
				 "amenity", "shower", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "(customers)", 
				 "amenity", "shower", 
				 "access", "customers", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "(pay)", 
				 "amenity", "shower", 
				 "fee", "yes", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "(female)", 
				 "amenity", "shower", 
				 "female", "yes", 
				 "name", "Name" );

	// Row 14 - places you might want to visit outside
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Picnic Site", 
				 "tourism", "picnic_site", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Shelter", 
				 "amenity", "shelter", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Picnic Table", 
				 "leisure", "picnic_table", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "BBQ", 
				 "amenity", "bbq", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Playground", 
				 "leisure", "playground", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Slipway", 
				 "leisure", "slipway", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Canoe Put In", 
				 "whitewater", "put_in", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Marina", 
				 "leisure", "marina", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Boatyard", 
				 "amenity", "boatyard", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Waterway fuel", 
				 "waterway", "fuel", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Bird Hide", 
				 "leisure", "bird_hide", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Hunting Stand", 
				 "leisure", "hunting_stand", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Grouse Butt", 
				 "leisure", "grouse_butt", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Trig Point", 
				 "man_made", "survey_point", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Boundary Stone", 
				 "man_made", "boundary_stone", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Cairn", 
				 "man_made", "cairn", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Mounting Block", 
				 "man_made", "mounting_block", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Firepit", 
				 "leisure", "firepit", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Watering Place", 
				 "amenity", "watering_place", 
				 "name", "Name" );

	// Row 15 - Playground Equipment
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Playground Swing", 
				 "playground", "swing", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Structure", 
				 "playground", "structure", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Climbing Frame", 
				 "playground", "climbingframe", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Slide", 
				 "playground", "slide", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Springy", 
				 "playground", "springy", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Roundabout", 
				 "playground", "roundabout", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Zipwire", 
				 "playground", "zipwire", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Seesaw", 
				 "playground", "seesaw", 
				 "name", "Name" );

	// Row 16 - Pitches
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Tennis Court",
			 "leisure", "pitch", 
			 "sport", "tennis", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Football Pitch",
			 "leisure", "pitch", 
			 "sport", "soccer", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Equestrian Area",
			 "leisure", "pitch", 
			 "sport", "equestrian", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Bowling Green",
			 "leisure", "pitch", 
			 "sport", "bowls", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Cricket Pitch",
			 "leisure", "pitch", 
			 "sport", "cricket", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Basketball Court",
			 "leisure", "pitch", 
			 "sport", "basketball", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Multi-use Area",
			 "leisure", "pitch", 
			 "sport", "multi", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Rugby Pitch",
			 "leisure", "pitch", 
			 "sport", "rugby", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Gaelic Games",
			 "leisure", "pitch", 
			 "sport", "gaelic_games", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Skateboard Park",
			 "leisure", "pitch", 
			 "sport", "skateboard", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Athletics",
			 "leisure", "pitch", 
			 "sport", "athletics", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Netball Court",
			 "leisure", "pitch", 
			 "sport", "netball", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Climbing",
			 "leisure", "pitch", 
			 "sport", "climbing", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Climbing Boulder", 
			 "natural", "climbing", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Cycling Area",
			 "leisure", "pitch", 
			 "sport", "cycling", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Table Tennis Table",
			 "leisure", "pitch", 
			 "sport", "table_tennis", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Hockey Pitch",
			 "leisure", "pitch", 
			 "sport", "hockey", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Shooting Ground",
			 "leisure", "pitch", 
			 "sport", "shooting", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Boules Court",
			 "leisure", "pitch", 
			 "sport", "boules", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Polo Pitch",
			 "leisure", "pitch", 
			 "sport", "polo", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Croquet Pitch",
			 "leisure", "pitch", 
			 "sport", "croquet", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Baseball Pitch",
			 "leisure", "pitch", 
			 "sport", "baseball", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Chess Board",
			 "leisure", "pitch", 
			 "sport", "chess", 
			 "name", "Name" );

	// Row 17 - Leisure
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Sports Centre",
			 "leisure", "sports_centre", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Swimming Pool",
			 "leisure", "swimming_pool", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Swimming Area",
			 "leisure", "swimming_area", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Water Park",
			 "leisure", "water_park", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Ice Rink",
			 "leisure", "ice_rink", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Stadium",
			 "leisure", "stadium", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Golf Course",
			 "leisure", "golf_course", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Golf Pin", 
				 "golf", "pin", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Mini Golf", 
				 "leisure", "miniature_golf", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Golf Ball Washer", 
				 "golf", "ball_washer", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Bowling Alley",
			 "leisure", "bowling_alley", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Rec. Ground",
			 "leisure", "recreation_ground", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Dancing", 
				 "leisure", "dance", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Club", 
				 "leisure", "club", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Fitness Centre", 
				 "leisure", "fitness_centre", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Fitness Station", 
				 "leisure", "fitness_station", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Dog Park", 
				 "leisure", "dog_park", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Sauna", 
				 "leisure", "sauna", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Horse Riding", 
				 "leisure", "horse_riding", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Fishing", 
				 "leisure", "fishing", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Bandstand", 
				 "leisure", "bandstand", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Bleachers", 
				 "leisure", "bleachers", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Outdoor Seating", 
				 "leisure", "outdoor_seating", 
				 "name", "Name" );

	// Row 18 - Barriers
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Barriers", 
				 "barrier", "gate", 
				 "name", "Gate" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol,
				 "barrier", "gate", 
				 "locked", "yes", 
				 "name", "Locked gate" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "barrier", "stile", 
			 "name", "Stile" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "barrier", "dog_gate_stile", 
			 "name", "(with dog gate)" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "barrier", "bollard", 
			 "name", "Bollard" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "barrier", "kissing_gate", 
			 "name", "Kissing Gate" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "barrier", "cycle_barrier", 
			 "name", "Cycle Barrier" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "barrier", "cattle_grid", 
			 "name", "Cattle Grid" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "barrier", "lift_gate", 
			 "name", "Lift Gate" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "barrier", "height_restrictor", 
			 "name", "Height Restrictor" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "barrier", "door", 
			 "name", "Door" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "loading_dock", 
			 "name", "Loading Dock" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "barrier", "toll_booth", 
			 "name", "Toll Booth" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "highway", "toll_gantry", 
			 "name", "Toll Gantry" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "barrier", "horse_stile", 
			 "name", "Horse Stile" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "barrier", "border_control", 
			 "name", "Border Control" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "barrier", "bus_trap", 
			 "name", "Bus Trap" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "man_made", "footwear_decontamination", 
			 "name", "Footwear Decontamination" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "highway", "wheelwash", 
			 "name", "Wheel Wash" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "barrier", "ticket_barrier", 
			 "name", "Ticket Barrier" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Main Entrance", 
			 "entrance", "main", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Sluice", 
				 "waterway", "sluice_gate", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Lock Gate", 
				 "waterway", "lock_gate", 
				 "name", "Name" );

	// Row 19 - Tourist Information
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Tourist Information", 
				 "tourism", "information", 
				 "name", "Generic Information" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "information", 
			 "information", "board", 
			 "name", "Board" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "information", 
			 "information", "board", 
			 "board_type", "public_transport", 
			 "name", "Public Transport" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "information", 
			 "information", "sign", 
			 "name", "Sign" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "information", 
			 "information", "sign", 
			 "operator:type", "military", 
			 "name", "Military" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "information", 
			 "information", "guidepost", 
			 "name", "Guidepost" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "information", 
			 "information", "guidepost", 
			 "guidepost_type", "PROW", 
			 "name", "PROW" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "information", 
			 "information", "route_marker", 
			 "name", "Route marker" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "information", 
			 "information", "office", 
			 "name", "Office" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "information", 
			 "information", "plaque", 
			 "name", "Plaque" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "information", 
			 "information", "audioguide", 
			 "name", "Audioguide" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "information", 
			 "information", "artwork", 
			 "name", "Artwork" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "information", 
			 "information", "stele", 
			 "name", "Stele" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "information", 
			 "operator", "Peak and Northern Footpaths Society",
			 "ref", "Ref",
			 "name", "PNFS Signpost",
			 "", "",
			 "", "",
			 "", "" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Sustrans markers", 
			 "ncn_milepost", "dudgeon", 
			 "sustrans_ref", "Dudgeon" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "ncn_milepost", "mccoll", 
			 "sustrans_ref", "McColl" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "ncn_milepost", "mills", 
			 "sustrans_ref", "Mills" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "ncn_milepost", "rowe", 
			 "sustrans_ref", "Rowe" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "ncn_milepost", "yes", 
			 "sustrans_ref", "Unknown" );

	// Row 20 - religious
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Places of Worship etc.", 
				 "amenity", "place_of_worship", 
				 "religion", "christian", 
				 "name", "Christian" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "place_of_worship", 
			 "religion", "muslim", 
			 "name", "Muslim" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "place_of_worship", 
			 "religion", "hindu", 
			 "name", "Hindu" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "place_of_worship", 
			 "religion", "sikh", 
			 "name", "Sikh" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "place_of_worship", 
			 "religion", "jewish", 
			 "name", "Jewish" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "place_of_worship", 
			 "religion", "buddhist", 
			 "name", "Buddhist" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "place_of_worship", 
			 "religion", "shinto", 
			 "name", "Shinto" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "place_of_worship", 
			 "religion", "taoist", 
			 "name", "Taoist" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "place_of_worship", "holy_well", 
			 "man_made", "water_well", 
			 "name", "Holy Well" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "place_of_worship", "holy_well", 
			 "natural", "spring", 
			 "name", "Holy Spring" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
				 "amenity", "monastery", 
				 "name", "Monastery" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
				 "man_made", "cross", 
				 "name", "Cross" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol,
				 "man_made", "dovecote", 
				 "name", "Dovecote" );

	// Row 21 - government
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Post Office", 
				 "amenity", "post_office", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Fire", 
			 "amenity", "fire_station", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Police", 
			 "amenity", "police", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Embassy", 
			 "amenity", "embassy", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Courthouse", 
			 "amenity", "courthouse", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Prison", 
			 "amenity", "prison", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Other", 
			 "office", "government", 
			 "name", "Name" );

	// Row 22 - financial
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Bank / Building Society", 
				 "amenity", "bank", 
				 "name", "Name" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
				 "amenity", "bank",
				 "wheelchair", "yes", 
				 "name", "wheelchair access" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
				 "amenity", "bank", 
				 "wheelchair", "limited", 
				 "name", "limited wheelchair access" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
				 "amenity", "bank", 
				 "wheelchair", "no", 
				 "name", "no wheelchair access" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "ATM", 
				 "amenity", "atm", 
				 "operator", "Operator" );

	// Row 23 - education
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "University", 
				 "amenity", "university", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "School / College", 
				 "amenity", "school", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Kindergarten", 
				 "amenity", "kindergarten", 
				 "name", "Name" );

	// Row 24 - smaller amenities
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Viewpoint", 
				 "tourism", "viewpoint", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Artwork", 
				 "tourism", "artwork", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Fountain", 
				 "amenity", "fountain", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Advertising", 
				 "advertising", "column", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Sundial", 
				 "amenity", "sundial", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Postbox", 
				 "amenity", "post_box", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Telephone", 
				 "amenity", "telephone", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Shopmobility", 
				 "amenity", "shopmobility", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Public Bookcase", 
				 "amenity", "public_bookcase", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Left Luggage", 
				 "amenity", "left_luggage", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Parcel Locker", 
				 "amenity", "parcel_locker", 
				 "name", "Operator" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Vending Machine", 
				 "amenity", "vending_machine", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Poo bags", 
				 "amenity", "vending_machine", 
				 "vending", "excrement_bags", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Bottle Return", 
				 "amenity", "vending_machine", 
				 "vending", "bottle_return", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Musical Instrument", 
				 "amenity", "musical_instrument", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Recycling Centre", 
				 "amenity", "recycling", 
				 "recycling_type", "centre", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Recycling bin", 
				 "amenity", "recycling", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Waste bin", 
				 "amenity", "waste_basket", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Large waste bin", 
				 "amenity", "waste_disposal", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Grit bin", 
				 "amenity", "grit_bin", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Bench", 
				 "amenity", "bench", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Drinking water", 
				 "amenity", "drinking_water", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Non-drinking water", 
				 "amenity", "nondrinking_water", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Sanitary Dump Station", 
				 "amenity", "sanitary_dump_station", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Well", 
				 "man_made", "water_well", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Outfall", 
				 "man_made", "outfall", 
				 "name", "Name" );

	// Row 25 - Historic and archaeological
	currentRow += 1;
	currentCol = 1;
	
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Archaeology", 
				 "historic", "archaeological_site", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Palaeontology", 
				 "geological", "palaeontological_site", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Fortification", 
				 "historic", "archaeological_site", 
				 "archaeological_site", "fortification", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Ringfort", 
				 "historic", "archaeological_site", 
				 "archaeological_site", "fortification", 
				 "fortification_type", "ringfort", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Hill Fort", 
				 "historic", "archaeological_site", 
				 "archaeological_site", "fortification", 
				 "fortification_type", "hill_fort", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Motte", 
				 "historic", "archaeological_site", 
				 "archaeological_site", "fortification", 
				 "fortification_type", "motte", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Archaeological Castle", 
				 "historic", "archaeological_site", 
				 "archaeological_site", "fortification", 
				 "fortification_type", "castle", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Promontory Fort", 
				 "historic", "archaeological_site", 
				 "archaeological_site", "fortification", 
				 "fortification_type", "promontory_fort", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Crannog", 
				 "historic", "archaeological_site", 
				 "archaeological_site", "crannog", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Tumulus", 
				 "historic", "archaeological_site", 
				 "archaeological_site", "tumulus", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Stone", 
				 "historic", "stone", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Standing Stone", 
				 "historic", "standing_stone", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Stone Circle", 
				 "historic", "archaeological_site", 
				 "archaeological_site", "megalith", 
				 "megalith_type", "stone_circle", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Megalithic Tomb", 
				 "historic", "archaeological_site", 
				 "archaeological_site", "megalith", 
				 "megalith_type", "dolmen", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Stone Row", 
				 "historic", "archaeological_site", 
				 "archaeological_site", "megalith", 
				 "megalith_type", "stone_row", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Ogham Stone", 
				 "historic", "ogham_stone", 
				 "stone_type", "ogham_stone", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Rune Stone", 
				 "historic", "rune_stone", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Mass Rock", 
				 "place_of_worship", "mass_rock", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Historic Mineshaft", 
				 "historic", "mineshaft", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Historic Castle", 
				 "historic", "castle", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Folly", 
				 "historic", "folly", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Martello Tower", 
				 "historic", "martello_tower", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Manor", 
				 "historic", "manor", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Historic Monastery", 
				 "historic", "monastery", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "City Gate", 
				 "historic", "city_gate", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Battlefield", 
				 "historic", "battlefield", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Cannon", 
				 "historic", "cannon", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Stocks", 
				 "historic", "stocks", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Well", 
				 "historic", "well", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Cross", 
				 "historic", "cross", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Dovecote", 
				 "historic", "dovecote", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Kiln", 
				 "historic", "kiln", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Ice House", 
				 "historic", "ice_house", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Pinfold", 
				 "historic", "pinfold", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Water Pump", 
				 "historic", "water_pump", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Water Crane", 
				 "railway", "water_crane", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Historic Church", 
				 "historic", "church", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Round Tower", 
				 "historic", "tower", 
				 "tower:type", "round_tower", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Historic Defensive Tower", 
				 "historic", "tower", 
				 "tower:type", "defensive", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Historic Observation Tower", 
				 "historic", "tower", 
				 "tower:type", "observation", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Historic Bell Tower", 
				 "historic", "tower", 
				 "tower:type", "bell_tower", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Other Historic Tower", 
				 "historic", "tower", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Historic Military Bunker", 
				 "historic", "bunker", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Historic Windmill", 
				 "historic", "windmill", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Watermill", 
				 "historic", "watermill", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Mill", 
				 "historic", "mill", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Tank", 
				 "historic", "tank", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Ship", 
				 "historic", "ship", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Wreck", 
				 "historic", "wreck", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Aircraft", 
				 "historic", "aircraft", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Aircraft Wreck", 
				 "historic", "aircraft_wreck", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Milk Churn Stand", 
				 "historic", "milk_churn_stand", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Other Historic", 
				 "historic", "ruins", 
				 "name", "Name" );

	// Row 26 - Monuments and memorials
	currentRow += 1;
	currentCol = 1;

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Monument", 
				 "historic", "monument", 
				 "name", "Monument" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "historic", "tomb", 
			 "name", "Tomb" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Memorials", 
				 "historic", "memorial", 
				 "memorial", "war_memorial", 
				 "name", "War" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "man_made", "obelisk", 
			 "name", "Obelisk" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "historic", "memorial", 
			 "memorial", "plaque", 
			 "name", "Plaque" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "historic", "memorial", 
			 "memorial", "pavement plaque", 
			 "name", "Pavement Plaque" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "historic", "memorial", 
			 "memorial", "statue", 
			 "name", "Statue" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "historic", "memorial", 
			 "memorial", "sculpture", 
			 "name", "Sculpture" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "historic", "memorial", 
			 "memorial", "cross", 
			 "name", "Cross" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "historic", "memorial", 
			 "memorial", "stone", 
			 "name", "Stone" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "historic", "memorial", 
			 "memorial", "plate", 
			 "name", "Plate" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "historic", "memorial", 
			 "memorial", "bench", 
			 "name", "Bench" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "historic", "memorial", 
			 "memorial", "grave", 
			 "name", "Grave" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "historic", "memorial", 
			 "name", "Other" );

	// Row 27 - Former phoneboxes
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Telephone box containing:", 
				 "amenity", "telephone", 
				 "booth", "K6", 
				 "name", "Telephone" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "booth", "K6", 
			 "emergency", "defibrillator", 
			 "name", "Defibrillator" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "booth", "K6", 
			 "amenity", "library", 
			 "name", "Library" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "booth", "K6", 
			 "amenity", "bicycle_repair_station", 
			 "name", "Bike Repair" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "booth", "K6", 
			 "amenity", "atm", 
			 "name", "ATM" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "booth", "K6", 
			 "tourism", "information", 
			 "name", "Tourist Info" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "booth", "K6", 
			 "tourism", "artwork", 
			 "name", "Artwork" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "booth", "K6", 
			 "disused:amenity", "telephone", 
			 "name", "Disused" );

	// Row 28 - Travel infrastructure
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Car Park", 
				 "amenity", "parking", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "(pay)", 
				 "amenity", "parking", 
				 "fee", "yes", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "(private)", 
				 "amenity", "parking", 
				 "access", "private", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "(disabled)", 
				 "amenity", "parking_space", 
				 "parking_space", "disabled", 
				 "fee", "no", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "(pay disabled)", 
				 "amenity", "parking_space", 
				 "parking_space", "disabled", 
				 "fee", "yes", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Car Sharing", 
				 "amenity", "car_sharing", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Car Rental",
				 "amenity", "car_rental", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Rail Station", 
				 "railway", "station", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Rail Halt", 
				 "railway", "halt", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Preserved", 
				 "railway", "station", 
				 "usage", "tourism", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Bus Station", 
				 "amenity", "bus_station", 
				 "name",    "Name",
				 "website", "Website" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Bus Stop", 
				 "highway", "bus_stop", 
				 "name",    "Name",
				 "website", "Website" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "(with timetable)", 
				 "highway",          "bus_stop", 
				 "name",             "Name",
				 "website",          "Website",
				 "departures_board", "timetable" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "(+speech)", 
				 "highway",                        "bus_stop", 
				 "name",                           "Name",
				 "website",                        "Website",
				 "departures_board",               "timetable",
				 "departures_board:speech_output", "yes" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "(realtime)", 
				 "highway",          "bus_stop", 
				 "name",             "Name",
				 "website",          "Website",
				 "departures_board", "realtime" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "(+speech)", 
				 "highway",                        "bus_stop", 
				 "name",                           "Name",
				 "website",                        "Website",
				 "departures_board",               "realtime",
				 "departures_board:speech_output", "yes" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "(no pole)", 
				 "highway",            "bus_stop", 
				 "name",               "Name",
				 "website",            "Website",
				 "physically_present", "no" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "(disused with pole)", 
				 "disused:highway",    "bus_stop", 
				 "name",               "Name",
				 "website",            "Website",
				 "physically_present", "yes" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Standalone departures board", 
				 "departures_board",   "realtime", 
				 "name",               "Name",
				 "website",            "Website" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Taxi Stand", 
				 "amenity", "taxi", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Lift", 
				 "highway", "elevator", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Taxi Office", 
				 "amenity", "taxi_office", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Ferry Terminal", 
				 "amenity", "ferry_terminal", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Bike Parking", 
				 "amenity", "bicycle_parking", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Pay Bike Parking", 
				 "amenity", "bicycle_parking", 
				 "fee", "yes", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Bike Rental", 
				 "amenity", "bicycle_rental", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Bike Repair Station", 
				 "amenity", "bicycle_repair_station", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Scooter Rental", 
				 "amenity", "scooter_rental", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Airport", 
				 "aeroway", "aerodrome", 
				 "iata", "IATA", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Heliport", 
				 "aeroway", "heliport", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Helipad", 
				 "aeroway", "helipad", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Gate", 
				 "aeroway", "gate", 
				 "ref", "Ref" );

	// Row 29 - Smaller travel infrastructure
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Traf. Lights", 
				 "highway", "traffic_signals", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Crossing", 
				 "highway", "crossing", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Milestone", 
				 "highway", "milestone", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Mini Rndbt", 
				 "highway", "mini_roundabout", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Streetlamp", 
				 "highway", "street_lamp", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Gaslight", 
				 "highway", "street_lamp", 
				 "lamp_type", "gaslight", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Phone", 
				 "emergency", "phone", 
				 "name", "Name" );

	// Row 30 - Masts and towers and other man_made
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Mast", 
				 "man_made", "mast", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Chimney", 
				 "man_made", "chimney", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Clock Tower", 
				 "man_made", "tower", 
				 "tower:type", "clock", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Pedestal Clock", 
				 "amenity", "clock", 
				 "support", "pedestal", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Other Clock", 
				 "amenity", "clock", 
				 "support", "wall", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Illumination", 
				 "man_made", "tower", 
				 "tower:type", "lighting", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Defensive", 
				 "man_made", "tower", 
				 "tower:type", "defensive", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Observation", 
				 "man_made", "tower", 
				 "tower:type", "observation", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Aircraft Control", 
				 "man_made", "tower", 
				 "tower:type", "aircraft_control", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Radar Tower", 
				 "man_made", "tower", 
				 "tower:type", "radar", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Satellite Dish", 
				 "man_made", "satellite_dish", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Firefighter", 
				 "man_made", "tower", 
				 "tower:type", "firefighter_training", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Church Tower", 
				 "man_made", "tower", 
				 "tower:type", "church", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Church Spire", 
				 "man_made", "tower", 
				 "tower:type", "spire", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Maypole", 
				 "man_made", "maypole", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Flagpole", 
				 "man_made", "flagpole", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Military", 
				 "man_made", "flagpole_red", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Windsock", 
				 "man_made", "windsock", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Water Tower", 
				 "man_made", "water_tower", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Lighthouse", 
				 "man_made", "lighthouse", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Watermill", 
				 "man_made", "watermill", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Wind Turbine", 
				 "man_made", "power_wind", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Windmill", 
				 "man_made", "windmill", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Vent Shaft", 
				 "man_made", "ventilation_shaft", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Weighbridge", 
				 "amenity", "weighbridge", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Manhole", 
				 "man_made", "manhole", 
				 "Ref", "Ref" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Crane", 
				 "man_made", "crane", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "El Substation", 
				 "power", "substation", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Hydro Power", 
				 "power", "generator", 
				 "generator:source", "hydro" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Sewage", 
				 "man_made", "wastewater_plant", 
				 "name", "Name" );

	// Row 31 - Natural
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Peak", 
				 "natural", "peak", 
				 "name", "Name / ele" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Hill", 
				 "natural", "hill", 
				 "name", "Name / ele" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Volcano", 
				 "natural", "volcano", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Cave", 
				 "natural", "cave_entrance", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Sinkhole", 
				 "natural", "sinkhole", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Mine", 
				 "man_made", "mineshaft", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Rock", 
				 "natural", "rock", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Stone", 
				 "natural", "stone", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Spring", 
				 "natural", "spring", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Shrub", 
				 "natural", "shrub", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Tree", 
				 "natural", "tree", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "10m crown", 
				 "natural", "tree", 
				 "diameter_crown", "10", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "20m crown", 
				 "natural", "tree", 
				 "diameter_crown", "20", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "30m crown", 
				 "natural", "tree", 
				 "diameter_crown", "30", 
				 "name", "Name" );

	myOutputOsmStream.println( osmTrailer );
    }
}
