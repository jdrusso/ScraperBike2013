/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2013. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.ScraperBike;
import edu.wpi.first.wpilibj.templates.subsystems.VerticalTurretAxis;

/** Automatically aligns the turret to the desired angle
 *
 * @author team 2035 programmers
 */
public class ShooterElevationPID extends PIDCommand {
    private VerticalTurretAxis VerticalAxis;
    private double lastAngle;
    
    
    public ShooterElevationPID(double Kp, double Ki, double Kd){
        super("VerticalTurretRotation", Kp, Ki, Kd);
        this.VerticalAxis = ScraperBike.getVerticalTurretAxis();
        requires(this.VerticalAxis);
        
        lastAngle = 0;
        
    }
    protected double returnPIDInput() {
        //this.gyro1 = this.VerticalAxis.getGyro1();
        return -VerticalTurretAxis.readGyroDegress();
        //return this.getSetpoint();
        
    }

    protected void usePIDOutput(double output) {
        VerticalAxis.rotate(output);
    }

    protected void initialize() {
//        VerticalTurretAxis.getCommandLog().setCommand(this.getName());
        //speedController = new ShooterSpeed(RobotMap.shooterKp, RobotMap.shooterKi, RobotMap.shooterKd); //
        //speedController.start();
        
        // use 10 percent tolerance to the desired 
        this.getPIDController().setPercentTolerance(10);
        
    }

    // checks to see if the last angle the turret was on was the one that is desired. If not, it realigns itself.
    protected void execute() {
        
        this.determineSetpoint();
        
        if (lastAngle != RobotMap.desiredShooterAngle) {
            
            VerticalTurretAxis.resetGyro();      
            lastAngle = RobotMap.desiredShooterAngle;
        }
        
//        if (RobotMap.desiredShooterAngle != 0.0)    {
//            
//            VerticalTurretAxis.getGyro();
//            this.setSetpoint(RobotMap.desiredShooterAngle);
//            //VerticalTurretAxis = RobotMap.desiredShooterAngle;
//        }
//        
//        if (Math.abs (RobotMap.desiredShooterAngle - VerticalTurretAxis.readGyroDegress()) < 0.5) {
//            RobotMap.desiredShooterAngle = 0.0;
//        }
        
    }
        
    

    protected boolean isFinished() {
        
            return false;
            
    }

    protected void end() {
        
    }

    protected void interrupted() {
    }
    
    /**
     * This will do something to determine how the target information changes the PID Controller's Setpoint (reference r(t))
     */
    protected void determineSetpoint() {
        
        RobotMap.desiredShooterAngle = ScraperBike.nt.getNumber("DesiredShooterAngle", 0.0);
        
        // code here to choose a desiredShooterAngle
 
        
        
    }

}