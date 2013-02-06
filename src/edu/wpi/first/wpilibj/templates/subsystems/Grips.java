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

public class Grips extends Subsystem {
    private boolean frontGripDeployed;
    private boolean rearGripDeployed;
    private boolean frontGripContacted;
    private boolean rearGripContacted;
    
    public Grips() {
        
    }
    
    public void moveFrontGrip(int direction) {
        
    }
    
    public void moveRearGrip(int direction) {
        
    }
    
    public boolean isFrontContacting() {
        return true;
    }
    
    public boolean isRearContacting() {
        return true;
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

