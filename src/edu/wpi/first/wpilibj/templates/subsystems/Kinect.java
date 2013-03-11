/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2013. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.KinectStick;

/** NOT USING IN THE CURRENT ROBOT.
 *
 * @author jrusso
 */
public class Kinect extends Subsystem {
    KinectStick leftArm = new KinectStick(1);
    KinectStick rightArm = new KinectStick(2);

    //moving left arm controls robot speed, down speeds up
    public double getKinectY(){
        
        return -leftArm.getY();
    }
    
    //Moving right arm controls robot turning
    public double getKinectX(){
        
        return -rightArm.getY();
    }
    
    public double getKinectTankDriveRight(){
        
        return -rightArm.getY();
    }
    
    public double getKinectTankDriveLeft(){
        
        return -leftArm.getY();
    }
    
    //Returns true if head is turned to the right
    public boolean getRightLegOut(){
        
        return leftArm.getRawButton(3);
    }
 
    //True if arms are detectable
    public boolean kinectIsEnabled(){
        
        return leftArm.getRawButton(9);
    }
    
    public void initDefaultCommand() {
        
    }
}