/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

//import edu.team2035.meta.MetaTCPVariables;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.templates.ScraperBike;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

/**
 *
 * @author abbottk
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
            
            return RobotMap.targetDistance;
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
        
        this.setSetpoint(RobotMap.targetDistance);
    }

    protected boolean isFinished() {
        
            return false;
    }

    protected void end() {
        
        RobotMap.LatMovOut = 0;
    }

    protected void interrupted() {
        
        RobotMap.LatMovOut = 0;
    }
    
    
}
