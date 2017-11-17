package org.usfirst.frc.team5490.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {
    
	RobotDrive m_robotDrive;
	SpeedController motorFrontLeft;
    SpeedController motorRearLeft;  
    SpeedController motorFrontRight;
    SpeedController motorRearRight;
	 
	public Robot() {
		motorFrontLeft = new Talon(0);
		motorRearLeft = new Talon(3);
		motorFrontRight = new Talon(1);
		motorRearRight = new Talon(2);
		
		m_robotDrive = new RobotDrive(motorFrontLeft,motorRearLeft,motorFrontRight,motorRearRight);
		m_robotDrive.setInvertedMotor(MotorType.kFrontLeft, true);
		m_robotDrive.setInvertedMotor(MotorType.kRearLeft, true);
		
	}
	
	
	Joystick m_driveStick = new Joystick(1);
	
	public void teleopPeriodic() {
		double speed = (-1*m_driveStick.getThrottle()+1)/2;
		m_robotDrive.mecanumDrive_Cartesian(-speed*m_driveStick.getX(), speed*m_driveStick.getY(), speed*m_driveStick.getTwist(), 0);
		
		
		//		if (m_driveStick.getZ()>0){
//			float twist = (float) m_driveStick.getZ();
//			m_robotDrive.mecanumDrive_Cartesian(twist*m_driveStick.getX(), 0*m_driveStick.getY(), twist*m_driveStick.getTwist(), 0);
//			
//		}
		
	}
	
}





//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.RobotDrive;
//import edu.wpi.first.wpilibj.RobotDrive.MotorType;
//import edu.wpi.first.wpilibj.SampleRobot;
//import edu.wpi.first.wpilibj.Timer;
//
///**
// * This is a demo program showing how to use Mecanum control with the RobotDrive
// * class.
// */
//public class Robot extends SampleRobot {
//	RobotDrive robotDrive;
//
//	// Channels for the wheels
//	final int kFrontLeftChannel = 2;
//	final int kRearLeftChannel = 3;
//	final int kFrontRightChannel = 1;
//	final int kRearRightChannel = 0;
//
//	// The channel on the driver station that the joystick is connected to
//	final int kJoystickChannel = 0;
//
//	Joystick stick = new Joystick(kJoystickChannel);
//
//	public Robot() {
//		robotDrive = new RobotDrive(kFrontLeftChannel, kRearLeftChannel, kFrontRightChannel, kRearRightChannel);
//		robotDrive.setInvertedMotor(MotorType.kFrontLeft, true); // invert the
//																	// left side
//																	// motors
//		robotDrive.setInvertedMotor(MotorType.kRearLeft, true); // you may need
//																// to change or
//																// remove this
//																// to match your
//																// robot
//		robotDrive.setExpiration(0.1);
//	}
//
//	/**
//	 * Runs the motors with Mecanum drive.
//	 */
//	@Override
//	public void operatorControl() {
//		robotDrive.setSafetyEnabled(true);
//		while (isOperatorControl() && isEnabled()) {
//
//			// Use the joystick X axis for lateral movement, Y axis for forward
//			// movement, and Z axis for rotation.
//			// This sample does not use field-oriented drive, so the gyro input
//			// is set to zero.
//			robotDrive.mecanumDrive_Cartesian(stick.getX(), stick.getY(), stick.getZ(), 0);
//
//			Timer.delay(0.005); // wait 5ms to avoid hogging CPU cycles
//		}
//	}
//}
