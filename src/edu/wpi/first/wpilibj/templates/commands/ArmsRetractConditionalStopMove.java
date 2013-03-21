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

/** Used for the climbing sequence to stop at a sensor.  Either the home sensor,
 * or the aft position sensor.
 *
 * @author Team 2035 Programmers
 */
public class ArmsRetractConditionalStopMove extends CommandBase {
    private Arms arm;
    private DriveTrain dt;
    private boolean started;
    private int endcondition;
    
    /**
     * @param endcond End condition (1 = home, 2 = aft)
     */
    public ArmsRetractConditionalStopMove(int endcond) {
        super("ArmsRetractConditionalStopMove");
        arm = ScraperBike.getArms();
        dt = ScraperBike.getDriveTrain();
        requires(arm);
        requires(dt);
        started = false;
        endcondition = endcond;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run, allows arms to retract only if they are hooked on to the bar on the pyramid
    protected void execute() {
        //if (arm.isContacting()) {
            started = true;
        //}
        if (started) {
            arm.move(-1);    
        }
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (endcondition == 1) {
            // if either sensor is tripped, then stop.
            return arm.isHomePosition() || arm.isLimitAft();
        }
        // otherwise only stop for the aft sensor.
        return arm.isLimitAft();
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
