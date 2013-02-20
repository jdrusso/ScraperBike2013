/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import java.util.Vector;

/**
 * The RobotMap is a collection of constant values that are used throughout the code.
 * Some constants are port numbers for the physical wiring.
 * This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of constants 
 * defined elsewhere in the code.
 * 
 * @author Team 2035 Programmers
 */
public class RobotMap {
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    /* cRIO SIDECARS
     * 
     */
    public static final int AnalogSideCar = 1; // Analog SideCar is connected to cRIO Slot 1
    public static final int DigitalSideCar = 2; // Digital SideCar is connected to cRIO Slot 2
    public static final int SolenoidSideCar = 3; // Solenoid SideCar is connected to cRIO Slot 3
    
    /* ANALOG SIDECAR 1 
     *
     */
    public static final int gyroAnalogInput = 1;
    
    
    /* DIGITAL SIDECAR 1
    /* PWM OUTPUTS for Digital Sidecar
     * 
     */
    public static final int frontLeftMotor = 1;
    public static final int rearLeftMotor = 2;
    public static final int frontRightMotor = 3;
    public static final int rearRightMotor = 4;
    public static final int ShooterMotor = 9;
    public static final int ReloadMotor = 10;
    public static final int VerTurretMotor = 8;
    
    /* Relay outputs for Spikes
     * 
     */
    public static final Encoder shootEncoder = new Encoder(1, 2, true, CounterBase.EncodingType.k2X);
    public static final DigitalInput topLimit = new DigitalInput(3); //DIO 3, limit switch Normally open
    public static final DigitalInput bottomLimit = new DigitalInput(4); //DIO 4, limit switch Normally open
    public static final DigitalInput armsContacted = new DigitalInput(5); // Arms subsystem
    public static final DigitalInput armsExtendedFore = new DigitalInput(6); // Arms subsytem
    public static final DigitalInput armsExtendedAft = new DigitalInput(7); // Arms subsytem
    public static final DigitalInput fingerContacted = new DigitalInput(8); // Finger Subsystem
    public static final DigitalInput armsHome = new DigitalInput(9); // Pusher subsytem
    public static final DigitalInput pusherFrontSensor2 = new DigitalInput(10); // Pusher subsytem
    public static final DigitalInput pusherRearSensor1 = new DigitalInput(11); // Pusher subsystem
    public static final DigitalInput pusherRearSensor2 = new DigitalInput(12); // Pusher subsystem
    
    public static final int pressureSwitch = 13;
    public static final int compressorRelay = 6;
    
    public static final boolean shifterDriveTrainDirection = false;
    public static final boolean shifterArmsDirection = true;   
    
    /* SOLENOIDS SIDECAR 1
     * 
     */
    public static final Solenoid shifter = new Solenoid(1);
    public static final Solenoid powerTakeoff = new Solenoid(2);
    public static final Solenoid frontPusherFirst = new Solenoid(3);
    public static final Solenoid frontPusherSecond = new Solenoid(4);
    public static final Solenoid rearPusher = new Solenoid(5);
    public static final Solenoid popper = new Solenoid(6);
    public static final Solenoid popper2 = new Solenoid(7);
    
    /* SOLENOIDS SIDECAR 2
     * 
     */
    public static final Solenoid shifter_2 = new Solenoid(2, 1);
    public static final Solenoid powerTakeoff_2 = new Solenoid(2, 2);
    public static final Solenoid frontPusherFirst_2 = new Solenoid(2, 3);
    public static final Solenoid frontPusherSecond_2 = new Solenoid(2, 4);
    public static final Solenoid rearPusher_2 = new Solenoid(2, 5);
    public static final Solenoid popper_2 = new Solenoid(2, 6);
    public static final Solenoid popper2_2 = new Solenoid(2, 7);
    
    
    public static final boolean shifterLowGear = true;
    public static final boolean shifterHighGear = false;
    
    /* TARGETING 
     * Aspect ratio constants for targets, calculated as width/height in inches
     */
    
    public static final double topW = 62;
    public static final double topH = 20;
    public static final double midW = 24;
    public static final double midH = 18;
    public static final double botW = 69;
    public static final double botH = 1;
    //public static final double topAspect = 3.100;
    //public static final double midAspect = 2.138;
    //public static final double botAspect = 1.156;
    public static final double topAspect = topW/topH;
    //public static final double midAspect = 62/29;
    public static final double midAspect = midW/midH;
    //public static final double botAspect = 37/32;
    public static final double botAspect = botW/botH;
    
