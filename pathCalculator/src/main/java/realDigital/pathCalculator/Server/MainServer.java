package realDigital.pathCalculator.Server;

import java.net.ServerSocket;
import java.net.Socket;

import realDigital.pathCalculator.Algorithm.Algorithm;


/**
 * This class is the Server of the program and needs to run first.
 * Once Server started, the Server begins to wait for requests from the Client.
 * In order to reduce the calculation time of finding the shortest path, the coordinates of depots and stores will 
 * 	be parsed before receiving the request from the client.
 * The way to parse the address is using Google Geocoding API, so this program can only work with network.
 * For simplicity, the communication between the Server and the Client is one-way, which means, the Client sends 
 * 	requests to the Server, and then Server prints the result direct in the console , without sending the result 
 * 	back to the Client.
 * @author Kaidie Su
 */

public class MainServer {
	
	public static void main(String[] args) throws Exception {
		System.out.println("Server is starting... please wait");

		Algorithm.d1.setName("d1");
		Algorithm.d1.setAddress("Metrostrasse 12, 40235 Düsseldorf");
		Algorithm.d1.setCoo(Algorithm.address2coordinates("Metrostrasse 12, 40235 Düsseldorf"));
		
		Algorithm.d2.setName("d2");
		Algorithm.d2.setAddress("Am Albertussee 1, 40549 Düsseldorf");
		Algorithm.d2.setCoo(Algorithm.address2coordinates("Am Albertussee 1, 40549 Düsseldorf"));
		
		Algorithm.s1.setName("s1");
		Algorithm.s1.setAddress("Schiessstraße 31, 40549 Düsseldorf");
		Algorithm.s1.setCoo(Algorithm.address2coordinates("Schiessstraße 31, 40549 Düsseldorf"));
		
		Algorithm.s2.setName("s2");
		Algorithm.s2.setAddress("Friedrichstraße 152, 40217 Düsseldorf");
		Algorithm.s2.setCoo(Algorithm.address2coordinates("Friedrichstraße 152, 40217 Düsseldorf"));
		
		Algorithm.s3.setName("s3");
		Algorithm.s3.setAddress("Breslauer Str. 2, 41460 Neuss");
		Algorithm.s3.setCoo(Algorithm.address2coordinates("Breslauer Str. 2, 41460 Neuss"));
		
		Algorithm.s4.setName("s4");
		Algorithm.s4.setAddress("Bataverstraße 93, 41462 Neuss");
		Algorithm.s4.setCoo(Algorithm.address2coordinates("Bataverstraße 93, 41462 Neuss"));
		
		Algorithm.s5.setName("s5");
		Algorithm.s5.setAddress("Am Sandbach 30, 40878 Ratingen");
		Algorithm.s5.setCoo(Algorithm.address2coordinates("Am Sandbach 30, 40878 Ratingen"));
		
		Algorithm.depots.add(Algorithm.d1);
		Algorithm.depots.add(Algorithm.d2);
			
		Algorithm.stores.add(Algorithm.s1);
		Algorithm.stores.add(Algorithm.s2);
		Algorithm.stores.add(Algorithm.s3);
		Algorithm.stores.add(Algorithm.s4);
		Algorithm.stores.add(Algorithm.s5);
		
		System.out.println("---------------------------------------");
		System.out.printf("%-45s%s%n", Algorithm.d1.getName()+": "+Algorithm.d1.getAddress(), Algorithm.d1.getCoo());
		System.out.printf("%-45s%s%n", Algorithm.d2.getName()+": "+Algorithm.d2.getAddress(), Algorithm.d2.getCoo());
		System.out.printf("%-45s%s%n", Algorithm.s1.getName()+": "+Algorithm.s1.getAddress(), Algorithm.s1.getCoo());
		System.out.printf("%-45s%s%n", Algorithm.s2.getName()+": "+Algorithm.s2.getAddress(), Algorithm.s2.getCoo());
		System.out.printf("%-45s%s%n", Algorithm.s3.getName()+": "+Algorithm.s3.getAddress(), Algorithm.s3.getCoo());
		System.out.printf("%-45s%s%n", Algorithm.s4.getName()+": "+Algorithm.s4.getAddress(), Algorithm.s4.getCoo());
		System.out.printf("%-45s%s%n", Algorithm.s5.getName()+": "+Algorithm.s5.getAddress(), Algorithm.s5.getCoo());
		System.out.println("---------------------------------------");
		System.out.println("Server started successfully and is waiting for the client request.");
		System.out.println("---------------------------------------");
			
		
		ServerSocket serversocket=new ServerSocket(7777);
		
		while(true) {
			Socket socket=serversocket.accept();
						
			System.out.println(">>> Client connected");
			System.out.println("---------------------------------------");
			new ServerInputThread(socket).start();
		}

	}

}
