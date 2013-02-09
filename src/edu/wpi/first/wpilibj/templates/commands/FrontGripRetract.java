/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.ScraperBike;
import edu.wpi.first.wpilibj.templates.subsystems.Grips;

/**
 *
 * @author bradmiller
 */
public class FrontGripRetract extends CommandBase {
       private Grips g;
       
    public FrontGripRetract() {
        g = ScraperBike.getGrips();
    }

    protected void initialize() {
    }

    protected void execute() {
        g.moveFrontGrip(-1);
    }

    protected boolean isFinished() {
        return !g.isFrontContacting();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
