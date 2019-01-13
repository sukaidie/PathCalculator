package realDigital.pathCalculator.Client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import realDigital.pathCalculator.Data.Customer;

/**
 * Thread for sending requests to the Server.
 * The request is an ArrayList of customers, you can change the customer data by inputting a valid address.
 */

public class ClientOutputThread extends Thread{
	private Socket socket;

	public ClientOutputThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			
			OutputStream os=socket.getOutputStream();
			
			try {
				Customer c1=new Customer("c1", "Kronprinzenstraße 88, 40217 Düsseldorf");
				Customer c2=new Customer("c2","Kaiserstraße 2, 40479 Düsseldorf");
				Customer c3=new Customer("c3","Wildenbruchstraße 2, 40545 Düsseldorf");
				Customer c4=new Customer("c4","Schlesische Straße 5, 40231 Düsseldorf");
//				Customer c5=new Customer("c5","Küntzelstraße 18, 45147 Essen");
	
				ObjectOutputStream oos=new ObjectOutputStream(os);
				
				ArrayList<Customer> request=new ArrayList<>();
				request.add(c1);
				request.add(c2);
				request.add(c3);
				request.add(c4);
//				request.add(c5);
				
				//Entry to change the customer
				oos.writeObject(request);
				oos.flush();
				
				oos.close();
				os.close();
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
