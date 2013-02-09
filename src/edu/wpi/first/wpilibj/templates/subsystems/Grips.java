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

/**
 *
 */

public class Grips extends Subsystem {
    
    private boolean frontGripDeployed;
    private boolean rearGripDeployed;
    private boolean frontGripContacted;
    private boolean rearGripContacted;
    private Solenoid frontSolenoid;
    private Solenoid rearSolenoid;
    
    public Grips() {
        frontGripDeployed = false;
        rearGripDeployed = false;
        frontGripContacted = false;
        rearGripContacted = false;
        frontSolenoid = new Solenoid(RobotMap.gripsFrontSolenoid);
        rearSolenoid = new Solenoid(RobotMap.gripsRearSolenoid);
        
    }
    
    public void moveFrontGrip(int direction) {
        if(direction == 1) {
            frontSolenoid.set(true);
            frontGripDeployed = true;
        }
        if(direction == -1) {
            frontSolenoid.set(false);
            frontGripDeployed = false;
        }
    }
    
    public void moveRearGrip(int direction) {
        if(direction == 1) {
            rearSolenoid.set(true);
            rearGripDeployed = true;
        }
        if(direction == -1) {
            rearSolenoid.set(false);
            rearGripDeployed = false;
        }
    }
    
    public boolean isFrontContacting() {
        frontGripContacted = RobotMap.gripsFrontSensor.get();
        return frontGripContacted;
    }
    
    public boolean isRearContacting() {
        rearGripContacted = RobotMap.gripsRearSensor.get();
        return rearGripContacted;
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

