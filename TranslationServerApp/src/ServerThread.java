import java.io.*;
import java.net.*;


public class ServerThread extends Thread {

	private Socket socket;
	private String engText;
	private String lang;

	public ServerThread(Socket socket) {
		engText = "";
		lang = "";
		this.socket = socket;
	}
	
	public void run() {
		
		try {
			
			DataInputStream input = new DataInputStream(socket.getInputStream());
			engText = input.readUTF();
			
			lang = input.readUTF();
			
			System.out.println("> The server has received text. and translating it now.");
			System.out.println();
			
			
			TranslationDB translationDB = new TranslationDB(engText, lang);
			String translated = translationDB.getTranslatedText();
			
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			output.writeUTF(translated);
			
			System.out.println("> Server: The translated text for " + engText + " in " + lang + " is " + translated);
			System.out.println();
			System.out.println("> Server: Translated text is sent.");
			System.out.println();
			System.out.println(">>>> Connection has ended.");
			System.out.println("");
			
			
			
			
			
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	
	
}
