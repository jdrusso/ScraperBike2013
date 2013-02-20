/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.ScraperBike;
import edu.wpi.first.wpilibj.templates.subsystems.Arms;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;

/**
 * Creates variables.
 * @author Team 2035 Programmers
 */
public class ArmsExtend extends CommandBase {
    private Arms arm;
    private int endCond;
    
    /**
     * Gives Assignments to variables and requires each subsystem that it uses.
     * @param endCondition 
     */
    private DriveTrain dt;
    
    public ArmsExtend(int endCondition) {
        arm = ScraperBike.getArms();
        dt = ScraperBike.getDriveTrain();
        requires(arm);
        endCond = endCondition;
        requires(dt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    
     /**
     * The Arms extend at full speed until limit switch is triggered,
     * or button is released.
     */
    protected void execute() {
        arm.move(1);
    }
    
    // Make this return true when this Command no longer needs to run execute()
    
    /**
     * Checks the arm's current position and if the arms are contacting the
     * pyramid or are extended to far.
     * @return the limit of the arms or if the arms are contacting
     */
    protected boolean isFinished() {
        if (endCond == 1) {
            return arm.isContacting();
        } else if (endCond == 2) {
            return arm.isLimitFore();
        } 
        return false;
//        if (endcond == 1) {
//            return arm.isContacting();
//        } else if (endcond == 2) {
//            return arm.isLimitFore();
//        } 
//        return false;
    }
    
    // Called once after isFinished returns true
    
    /**
     * Stop extending or retracting arms.
     */
    protected void end() {
        arm.move(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    
    /**
     * Stop extending or retracting the arms.
     */
    protected void interrupted() {
         arm.move(0);
    }
}
