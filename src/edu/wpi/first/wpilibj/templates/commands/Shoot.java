/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.ScraperBike;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;

/**
 * Creates variables.
 * @author Team 2035 Programmers
 */
public class Shoot extends CommandBase {
    private Shooter shooter;
    private Joystick joystick;
    
    /**
     * Gives variables an assignment and requires the subsystem it uses.
     */
    public Shoot() {
        shooter = ScraperBike.getShooterController();
        requires(shooter);
        joystick = RobotMap.dStick;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    
    /**
     * Sets the speed of the shooter motor.
     */
    protected void execute() {
        shooter.setShooterMotor(joystick.getZ());
        ScraperBike.debugToTable("Shooter Z", joystick.getZ());
    }

    // Make this return true when this Command no longer needs to run execute()
    
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    
    /**
     * Stops the shooter motor. 
     */
    protected void end() {
        shooter.setShooterMotor(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    
    /**
     * Stops the shooter motor.s
     */
    protected void interrupted() {
        shooter.setShooterMotor(0.0);
    }
}
