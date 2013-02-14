/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 * @author Team 2035 Programmers
 */
public class Arms extends Subsystem {
    private boolean contacted;
    private boolean extended;
    private Relay arm;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
   
    public Arms() {
        contacted = false;
        extended = false;
        arm = RobotMap.armSpike;
        arm.setDirection(Relay.Direction.kBoth);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public boolean isContacting() {
        contacted = RobotMap.armsContacted.get();
        return contacted;
    }
    public boolean isExtended() {
        extended = RobotMap.armsExtended.get();
        return extended;
    }
    public void move(Relay.Value direction) {
        arm.set(direction);
    }
}

