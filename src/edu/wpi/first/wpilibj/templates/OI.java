/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2013. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.templates.commands.*;
/** This file connects Joystick inputs (Buttons) into commands.
 * 
 * @author Team 2035 Programmers
 */
public class OI {
    
    // Place all variable definitions below
    // Joystick 1
    private static Button shiftLowGear;
    private static Button pidShooter;
    private static Button manualShooter;
    private static Button reloadLeft;
    private static Button reloadRight;
    private static Button rotate;
    private static Button frontPusher1;
    private static Button frontPusher2;
    private static Button climbPyramid;
    private static Button armExtend;
    private static Button armRetract;
    
    // Joystick 2
    private static Button shoot;
    private static Button keepAtRange;
    private static Button lockTop;
    private static Button lockLMid;
    private static Button lockRMid;
    private static Button frontPusherRetract;
    private static Button rearPusherRetract;
    private static Button lockLBot;
    private static Button lockRBot;
    
    /**  This method has the code that connects each button to a Command.
     *   The button can be either pressed or held down.
     * <p/>
     * This method is called by the parent class ScraperBike.
     *
     */
    public static void initialize() {
        
        // Joystick 1 Button (Driving Joystick)
        shiftLowGear = RobotMap.dTrigger;
        pidShooter = RobotMap.dButton2; //doesn't shoot
        manualShooter = RobotMap.dButton3;
        reloadLeft = RobotMap.dButton4;
        reloadRight = RobotMap.dButton5;
        rotate = RobotMap.dButton6;
        frontPusher1 = RobotMap.dButton7;
        frontPusher2 = RobotMap.dButton8;
        climbPyramid = RobotMap.dButton9; // doesn't climb the pyramid right now
        armRetract = RobotMap.dButton10;
        armExtend = RobotMap.dButton11;
        
        // Joystick 1 Actions
        shiftLowGear.whileHeld(new ShiftLowGear());
        pidShooter.whileHeld(new PIDShoot());
        manualShooter.whileHeld(new Shoot());
        reloadLeft.whileHeld(new Reload(1));
        reloadRight.whileHeld(new Reload(-1));
        rotate.whileHeld(new RotateRobot());
        frontPusher1.whileHeld(new FrontPusherExtend(1));
        frontPusher2.whileHeld(new FrontPusherExtend(2));
        //frontPusher1.whenReleased(new FrontPusherRetract());
        //frontPusher2.whenReleased(new FrontPusherRetract());
        climbPyramid.whenPressed(new RearPusherExtend());
        armRetract.whileHeld(new ArmsRetract());
        armExtend.whileHeld(new ArmsExtend(2)); 
        
        // Joystick 2 Buttons (Shooting Joystick)
        shoot = RobotMap.shootTrigger;
        keepAtRange = RobotMap.shootButton2;
        lockTop = RobotMap.shootButton3;
        lockLMid = RobotMap.shootButton4;
        lockRMid = RobotMap.shootButton5;
        frontPusherRetract = RobotMap.shootButton6;
        rearPusherRetract = RobotMap.shootButton7;
        lockLBot = RobotMap.shootButton8;
        lockRBot = RobotMap.shootButton9;
        
        // Joystick 2 Actions
        //shoot.whileHeld(new PIDShoot(RobotMap.maxRPM));
        //shoot.whileHeld(new Shoot());
        
        keepAtRange.whileHeld(new DriveTrainLateral(RobotMap.DTLKp, RobotMap.DTLKi, RobotMap.DTLKd));
        keepAtRange.whenReleased(new StandardDrive(ScraperBike.getDriveTrain().getDrive(), RobotMap.dStick));
        
        lockTop.whileHeld(new DriveTrainTargeting(RobotMap.DTLKp, RobotMap.DTLKi, RobotMap.DTLKd, RobotMap.Top));
        lockTop.whenReleased(new StandardDrive(ScraperBike.getDriveTrain().getDrive(), RobotMap.dStick));
        
        lockLMid.whileHeld(new DriveTrainTargeting(RobotMap.DTLKp, RobotMap.DTLKi, RobotMap.DTLKd, RobotMap.LMid));
        lockLMid.whenReleased(new StandardDrive(ScraperBike.getDriveTrain().getDrive(), RobotMap.dStick));
        
        lockRMid.whileHeld(new DriveTrainTargeting(RobotMap.DTLKp, RobotMap.DTLKi, RobotMap.DTLKd, RobotMap.RMid));
        lockRMid.whenReleased(new StandardDrive(ScraperBike.getDriveTrain().getDrive(), RobotMap.dStick));
        
        frontPusherRetract.whenPressed(new FrontPusherRetract());
        rearPusherRetract.whenPressed(new RearPusherRetract());
        
        lockLBot.whileHeld(new DriveTrainTargeting(RobotMap.DTLKp, RobotMap.DTLKi, RobotMap.DTLKd, RobotMap.LBot));
        lockLBot.whenReleased(new StandardDrive(ScraperBike.getDriveTrain().getDrive(), RobotMap.dStick));
        
        lockRBot.whileHeld(new DriveTrainTargeting(RobotMap.DTLKp, RobotMap.DTLKi, RobotMap.DTLKd, RobotMap.RBot));
        lockRBot.whenReleased(new StandardDrive(ScraperBike.getDriveTrain().getDrive(), RobotMap.dStick));
        
    }
    
    /**  The Joystick objects are created in the OI class.  
     * The objects are also needed in ScraperBike, so this method provides access
     * to joystick 1.
     *
     * @return Joystick 1 object (Drive Joystick)
     */
    public static Joystick getDriveStick(){
        return RobotMap.dStick;
    }
    
    /** The Joystick objects are created in the OI class.
     * The objects are also needed in ScraperBike, so this method provides access
     * to joystick 2.
     *
     * @return Joystick 2 object (Shoot Joystick)
     */
    public static Joystick getShootStick(){
        return RobotMap.shootStick;
    }
    
    /**  The Joystick throttle is mapped to [0, 1] rather than [-1, 1].
     *   The return is given by the formula
     * <p/>
     * \( speed = 1 - \left( \text{Throttle} + 1 \right) / 2 \)
     * <p/>
     * In math shorthand, this is stated as \( speed \in [0, 1] \), where the square
     * brackets mean that the value can also take on the end values 0 and 1.
     * <p/>
     * The extents are determined by substituting the values -1 and 1 for \( \text{Throttle} \).
     * <p/>
     * Maximum: \( speed = 1 - \left( -1 + 1 \right) / 2 = 1 - 0/2 = 1.\)
     * <p/>
     * Minimum: \( speed = 1 - \left( 1 + 1 \right) / 2 = 1 - 2/2 = 1 - 1 = 0.\)
     *
     * @return speed on the range [0, 1]
     */
    public static double getAdjustedThrottle(){
        
        double speed;
        speed = 1-(RobotMap.shootStick.getZ()+1)/2;
        ScraperBike.debugToTable("ShootStick Speed", speed);
        return speed;
    }
    
}