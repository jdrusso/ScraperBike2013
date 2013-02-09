/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Finger extends Subsystem {
    private boolean extended;
    private boolean contacted;
    
    public Finger() {
        extended = false;
        contacted = false;
    }
    
    public boolean isContacting() {
        return contacted;
    }
    
    public boolean isExtending() {
        return extended;
    }
    
    public void extend() {
    
    }
    
    public void retract() {
        
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

