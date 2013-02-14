package edu.wpi.first.wpilibj.templates.subsystems;
//import edu.team2035.meta.MetaCommandLog;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.VerticalTurretRotationManual;


/**
 *
 * @author Team 2035 Programmers
 */
public class VerticalTurretAxis extends Subsystem  {

    private Jaguar verTurretJag;
    private static Gyro gyro;
    private double angle;
    
    public static void resetGyro() {
        gyro.reset();
    }
    
    public static double readGyroDegress() {
        return gyro.getAngle();
    }
    
    public void updateAngle(double d) {
        angle += d;
    }
    
    public void moveElevation() {
        verTurretJag.set(0.1);
    }
    
    public void stopElevation() {
        verTurretJag.set(0.0);
    }
    
    public VerticalTurretAxis(){
        super("VerticalTurretAxis");
        verTurretJag = new Jaguar(RobotMap.VerTurretMotor);
    }
    protected void initDefaultCommand() {
        super.setDefaultCommand(new VerticalTurretRotationManual());
    }    
    public void rotate(double speed){
        
        if(RobotMap.bottomLimit.get() && RobotMap.topLimit.get()){
            verTurretJag.set(speed);
//            VerLog.setOutputs("" + speed);
            
        } else if (!RobotMap.bottomLimit.get()){
            
            if(speed >= 0){
                
                verTurretJag.set(speed);
//                VerLog.setOutputs("" + speed);
            
            } else if (speed < 0){
                
                verTurretJag.set(0);
//                VerLog.setOutputs("" + speed);
            }
            
            
        } else if (!RobotMap.topLimit.get()){
            if(speed <= 0){
                
                verTurretJag.set(speed);
//                VerLog.setOutputs("" + speed);
            
            }
            else if (speed > 0){
                verTurretJag.set(0);
//                VerLog.setOutputs("" + speed);
            }
        }
    }
   
    public static Gyro getGyro(){
        return gyro;
    }
    
}
