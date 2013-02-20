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
 * @author Team 2035 Programmers
 */
public class RearPusherRetract extends CommandBase {
    private Pusher g;
    private boolean commanded;
    
    public RearPusherRetract() {
        g = ScraperBike.getPusher();
        requires(g);
        commanded = false;
    }

    protected void initialize() {
    }

    protected void execute() {
        g.moveRearPusher(0);
        commanded = true;
    }

    protected boolean isFinished() {
        return commanded; //!g.isRearContacting();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
