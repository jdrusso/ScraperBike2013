/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.ScraperBike;
import edu.wpi.first.wpilibj.templates.Target;

/**
 *
 * @author robotlab
 */
public class TargetParser extends CommandBase {

    int numDetected;
    
    public TargetParser() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis); 
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        numDetected = (int)ScraperBike.nt.getNumber("NumTargets", 0);
        RobotMap.unsortedMid.clear();
        RobotMap.unsortedBot.clear();
        
        //Create target objects
        for (int i = 1; i <= 6; i++){
            
            switch (i){
                case 1:
                    RobotMap.t1.setSize(ScraperBike.nt.getNumber("H1", 0), ScraperBike.nt.getNumber("W1", 0));
                    RobotMap.t1.setCenter(ScraperBike.nt.getNumber("X1", 0), ScraperBike.nt.getNumber("Y1", 0)); break;
                case 2:
                    RobotMap.t2.setSize(ScraperBike.nt.getNumber("H2", 0), ScraperBike.nt.getNumber("W2", 0));
                    RobotMap.t2.setCenter(ScraperBike.nt.getNumber("X2", 0), ScraperBike.nt.getNumber("Y2", 0)); break;
                case 3:
                    RobotMap.t3.setSize(ScraperBike.nt.getNumber("H3", 0), ScraperBike.nt.getNumber("W3", 0));
                    RobotMap.t3.setCenter(ScraperBike.nt.getNumber("X3", 0), ScraperBike.nt.getNumber("Y3", 0)); break;
                case 4:
                    RobotMap.t4.setSize(ScraperBike.nt.getNumber("H4", 0), ScraperBike.nt.getNumber("W4", 0));
                    RobotMap.t4.setCenter(ScraperBike.nt.getNumber("X4", 0), ScraperBike.nt.getNumber("Y4", 0)); break;
                case 5:
                    RobotMap.t5.setSize(ScraperBike.nt.getNumber("H5", 0), ScraperBike.nt.getNumber("W5", 0));
                    RobotMap.t5.setCenter(ScraperBike.nt.getNumber("X5", 0), ScraperBike.nt.getNumber("Y5", 0)); break;
                case 6:
                    RobotMap.t6.setSize(ScraperBike.nt.getNumber("H6", 0), ScraperBike.nt.getNumber("W6", 0));
                    RobotMap.t6.setCenter(ScraperBike.nt.getNumber("X6", 0), ScraperBike.nt.getNumber("Y6", 0)); break;
            }
        } //Finished assigning sizes, time to sort through the unsorted vectors
        
        if (RobotMap.Top.cenX == 0.0){
        
            //Sort mid vector IF NO TOP DETECTED
            if (RobotMap.unsortedMid.capacity() == 2){
                for (int i = 0; i <= RobotMap.unsortedMid.capacity(); i++){

                    if (RobotMap.unsortedMid.get(0).cenX < RobotMap.unsortedMid.get(1).cenX){
                        RobotMap.unsortedMid.get(0).setHorPos(Target.tLeft);
                        RobotMap.unsortedMid.get(1).setHorPos(Target.tRight);
                    }

                    else if (RobotMap.unsortedMid.get(0).cenX > RobotMap.unsortedMid.get(1).cenX){
                        RobotMap.unsortedMid.get(0).setHorPos(Target.tRight);
                        RobotMap.unsortedMid.get(1).setHorPos(Target.tLeft);
                    }
                }
            }

            //Sort bot vector IF NO TOP DETECTED
            if (RobotMap.unsortedBot.capacity() == 2){
                for (int i = 0; i <= RobotMap.unsortedBot.capacity(); i++){

                    if (RobotMap.unsortedBot.get(0).cenX < RobotMap.unsortedBot.get(1).cenX){
                        RobotMap.unsortedBot.get(0).setHorPos(Target.tLeft);
                        RobotMap.unsortedBot.get(1).setHorPos(Target.tRight);
                    }

                    else if (RobotMap.unsortedBot.get(0).cenX > RobotMap.unsortedBot.get(1).cenX){
                        RobotMap.unsortedBot.get(0).setHorPos(Target.tRight);
                        RobotMap.unsortedBot.get(1).setHorPos(Target.tLeft);
                    }
                }
            }
            
        }
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
