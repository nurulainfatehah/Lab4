import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerWordCounterApp {

	public static void main(String[] args) throws Exception{
		
		//Launch the server frame
		ServerWordCounterFrame serverFrame = new ServerWordCounterFrame();
		serverFrame.setVisible(true);


		ServerSocket serverSocket = new ServerSocket(2393);	

		// the counter of number requested for connection
		int totalRequest = 0;



		while(true) {
			//accept client request for connection
			Socket clientSocket = serverSocket.accept();
			
			serverFrame.updateServerStatus(clientSocket.isConnected());
			
			serverFrame.updateRequestStatus("New connection is made.");
			
			
			DataInputStream input = new DataInputStream(clientSocket.getInputStream());
			String text = input.readUTF();
			serverFrame.updateRequestStatus("Server is counting number of words now....");
			
			
			WordCounter wc = new WordCounter();
			wc.setText(text);
			
			int totalword = 0;
			
			totalword =	wc.getWordCount();
			
			serverFrame.updateWordCount(totalword, text);
			
			DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
			output.writeUTF(String.valueOf(totalword));
			
			serverFrame.updateRequestStatus("Server found " + totalword + " word(s) from '"+ text + "' ");

			
			
			
			
			//update the request status
			//serverFrame.updateRequestStatus("Data sent to the client: ");
			serverFrame.updateRequestStatus("Accepted connection from the client. Total request = " + ++totalRequest);

			clientSocket.close();


		}
	
		
				
				
	}

}