    //Tolerance for target detected aspect ratio
    public static final double targetTolerance = 0.4;
     
    
    public static Vector unsortedMid = new Vector();
    public static Vector unsortedBot = new Vector();
    
    //Create target objects for use in sorting later
    public static Target t1 = new Target(ScraperBike.nt.getNumber("H1", 0), ScraperBike.nt.getNumber("W1", 0)
            , ScraperBike.nt.getNumber("X1", 0), ScraperBike.nt.getNumber("Y1", 0));
    public static Target t2 = new Target(ScraperBike.nt.getNumber("H2", 0), ScraperBike.nt.getNumber("W2", 0)
            , ScraperBike.nt.getNumber("X2", 0), ScraperBike.nt.getNumber("Y2", 0));
    public static Target t3 = new Target(ScraperBike.nt.getNumber("H3", 0), ScraperBike.nt.getNumber("W3", 0)
            , ScraperBike.nt.getNumber("X3", 0), ScraperBike.nt.getNumber("Y3", 0));
    public static Target t4 = new Target(ScraperBike.nt.getNumber("H4", 0), ScraperBike.nt.getNumber("W4", 0)
            , ScraperBike.nt.getNumber("X4", 0), ScraperBike.nt.getNumber("Y4", 0));
    public static Target t5 = new Target(ScraperBike.nt.getNumber("H5", 0), ScraperBike.nt.getNumber("W5", 0)
            , ScraperBike.nt.getNumber("X5", 0), ScraperBike.nt.getNumber("Y5", 0));
    public static Target t6 = new Target(ScraperBike.nt.getNumber("H6", 0), ScraperBike.nt.getNumber("W6", 0)
            , ScraperBike.nt.getNumber("X6", 0), ScraperBike.nt.getNumber("Y6", 0));
    
    public static Target Top = new Target(0, 0, 0, 0);
    public static Target LMid = new Target(0, 0, 0, 0);
    public static Target RMid = new Target(0, 0, 0, 0);
    public static Target LBot = new Target(0, 0, 0, 0);
    public static Target RBot = new Target(0, 0, 0, 0);
    public static Target Tower = new Target(0, 0, 0, 0);
    
    public static int numTargets;
    
    /* DRIVER STATION CONTROLS
     * 
     */
    public static boolean JoystickEnabled = true;
    public static final int DriverJoystickNumber = 1; // Robot Driver's Joystick USB number
    public static final int shooterJoystickNumber = 2; // Robot Driver's Joystick USB number
    
    public static final Joystick dStick = new Joystick(DriverJoystickNumber);
    public static final JoystickButton dTrigger = new JoystickButton(dStick, 1);
    public static final JoystickButton dButton2 = new JoystickButton(dStick, 2);
    public static final JoystickButton dButton3 = new JoystickButton(dStick, 3);
    public static final JoystickButton dButton4 = new JoystickButton(dStick, 4);
    public static final JoystickButton dButton5 = new JoystickButton(dStick, 5);
    public static final JoystickButton dButton6 = new JoystickButton(dStick, 6);
    public static final JoystickButton dButton7 = new JoystickButton(dStick, 7);
    public static final JoystickButton dButton8 = new JoystickButton(dStick, 8);
    public static final JoystickButton dButton9 = new JoystickButton(dStick, 9);
    public static final JoystickButton dButton10 = new JoystickButton(dStick, 10);
    public static final JoystickButton dButton11 = new JoystickButton(dStick, 11);
    
    public static final Joystick shootStick = new Joystick(shooterJoystickNumber);
    public static final JoystickButton shootTrigger = new JoystickButton(shootStick, 1);
    public static final JoystickButton shootButton2 = new JoystickButton(shootStick, 2);
    public static final JoystickButton shootButton3 = new JoystickButton(shootStick, 3);
    public static final JoystickButton shootButton4 = new JoystickButton(shootStick, 4);
    public static final JoystickButton shootButton5 = new JoystickButton(shootStick, 5);
    public static final JoystickButton shootButton6 = new JoystickButton(shootStick, 6);
    public static final JoystickButton shootButton7 = new JoystickButton(shootStick, 7);
    public static final JoystickButton shootButton8 = new JoystickButton(shootStick, 8);
    public static final JoystickButton shootButton9 = new JoystickButton(shootStick, 9);
    public static final JoystickButton shootButton10 = new JoystickButton(shootStick, 10);
    public static final JoystickButton shootButton11 = new JoystickButton(shootStick, 11);
    
