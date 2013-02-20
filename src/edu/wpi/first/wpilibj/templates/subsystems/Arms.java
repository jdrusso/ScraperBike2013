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
 * Creates variables.
 * @author Team 2035 Programmers
 */
public class Arms extends Subsystem {
    private boolean contacted;
    private boolean extended;
    private DriveTrain d;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
   
    /**
     * Gives the variables their assignments.
     */
    public Arms() {
        d = ScraperBike.getDriveTrain();
        contacted = false;
        extended = false;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Checks if the arms are contacting the pyramid.
     * @return True if the arms are contacting, false if not.
     */
    public boolean isContacting() {
        contacted = RobotMap.armsContacted.get();
        return contacted;
    }
    
    /**
     * Checks if the arms are extended at its limit.
     * @return True if they are extended to it's limit, false if not.
     */
    public boolean isLimitFore() {
        return RobotMap.armsExtendedFore.get();
    }
    
    /**
     * Checks if the arms are retracted at it's limit.
     * @return True if they are retracted at it's limit, false if not.
     */
    public boolean isLimitAft() {
        return RobotMap.armsExtendedAft.get();
    }
    
    /**
     * Checks if the arms are extended.
     * @return True, if the arms are extended, false if not.
     */
    public boolean isExtended() {
        extended = RobotMap.armsExtendedFore.get() || RobotMap.armsExtendedAft.get();
        return extended;
    }
    
    /** This moves the arms.
     * climb speed set in RobotMap
     * @param direction 0 for off, 1 for forward, -1 for reverse
     */
    /**
     * moves the arms in a given direction.
     * @param direction 
     */
    public void move(double direction) {
//     if (direction == 1) {
//           if (RobotMap.armsFrontLimitSwitch.get() == true) {
//               d.climb(0);
//           }
//           else if (RobotMap.armsFrontLimitSwitch.get() == false) {
//               d.climb(1);
//           }
//      }
//      else if (direction == -1 * RobotMap.climbSpeed) {
//            if (RobotMap.armsRearLimitSwitch.get() == true) {
//               d.climb(0);
//            }
//            else if (RobotMap.armsRearLimitSwitch.get() == false) {
//               d.climb(-1 * RobotMap.climbSpeed);
//            }
//     }
      
        //if arms are not at maximum extension (the arms limit switch is not triggered), then extend.
        d.climb(direction*RobotMap.climbSpeed);
    }
}

