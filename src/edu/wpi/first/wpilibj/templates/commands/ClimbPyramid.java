/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2013. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**Runs the necessary commands to make the robot climb up the pyramid by itself when button 9 on the drive joystick is pressed.
 *
 * @author bradmiller
 */
public class ClimbPyramid extends CommandGroup {
    
    public ClimbPyramid() {
        addSequential(new ClimbLevelOne());
        //addSequential(new Pause(0.6));, if we implement this command, should we have a pause inbetween the level climbs?
        addSequential(new ClimbLevelTwo());
        //addSequential(new Pause(0.6));, if we implement this command, should we have a pause inbetween the level climbs?
        addSequential(new ClimbLevelThree());
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