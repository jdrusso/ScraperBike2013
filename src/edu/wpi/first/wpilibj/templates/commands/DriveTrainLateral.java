/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2013. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.templates.ScraperBike;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 *
 * @author Team 2035 Programmers
 */
public class DriveTrainLateral extends PIDCommand {
    private DriveTrain driveTrain;
    private RobotDrive d;
    
    
    public DriveTrainLateral(double Kp, double Ki, double Kd){
        super("", Kp, Ki, Kd);
        this.driveTrain = ScraperBike.getDriveTrain();
        //requires(this.driveTrain);
        
    }    
    
    //Takes X coordinate of top detected target centroid and feeds it to PID loop
    protected double returnPIDInput() {
        
        //If a range is detected, use that as input
        if(RobotMap.range != 0 && RobotMap.range < 300){
            
            return RobotMap.range;
            //return ScraperBike.getShooterController().getRange();
        }
        
        //if not, this effectively stops the loop from moving anything.
        else {
            
            return RobotMap.targetDesiredDistance;
        }
        
    }

    //PID loop controls horizontalaxis jags
    protected void usePIDOutput(double output) {
        // Only give the PIDcommand output if the manual control is not on.
        
        //this.driveTrain.rotate(-output*.55);
        RobotMap.LatMovOut = output;
    }

    protected void initialize() {
        
        //this.getPIDController().setPercentTolerance(5);
//        HorizontalTurretAxis.getCommandLog().setCommand(this.getName());
        this.getPIDController().setPercentTolerance(8);
        this.getPIDController().setOutputRange(-1, 1);
    }

    protected void execute() {
        
        this.setSetpoint(RobotMap.targetDesiredDistance);
    }

    protected boolean isFinished() {
        
            return false;
    }

    protected void end() {
        
        RobotMap.LatMovOut = 0;
        //TODO: Make this start StandardDrive so that we don't need a whenRelease() in OI?
    }

    protected void interrupted() {
        
        RobotMap.LatMovOut = 0;
    }
    
    
}
