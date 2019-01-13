package realDigital.pathCalculator.Client;

import java.net.Socket;

/**
 * This class is the Client of the program and should run after Server is running.
 * The communication with the server is implemented through Socket. 
 * Once Server started, the Client can continuously send requests and each time a new Thread will be created.
 */

public class ClientServer {

	public static void main(String[] args) throws Exception {
		String ip="localhost";
		int port=7777;
		Socket socket=new Socket(ip,port);
		
		new ClientOutputThread(socket).start();

	}

}
