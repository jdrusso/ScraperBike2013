/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2013. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.ScraperBike;
import edu.wpi.first.wpilibj.templates.subsystems.VerticalTurretAxis;

/**
 *
 * @author Team 2035 Programmers
 */
public class ChangeShooterElevation extends CommandBase {
    private VerticalTurretAxis elev;
    private double degrees;
    
    /**allows the shooter to change position only if 
    * {@link ScraperBike#VerticalTurretAxis} subsystem isn't being used.
    * @param Degrees double value of the number of degrees to change.
    */
    public ChangeShooterElevation(double Degrees) {
        super("ChangeShooterElevation");
        elev = ScraperBike.getVerticalTurretAxis();
        requires(elev);
        degrees = Degrees;
    }

    // Called just before this Command runs the first time. resets gyro to 0.
    protected void initialize() {
       elev.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run.  moves turret up/down to the desired angle.
    protected void execute() {
        elev.moveElevation();
    }

    // Make this return true when this Command no longer needs to run execute(). checks the turret's angle to the desired angle, and if it is within the alloted margin of error, stops the turret from correcting itself.
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
