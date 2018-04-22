import java.io.*;
import java.net.*;

import lejos.hardware.Sound;
import lejos.utility.Delay;

public class EV3Robot {
	public static void main(String argv[]) throws Exception {
		String clientSentence;
		String capitalizedSentence;
		ServerSocket welcomeSocket = new ServerSocket(5555);
		
		
		Socket connectionSocket = welcomeSocket.accept();
		while (true) {
			
			BufferedReader inFromClient = new BufferedReader(
					new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(
					connectionSocket.getOutputStream());
			clientSentence = inFromClient.readLine();
			System.out.println("Received: " + clientSentence);
			capitalizedSentence = clientSentence.toUpperCase() + '\n';
			outToClient.writeBytes(capitalizedSentence);
			
			if(clientSentence.equals("5")){
				 Sound.twoBeeps();
				 Delay.msDelay(1000);
				
			}
		}
	}
}
