/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.ScraperBike;
import edu.wpi.first.wpilibj.templates.subsystems.Pusher;

/**
 *
 * @author bradmiller
 */
public class FrontPusherClimbOver extends CommandBase {
    private Pusher g;
    
    public FrontPusherClimbOver() {
        g = ScraperBike.getPusher();
        requires(g);
    }

    protected void initialize() {
    }

    protected void execute() {
        g.moveFrontPusher(1);
    }

    protected boolean isFinished() {
        return g.isFrontContacting();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
