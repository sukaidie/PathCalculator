package realDigital.pathCalculator.Server;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

import realDigital.pathCalculator.Algorithm.Algorithm;
import realDigital.pathCalculator.Data.Customer;

/**
 * Thread for receiving requests from the Client.
 * Once connected, in the console you can see "Client connected" and also the customer information.
 */

public class ServerInputThread extends Thread{
	private Socket socket;

	public ServerInputThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {

				InputStream is=socket.getInputStream();
				
				ObjectInputStream ois=new ObjectInputStream(is);
				
				ArrayList<Customer> request=new ArrayList<>();
		        request=(ArrayList<Customer>)ois.readObject();

		        for(int i=0;i<request.size();i++){
		            System.out.println("Customer name: "+request.get(i).getName());
					System.out.println("Customer address: "+request.get(i).getAddress());
					System.out.println("Calculating... please wait");
					System.out.println("Shortest Path: "+Algorithm.findShortestPath(request.get(i)));
					System.out.println("---------------------------------------");
		        }		        
//		        ois.close();		
//		        is.close();
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
