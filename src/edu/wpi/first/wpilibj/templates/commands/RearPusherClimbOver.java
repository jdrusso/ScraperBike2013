/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2013. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.ScraperBike;
import edu.wpi.first.wpilibj.templates.subsystems.Arms;
import edu.wpi.first.wpilibj.templates.subsystems.Pusher;

/**
 *retracts and then extends rear pusher so it goes over the lip of the pyramid.
 * @author Team 2035 programmers
 */
public class RearPusherClimbOver extends CommandBase {
    private Pusher pusher;
    private Arms arms;
    private int state;
    
    public RearPusherClimbOver() {
        pusher = ScraperBike.getPusher();
        requires(pusher);
        arms = ScraperBike.getArms();
        requires(arms);
        state = 0;
    }

    protected void initialize() {
    }

    //checks and sees what the state of the rear pusher's surroundings are to see if it should extend/retract or not.
    protected void execute() {
//        if (state == 0) {
//            if (pusher.checkRearSensor1()) {
//                state = 1;
//            }
//        } else if (state == 1) {
//            pusher.moveRearPusher(0);
//            // may need a dealy
//            state = 2;
//        } else if (state == 2) {
//            arms.move(-1);
//            state = 3;
//        } else if (state == 3) {
//            if (pusher.checkRearSensor2()) {
//                pusher.moveRearPusher(1);
//                // may need delay
//                state = 4;
//            }
//        } 
        
    }

    protected boolean isFinished() {
        return (state == 4);
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
