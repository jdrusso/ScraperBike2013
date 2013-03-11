/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2013. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.ScraperBike;
import edu.wpi.first.wpilibj.templates.Target;
import java.util.Vector;

/**
 *
 * @author robotlab
 */
public class TargetParser extends CommandBase {

    int numDetected;
    double w1; double h1; double x1; double y1;
    double w2; double h2; double x2; double y2;
    double w3; double h3; double x3; double y3;
    double w4; double h4; double x4; double y4;
    double w5; double h5; double x5; double y5;
    double w6; double h6; double x6; double y6;
    
    public TargetParser() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis); 
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected synchronized void execute() {
               
        ScraperBike.debugPrint("Running TargetParser");
        numDetected = (int)ScraperBike.nt.getNumber("NumTargets", 0);
        RobotMap.unsortedMid.removeAllElements();
        RobotMap.unsortedBot.removeAllElements();
        updateTargets();
        ScraperBike.debugPrint("Num: " + RobotMap.numTargets);
        //Create target objects
        for (int i = 1; i <= RobotMap.numTargets; i++){
            
            switch (i){
                case 1:
                    ScraperBike.debugToTable("Parser Status", "Setting H1. H1: " + h1 + "W1: " + w1);
                    RobotMap.t1.setCenter(x1, y1); 
                    RobotMap.t1.setSize(h1, w1);
                    ScraperBike.debugToTable("T1", "Aspect: " + RobotMap.t1.aspect + ", X: " + RobotMap.t1.cenX + ", Y: " + RobotMap.t1.cenY + ", H: " + RobotMap.t1.height + ", W: " + RobotMap.t1.width);break;
                case 2:
                    ScraperBike.debugToTable("Parser Status", "Setting 2");
                    RobotMap.t2.setCenter(x2, y2);
                    RobotMap.t2.setSize(h2, w2);
                    ScraperBike.debugToTable("T2", "Aspect: " + RobotMap.t2.aspect + ", X: " + RobotMap.t2.cenX + ", Y: " + RobotMap.t2.cenY + ", H: " + RobotMap.t2.height + ", W: " + RobotMap.t2.width); break;
                case 3:
                    ScraperBike.debugToTable("Parser Status", "Setting 3");
                    RobotMap.t3.setSize(h3, w3);
                    RobotMap.t3.setCenter(x3, y3); break;
                case 4:
                    ScraperBike.debugToTable("Parser Status", "Setting 4");
                    RobotMap.t4.setSize(h4, w4);
                    RobotMap.t4.setCenter(x4, y4); break;
                case 5:
                    ScraperBike.debugToTable("Parser Status", "Setting 5");
                    RobotMap.t5.setSize(h5, w5);
                    RobotMap.t5.setCenter(x5, y5); break;
                case 6:
                    ScraperBike.debugToTable("Parser Status", "Setting 6");
                    RobotMap.t6.setSize(h6, w6);
                    RobotMap.t6.setCenter(x6, y6); break;
            }
        } //Finished assigning sizes, time to sort through the unsorted vectors
        
        
        //TIME TO START SORTIN' GOOD
        //Sort if a top target is detected
        if (!Double.isNaN(RobotMap.Top.aspect)) {
            
            if(RobotMap.unsortedMid.size() > 0)
                this.sort(RobotMap.unsortedMid, RobotMap.Top);
            
            if(RobotMap.unsortedBot.size() > 0)
                this.sort(RobotMap.unsortedBot, RobotMap.Top);
        }
        
        else if (Double.isNaN(RobotMap.Top.aspect)){
        
            if(RobotMap.unsortedMid.size() > 0)
                this.sort(RobotMap.unsortedMid);
            
            if(RobotMap.unsortedBot.size() > 0)
                this.sort(RobotMap.unsortedBot);
            
            
//            if (RobotMap.unsortedMid.size() == 2){
//                for (int i = 0; i <= RobotMap.unsortedMid.capacity(); i++){
//
//                    if (((Target)RobotMap.unsortedMid.elementAt(0)).cenX < ((Target)RobotMap.unsortedMid.elementAt(1)).cenX){
//                        ((Target)RobotMap.unsortedMid.elementAt(0)).setHorPos(Target.tLeft);
//                        ((Target)RobotMap.unsortedMid.elementAt(1)).setHorPos(Target.tRight);
//                    }
//
//                    else if (((Target)RobotMap.unsortedMid.elementAt(0)).cenX > ((Target)RobotMap.unsortedMid.elementAt(1)).cenX){
//                        ((Target)RobotMap.unsortedMid.elementAt(0)).setHorPos(Target.tRight);
//                        ((Target)RobotMap.unsortedMid.elementAt(1)).setHorPos(Target.tLeft);
//                    }
//                }
//            }

            
            //Sort bot vector
            
//            if (RobotMap.unsortedBot.capacity() == 2){
//                for (int i = 0; i <= RobotMap.unsortedBot.capacity(); i++){
//
//                    if (((Target)RobotMap.unsortedBot.elementAt(0)).cenX < ((Target)RobotMap.unsortedBot.elementAt(1)).cenX){
//                        ((Target)RobotMap.unsortedBot.elementAt(0)).setHorPos(Target.tLeft);
//                        ((Target)RobotMap.unsortedBot.elementAt(1)).setHorPos(Target.tRight);
//                    }
//
//                    else if (((Target)RobotMap.unsortedBot.elementAt(0)).cenX > ((Target)RobotMap.unsortedBot.elementAt(1)).cenX){
//                        ((Target)RobotMap.unsortedBot.elementAt(0)).setHorPos(Target.tRight);
//                        ((Target)RobotMap.unsortedBot.elementAt(1)).setHorPos(Target.tLeft);
//                    }
//                }
//            }
            
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
    
    private void sort(Vector tVec, Target compare){
        if (tVec.size() == 2){
            for (int i = 0; i <= tVec.size(); i++){

                if (((Target)tVec.elementAt(0)).cenX < compare.cenX){
                    ((Target)tVec.elementAt(0)).setHorPos(Target.tLeft);
                    ((Target)tVec.elementAt(1)).setHorPos(Target.tRight);
                }

                else if (((Target)tVec.elementAt(0)).cenX > compare.cenX){
                    ((Target)tVec.elementAt(0)).setHorPos(Target.tRight);
                    ((Target)tVec.elementAt(1)).setHorPos(Target.tLeft);
                }
            }
            //tVec.removeAllElements();
        } else if (tVec.size() == 1){
            
            if (((Target)tVec.elementAt(0)).cenX < compare.cenX){
                
                ((Target)tVec.elementAt(0)).setHorPos(Target.tLeft);
            }
            else {
                
                ((Target)tVec.elementAt(0)).setHorPos(Target.tRight);
            }
            //tVec.removeAllElements();
        }
        else
            ScraperBike.debugPrintln("Compare to - Vector doesn't contain two targets!");
    }
    
    private void sort(Vector tVec){
        if (tVec.size() == 2){
            for (int i = 0; i <= tVec.size(); i++){

                if (((Target)tVec.elementAt(0)).cenX < ((Target)tVec.elementAt(1)).cenX){
                    ((Target)tVec.elementAt(0)).setHorPos(Target.tLeft);
                    ((Target)tVec.elementAt(1)).setHorPos(Target.tRight);
                }

                else if (((Target)tVec.elementAt(0)).cenX > ((Target)tVec.elementAt(1)).cenX){
                    ((Target)tVec.elementAt(0)).setHorPos(Target.tRight);
                    ((Target)tVec.elementAt(1)).setHorPos(Target.tLeft);
                }
            }
            //tVec.removeAllElements();
        }
        else
            ScraperBike.debugPrintln("Regular - Vector doesn't contain two targets!");
    }
    
    private void updateTargets(){
        RobotMap.numTargets = 0;
        double x = 1;
        
        this.h1 = ScraperBike.nt.getNumber("H1", 0);
        this.w1 = ScraperBike.nt.getNumber("W1", 0);
        this.x1 = ScraperBike.nt.getNumber("X1", 0);
        this.y1 = ScraperBike.nt.getNumber("Y1", 0);
        if(!Double.isNaN(this.h1/this.w1/this.x1/this.y1))
            RobotMap.numTargets++;
        
        this.h2 = ScraperBike.nt.getNumber("H2", 0);
        this.w2 = ScraperBike.nt.getNumber("W2", 0);
        this.x2 = ScraperBike.nt.getNumber("X2", 0);
        this.y2 = ScraperBike.nt.getNumber("Y2", 0);
        if(!Double.isNaN(this.h2/this.w2/this.x2/this.y2))
            RobotMap.numTargets++;
        
        this.h3 = ScraperBike.nt.getNumber("H3", 0);
        this.w3 = ScraperBike.nt.getNumber("W3", 0);
        this.x3 = ScraperBike.nt.getNumber("X3", 0);
        this.y3 = ScraperBike.nt.getNumber("Y3", 0);
        if(!Double.isNaN(this.h3/this.w3/this.x3/this.y3))
            RobotMap.numTargets++;
        
        this.h4 = ScraperBike.nt.getNumber("H4", 0);
        this.w4 = ScraperBike.nt.getNumber("W4", 0);
        this.x4 = ScraperBike.nt.getNumber("X4", 0);
        this.y4 = ScraperBike.nt.getNumber("Y4", 0);
        if(!Double.isNaN(this.h4/this.w4/this.x4/this.y4))
            RobotMap.numTargets++;
        
        this.h5 = ScraperBike.nt.getNumber("H5", 0);
        this.w5 = ScraperBike.nt.getNumber("W5", 0);
        this.x5 = ScraperBike.nt.getNumber("X5", 0);
        this.y5 = ScraperBike.nt.getNumber("Y5", 0);
        if(!Double.isNaN(this.h5/this.w5/this.x5/this.y5))
            RobotMap.numTargets++;
        
        this.h6 = ScraperBike.nt.getNumber("H6", 0);
        this.w6 = ScraperBike.nt.getNumber("W6", 0);
        this.x6 = ScraperBike.nt.getNumber("X6", 0);
        this.y6 = ScraperBike.nt.getNumber("Y6", 0);
        if(!Double.isNaN(this.h6/this.w6/this.x6/this.y6))
            RobotMap.numTargets++;
        
        RobotMap.t1.clear();
        RobotMap.t2.clear();
        RobotMap.t3.clear();
        RobotMap.t4.clear();
        RobotMap.t5.clear();
        RobotMap.t6.clear();
    }
}
