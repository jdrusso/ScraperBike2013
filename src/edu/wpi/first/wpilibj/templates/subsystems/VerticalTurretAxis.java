package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.ShooterElevationManual;


/**
 * Creates variables.
 * @author Team 2035 Programmers
 */
public class VerticalTurretAxis extends Subsystem  {

    private Talon verTurretTalon;
    private static Gyro gyro;
    private double angle;
    
    public VerticalTurretAxis(){
        super("VerticalTurretAxis");
        verTurretTalon = new Talon(RobotMap.VerTurretMotor);
        
        gyro = new Gyro(RobotMap.gyroAnalogInput);
    }    
    
    /**
     * Resets the gyro.
     */
    public static void resetGyro() {
        gyro.reset();
    }
    
    /*
     * Gets the current angle of the gyro.
     * @return the current angle of the gyro.
     */
    public static double readGyroDegress() {
        return gyro.getAngle();
    }
    
    /**
     * Updates the angle of the gyro.
     * @param d 
     */
    public void updateAngle(double d) {
        angle += d;
    }
    
    /**
     * Moves the elevation of the shooter.
     */
    public void moveElevation() {
        verTurretTalon.set(RobotMap.elevatorSpeed);
    }
    
    /**
     * Stops moving the elevation of the shooter.
     */
    public void stopElevation() {
        verTurretTalon.set(0.0);
    }
    
    protected void initDefaultCommand() {
        super.setDefaultCommand(new ShooterElevationManual());
    }
    
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
     * Gets the current value of the gyro.
     * @return the value of the gyro.
     */
    public static Gyro getGyro(){
        return gyro;
    }
    
}
