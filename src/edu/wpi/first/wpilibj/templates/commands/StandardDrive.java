/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2013. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.ScraperBike;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;

/**
 *
 * @author Team 2035 Programmers
 */
public class StandardDrive extends CommandBase{

    private Joystick  Joystick;
    private RobotDrive drive;
    private DriveTrain DriveTrain;
    //private Gyro gyro1;
    
    /**
     *
     * @param d
     * @param j
     */
    public StandardDrive(RobotDrive d, Joystick j){
        super("StandardDrive");
        DriveTrain = ScraperBike.getDriveTrain(); 
        //gyro1 = DriveTrain.getGyro1();
        requires(DriveTrain);
        Joystick = j;
        drive = d;    
    }
    
    protected void initialize() {
        ScraperBike.nt.putBoolean("AutoAlign", false);
//        DriveTrain.getCommandLog().setCommand(this.getName());
    }

    protected void execute() {
//        DriveTrain.getCommandLog().setInputs("" + gyro1.getAngle());
//        DriveTrain.setMetaCommandOutputs();
        //drive.arcadeDrive(Joystick1);
//TODO: if pause works, uncomment.
//        if (RobotMap.isJoystickEnabled()) {
            DriveTrain.powerDriveTrain();
            
            DriveTrain.arcadeDrive(Joystick);
            
//        }
    
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        drive.stopMotor();
    }

    protected void interrupted() {
    }
    
}
