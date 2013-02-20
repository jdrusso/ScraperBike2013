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
 * Creates variables.
 * @author Team 2035 Programmers
 */
public class RearPusherExtend extends CommandBase {
    private Pusher g;
    
    /**
     * gives assignments to variables and requires the subsystem it uses.
     */
    public RearPusherExtend() {
        g = ScraperBike.getPusher();
        requires(g);
    }

    protected void initialize() {
        
    }
    
    /**
     * Extends the rear pusher to the given parameters.
     */
    protected void execute() {
        g.moveRearPusher(1);
    }
    
    /**
     * Checks is the rear pusher is contacting the pyramid.
     * @return true if the pusher is contacting, false if not.
     */
    protected boolean isFinished() {
        return g.isRearContacting();
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
}
