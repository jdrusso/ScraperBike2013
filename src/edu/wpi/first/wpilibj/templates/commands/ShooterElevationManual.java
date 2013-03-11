/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2013. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.ScraperBike;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.subsystems.VerticalTurretAxis;

/** Allows you to manually change the angle of the shooter with the y-axis of 
 * the shooter joystick.
 *
 * @author jrusso
 */
public class ShooterElevationManual extends CommandBase {
    public double direction;
//    public Relay VerTurretSpike;
    public VerticalTurretAxis vt;
    
    public ShooterElevationManual() {
        vt = ScraperBike.getVerticalTurretAxis();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(vt);
//        VerTurretSpike = RobotMap.VerTurretMotorSpike;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//        if (direction > 0)
//            VerTurretSpike.set(Relay.Value.kForward);
//        else
//            VerTurretSpike.set(Relay.Value.kReverse);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        direction = RobotMap.shootStick.getY();
        vt.rotate(direction);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
//        VerTurretSpike.set(Relay.Value.kOff);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
//        VerTurretSpike.set(Relay.Value.kOff);
        vt.rotate(0.0);
    }
}
