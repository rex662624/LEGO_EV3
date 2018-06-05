import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;


public class GyroSensor {

	//Robot Configuration
	private static EV3GyroSensor gyroSensor = new EV3GyroSensor(SensorPort.S4);

	public static void main(String[] args) {

		final SampleProvider sp = gyroSensor.getAngleAndRateMode();

        //Control loop
		while(Button.ESCAPE.isUp()){
			float [] sample = new float[sp.sampleSize()];
            sp.fetchSample(sample, 0);
           
            
            System.out.println("Angle " +sample[0]);
            
			if(sample[0] > 5.0){
				Motor.A.rotate(100);	
				//break;
			}

			/*iterationCounter++;
			if(iterationCounter >= 100){
				break;
			}

			Delay.msDelay(500);*/
		}

	}

}