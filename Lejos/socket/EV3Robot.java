import java.io.*;
import java.net.*;

import lejos.hardware.Sound;
import lejos.hardware.motor.Motor;
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

			if (clientSentence.equals("8")) {
				Motor.A.forward();
				Motor.C.forward();

			} else if (clientSentence.equals("2")) {
				Motor.A.backward();
				Motor.C.backward();

			} else if (clientSentence.equals("4")) {
				Motor.C.rotate(360);
			} else if (clientSentence.equals("6")) {
				Motor.A.rotate(360);

			} else if (clientSentence.equals("5")) {
				Motor.A.stop();
				Motor.C.stop();

			}
		}
	}
}
