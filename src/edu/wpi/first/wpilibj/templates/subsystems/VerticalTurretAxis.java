package edu.wpi.first.wpilibj.templates.subsystems;
//import edu.team2035.meta.MetaCommandLog;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.VerticalTurretRotationManual;


/**
 *
 * @author Team 2035 Programmers
 */
public class VerticalTurretAxis extends Subsystem  {

    private Talon verTurretTalon;
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
        verTurretTalon.set(0.1);
    }
    
    public void stopElevation() {
        verTurretTalon.set(0.0);
    }
    
    public VerticalTurretAxis(){
        super("VerticalTurretAxis");
        verTurretTalon = new Talon(RobotMap.VerTurretMotor);
    }
    protected void initDefaultCommand() {
        super.setDefaultCommand(new VerticalTurretRotationManual());
    }    
    public void rotate(double speed){
        
        if(RobotMap.bottomLimit.get() && RobotMap.topLimit.get()){
            verTurretTalon.set(speed);
//            VerLog.setOutputs("" + speed);
            
        } else if (!RobotMap.bottomLimit.get()){
            
            if(speed >= 0){
                
                verTurretTalon.set(speed);
//                VerLog.setOutputs("" + speed);
            
            } else if (speed < 0){
                
                verTurretTalon.set(0);
//                VerLog.setOutputs("" + speed);
            }
            
            
        } else if (!RobotMap.topLimit.get()){
            if(speed <= 0){
                
                verTurretTalon.set(speed);
//                VerLog.setOutputs("" + speed);
            
            }
            else if (speed > 0){
                verTurretTalon.set(0);
//                VerLog.setOutputs("" + speed);
            }
        }
    }
   
    public static Gyro getGyro(){
        return gyro;
    }
    
}
