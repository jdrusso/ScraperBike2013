/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.ScraperBike;
import edu.wpi.first.wpilibj.templates.subsystems.VerticalTurretAxis;

/**
 *
 * @author bradmiller
 */
public class ChangeShooterElevation extends CommandBase {
    private VerticalTurretAxis elev;
    private double degrees;
    
    public ChangeShooterElevation(int Degrees) {
        elev = ScraperBike.getVerticalTurretAxis();
        degrees = Degrees;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
       elev.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        elev.moveElevation();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
       return (Math.abs(degrees - VerticalTurretAxis.readGyroDegress())< 0.1);
    }

    // Called once after isFinished returns true
    protected void end() {
        elev.updateAngle(degrees);
        elev.stopElevation();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
