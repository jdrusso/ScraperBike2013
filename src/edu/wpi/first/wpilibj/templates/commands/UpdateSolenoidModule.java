/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**sets the solenoids to their default positions when robot is powered up.
 *
 * @author robotlab
 */
public class UpdateSolenoidModule extends CommandBase {
    
    public UpdateSolenoidModule() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
//        for (int i = 0; i < 8; i++){
//            
//            switch(i){
//                
//                case 1:
//                   
//            }
//        }
        
        RobotMap.shifter_2.set(!RobotMap.shifter.get());
        RobotMap.powerTakeoff_2.set(!RobotMap.powerTakeoff.get());
        RobotMap.frontPusherFirst_2.set(!RobotMap.frontPusherFirst.get());
        RobotMap.frontPusherSecond_2.set(!RobotMap.frontPusherSecond.get());
        RobotMap.rearPusher_2.set(!RobotMap.rearPusher.get());
        RobotMap.popper_2.set(!RobotMap.popper.get());
        RobotMap.popper2_2.set(!RobotMap.popper2.get());
        
        
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
