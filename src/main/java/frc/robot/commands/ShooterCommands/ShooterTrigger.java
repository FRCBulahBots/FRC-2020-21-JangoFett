// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ShooterCommands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class ShooterTrigger extends Trigger{

    Joystick joy;
    int axis;


    public ShooterTrigger(Joystick joy, int axis){
        this.joy = joy;
        this.axis = axis;
    }


    @Override
    public boolean get() {
      return (joy.getRawAxis(axis) >= 0.4);
    }





}