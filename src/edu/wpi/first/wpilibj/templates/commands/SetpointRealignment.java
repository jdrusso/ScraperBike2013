/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2013. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Team 2035 Programmers
 */
public class SetpointRealignment extends CommandBase{

    int Direction;
    
    public SetpointRealignment(int d){
        Direction = d;
    }
    
    protected void initialize() {
    }

    protected void execute() {
        switch (Direction) {
            case RobotMap.realignLeft: RobotMap.cameraXOffset += 1;
                                       break; 
               
            case RobotMap.realignRight: RobotMap.cameraXOffset -= 1;
                                        break;    
                
            case RobotMap.realignCenter: RobotMap.cameraXOffset = (double)RobotMap.defaultCameraOffset;
                                         break;   
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}