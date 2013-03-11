/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2013. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/** Runs the necessary commands to make the robot climb up first level of the 
 * pyramid by itself, used as part of the ClimbPyramid command.
 *
 * @author Team 2035 Programmers
 */
public class ClimbLevelOne extends CommandGroup {

    public ClimbLevelOne() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        addSequential(new DisableJoystick());
        addSequential(new FrontPusherExtend(1));
        addSequential(new Pause(0.25));
        addSequential(new FrontPusherExtend(2));
        addSequential(new ArmsExtend(2));
        addSequential(new FrontPusherRetract());
        addSequential(new ArmsRetract());
        addSequential(new Pause(2.0));
        //addSequential(new FrontPusherClimbOver());
        //addSequential(new RearPusherClimbOver());
        //addSequential(new ArmsExtend());//not sure, but I think this should be deleted
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
