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
public class FrontPusherExtend extends CommandBase {
    private Pusher g;
    private int inputPosition;
    
    /**
     * Gives assignments to variables and requires the subsystem that it uses.
     * @param position 
     */
    public FrontPusherExtend(int position) {
        g = ScraperBike.getPusher();
        requires(g);
        inputPosition = position;
    }

    protected void initialize() {
    }
    
    /**
     * Extends the front pusher to the given parameters.
     */
    protected void execute() {
        g.moveFrontPusher(inputPosition);
    }

    /**
     * Checks to see if the front pusher is contacting the pyramid.
     * @return true if the pusher is contacting, false if not.
     */
    protected boolean isFinished() {
        return g.isFrontContacting();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
