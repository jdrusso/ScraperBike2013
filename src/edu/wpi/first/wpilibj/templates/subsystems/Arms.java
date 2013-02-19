/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.ScraperBike;

/**
 * @author Team 2035 Programmers
 */
public class Arms extends Subsystem {
    private boolean contacted;
    private boolean extended;
    private DriveTrain d;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
   
    public Arms() {
        d = ScraperBike.getDriveTrain();
        contacted = false;
        extended = false;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean isContacting() {
        contacted = RobotMap.armsContacted.get();
        return contacted;
    }
    
    public boolean isLimitFore() {
        return RobotMap.armsExtendedFore.get();
    }
    
    public boolean isLimitAft() {
        return RobotMap.armsExtendedAft.get();
    }
    
    public boolean isExtended() {
        extended = RobotMap.armsExtendedFore.get() || RobotMap.armsExtendedAft.get();
        return extended;
    }
    
    /** This moves the arms.
     * climb speed set in RobotMap
     * @param direction 0 for off, 1 for forward, -1 for reverse
     */
    public void move(double direction) {
    /* if (direction == forward) {
     *      if (armsFrontLimitSwitch.triggered) {
     *          arms.move(0)
     *      }
     *      if (armsFrontLimitSwitch.notTriggered) {
     *          arms.move(1)
     *      }
     * }
     *  else if (direction == reverse) {
     *       if (armsRearLimitSwitch.Triggered) {
     *          arms.move(0)
     *       }
     *       if (armsRearLimitSwitch.notTriggered) {
     *          arms.move(-1)
     *       }
     * }
     */ 
        //if arms are not at maximum extension (the arms limit switch is not triggered), then extend.
        d.climb(direction*RobotMap.climbSpeed);
    }
}

