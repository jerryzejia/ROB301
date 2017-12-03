package project;
import lejos.hardware.motor.*;
import lejos.hardware.lcd.*;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.*;

public class robot_runner {
	public static int existingAngle = 0; 
	
	
	
	public static void changeDir(int dirChange) {
		Motor.B.rotate((dirChange)*210,true);
		Motor.C.rotate(-(dirChange)*210);
		existingAngle += dir*90; 
		while(tiltsample[0] + existingAngle > 1 ){
			if(Button.ENTER.isDown()){
				break; 
			}
			tilt.getAngleMode().fetchSample(tiltsample, 0);

			Motor.B.rotate(dir*5);
			Motor.C.rotate(dir*-5);
			System.out.println(tiltsample[0] + " " + existingAngle );

		}
		while(tiltsample[0] + existingAngle < -1 ){
			if(Button.ENTER.isDown()){
				break; 
			}
			tilt.getAngleMode().fetchSample(tiltsample, 0);
			Motor.B.rotate(dir*-5);
			Motor.C.rotate(dir*5);
			System.out.println(tiltsample[0] + " " + existingAngle);
		}
	}

	public static void GoStraight() {
		Motor.B.resetTachoCount();
		Motor.C.resetTachoCount();			
		while (Motor.B.getTachoCount() < 640 )
		{
			if(Button.ENTER.isDown()){
				break; 
			}
			else
			{
				if(dirChange == 0){
					while(tiltsample[0] + existingAngle > 1 ){
						if(Button.ENTER.isDown()){
							break; 
						}
						tilt.getAngleMode().fetchSample(tiltsample, 0);

						Motor.B.rotate(5);
						Motor.C.rotate(-5); //left 
						System.out.println(tiltsample[0] + " " + "s");

					}
					while(tiltsample[0] + existingAngle < -1 ){
						if(Button.ENTER.isDown()){
							break; 
						}
						tilt.getAngleMode().fetchSample(tiltsample, 0);
						Motor.B.rotate(-5);
						Motor.C.rotate(5); //right 
						System.out.println(tiltsample[0] + " " +"s");
					}
				}

				Motor.B.setSpeed(200);
				Motor.C.setSpeed(200);
				Motor.B.forward();
				Motor.C.forward();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] pose1 = new int[]{0,1,1,0,3,3,0,0,0,1,1,2,1,1,0,3,2}; 


		EV3GyroSensor tilt = new EV3GyroSensor(SensorPort.S3);
		int gsampleSize = tilt.sampleSize();
		float[] tiltsample = new float[gsampleSize];
		LCD.clear();

		for (int i = 0; i < pose1.length-1; i++)
		{
			tilt.getAngleMode().fetchSample(tiltsample, 0);
			Motor.B.setSpeed(150);
			Motor.C.setSpeed(150);
			int dirChange = pose1[i+1]-pose1[i];   
			if(dirChange == -3){
				dirChange = 1;
			}
			else if(dirChange == 3){
				dirChange = -1;
			}
			changeDir(dirChange);
			
			if(i == pose1.length-2){
				break; 
			}
			GoStraight(); 
		
		}
	}
}

