/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2013. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.ScraperBike;
import edu.wpi.first.wpilibj.templates.subsystems.Arms;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;

/**
 *
 * @author Team 2035 Programmers
 */
public class ArmsExtend extends CommandBase {
    private Arms arm;
    private DriveTrain dt;
    private int endcond;
    
    
    public ArmsExtend(int endCondition) {
        arm = ScraperBike.getArms();
        dt = ScraperBike.getDriveTrain();
        requires(arm);
        requires(dt);
        endcond = endCondition;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (arm.isLimitFore())
            arm.move(0.0);
        else
            arm.move(1.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
//        if (endcond == 1) {
//            return arm.isContacting();
//        } else if (endcond == 2) {
//            return arm.isLimitFore();
//        } 
//        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        arm.move(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
         arm.move(0.0);
    }
}
