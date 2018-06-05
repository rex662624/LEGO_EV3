import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;



public class ColorSensor {
	public static void main(String[] args) {


		// Color sensor
		EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S3);
		SensorMode color = colorSensor.getRGBMode();
		float[] colorSample = new float[color.sampleSize()];


		while(Button.ESCAPE.isUp()) {
		
			color.fetchSample(colorSample, 0);
			System.out.println("Color " + colorSample[0]);
			
			if(colorSample[0] > 0.3){
				Motor.A.rotate(25);
			}
			else{
				Motor.C.rotate(25);
			}
			
			//Motor.A.forward();
			//Motor.C.forward();
			/*
			if(colorSample[0] > 0.3){
				Motor.A.rotate(30);
			}
			else if(colorSample[0] > 0.2){
				Motor.A.rotate(20);
			}
			
			else if (colorSample[0] > 0.1) {//¥Õ
				Motor.A.rotate(10);
				
			}else{
				Motor.C.rotate(40);
				Motor.A.rotate(20);
			}*/

		} 

	}
	
	
}
