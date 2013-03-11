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
import edu.wpi.first.wpilibj.templates.Target;

/**
 *
 * @author Team 2035 Programmers
 */
public class DriveTrainTargeting extends PIDCommand {
    private DriveTrain driveTrain;
    private RobotDrive d;
    
    
    /**
     *
     * @param Kp
     * @param Ki
     * @param Kd
     * @param t
     */
    public DriveTrainTargeting(double Kp, double Ki, double Kd, Target t){
        super("DriveTrainTargeting", Kp, Ki, Kd);
        this.driveTrain = ScraperBike.getDriveTrain();
        requires(this.driveTrain);
        this.setSetpoint(t.cenX);
    }    
    
//    public DriveTrainTargeting(double Kp, double Ki, double Kd, double Kp2, double Ki2, double Kd2){
//        super("", Kp, Ki, Kd);
//        this.driveTrain = ScraperBike.getDriveTrain();
//        requires(this.driveTrain);
//        
//    }
    
    //Takes X coordinate of top detected target centroid and feeds it to PID loop
    protected double returnPIDInput() {
        
        //If a top target is detected, give it's X coord
        if(RobotMap.Top.cenX != 0){
            
            return RobotMap.Top.cenX;
        }
        
        //if not, this effectively stops the loop from moving anything.
        else {
            
//            HorizontalTurretAxis.getCommandLog().setOutputs("N/A");//
            return RobotMap.cameraXOffset;
        }
        
    }

    //PID loop controls horizontalaxis jags
    protected void usePIDOutput(double output) {
        // Only give the PIDcommand output if the manual control is not on.
        
        //this.driveTrain.rotate(-output*.55);
        ScraperBike.debugToTable("DriveTrain Targeting", "Speed: " + RobotMap.LatMovOut + ", Rotation: " + output*.63);
        
        if (Math.abs(RobotMap.LatMovOut) >= .1)
        {
            this.driveTrain.drive(RobotMap.LatMovOut*.3, -output*.63);
        } else if (Math.abs(RobotMap.LatMovOut) < .1)
        {
            this.driveTrain.rotate(-output*.63);
        }
    }

    protected void initialize() {
        
        //this.getPIDController().setPercentTolerance(5);
//        HorizontalTurretAxis.getCommandLog().setCommand(this.getName());
        //this.getPIDController().setOutputRange(-1, 1);
        ScraperBike.nt.putBoolean("AutoAlign", true);
        this.getPIDController().setPercentTolerance(5);
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        
            return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
    
}
