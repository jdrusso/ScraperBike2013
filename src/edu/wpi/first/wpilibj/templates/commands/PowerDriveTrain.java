/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2013. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.ScraperBike;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;

/**
 *
 * @author Team 2035 Programmers
 */
public class PowerDriveTrain extends CommandBase {
    private DriveTrain drive;
    private boolean commanded;

    /**
     *
     */
    public PowerDriveTrain() {
        super("PowerDriveTrain");
        drive = ScraperBike.getDriveTrain();
        commanded = false;
        //requires(drive);
    }

    /** This method is called just before this Command runs the first time
     * 
     */
    protected void initialize() {
        // code here is run once.  This could have also been done in the constructor.
        // simply an extra option to have it here.
    }

    /** Called repeatedly when this Command is scheduled to run
     *
     */
    protected void execute() {
        drive.powerDriveTrain();
        commanded = true;
        // code here is executed repeatedly until isFinished() returns true
    }

    /** This method returns true when this Command no longer needs to run execute()
     * 
     * @return true only after the command has finished (using a switch or other sensor or a timer)
     */
    protected boolean isFinished() {
        return commanded;
    }

    /** This method is called once after isFinished returns true
     * 
     */
    protected void end() {
        
        // code here is run once after isFinished() returns true.
    }

    /** This method is called when another command which requires one or more of the same
     * subsystems is scheduled to run.
     */
    protected void interrupted() {
        
    }
}
