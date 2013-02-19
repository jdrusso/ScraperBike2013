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
 * @author Team 2035 Programmers
 */

public class Pusher extends Subsystem {
    
    private boolean frontGripDeployed1;
    private boolean frontGripDeployed2;
    private boolean rearGripDeployed;
    private boolean frontGripContacted;
    private boolean rearGripContacted;
    private Solenoid frontSolenoid1;
    private Solenoid frontSolenoid2;
    private Solenoid rearSolenoid;

    public Pusher() {
        frontGripDeployed1 = false;
        frontGripDeployed2 = false;
        rearGripDeployed = false;
        frontGripContacted = false;
        rearGripContacted = false;
        frontSolenoid1 = RobotMap.frontPusherFirst; // Solenoid 3
        frontSolenoid2 = RobotMap.frontPusherSecond; // Solenoid 4
        rearSolenoid = RobotMap.rearPusher; // Solenoid 5
        this.moveFrontPusher(0);
        this.moveRearPusher(0);
    }
    /** The front Pusher has two air cylinders to have the option to extend 3 or 6 inches.
     * 
     * @param position Either 0 for both off, 1 for a single extension, or 2 for double extension
     */
    public void moveFrontPusher(int position) {
        if(position == 1) {
            frontSolenoid1.set(true);
            frontGripDeployed1 = true;
            
            frontSolenoid2.set(true);  //TODO: wired backwards
            frontGripDeployed2 = false;
        }
        if(position == 2) {
            frontSolenoid2.set(true);
            frontGripDeployed1 = true;
            
            frontSolenoid2.set(false);  //TODO: wired backwards
            frontGripDeployed2 = true;
            
        }
        if(position == 0) {
            frontSolenoid1.set(false);
            frontGripDeployed1 = false;
            
            frontSolenoid2.set(true);  //TODO: wired backwards
            frontGripDeployed2 = false;
        }
    }
    
    /** The rear Pusher has only one cylinder to extend 3 inches.
     * 
     * @param position Either 0 for off, or 1 for extension.
     */
    public void moveRearPusher(int position) {
        if(position == 1) {
            rearSolenoid.set(true);
            rearGripDeployed = true;
        }
        if(position == 0) {
            rearSolenoid.set(false);
            rearGripDeployed = false;
        }
    }
    
    /** Returns the Solenoid position of the front Pusher.
     * 
     * @return 0 for not deployed, 1 for extended 3 inches, 2 for extended 6 inches.
     */
    public int getFrontPusherPosition() {
        int position = 0;
        if (frontGripDeployed1) {
            position++;
        }
        if (frontGripDeployed2) {
            position++;
        }
        return position;
    }
    
        /** Returns the Solenoid position of the rear Pusher.
     * 
     * @return 0 for not deployed, 1 for extended 3 inches.
     */
    public int getRearPusherPosition() {
        int position = 0;
        if (rearGripDeployed) {
            position++;
        }
        return position;
    }
    
    public boolean isFrontContacting() {
        frontGripContacted = RobotMap.pusherFrontSensor1.get();
        return frontGripContacted;
    }
    
    public boolean isRearContacting() {
        rearGripContacted = RobotMap.pusherRearSensor1.get();
        return rearGripContacted;
    }
    
    public boolean checkFrontSensor1() {
        return RobotMap.pusherFrontSensor1.get();
    }
    
    public boolean checkFrontSensor2() {
        return RobotMap.pusherFrontSensor2.get();
    }
    
    public boolean checkRearSensor1() {
        return RobotMap.pusherRearSensor1.get();
    }
    
    public boolean checkRearSensor2() {
        return RobotMap.pusherRearSensor2.get();
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