    /* ROBOT CODE DEFINED CONSTANTS */
    // Kp - K proportional value for AutoBalancing.
    //public static final double AutoBalKp = (double) (0.5 / 45);
    // Ki - K integral value for AutoBalancing.
    //public static final double AutoBalKi = (double) (0);
    // Kd - K differential value for AutoBalancing.
    //public static final double AutoBalKd = (double) (0.25 / 20);
    
    /* ROBOT CODE DEFINED CONSTANTS */
    // Kp - K proportional value for HorizontalTurretRotation.
    //public static final double HorTurretKp = (double) (.25/20);
    // Ki - K integral value for HorizontalTurretRotation.
    //public static final double HorTurretKi = (double) (0);
    // Kp - K differential value for HorizontalTurretRotation.
    //public static final double HorTurretKd = (double) (0);
    
    /* ROBOT CODE DEFINED CONSTANTS */
    // Kp - K proportional value for VerticalTurretRotation.
    //public static final double VerTurretKp = (double) (.25/2);
    // Ki - K integral value for VerticalTurretRotation.
    //public static final double VerTurretKi = (double) (0);
    // Kp - K differential value for VerticalTurretRotation.
    //public static final double VerTurretKd = (double) (0);
    
     /* ROBOT CODE DEFINED CONSTANTS */
    // Kp - K proportional value for shooter.
    public static final double shooterKp = (double) (0.001);
    // Ki - K integral value for shooter.
    public static final double shooterKi = (double) (0.0001);
    // Kp - K differential value for shooter.
    public static final double shooterKd = (double) (0);
    
    // Kp - K proportional value for shooter.
    public static final double shooterElevationKp = (double) (5);
    // Ki - K integral value for shooter.
    public static final double shooterElevationKi = (double) (0);
    // Kp - K differential value for shooter.
    public static final double shooterElevationKd = (double) (0);
    
    /* ROBOT CODE DEFINED CONSTANTS */
    // Kp - K proportional value for Drive Train Rotation.
    public static final double DTRKp = (double) (.25/20);
    // Ki - K integral value for Drive Train Rotation.
    public static final double DTRKi = (double) (3);
    // Kp - K differential value for Drive Train Rotation.
    public static final double DTRKd = (double) (0);
    
     /* ROBOT CODE DEFINED CONSTANTS */
    // Kp - K proportional value for Lateral Drive Train.
    public static final double DTLKp = (double) (1);
    // Ki - K integral value for Lateral Drive Train.
    public static final double DTLKi = (double) (0);
    // Kp - K differential value for Lateral Drive Train.
    public static final double DTLKd = (double) (0);
    
    /*String KeyValues for Vision Tracking Hashtable*/
    //VTx - X value offset
    //public static final String VTx = "VTx";
    //VTy - y value offset
    //public static final String VTy = "VTy";
    //VTd - distance to target
    //public static final String VTd = "VTd";//
    
    //public static boolean HorTurretManualControl = false;
    //public static boolean VerTurretManualControl = false;


    //Offset for allowing user to press a button to move the setpoint, currently just used as the center position of the camera FoV
    public static double cameraXOffset = 160;
    public static final int defaultCameraOffset = 160;
    public static final int cameraYOffset = 0;
    public static final int realignLeft = -1;
    public static final int realignRight = 1;
    public static final int realignCenter = 0;
    
    public static double targetDesiredDistance = 6;
    public static double LatMovOut = 0;
    
    public static double range = 0;
    
    public static double desiredShooterAngle = 0.0;
    
    public static double shootRPM = 0;
    public static final double maxRPM = 6500;
    
    //public static final double autonomousSpeed = .92;
    public static final double climbSpeed = 0.5;
    public static final double elevatorSpeed = 0.1;
    
    public static boolean debug = true;
    public static boolean debugTable = true;
}