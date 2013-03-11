/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2013. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.ScraperBike;

/** Defines the motors, booleans, and other variables for Commands that have to do with shooting Frisbees.
 *
 * @author Team 2035 Programmers
 */
public class Shooter extends Subsystem {

    private Talon ShootTalon;
    private Talon ReloadTalon;
    private AnalogChannel RangeFinder;
    
    /** The Shooter constructor is called by the ScraperBike constructor.
     *
     */
    public Shooter() {
        ShootTalon = new Talon(RobotMap.ShooterMotor);
        ReloadTalon = new Talon(RobotMap.ReloadMotor);
    }
    
    /** Defines how to set the speed for the motor.
     *
     * @param speed for the shooting motor; it is between [-1, 1].
     */
    public void setShooterMotor(double speed){
        ShootTalon.set(speed);
        ScraperBike.debugToTable("PID_Shooter", speed);
        
    }
    
    /** Defines how fast the reload motor spins
     *
     * @param speed for the reloading motor; it is between [-1, 1].
     */
    public void setReloadMotor(double speed){
        ReloadTalon.set(speed);
    }    
    
    /** Gives the range from the camera to the shooter.
     *
     * @return Range in inches
     */
    public double getRange(){
        
        double range = this.RangeFinder.getVoltage()/.098;
        return range;
    }
    
    /** Gives the range from the camera to the shooter.
     *
     * @return Range in feet
     */
    public double getRangeFT(){
        
        return (getRange()/12);
    }
    
    /** The default command that runs when no other Command is using this 
     * subsystem.  
     * 
     */
    protected void initDefaultCommand() {
    }

}