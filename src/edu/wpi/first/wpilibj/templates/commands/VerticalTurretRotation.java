/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

//import edu.team2035.meta.MetaTCPVariables;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.ScraperBike;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.subsystems.VerticalTurretAxis;

/**
 *
 * @author abbottk
 */
public class VerticalTurretRotation extends PIDCommand {
    private VerticalTurretAxis VerticalAxis;
    
    
    public VerticalTurretRotation(double Kp, double Ki, double Kd){
        super("VerticalTurretRotation", Kp, Ki, Kd);
        this.VerticalAxis = ScraperBike.getVerticalTurretAxis();
        requires(this.VerticalAxis);
        
    }
    protected double returnPIDInput() {
        //this.gyro1 = this.VerticalAxis.getGyro1();
        //return gyro1.getAngle();
        return this.getSetpoint();
        
    }

    protected void usePIDOutput(double output) {
        VerticalAxis.rotate(output);
    }

    protected void initialize() {
//        VerticalTurretAxis.getCommandLog().setCommand(this.getName());
        //speedController = new ShooterSpeed(RobotMap.shooterKp, RobotMap.shooterKi, RobotMap.shooterKd); //
        //speedController.start();
        
    }

    protected void execute() {
        
        this.determineSetpoint();
        this.setSetpoint(RobotMap.desiredAngle);
        
    }

    protected boolean isFinished() {
        
            return false;
            
    }

    protected void end() {
        
    }

    protected void interrupted() {
    }
    
    protected void determineSetpoint(){
        
    }

}