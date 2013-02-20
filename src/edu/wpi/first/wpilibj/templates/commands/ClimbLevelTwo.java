/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**runs the necessary commands to make the robot climb up second level of the pyramid by itself, used as part of the ClimbPyramid command.
 *
 * @author bradmiller
 */
public class ClimbLevelTwo extends CommandGroup {

    public ClimbLevelTwo() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        addSequential(new ArmsExtend(2));
        addSequential(new ArmsRetract());
        addSequential(new Pause(2.0));
        //addSequential(new FrontPusherClimbOver()); should we add this as part of the code?
        //addSequential(new RearPusherClimbOver()); should we add this as part of the code?
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
