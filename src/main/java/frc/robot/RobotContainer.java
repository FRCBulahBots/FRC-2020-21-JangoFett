/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Pickup;
import jdk.vm.ci.meta.Constant;
import frc.robot.commands.JoystickToDrive;
import frc.robot.commands.ArmCommands.JoystickToSuck;
import frc.robot.commands.ClimberCommands.JoystickToPull;
import frc.robot.commands.ClimberCommands.JoystickToRaise;
import frc.robot.commands.ArmCommands.JoystickToArm;



public class RobotContainer {

  private final Joystick joystick = new Joystick (Constants.joystick);

  private final Drivetrain drive = new Drivetrain(Constants.leftMasterChief, Constants.leftFollower, Constants.rightMasterChief, Constants.rightFollower);
  private final Pickup picker = new Pickup(Constants.armMover, Constants.pickupDeviceID, Constants.armA, Constants.armB);
  private final Climb climber = new Climb(Constants.poleMotor, Constants.climbmotor1);


  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();  
      
    drive.setDefaultCommand(
      new JoystickToDrive(drive, joystick, 1, 4)
      );

  }


  private void configureButtonBindings() {

    new JoystickButton(joystick, 7)
      .whenPressed(new JoystickToArm(picker));

    new JoystickButton(joystick, 0)
      .whenPressed(new JoystickToSuck(picker, 0));

    new JoystickButton(joystick, 1)
      .whenPressed(new JoystickToSuck(picker, 1));

    
    new JoystickButton(joystick, 2)
      .whenPressed(new JoystickToRaise(climber, 0));
      
         
  
    
  }

   /*
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
  */
}
