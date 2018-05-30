import lejos.hardware.Button;
import lejos.robotics.navigation.DifferentialPilot; 
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class irsensor {
	
public static void main(String[] args) {
		
		
		//���port2�Osensor
		EV3UltrasonicSensor UL = new EV3UltrasonicSensor(SensorPort.S2);
		SampleProvider ULsensor = UL.getDistanceMode();
		float[] sample = new float[ULsensor.sampleSize()];
		
		//6.8:���L���|15.5:����L�Z��
		//DifferentialPilot pilot = new DifferentialPilot (2.5 ,6, Motor.A, Motor.C);
		//pilot.setTravelSpeed(7);
		//pilot.forward();
		
		
		
		while(Button.ESCAPE.isUp()) {
			//Delay.msDelay(1);
			ULsensor.fetchSample(sample, 0);
			float distance =  sample[0];
			System.out.println("distance " + distance);
			
			
			if (distance < 0.1) {//�ּ���F
				//pilot.backward();//��h20����
				Motor.A.backward();
				Motor.C.backward();
				
			} else if(distance<0.5){
				Motor.C.rotate(360);
				
			}else{
				//pilot.forward();
				Motor.A.forward();
				Motor.C.forward();
				
			}
		}
		
		UL.close();
	}

}
