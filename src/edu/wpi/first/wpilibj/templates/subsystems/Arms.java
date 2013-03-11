/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2013. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.ScraperBike;

/** Arms subsystem uses the DriveTrain subsystem and moves the Arms 
 * rather than spin the wheels.
 * @author Team 2035 Programmers
 */
public class Arms extends Subsystem {
    private boolean contacted;
    private boolean extended;
    private DriveTrain d;
   
    /**  The Arms constructor is called by the ScraperBike constructor.
     *
     */
    public Arms() {
        d = ScraperBike.getDriveTrain();
        contacted = false;
        extended = false;
    }
    
    /** I am not sure what this is still used for.
     *
     * @return True if the arms
     */
    public boolean isContacting() {
        contacted = RobotMap.armsContacted.get();
        return contacted;
    }
    
    /** The Arms have a physical limit.  Otherwise they could become 
     * disconnected mechanically.
     *
     * @return True if the Arms are as far forward physically as they should be 
     * allowed for safe operation
     */
    public boolean isLimitFore() {
        return !RobotMap.armsExtendedFore.get();
    }
    
    /** The Arms have a physical limit.  Otherwise they could become 
     * disconnected mechanically.
     *
     * @return True if the Arms are as far rear physically as they should be 
     * allowed for safe operation
     */
    public boolean isLimitAft() {
        return !RobotMap.armsExtendedAft.get();
    }
    
    /** The Arms have a neutral home position.
     *
     * @return True if the Arms are in the center (home) position.
     */
    public boolean isHomePosition() {
        return !RobotMap.armsHome.get();
    }
    
    /** The Arms have a physical limit.  Otherwise they could become 
     * disconnected mechanically.  This checks if either limit is reached.
     *
     * @return True if either completely extended in either direction
     */
    public boolean isExtended() {
        extended = RobotMap.armsExtendedFore.get() || RobotMap.armsExtendedAft.get();
        return extended;
    }
    
    /** This moves the arms.
     * climb speed set in RobotMap
     * @param direction 0 for off, 1 for forward, -1 for reverse
     */
    public void move(double direction) {
        d.climb(direction*RobotMap.climbSpeed);
    }
    
    /** The default command that runs when no other Command is using this 
     * subsystem.  
     * 
     */
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

