/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

/**
 * An example command that uses an example subsystem.
 */
public class JoystickToDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivetrain drive;
  private double move;
  private double turn;
  private final Joystick joystick;
  private final int axis1;
  private final int axis2;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public JoystickToDrive(Drivetrain drive, Joystick joy, int axis1, int axis2) {
    this.drive = drive;
    this.joystick = joy;
    this.axis1 = axis1;
    this.axis2 = axis2;

    addRequirements(drive);
  }

  @Override
  public void execute() {
    move = joystick.getRawAxis(axis1);
    turn = -joystick.getRawAxis(axis2);
    drive.arcadeDrive(move, turn);
  }

}
