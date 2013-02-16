/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author bradmiller
 */
public class ClimbLevelOne extends CommandGroup {

    public ClimbLevelOne() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        addSequential(new FrontPusherExtend());
        addSequential(new ArmsExtend());
        addSequential(new ArmsRetractConditional());
        addSequential(new DisableJoystick());
        addSequential(new Pause(2.0));
        addSequential(new FrontPusherClimbOver());
        addSequential(new RearPusherClimbOver());
        addSequential(new ArmsExtend());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
