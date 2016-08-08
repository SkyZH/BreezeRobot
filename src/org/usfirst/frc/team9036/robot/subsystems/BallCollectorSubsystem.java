package org.usfirst.frc.team9036.robot.subsystems;

import org.usfirst.frc.team9036.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BallCollectorSubsystem extends Subsystem {
	VictorSP ballCollectorMotor;
	
	public BallCollectorSubsystem() {
		ballCollectorMotor = new VictorSP(RobotMap.BallCollectorMotorPort);
	}
	
	public void collect(){
    	ballCollectorMotor1.set(RobotMap.BallCollectorMotorSpeed);
    }
	
	public void stop(){
		ballCollectorMotor1.stopMotor();
	}
	
    public void initDefaultCommand() {
    }
}

