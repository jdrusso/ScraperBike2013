/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.ScraperBike;
import edu.wpi.first.wpilibj.templates.subsystems.Arms;

/**
 * Creates variables.
 * @author Team 2035
 */
public class ArmsExtendConditional extends CommandBase {
    private Arms arm;
    
    /**
     * Gives assignments to variables and requires the subsystem that it uses.
     */
    public ArmsExtendConditional() {
        arm = ScraperBike.getArms();
        requires(arm);
    }

    // Called just before this Command runs the first time
    
    
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    
    /**
     * Extends the arms.
     */
    protected void execute() {
        arm.move(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    
    /**
     * Checks to see if the arms are contacting.
     * @return true if the arms are contacting, false if they are not.
     */
    protected boolean isFinished() {
        return arm.isContacting();
    }

    // Called once after isFinished returns true
    
    /**
     * Stop moving the arms.
     */
    protected void end() {
         arm.move(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    
    /**
     * Stop moving the arms.
     */
    protected void interrupted() {
         arm.move(0);
    }
}
