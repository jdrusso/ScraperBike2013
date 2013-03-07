/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2013. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DriverStationLCD.Line;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.templates.commands.*;
import edu.wpi.first.wpilibj.templates.subsystems.*;

/** This is the primary class file of the entire robot code.  This file
 * contains the code that runs during each of the competition periods: autonomous,
 * tele-operated, and disabled.
 * <p/>
 * The Java Virtual Machine that runs on the cRIO (called Squawk)
 * is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation of WPILib. If you change the name of this class or the package after
 * creating this project, you must also update the MANIFEST file in the resource
 * directory of the NetBeans project.
 * <p/>
 * The order of execution of the methods is:
 * <ul><li/>robotInit() - once after the boot up of the cRIO.
 * <li/>disabledInit() - called once, every time the robot is placed in disabled mode.
 * <li/>disabledPeriodic() - called multiple times a second, during which the robot is disabled.
 * <li/>autonomousInit() - called once, every time the robot is placed in autonomous mode (only once on the field).
 * <li/>autonomousPeriodic() - called multiple times a second, during which the robot is autonomously controlled.
 * <li/>teleopInit() - called once, every time the robot is placed in tele-operated (user controlled) mode (only once on the field).
 * <li/>teleopPeriodic() - called multiple times a second, during which the robot is user controlled.
 * </ul>
 * 
 * On the competition field, the order of modes is:
 * <ul><li/>disabled (while the field is getting ready)
 * <li/>autonomous (15 seconds duration)
 * <li/>disabled (briefly)
 * <li/>teleop (2 minute duration)
 * <li/>disabled (until the robot is powered off)
 * </ul>
 */
public class ScraperBike extends IterativeRobot {

    private static DriveTrain DriveTrain;
    private static VerticalTurretAxis VerticalAxis;
    private static Shooter shooterController;
    private static DriverStationLCD display;
    private static boolean isDisabled;
    //private static Shooter shooter;
    //private double shooterSpeed;
    private Compressor compressor;
    //private String status;
    /** Network Table to share values with the computer */
    public static NetworkTable nt;
    /** The debugging Network Table. */
    public static NetworkTable debugTable;
    private static Pusher pusher;
    private static Arms arms;
    private static TargetParser tp;
    private static UpdateSolenoidModule updateSolenoids;
    private static ShooterElevationPID shooterElevationPID;
    
    /** Method to return a subsystem that is used in commands.
     *
     * @return the DriveTrain subsystem
     */
    public static DriveTrain getDriveTrain() {
        return DriveTrain;
    }
    
    /** Method to return a subsystem that is used in commands.
     *
     * @return the Pusher subsystem
     */
    public static Pusher getPusher() {
        return pusher;
    }
    
    /** Method to return a subsystem that is used in commands.
     *
     * @return the Arms subsystem
     */
    public static Arms getArms() {
        return arms;
    }

    /** Method to return a subsystem that is used in commands.
     *
     * @return the VerticalTurretAxis subsystem
     */
    public static VerticalTurretAxis getVerticalTurretAxis(){
        
        return VerticalAxis;
    }
    
    /** Method to return a subsystem that is used in commands.
     *
     * @return the Shooter subsystem
     */
    public static Shooter getShooterController(){
        return shooterController;
    }
    
    /** Whether or not the robot is disabled.
     *
     * @return true if the robot is disabled
     */
    public static boolean getIsDisabled(){
        return isDisabled;
    }     
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        //status = new String();
        nt = NetworkTable.getTable("ST");
        debugTable = NetworkTable.getTable("Debug");
        nt.putString("Status", "Initializing");
        nt.putBoolean("AutoAlign", false);
        pusher =  new Pusher();
        DriveTrain = new DriveTrain(); // must be before Arms constructor
        arms = new Arms();
        VerticalAxis = new VerticalTurretAxis();   
        shooterController = new Shooter();
        display = DriverStationLCD.getInstance();
        OI.initialize();
        display.updateLCD();
        display.println(Line.kUser1, 1, "Initializing...                      ");
        display.println(Line.kUser2, 1, "                                     ");
        display.println(Line.kUser3, 1, "                                     ");
        display.println(Line.kUser4, 1, "                                     ");
        display.println(Line.kUser5, 1, "                                     ");
        display.println(Line.kUser6, 1, "                                     ");
        display.updateLCD();
        compressor = new Compressor(RobotMap.pressureSwitch, RobotMap.compressorRelay);
        compressor.start();
        RobotMap.shootEncoder.start();
        nt.putString("Status", "Initialized");
        tp = new TargetParser();
        
