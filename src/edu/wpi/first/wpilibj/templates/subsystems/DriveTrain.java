/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2013. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.subsystems;

//import edu.team2035.meta.MetaGyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.templates.commands.StandardDrive;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 * 
 * Handles drive motors, transmission, gyros for autonomous balancing, and
 * joystick input
 *
 * @author jrusso
 */
public class DriveTrain extends Subsystem {
    
    private Solenoid powerTakeOff;
    private Solenoid shifter;
    private static RobotDrive drive;
    private Encoder transmission1;
    private DigitalInput sensor1;
    private DigitalInput sensor2;
    private Talon FrontLeftTalon;
    private Talon FrontRightTalon;
    private Talon RearLeftTalon;
    private Talon RearRightTalon;
    private double motorSpeeds;
    //private static Gyro gyro1;
    //private static MetaCommandLog Log;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    /** The DriveTrain constructor is called by the ScraperBike constructor.
     *
     */
    public DriveTrain(){
        super("Drive Train");
//        Log = new MetaCommandLog("DriveTrain", "Gyro" , "Left Jaguars,Right Jaguars");
        //gyro1 = new Gyro(RobotMap.AnalogSideCar , RobotMap.DriveTrainGyroInput);
        shifter = RobotMap.shifter; // Solenoid 1
        powerTakeOff = RobotMap.powerTakeoff; // Solenoid 2
        //shifter.setDirection(Relay.Direction.kBoth);
        
        FrontLeftTalon = new Talon(RobotMap.frontLeftMotor);
        RearLeftTalon = new Talon(RobotMap.rearLeftMotor);
        FrontRightTalon = new Talon(RobotMap.frontRightMotor);
        RearRightTalon = new Talon(RobotMap.rearRightMotor);
        drive = new RobotDrive(FrontLeftTalon, RearLeftTalon, FrontRightTalon, RearRightTalon);
        //drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        //drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        //drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        //drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        
        //lfFrontJag = new Jaguar (3);
        //rtFrontJag = new Jaguar (4);
        
        //joystick2 = new Joystick(2);
        //sensor1 = new DigitalInput(1);
        //sensor2 = new DigitalInput (2);

    }
    
//    public double getLeftOutput(){
//       return truncate(drive.getLeftOutputs());
//    }
    
//    public double getRightOutput(){
//       return truncate(drive.getRightOutputs());
//    }
    
    /** Drive the robot (spins the wheels)
     *
     * @param speed The commanded wheel speed; it is between [-1, 1].
     */
    public void drive(double speed) {
        powerDriveTrain();
        drive.drive(speed, 0.0);
    }
    
    /** Drive the robot (spins the wheels)
     *
     * @param speed The commanded wheel speed; it is between [-1, 1].
     * @param rot Rotation speed; it is between [-1, 1].  It is the difference 
     * between the left side motor speed and the right side motor speed of 
     * the robot.
     */
    public void drive(double speed, double rot) {
        powerDriveTrain();
        drive.drive(speed, rot);
    }
    
    /** Drive the robot in Arcade drive mode.
     *
     * @param j Joystick to use for Arcade driving style
     */
    public void arcadeDrive(Joystick j){
        powerDriveTrain();
        //drive.arcadeDrive(j);
        drive.arcadeDrive(j.getY(), -j.getX());
    }
    
    /** Rotate the robot in place.
     *
     * @param rot Rotation speed; it is between [-1, 1].  It is the difference 
     * between the left side motor speed and the right side motor speed of 
     * the robot. 
     */
    public void rotate(double rot) {
        powerDriveTrain();
        drive.arcadeDrive(0, rot);
    }
    
    /** Use the Arms to climb up the pyramid.
     *
     * @param speed The commanded wheel speed; it is between [-1, 1].
     */
    public void climb(double speed) {
        shiftLowGear();
        powerArms();
        drive.drive(speed, 0.0);
    }
    
    /** The DriveTrain can spin the wheels at low-speed high-torque
     *
     */
    public void shiftLowGear() {
        shifter.set(RobotMap.shifterLowGear);
    }
    
    /** The DriveTrain can spin the wheels at high-speed low-torque
     *
     */
    public void shiftHighGear() {
        shifter.set(RobotMap.shifterHighGear);
        System.out.println("Shifting high");
    }
    
    /** Places DriveTrain in the mode to spin the wheels (rather than move the
     * arms)
     *
     */
    public void powerDriveTrain() {
        System.out.println("SHIFTING THIS SHIT UP YO");
        powerTakeOff.set(RobotMap.shifterDriveTrainDirection);
    }
    
    /** Places DriveTrain in the mode to move the arms (rather than spin the 
     * wheels)
     *
     */
    public void powerArms() {
        System.out.println("SHIFTIN THEM ARMS BACK");
        powerTakeOff.set(RobotMap.shifterArmsDirection);
    }

    
    /** The RobotDrive object is used for driving the robot.
     *
     * @return The RobotDrive object (which can be used to change the motor 
     * output)
     */
    public RobotDrive getDrive(){
        return drive;
    }
    
    /** Disables the RobotDrive safety feature (if needed)
     *
     */
    public void disableSafety(){
        drive.setSafetyEnabled(false);
    }
    
    /** Enables the RobotDrive safety feature (if needed)
     *
     */
    public void enableSafety(){
        drive.setSafetyEnabled(true);
    }
    
    /** This is used to pretty print the values of double variables.  The long
     * number of digits after the decimal is a distraction.
     *
     * @param d a Double with a long grouping of digits after the decimal
     * @return d to four digits after the decimal
     */
    public double truncate(double d){
        
        int temp = (int)(d*1000);
        double result = (double)temp/1000;
        return result;
    }
    
    /** The default command that runs when no other Command is using this 
     * subsystem.  
     * 
     */
    public void initDefaultCommand() {  
        super.setDefaultCommand(new StandardDrive(drive, OI.getDriveStick()));
    }

}
