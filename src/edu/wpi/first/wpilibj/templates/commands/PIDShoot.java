
/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2013. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.PIDVelocityCommand;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.ScraperBike;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;

/**
 * @author Team 2035 Programmers
 */
public class  PIDShoot extends PIDVelocityCommand {
    private Shooter shooter;

    /**
     *
     */
    public PIDShoot() {
        
        super("PIDShoot", RobotMap.shooterKp, RobotMap.shooterKi, RobotMap.shooterKd);
        getPIDController().setContinuous(false);
        this.shooter = ScraperBike.getShooterController();
        requires(this.shooter);
        //RobotMap.shootRPM = rpm;
        //this.getPIDController().setSetpoint(RobotMap.shootRPM);
        this.getPIDController().setOutputRange(0.0, 1.0);
        this.getPIDController().setPercentTolerance(2);
    }

    /**
     *
     * @return
     */
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
		
        ScraperBike.debugToTable("PIDInput", RobotMap.shootEncoder.getRate()*60);
        
        return RobotMap.shootEncoder.getRate()*60;
    }

    /**
     *
     * @param output
     */
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
	
        if(output >= 0.0)
            this.shooter.setShooterMotor(output);
        ScraperBike.debugToTable("PIDOutput", output);
    }

    // Called just before this Command runs the first time
    /**
     *
     */
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     *
     */
    protected void execute() {
        this.setSetpoint(OI.getAdjustedThrottle()*RobotMap.maxRPM);
        ScraperBike.debugToTable("PIDSetpoint", OI.getAdjustedThrottle()*RobotMap.maxRPM);
        
    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     *
     * @return
     */
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    /**
     *
     */
    protected void end() {
        
        this.getPIDController().disable();
        shooter.setShooterMotor(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    /**
     *
     */
    protected void interrupted() {
        
        this.getPIDController().disable();
        shooter.setShooterMotor(0.0);
    }
}