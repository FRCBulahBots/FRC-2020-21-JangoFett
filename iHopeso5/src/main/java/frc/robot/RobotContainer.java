/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.Drivetrain;
import frc.robot.commands.JoystickToDrive;
import edu.wpi.first.wpilibj2.command.Command;


public class RobotContainer {

  private final Joystick joystick = new Joystick (Constants.joystick);

  private final Drivetrain drive = new Drivetrain(Constants.leftMasterChief, Constants.leftFollower, Constants.rightMasterChief, Constants.rightFollower);

  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();  
      
    drive.setDefaultCommand(
      new JoystickToDrive(drive, joystick, 1, 4)
      );

  }


  private void configureButtonBindings() {
  }

   /*
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
  */
}
