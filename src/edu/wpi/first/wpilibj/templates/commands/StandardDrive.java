/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.ScraperBike;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;

/**
 *
 * @author abbottk
 */
public class StandardDrive extends CommandBase{

    private Joystick  Joystick1;
    private Joystick Joystick2;
    private RobotDrive drive;
    private DriveTrain DriveTrain;
    //private Gyro gyro1;
    
    public StandardDrive(RobotDrive d, Joystick j){
        super("DefaultDriveTrain");
        DriveTrain = ScraperBike.getDriveTrain(); 
        //gyro1 = DriveTrain.getGyro1();
        requires(DriveTrain);
        Joystick1 = j;
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
        //if (RobotMap.JoystickEnabled) {
            DriveTrain.powerDriveTrain();
            
            DriveTrain.arcadeDrive(Joystick1);
            
        //}
    
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
