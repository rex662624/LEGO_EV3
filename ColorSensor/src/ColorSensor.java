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
			
			//Motor.A.forward();
			//Motor.C.forward();
			if (colorSample[0] > 0.1) {//¥Õ
				Motor.A.rotate(15);
				
			}else{
				
				Motor.C.rotate(15);
				
			}

		} 

	}
	
	
}
