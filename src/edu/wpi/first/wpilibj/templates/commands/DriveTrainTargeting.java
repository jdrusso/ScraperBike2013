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
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 *
 * @author abbottk
 */
public class DriveTrainTargeting extends PIDCommand {
    private DriveTrain driveTrain;
    private RobotDrive d;
    
    
    public DriveTrainTargeting(double Kp, double Ki, double Kd){
        super("", Kp, Ki, Kd);
        this.driveTrain = ScraperBike.getDriveTrain();
        requires(this.driveTrain);
        
    }
    
    //Takes X coordinate of top detected target centroid and feeds it to PID loop
    protected double returnPIDInput() {
        
        //If a top target is detected, give it's X coord
        if(RobotMap.top[0] != 0){
            
            return RobotMap.top[0];
        }
        
        //if not, this effectively stops the loop from moving anything.
        else {
            
//            HorizontalTurretAxis.getCommandLog().setOutputs("N/A");//
            return RobotMap.cameraXOffset;
        }
        //TODO:  Get x values and add to meta command log, also do for vertical turret
        
    }

    //PID loop controls horizontalaxis jags
    protected void usePIDOutput(double output) {
        // Only give the PIDcommand output if the manual control is not on.
        
        this.driveTrain.rotate(-output*.27);
    }

    protected void initialize() {
        
        //this.getPIDController().setPercentTolerance(5);
//        HorizontalTurretAxis.getCommandLog().setCommand(this.getName());
    }

    protected void execute() {
        
        this.setSetpoint(RobotMap.cameraXOffset);
    }

    protected boolean isFinished() {
        
            return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
    
}
