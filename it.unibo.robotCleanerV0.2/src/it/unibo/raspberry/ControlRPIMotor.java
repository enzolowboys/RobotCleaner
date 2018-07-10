package it.unibo.raspberry;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.wiringpi.SoftPwm;


public class ControlRPIMotor {
	
	private static int MOTOR_1_PIN_A = 4;
	private static int MOTOR_1_PIN_B = 5;
	private static int MOTOR_2_PIN_A = 0;
	private static int MOTOR_2_PIN_B = 2;
	private static final GpioController gpio = GpioFactory.getInstance();
	
	
	private static void init (){
		
		
		SoftPwm.softPwmCreate(MOTOR_1_PIN_A, 0, 100);
		SoftPwm.softPwmCreate(MOTOR_1_PIN_B, 0, 100);
		SoftPwm.softPwmCreate(MOTOR_2_PIN_A, 0, 100);
		SoftPwm.softPwmCreate(MOTOR_2_PIN_B, 0, 100);
		// init GPIO pins

	}
	
	
	public static void forward(){
		
		init();
		SoftPwm.softPwmWrite(MOTOR_1_PIN_A, 30);
		SoftPwm.softPwmWrite(MOTOR_2_PIN_A, 30);
		
		
	}
	
	public static void backward(){
		
		init();
		SoftPwm.softPwmWrite(MOTOR_1_PIN_B, 30);
		SoftPwm.softPwmWrite(MOTOR_2_PIN_B, 30);
		
	}
	
	public static void leftward() throws InterruptedException{
		
		init();
		SoftPwm.softPwmWrite(MOTOR_1_PIN_A,15);
		SoftPwm.softPwmWrite(MOTOR_2_PIN_A, 0);
		Thread.sleep(2000);
		gpio.shutdown();
		
		
	}
	
	public static void rightward() throws InterruptedException{
		
		init();
		SoftPwm.softPwmWrite(MOTOR_1_PIN_A,0);
		SoftPwm.softPwmWrite(MOTOR_2_PIN_A,15);
		Thread.sleep(2000);
		gpio.shutdown();
		
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		forward();
		Thread.sleep(3000);
		backward();
		Thread.sleep(3000);
		rightward();
		Thread.sleep(3000);
		leftward();
		Thread.sleep(3000);
	}
}