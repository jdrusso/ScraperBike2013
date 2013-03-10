/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2013. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.ShooterElevationManual;

/**
 *
 * @author Team 2035 Programmers
 */
public class VerticalTurretAxis extends Subsystem  {

    private Talon verTurretTalon;
    private static Gyro gyro;
    private double angle;
    
    /** The VerticalTurretAxis constructor is called by the ScraperBike constructor.
     *
     */
    public VerticalTurretAxis(){
        super("VerticalTurretAxis");
        verTurretTalon = new Talon(RobotMap.VerTurretMotor);
        
        gyro = new Gyro(RobotMap.gyroAnalogInput);
    }    
    
    /** The gyro needs to be reset occasionally to read 0 degrees.  Gyros have 
     * "drift" because of sensor noise and other robot movements that can be
     * read incorrectly by the sensor.
     *
     */
    public static void resetGyro() {
        gyro.reset();
    }
    
    /**
     *
     * @return Gyro output in degrees
     */
    public static double readGyroDegress() {
        return gyro.getAngle();
    }
    
    /**  We store an internal variable (angle) that represents an estimate of 
     * the actual angle that the vertical turret axis is at.  The gyro measures
     * relative angles (not absolute).  This variable represents the estimate 
     * of the absolute angle.
     *
     * @param d Degree update from the gyro.
     */
    public void updateAngle(double d) {
        angle += d;
    }
    
    /** This sets the turret axis motor to adjust the angle.
     * The speed is selected in {@link RobotMap#elevatorSpeed} 
     *
     */
    public void moveElevation() {
        verTurretTalon.set(RobotMap.elevatorSpeed);
    }
    
    /** This stops the turret axis motor.
     *
     */
    public void stopElevation() {
        verTurretTalon.set(0.0);
    }
    
    /** This sets the turret axis motor to adjust the angle.
     *
     * @param speed value between [-1, 1].
     */
    public void rotate(double speed){
        verTurretTalon.set(speed);
//        if(RobotMap.bottomLimit.get() && RobotMap.topLimit.get()){
//            verTurretTalon.set(speed);
////            VerLog.setOutputs("" + speed);
//            
//        } else if (!RobotMap.bottomLimit.get()){
//            
//            if(speed >= 0){
//                
//                verTurretTalon.set(speed);
////                VerLog.setOutputs("" + speed);
//            
//            } else if (speed < 0){
//                
//                verTurretTalon.set(0);
////                VerLog.setOutputs("" + speed);
//            }
//            
//            
//        } else if (!RobotMap.topLimit.get()){
//            if(speed <= 0){
//                
//                verTurretTalon.set(speed);
////                VerLog.setOutputs("" + speed);
//            
//            }
//            else if (speed > 0){
//                verTurretTalon.set(0);
////                VerLog.setOutputs("" + speed);
//            }
//        }
    }
   
    /**
     *
     * @return the Gyro object that is used by VerticalTurretAxis
     */
    public static Gyro getGyro(){
        return gyro;
    }
    
    /** The default command that runs when no other Command is using this 
     * subsystem.  
     * 
     */
    protected void initDefaultCommand() {
        super.setDefaultCommand(new ShooterElevationManual());
    }
    
}
