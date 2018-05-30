import java.net.ServerSocket;
import java.net.Socket;

import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;

public class main {

	public static void main(String[] args) throws Exception {
		
		Motor.A.forward();
		Motor.C.forward();
		
		//touchSensor
		EV3TouchSensor touch = new EV3TouchSensor(SensorPort.S1);
		//§ì¨ìªº¼Æ¦r
		int sampleSize = touch.sampleSize();
		float[] sample = new float[sampleSize];
		
		while(sample[0]<1){
			touch.fetchSample(sample, 0);
		};
		Motor.A.stop();
		Motor.C.stop();
		
		
		
	}
}