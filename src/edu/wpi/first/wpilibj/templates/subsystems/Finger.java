/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/** finger subsystem implements code for a finger latch that holds the robot up on the pyramid as it climbs. *NOT BEING USED
 *
 */
public class Finger extends Subsystem {
    private boolean extended;
    private boolean contacted;

    
    
    /**Constructor that creates a solenoid.
     *
     */
    public Finger() {
        extended = false;
        contacted = false;
    }
    
    /**
     *
     * @return true if contacted
     */
    public boolean isContacting() {
        contacted = RobotMap.fingerContacted.get();
        return contacted;
    }
    
    /** checks to see if extended.
     *
     * @return state of extending finger (true if extended)
     */
    public boolean isExtending() {
        return extended;
    }
    
    /** extends finger.
     *
     */
    //public void extend() {
    //    extended = true;
    //    fingerSolenoid.set(extended);
    //}
    
    /** retracts finger.
     *
     */
    //public void retract() {
    //    extended = false;
    //    fingerSolenoid.set(extended);    
    //}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

