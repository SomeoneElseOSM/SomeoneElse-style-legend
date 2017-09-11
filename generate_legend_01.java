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

    static long   startNode = 9100000000L;
    static double startLat  = -24.9850;
    static double startLon  = 135.110;
    static double incLat   = -00.0010;
    static double incLon   = 000.001;

    // qqq

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

    // all 7 pairs of tags
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

    // 3 pairs of tags
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

    // all 7 pairs of tags
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

	writeNodeLatLon( myOutputOsmStream, currentNode, currentLat, currentLon, "place", "locality", "name", labelName, "", "", "", "", "", "", "", "", "", "" );
    }

    // 2 pairs of tags
    private static void writeLabelledNodeRowCol( PrintStream passedOutputOsmStream, long passedNodeNumber, int passedRow, int passedCol, String labelName, 
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

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, passedRow, passedCol, labelName, 
			 tag01, value01, 
			 tag02, value02, 
			 tag03, value03, 
			 tag04, value04, 
			 tag05, value05, 
			 tag06, value06, 
			 tag07, value07 );
    }

    // 3 pairs of tags
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

    public static void main(String[] args) throws Exception 
    {
	// No argument processing (yet)

	String osmLegendFile01 = "generated_legend_pub.osm"; 
	myOutputOsmStream = new PrintStream( osmLegendFile01 );
	myOutputOsmStream.println( osmHeader );

	// Row 0 - a descriptive label
	final int row_description = 0;
	writeNodeRowCol( myOutputOsmStream, startNode, row_description, 5, 
			 "place", "village", 
			 "name", "Zoom in to see items rendered at each zoom level:" );

	// Row 1 - pubs
	final int row_pub = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_pub, 1, "Pubs", 
				 "amenity", "pub", 
				 "name", "Generic Pub" );
	
	writeNodeRowCol( myOutputOsmStream, startNode, row_pub, 2, 
			 "amenity", "pub", 
			 "name", "Real Ale", 
			 "real_ale", "An interesting selection" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_pub, 3, 
			 "amenity", "pub", 
			 "name", "No Real Ale", 
			 "real_ale", "no" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_pub, 4, 
			 "amenity", "pub", 
			 "name", "Food", 
			 "food", "Some sort of description" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_pub, 5, 
			 "amenity", "pub", 
			 "name", "Non-carpeted area", 
			 "description:floor", "Tiles or Stone" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_pub, 6, 
			 "amenity", "pub", 
			 "name", "Pub with Microbrewery", 
			 "microbrewery", "yes" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_pub, 7, 
			 "amenity", "pub", 
			 "name", "Combination", 
			 "real_ale", "An interesting selection", 
			 "food", "Some sort of description", 
			 "microbrewery", "yes", 
			 "description:floor", "Tiles or stone",
			 "", "" );

	// Row 2 - fast food
	final int row_fast_food = 2;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_fast_food, 1, "Fast Food", 
				 "amenity", "fast_food", 
				 "name", "Generic Fast Food" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_fast_food, 2, 
			 "amenity", "fast_food", 
			 "name", "American, Burger", 
			 "cuisine", "burger" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_fast_food, 3, 
			 "amenity", "fast_food", 
			 "name", "Chicken", 
			 "cuisine", "chicken" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_fast_food, 4, 
			 "amenity", "fast_food", 
			 "name", "Chinese, Japanese, etc.", 
			 "cuisine", "chinese" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_fast_food, 5, 
			 "amenity", "fast_food", 
			 "name", "Coffee", 
			 "cuisine", "coffee" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_fast_food, 6, 
			 "amenity", "fast_food", 
			 "name", "Fish and Chips", 
			 "cuisine", "fish_and_chips" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_fast_food, 7, 
			 "amenity", "fast_food", 
			 "name", "Ice Cream", 
			 "cuisine", "ice_cream" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_fast_food, 8, 
			 "amenity", "fast_food", 
			 "name", "Indian", 
			 "cuisine", "indian" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_fast_food, 9, 
			 "amenity", "fast_food", 
			 "name", "Kebab, Turkish", 
			 "cuisine", "kebab" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_fast_food, 10, 
			 "amenity", "fast_food", 
			 "name", "Pies, Pasties", 
			 "cuisine", "pie" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_fast_food, 11, 
			 "amenity", "fast_food", 
			 "name", "Pizza, Italian", 
			 "cuisine", "pizza" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_fast_food, 12, 
			 "amenity", "fast_food", 
			 "name", "Sandwich", 
			 "cuisine", "sandwich" );

	// Row 3 - other eating and drinking
	final int row_other_eating = 3;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_other_eating, 1, "Other Eating and Drinking", 
				 "amenity", "bar", 
				 "name", "Bar" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_other_eating, 2, 
			 "amenity", "cafe", 
			 "name", "Cafe" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_other_eating, 3, 
			 "amenity", "restaurant", 
			 "name", "Restaurant" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_other_eating, 4, 
			 "amenity", "biergarten", 
			 "name", "Biergarten" );

	// Row 4 - shops
	final int row_shops = 4;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_shops, 1, "Shops", 
				 "shop", "yes", 
				 "name", "Generic Shop" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_shops, 2, 
			 "shop", "convenience",
			 "name", "Convenience, Kiosk, Newsagent, Food" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_shops, 3, 
			 "shop", "supermarket", 
			 "name", "Supermarket" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_shops, 4, 
			 "shop", "clothes", 
			 "name", "Clothes, Shoes, Boutique, Tailor, Fashion, Baby Goods" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_shops, 5, 
			 "shop", "hairdresser", 
			 "name", "Hairdresser" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_shops, 6, 
			 "shop", "bakery", 
			 "name", "Bakery" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_shops, 7, 
			 "shop", "butcher", 
			 "name", "Butcher" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_shops, 8, 
			 "shop", "florist", 
			 "name", "Florist" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_shops, 9, 
			 "shop", "doityourself", 
			 "name", "Do-It-Yourself, Hardware" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_shops, 10, 
			 "shop", "electrical", 
			 "name", "Electronics, Electrical" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_shops, 11, 
			 "shop", "bicycle", 
			 "name", "Bike Shop" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_shops, 12, 
			 "shop", "jewellery", 
			 "name", "Jewellery, Watches" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_shops, 13, 
			 "shop", "department_store", 
			 "name", "Department Store" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_shops, 14, 
			 "shop", "greengrocer", 
			 "name", "Greengrocer" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_shops, 15, 
			 "shop", "sports", 
			 "name", "Sports, Fishing, Scuba Diving" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_shops, 16, 
			 "shop", "garden_centre", 
			 "name", "Garden Centre" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_shops, 17, 
			 "shop", "outdoor", 
			 "name", "Outdoor" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_shops, 18, 
			 "shop", "pawnbroker", 
			 "name", "Pawnbroker, Money Lender" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_shops, 19, 
			 "shop", "estate_agent", 
			 "name", "Estate Agent" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_shops, 20, 
			 "shop", "charity", 
			 "name", "Charity" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_shops, 21, 
			 "shop", "antiques", 
			 "name", "Antiques" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_shops, 22, 
			 "shop", "e-cigarette", 
			 "name", "E-Cigarette" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_shops, 23, 
			 "shop", "variety_store", 
			 "name", "Variety, Discount" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_shops, 24, 
			 "shop", "funeral_directors", 
			 "name", "Funerals, Stonemasons, etc." );

	// Row 5 - cars
	final int row_cars = 5;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_cars, 1, "Cars", 
			 "amenity", "fuel", 
			 "name", "Petrol / Diesel" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_cars, 2, 
			 "shop", "car", 
			 "name", "Car Sales" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_cars, 3, 
			 "shop", "car_repair", 
			 "name", "Car Repair" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_cars, 4, 
			 "shop", "car_parts", 
			 "name", "Car Parts" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_cars, 5, 
			 "shop", "car_wash", 
			 "name", "Car Wash" );

	// Row 6 - generic
	final int row_generic = 6;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_generic, 1, "Vacant", 
				 "shop", "vacant", 
				 "", "" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_generic, 2, "Various Offices", 
				 "office", "yes", 
				 "name", "Office Name" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_generic, 3, "Various Leisure", 
				 "leisure", "fitness_centre", 
				 "name", "Leisure Name" );

	// Row 7 - medical
	final int row_medical = 7;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_medical, 1, "Healthcare", 
				 "amenity", "hospital", 
				 "name", "Hospital" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_medical, 2, 
			 "amenity", "doctors", 
			 "name", "Doctors" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_medical, 3, 
			 "amenity", "dentist", 
			 "name", "Dentist" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_medical, 4, 
			 "shop", "optician", 
			 "name", "Optician, Medical Supply, Hearing Aids" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_medical, 5, 
			 "amenity", "pharmacy", 
			 "name", "Pharmacy" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_medical, 6, "Defibrillator", 
				 "emergency", "defibrillator", 
				 "name", "Defibrillator" );

	// Row 8 - accomodation
	final int row_accomodation = 8;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_accomodation, 1, "Accomodation", 
				 "tourism", "hotel", 
				 "name", "Hotel" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_accomodation, 2, 
			 "tourism", "hotel", 
			 "name", "Motel" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_accomodation, 3, 
			 "tourism", "guest_house", 
			 "name", "Guest House" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_accomodation, 4, 
			 "tourism", "bed_and_breakfast", 
			 "name", "Bed And Breakfast" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_accomodation, 5, 
			 "tourism", "chalet", 
			 "name", "Chalet" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_accomodation, 6, 
			 "tourism", "alpine_hut", 
			 "name", "Alpine Hut" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_accomodation, 7, 
			 "tourism", "hostel", 
			 "name", "Hostel" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_accomodation, 8, 
			 "tourism", "caravan_site", 
			 "name", "Caravan site" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_accomodation, 9, 
			 "tourism", "camp_site", 
			 "name", "Camp site" );

	// Row 9 - big places you might want to visit
	final int row_visit = 9;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_visit, 1, "Other Tourism", 
				 "amenity", "cinema", 
				 "name", "Cinema" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_visit, 2, 
			 "amenity", "concert_hall", 
			 "name", "Concert Hall" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_visit, 3, 
			 "amenity", "library", 
			 "name", "Library" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_visit, 4, 
			 "amenity", "theatre", 
			 "name", "Theatre" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_visit, 5, 
			 "tourism", "museum", 
			 "name", "Museum" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_visit, 6, 
			 "tourism", "aquarium", 
			 "name", "Aquarium" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_visit, 7, 
			 "tourism", "zoo", 
			 "name", "Zoo" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_visit, 8, "Toilets", 
				 "amenity", "toilets", 
				 "name", "Toilets" );

	// Row 10 - places you might want to visit outside
	final int row_outside = 10;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_outside, 1, "Picnic Site", 
				 "tourism", "picnic_site", 
				 "name", "Picnic Site" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_outside, 2, "Playground", 
				 "leisure", "playground", 
				 "name", "Playground" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_outside, 3, "Slipway", 
				 "leisure", "slipway", 
				 "name", "Slipway" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_outside, 4, "Bird Hide", 
				 "leisure", "bird_hide", 
				 "name", "Bird Hide" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_outside, 5, 
			 "leisure", "swimming_pool", 
			 "name", "Swimming Pool" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_outside, 6, 
			 "leisure", "sports_centre", 
			 "name", "Sports Centre" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_outside, 7, "Trig Point", 
				 "man_made", "survey_point", 
				 "name", "Name" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_outside, 8, "Cairn", 
				 "man_made", "cairn", 
				 "name", "Name" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_outside, 9, "Well", 
				 "man_made", "water_well", 
				 "name", "Name" );

	// Row 11 - Tourist Information
	final int row_tourist_info = 11;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_tourist_info, 1, "Tourist Information", 
				 "tourism", "information", 
				 "name", "Generic Information" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_tourist_info, 2, 
			 "tourism", "information", 
			 "information", "board", 
			 "name", "Board" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_tourist_info, 3, 
			 "tourism", "information", 
			 "information", "board", 
			 "name", "Marker" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_tourist_info, 4, 
			 "tourism", "information", 
			 "information", "office", 
			 "name", "Office" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_tourist_info, 5, 
			 "tourism", "information", 
			 "information", "plaque", 
			 "name", "Plaque" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_tourist_info, 6, 
			 "tourism", "information", 
			 "information", "audioguide", 
			 "name", "Audioguide" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_tourist_info, 7, 
			 "tourism", "information", 
			 "operator", "Peak and Northern Footpaths Society",
			 "ref", "Ref",
			 "name", "PNFS Signpost",
			 "", "",
			 "", "",
			 "", "" );

	// Row 12 - religious
	final int row_religious = 12;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_religious, 1, "Places of Worship", 
				 "amenity", "place_of_worship", 
				 "religion", "christian", 
				 "name", "Christian" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_religious, 2, 
			 "amenity", "place_of_worship", 
			 "religion", "muslim", 
			 "name", "Muslim" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_religious, 3, 
			 "amenity", "place_of_worship", 
			 "religion", "hindu", 
			 "name", "Hindu" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_religious, 4, 
			 "amenity", "place_of_worship", 
			 "religion", "sikh", 
			 "name", "Sikh" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_religious, 5, 
			 "amenity", "place_of_worship", 
			 "religion", "jewish", 
			 "name", "Jewish" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_religious, 6, 
			 "amenity", "place_of_worship", 
			 "religion", "buddhist", 
			 "name", "Buddhist" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_religious, 7, 
			 "amenity", "place_of_worship", 
			 "religion", "shinto", 
			 "name", "Shinto" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_religious, 8, 
			 "amenity", "place_of_worship", 
			 "religion", "taoist", 
			 "name", "Taoist" );

	// Row 13 - government
	final int row_government = 13;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_government, 1, "Post Office", 
				 "amenity", "post_office", 
				 "name", "Post Office" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_government, 2, 
			 "amenity", "fire_station", 
			 "name", "Fire Station" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_government, 3, 
			 "amenity", "police", 
			 "name", "Police Station" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_government, 4, 
			 "amenity", "embassy", 
			 "name", "Embassy" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_government, 5, 
			 "amenity", "courthouse", 
			 "name", "Courthouse" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_government, 6, 
			 "amenity", "prison", 
			 "name", "Prison" );

	writeNodeRowCol( myOutputOsmStream, startNode, row_government, 7, 
			 "office", "government", 
			 "name", "Other Government Office" );

	// Row 14 - financial
	final int row_financial = 14;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_financial, 1, "Bank", 
				 "amenity", "bank", 
				 "name", "Name" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_financial, 2, "ATM", 
				 "amenity", "atm", 
				 "name", "ATM" );

	// Row 15 - smaller amenities
	final int row_small_amenities = 15;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_small_amenities, 1, "Viewpoint", 
				 "tourism", "viewpoint", 
				 "name", "Viewpoint" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_small_amenities, 2, "Artwork", 
				 "tourism", "artwork", 
				 "name", "Name" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_small_amenities, 3, "Postbox", 
				 "amenity", "post_box", 
				 "name", "Post Box" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_small_amenities, 4, "Telephone", 
				 "amenity", "telephone", 
				 "name", "Telephone" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_small_amenities, 5, "Left Luggage", 
				 "amenity", "left_luggage", 
				 "name", "Left Luggage" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_small_amenities, 6, "Recycling", 
				 "amenity", "recycling", 
				 "name", "Recycling" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_small_amenities, 7, "Wastebasket", 
				 "amenity", "waste_basket", 
				 "name", "Wastebasket" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_small_amenities, 8, "Bench", 
				 "amenity", "bench", 
				 "name", "Name" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_small_amenities, 9, "Picnic Table", 
				 "leisure", "picnic_table", 
				 "name", "Picnic Table" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_small_amenities, 10, "Water", 
				 "amenity", "drinking_water", 
				 "name", "Drinking Water" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_small_amenities, 11, "Vending Machine", 
				 "amenity", "vending_machine", 
				 "name", "Vending Machine" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_small_amenities, 12, "Sundial", 
				 "amenity", "sundial", 
				 "name", "Name" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_small_amenities, 13, "Shelter", 
				 "amenity", "shelter", 
				 "name", "Name" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_small_amenities, 14, "Memorial", 
				 "historic", "memorial", 
				 "name", "Name" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_small_amenities, 15, "Ruins", 
				 "historic", "ruins", 
				 "name", "Name" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_small_amenities, 16, "Archaeology", 
				 "historic", "archaeological_site", 
				 "name", "Name" );

	// Row 16 - Travel infrastructure
	final int row_travel = 16;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_travel, 1, "Travel", 
				 "amenity", "parking", 
				 "name", "Car Park" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_travel, 2, "Car Sharing", 
				 "amenity", "car_sharing", 
				 "name", "Car Sharing" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_travel, 3, "Ferry Terminal", 
				 "amenity", "ferry_terminal", 
				 "name", "Ferry Terminal" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_travel, 4, "Bus Station", 
				 "amenity", "bus_station", 
				 "name", "Bus Station" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_travel, 5, "Bus Stop", 
				 "amenity", "bus_stop", 
				 "name", "Bus Stop" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_travel, 6, "Bike Rental", 
				 "amenity", "bicycle_rental", 
				 "name", "Bike Rental" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_travel, 7, "Bike Parking", 
				 "amenity", "bicycle_parking", 
				 "name", "Bike Parking" );

	// Row 17 - Travel infrastructure
	final int row_trav_inf = 17;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_trav_inf, 1, "Traf. Lights", 
				 "highway", "traffic_signals", 
				 "name", "Traffic Signals" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_trav_inf, 2, "Crossing", 
				 "highway", "crossing", 
				 "", "" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_trav_inf, 3, "Milestone", 
				 "highway", "milestone", 
				 "name", "Name" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_trav_inf, 4, "Mini Rndbt", 
				 "highway", "mini_roundabout", 
				 "name", "Name" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_trav_inf, 5, "Gate", 
				 "barrier", "gate", 
				 "name", "Name" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_trav_inf, 6, "Kissing Gate", 
				 "barrier", "kissing_gate", 
				 "name", "Name" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_trav_inf, 7, "Stile", 
				 "barrier", "stile", 
				 "name", "Name" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_trav_inf, 8, "Horse Stile", 
				 "barrier", "horse_stile", 
				 "name", "Name" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_trav_inf, 9, "Cycle Barrier", 
				 "barrier", "cycle_barrier", 
				 "name", "Name" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_trav_inf, 10, "Cattle Grid", 
				 "barrier", "cattle_grid", 
				 "name", "Name" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_trav_inf, 11, "Lift Gate", 
				 "barrier", "lift_gate", 
				 "name", "Name" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_trav_inf, 12, "Bollard", 
				 "barrier", "bollard", 
				 "name", "Name" );

	// Row 18 - Towers etc.
	final int row_towers = 18;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_towers, 1, "Mast", 
				 "man_made", "mast", 
				 "name", "Mast" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_towers, 2, "Chimney", 
				 "man_made", "chimney", 
				 "name", "Chimney" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_towers, 3, "Water Tower", 
				 "man_made", "water_tower", 
				 "name", "Water Tower" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_towers, 4, "Lighthouse", 
				 "man_made", "lighthouse", 
				 "name", "Lighthouse" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_towers, 5, "Wind Turbine", 
				 "man_made", "power_wind", 
				 "name", "Name" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_towers, 6, "Windmill", 
				 "man_made", "windmill", 
				 "name", "Name" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_towers, 7, "Vent Shaft", 
				 "man_made", "ventilation_shaft", 
				 "name", "Name" );

	// Row 19 - Natural
	final int row_natural = 19;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_natural, 1, "Peak", 
				 "natural", "peak", 
				 "name", "Name" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_natural, 2, "Volcano", 
				 "natural", "volcano", 
				 "name", "Name" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_natural, 3, "Cave", 
				 "natural", "cave_entrance", 
				 "name", "Name" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_natural, 4, "Spring", 
				 "natural", "spring", 
				 "name", "Name" );

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, row_natural, 5, "Tree", 
				 "natural", "tree", 
				 "name", "Name" );

	myOutputOsmStream.println( osmTrailer );
    }
}
