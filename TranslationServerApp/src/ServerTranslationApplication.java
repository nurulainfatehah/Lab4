import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerTranslationApplication {

	public static void main(String[] args) throws IOException{
		
		ServerSocket serverSocket = new ServerSocket(2992);
		
		System.out.println("> Server: waiting for connection.\n");
		
		while(true) {
			
			Socket socket = serverSocket.accept();
			System.out.println("> Server: New connection at Translation App.");
			System.out.println("");
			
			new ServerThread(socket).start();
			
			
			
			
			
		}
		
		 

	}

}
