/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2013. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**runs the necessary commands to make the robot climb up third level of the 
 * pyramid by itself, used as part of the ClimbPyramid command.
 *
 * @author Team 2035 Programmers
 */
public class ClimbLevelThree extends CommandGroup  {

    /**
     *
     */
    public ClimbLevelThree() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        addSequential(new ArmsExtendConditional());
        addSequential(new ArmsRetract());
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
