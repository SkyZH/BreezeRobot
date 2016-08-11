package org.usfirst.frc.team9036.robot;

import org.usfirst.frc.team9036.robot.commands.drive.GyroAbsoluteRotateCommand;
import org.usfirst.frc.team9036.robot.commands.drive.GyroRotateCommand;
import org.usfirst.frc.team9036.robot.commands.drive.ReverseDriveDirectionCommand;
import org.usfirst.frc.team9036.robot.commands.drive.VisionAutoAimCommand;
import org.usfirst.frc.team9036.robot.commands.shooter.BallShooterCommand;
import org.usfirst.frc.team9036.robot.commands.shooter.BallShooterCommandGroup;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	Joystick mainJoystick;
	Joystick shootJoystick;

	Button gyroTurningButton;
	
	Button forwardTurningButton;
	Button backwardTurningButton;
	Button leftTurningButton;
	Button rightTurningButton;
	Button leftShooterTurningButton;
	Button rightShooterTurningButton;
	Button ballAutoAimButton;
	Button ballShooterLeftButton;
	Button ballShooterRightButton;
	
	public OI() {
		// Initialize Joysticks
		mainJoystick = new Joystick(RobotMap.DriverJoystickPort);
		shootJoystick = new Joystick(RobotMap.ShooterJoystickPort);

		// Main Joystick Button
		gyroTurningButton = new JoystickButton(mainJoystick, RobotMap.GyroTurningButtonID);
		forwardTurningButton = new JoystickButton(mainJoystick, RobotMap.ForwardTurningButtonID);
		backwardTurningButton = new JoystickButton(mainJoystick, RobotMap.BackwardTurningButtonID);
		leftTurningButton = new JoystickButton(mainJoystick, RobotMap.LeftTurningButtonID);
		rightTurningButton = new JoystickButton(mainJoystick, RobotMap.RightTurningButtonID);
		
		// Shoot Joystick Button
		ballAutoAimButton = new JoystickButton(shootJoystick, RobotMap.BallAutoAimButtonID);
		leftShooterTurningButton = new JoystickButton(shootJoystick, RobotMap.LeftShooterTurningButtonID);
		rightShooterTurningButton = new JoystickButton(shootJoystick, RobotMap.RightShooterTurningButtonID);
		ballShooterLeftButton = new JoystickButton(shootJoystick, RobotMap.LeftBallShooterButtonID);
		ballShooterRightButton = new JoystickButton(shootJoystick, RobotMap.RightBallShooterButtonID);
		
		// Main Button Command
		forwardTurningButton.whileHeld(new GyroAbsoluteRotateCommand(0));
		backwardTurningButton.whileHeld(new GyroAbsoluteRotateCommand(180));
		leftTurningButton.whileHeld(new GyroRotateCommand(-90));
		rightTurningButton.whileHeld(new GyroRotateCommand(90));
		
		// Shooter Button Command
		gyroTurningButton.whenPressed(new ReverseDriveDirectionCommand()); // TODO: Remove Test Button
		ballAutoAimButton.whileHeld(new VisionAutoAimCommand());
		leftShooterTurningButton.whileHeld(new GyroRotateCommand(-60));
		rightShooterTurningButton.whileHeld(new GyroRotateCommand(60));
		ballAutoAimButton.whileHeld(new VisionAutoAimCommand());
		ballShooterLeftButton.whileHeld(new BallShooterCommand());
		ballShooterRightButton.whileHeld(new BallShooterCommand());
	}

	public boolean getMainButton(int button) {
		return mainJoystick.getRawButton(button);
	}

	public boolean getShootButton(int button) {
		return shootJoystick.getRawButton(button);
	}

	public double getMainAxis(int axis) {
		return mainJoystick.getRawAxis(axis);
	}
	
	public double getMainPOV(int pov){
		return mainJoystick.getPOV(pov);
	}
	
	public double getShootPOV(int pov){
		return shootJoystick.getPOV(pov);
	}

	public double getShootAxis(int axis) {
		return shootJoystick.getRawAxis(axis);
	}
}
