import java.io.*;
import java.net.*;
import lejos.hardware.motor.Motor;
//-----touchSensor
import lejos.hardware.BrickFinder;
import lejos.hardware.Keys;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.TextLCD;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.SensorMode;

public class EV3Robot {
	public static void main(String argv[]) throws Exception {

		// 抓touch sensor P185
		EV3 ev3brick = (EV3) BrickFinder.getLocal();
		Port portS1 = ev3brick.getPort("S1");
		EV3TouchSensor touchSensor = new EV3TouchSensor(portS1);
		SensorMode toucher = touchSensor.getTouchMode();
		float[] samplevalue = new float[toucher.sampleSize()];

		// socket
		String clientSentence="5";
		String capitalizedSentence;
		ServerSocket welcomeSocket = new ServerSocket(5555);

		Socket connectionSocket = welcomeSocket.accept();
		while (true) {
			toucher.fetchSample(samplevalue, 0);
				
			if (samplevalue[0] != 1) {//沒有撞牆
				//接收PC
				BufferedReader inFromClient = new BufferedReader(
						new InputStreamReader(connectionSocket.getInputStream()));
				clientSentence = inFromClient.readLine();
				System.out.println("Received: " + clientSentence);
				
				//給PC
				/*
				DataOutputStream outToClient = new DataOutputStream(
						connectionSocket.getOutputStream());
				capitalizedSentence = clientSentence.toUpperCase() + '\n';
				outToClient.writeBytes(capitalizedSentence);*/
			}
			else{
				clientSentence="5";
				
			}
			// touch 拿到資料

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

class CommandThread extends Thread {

    public void run(){
        
    }
	
}
