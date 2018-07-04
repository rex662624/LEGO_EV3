import java.io.*;
import java.net.*;

public class EV3PC {
	public static void main(String argv[]) throws Exception {
		String sentence;
		String modifiedSentence;
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
				System.in));
		Socket clientSocket = new Socket("192.168.43.217", 5555);
		
		while (true) {
			
			//µ¹EV3
			if()
			DataOutputStream outToServer = new DataOutputStream(
					clientSocket.getOutputStream());
			sentence = inFromUser.readLine();
			outToServer.writeBytes(sentence + '\n');
			//±µ¦¬EV3
			/*BufferedReader inFromServer = new BufferedReader(
			new InputStreamReader(clientSocket.getInputStream()));*/
			//modifiedSentence = inFromServer.readLine();
			//System.out.println("FROM SERVER: " + modifiedSentence);
		}
		
		
		//clientSocket.close();
	}
}
