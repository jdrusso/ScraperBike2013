/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

//import edu.team2035.meta.MetaTCPVariables;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.templates.commands.*;
/**
 * 
 * @author Team 2035 Programmers
 */
public class OI {
    // Process operator interface input here.
    private static Button manualShooter;
    private static Button pidShooter;
    //private static Button speedSetterUp;
    //private static Button speedSetterDown;
    //private static Button VerTurretFwd;
    //private static Button VerTurretRev;
    private static Button autoTargeter;
    private static Button autoTargeterDisable;
    private static Button reloadLeft;
    private static Button reloadRight;
    private static Button rotate;
    
    
    public static void initialize() {
        
        manualShooter = RobotMap.dButton3;
        pidShooter = RobotMap.dButton2;
        reloadLeft = RobotMap.dButton4;
        reloadRight = RobotMap.dButton5;
        rotate = RobotMap.dButton6;
        
        //speedSetterUp = RobotMap.shootButton6;
        //speedSetterDown = RobotMap.shootButton7;
        //speedSetterUp.whileHeld(new ChangeShooterSpeed('+'));
        //speedSetterDown.whileHeld(new ChangeShooterSpeed('-'));
        //speedSetterUp.whenReleased(new ChangeShooterSpeed(' '));
        //speedSetterDown.whenReleased(new ChangeShooterSpeed(' '));
        
        autoTargeter = RobotMap.shootButton8;
        autoTargeterDisable = RobotMap.shootButton9;
        //autoTargeter.whenPressed(new HorizontalTurretRotation(RobotMap.HorTurretKp, RobotMap.HorTurretKi, RobotMap.HorTurretKd));
        autoTargeter.whenPressed(new DriveTrainTargeting(RobotMap.DTRKp, RobotMap.DTRKi, RobotMap.DTRKd));
        autoTargeter.whenPressed(new DriveTrainLateral(RobotMap.DTLKp, RobotMap.DTLKi, RobotMap.DTLKd));
        //autoTargeterDisable.whenPressed(new HorizontalTurretRotationManual());
        autoTargeterDisable.whenPressed(new StandardDrive(ScraperBike.getDriveTrain().getDrive(), getJoystick1()));
        
        manualShooter.whileHeld(new Shoot());
        pidShooter.whileHeld(new PIDShoot(RobotMap.maxRPM));
        reloadLeft.whileHeld(new Reload(1));
        reloadRight.whileHeld(new Reload(-1));
        rotate.whileHeld(new RotateRobot());
    }
    
    public static Joystick getJoystick1(){
        return RobotMap.dStick;
    }
    
    public static Joystick getJoystick2(){
        return RobotMap.shootStick;
    }
    
}