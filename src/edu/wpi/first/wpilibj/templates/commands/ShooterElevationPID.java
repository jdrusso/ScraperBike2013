/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

//import edu.team2035.meta.MetaTCPVariables;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.ScraperBike;
import edu.wpi.first.wpilibj.templates.subsystems.VerticalTurretAxis;

/**
 *
 * @author abbottk
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
        
        // code here to choose a desiredShooterAngle
 
        
        
    }

}