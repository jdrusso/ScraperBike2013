/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.templates.ScraperBike;
import edu.wpi.first.wpilibj.templates.subsystems.BallCollector;
/**
 *
 * @author Rachel and Jenny who are awesome - Fixed by JD
 */
public class BallCollectionOn extends CommandBase {
    private BallCollector ballCollection;
    
    public BallCollectionOn() {
        super("Ball Collect On");
        ballCollection = ScraperBike.getBallCollector();
        requires(ballCollection);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    /**
     * Called just before this Command runs the first time
     * sets the Motor direction to forward to pick up balls
     */
    protected void initialize() {
        BallCollector.suckBalls();
        ScraperBike.nt.putString("Status", "Active");
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     * motor keeps running
     */
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() { 
        //TODO: Add timer in purpledrank that resets when this finishes and only
        //return true if it has been x amount of time since timer has been running,
        //change button to always pull from the front roller and only from the elevator if switch is false
        //if (RobotMap.elevatorSwitch.get())
        //    return true;
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        //BallCollector.stopSucking();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        //BallCollector.stopSucking();
    }
}