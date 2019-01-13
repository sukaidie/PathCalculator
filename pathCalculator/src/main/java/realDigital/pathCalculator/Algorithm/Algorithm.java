package realDigital.pathCalculator.Algorithm;

import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import org.json.JSONObject;

import realDigital.pathCalculator.Data.*;

/**
 * Class to parse address to Coordinates, calculate the distance of two locations and find the shortest path.
 * You can also add depots or stores here but do not forget to set them in the MainServer class.
 */

public class Algorithm {
	
	public static Depot d1=new Depot();
	public static Depot d2=new Depot();
	
	public static Store s1=new Store();
	public static Store s2=new Store();
	public static Store s3=new Store();
	public static Store s4=new Store();
	public static Store s5=new Store();
	
	public static ArrayList<Path> paths = new ArrayList<Path>();		
	public static ArrayList<Depot> depots = new ArrayList<>();
	public static ArrayList<Store> stores = new ArrayList<>();
		
	
	/**
	 * Find the shortest path according to the total distance between depot to store and store to customer.
	 * @param c Input a customer object, which sent by the Client.
	 * @return Path object with route name, distance and needed time.
	 * @throws Exception
	 */
	public static Path findShortestPath(Customer c) throws Exception {
	
		paths.clear();
		
		for(Depot d: depots) {
			for(Store s: stores) {
				double wholeDistance=distance(d.getCoo(),s.getCoo())
						+distance(s.getCoo(),address2coordinates(c.getAddress()));
				double time=wholeDistance/(60/3.6);
				paths.add(new Path(d.getName()+"->"+s.getName()+"->"+c.getName(),wholeDistance,timeConversion((int)time)));
			}
		}
		
		Collections.sort(paths);
		return paths.get(0);

	}
	
	/**
	 * Change time format
	 * @param totalSeconds 
	 * @return String with format of "xx minutes xx seconds"
	 */
	public static String timeConversion(int totalSeconds) {
			
		    final int SECONDS_IN_A_MINUTE = 60;
	
		    int seconds = totalSeconds % SECONDS_IN_A_MINUTE;
		    int minutes = totalSeconds / SECONDS_IN_A_MINUTE;
	
		    return minutes + " minutes " + seconds + " seconds";
		}
	
	
	/**
	 * Parsing address to Coordinates by using Google Geocoding API.
	 * @param add Input a valid address.
	 * @return Coordinates Object with two double values: latitude and longitude.
	 * @throws Exception
	 */
	public static Coordinates address2coordinates(String add) throws Exception {
	    URL url = new URL(
	    	      "https://maps.googleapis.com/maps/api/geocode/json?address=" 
	    	      + URLEncoder.encode(add, "UTF-8") + "&key=AIzaSyDFkZYfZM0HFkFFGLVw3Es5Y0CvrOSTqaQ");
//	    System.out.println(url);
	     	     
		Scanner scan = new Scanner(url.openStream());
		String str = new String();
		while (scan.hasNext())
			str += scan.nextLine();
		scan.close();
		 
		/* parse the JSON */	     
		JSONObject obj = new JSONObject(str);
		JSONObject res = obj.getJSONArray("results").getJSONObject(0);
		JSONObject loc = res.getJSONObject("geometry").getJSONObject("location");
		
		double lat = ((Number)loc.get("lat")).doubleValue();
		double lng = ((Number)loc.get("lng")).doubleValue();
		
		Coordinates coo=new Coordinates(lat, lng);

		return coo;
	
	}
	
	
	/**
	 * Calculate the straight line distance of two Coordinates.
	 * @param coo1 Location 1 with latitude and longitude.
	 * @param coo2 Location 2 with latitude and longitude.
	 * @return Getting result with double type.
	 */
	public static double distance(Coordinates coo1, Coordinates coo2) {

	    final int R = 6371; // Radius of the earth
	    
	    double lat1=coo1.getLatitude();
	    double lon1=coo1.getLongitude();
	    
	    double lat2=coo2.getLatitude();
	    double lon2=coo2.getLongitude();

	    double latDistance = Math.toRadians(lat2 - lat1);
	    double lonDistance = Math.toRadians(lon2 - lon1);
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters

	    distance = Math.pow(distance, 2) ;

	    return Math.sqrt(distance);
	}
	
}