        updateSolenoids = new UpdateSolenoidModule();
        updateSolenoids.start();
        
        //shooterElevationPID = new ShooterElevationPID(RobotMap.shooterElevationKp, RobotMap.shooterElevationKi, RobotMap.shooterElevationKd);
        //shooterElevationPID.start();
        
        RobotMap.shootEncoder.setDistancePerPulse((1.0/360.0));
        
    }
    
    /** Called at the beginning of every disabled period.
     * 
     */
    public void disabledInit(){
        
        System.out.println("Entering disabled...");
    }
    
    /** Called several times a second during disabled mode.
     * 
     */
    public void disabledPeriodic(){
        
    }
    
    /**
     * Called at the beginning of every autonomous period.
     * Only used once on the competition field.
     */
    public void autonomousInit() {
        
        System.out.println("Entering Autonomous...");
    }

    /**
     * This function is called periodically during autonomous.
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    /** Called at the beginning of every teleop period.
     * Only used once on the competition field.
     * 
     */
    public void teleopInit() {
        
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
         
        System.out.println("Entering TeleOp...");
        tp.start();
        
        pusher.moveFrontPusher(0);
        pusher.moveRearPusher(0);
        DriveTrain.powerDriveTrain();
        DriveTrain.shiftHighGear();

    }
    
    /**
     * This method is called periodically during operator control.
     * <p/>
     * This method is called approximately 200 times a second.
     */
    public void teleopPeriodic() {
        
        System.out.println("DIO 6: " + !RobotMap.armsExtendedFore.get() + ", DIO 7: " + !RobotMap.armsExtendedAft.get() + ", DIO 9: " + !RobotMap.armsHome.get());
        
        display.updateLCD();
        
        RobotMap.debug = DriverStation.getInstance().getDigitalIn(1);
        RobotMap.debugTable = DriverStation.getInstance().getDigitalIn(2);
        
        Scheduler.getInstance().run();
            
        display.println(Line.kUser1, 1, "Aspect Ratio: " + RobotMap.Top.aspect);
        display.println(Line.kUser2, 1, "CenX: " + RobotMap.Top.cenX);
        display.println(Line.kUser3, 1, "CenY: " + RobotMap.Top.cenY);
        display.println(Line.kUser4, 1, "Distance (in): " + RobotMap.Top.getRange());
        //display.println(Line.kUser5, 1, "Distance (ft): " + RobotMap.Top.getRange()/12);
        display.println(Line.kUser5, 1, "shoot RPM: " + RobotMap.shootEncoder.getRate()*60);
        display.println(Line.kUser6, 1, "shoot encoder: " + (((double)RobotMap.shootEncoder.get())/360));
        this.debugToTable("Encoder getrate", RobotMap.shootEncoder.getRate());
        this.debugToTable("Encoder get", RobotMap.shootEncoder.get());
        
        display.updateLCD();
    }
    
    /** Places in the Debug Network Table the entry key.
     *
     * @param key String to identify the information
     * @param text String value
     */
    public static void debugToTable(String key, String text){
        
        if (RobotMap.debugTable){
            ScraperBike.debugTable.putString(key,text);
        }
    }  
    
    /** Places in the Debug Network Table the entry key.
     *
     * @param key String to identify the information
     * @param number double value
     */
    public static void debugToTable(String key, double number){
        
        if (RobotMap.debugTable){
            ScraperBike.debugTable.putString(key, ""+number);
        }
    } 
    
    /** Places in the Debug Network Table the entry key.
     *
     * @param key String to identify the information
     * @param number integer value
     */
    public static void debugToTable(String key, int number){
        
        if (RobotMap.debugTable){
            ScraperBike.debugTable.putString(key,""+number);
        }
    } 
    
    /** Prints text to the console output visible on the computer.  Includes
     * a new line character after the text.
     *
     * @param text String that contains information to output.
     */
    public static void debugPrintln(String text){
        
        if (RobotMap.debug){
            System.out.println(text);
        }
    } 
    
    /** Prints text to the console output visible on the computer.
     *
     * @param text String that contains information to output.
     */
    public static void debugPrint(String text){
        
        if (RobotMap.debug){
            System.out.print(text);
        }
    }
}