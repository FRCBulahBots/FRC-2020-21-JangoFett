/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.VisionCommands.AutonCommand;
import frc.robot.commands.DriveCommands.JoystickToDrive;
import frc.robot.commands.MagazineCommands.JoystickToMagazine;
import frc.robot.commands.ShooterCommands.JoystickToShoot;
import frc.robot.commands.ShooterCommands.ShooterTrigger;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Magazine;
import frc.robot.subsystems.Pickup;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Vision;



public class RobotContainer {

  private final Joystick joystick = new Joystick (Constants.joystick);

  private final Drivetrain drive = new Drivetrain(Constants.leftMasterChief, Constants.leftFollower, Constants.rightMasterChief, Constants.rightFollower);
  public final Pickup picker = new Pickup(Constants.armMover, Constants.pickupDeviceID, Constants.armA, Constants.armB);
  private final Climb climber = new Climb(Constants.climbMotor, Constants.winchmotor1, Constants.winchmotor2);
  public final Shooter shoot = new Shooter(Constants.shooterDeviceID, Constants.bigBoysPort);
  private final Magazine magazine = new Magazine(Constants.beltMotor);
  private final Vision vision = new Vision();


  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();  

    //Drive Default Control
    //drive.setDefaultCommand(new RunCommand(() -> drive.arcadeDrive(0.70 * joystick.getRawAxis(1), -0.9 * joystick.getRawAxis(4)), drive));
    
    //drive.setDefaultCommand(new JoystickToDrive(drive, () -> (0.7 * joystick.getRawAxis(1)) ,() -> (-0.9 * joystick.getRawAxis(4)) ));   

  }


  private void configureButtonBindings() {

    //drive.setDefaultCommand(new JoystickToDrive(drive, 1, 4));
    
    //Shooter Toggle
    new ShooterTrigger(joystick, 3)
      .whenActive(shoot::enable, shoot);
    new ShooterTrigger(joystick, 2)
      .whenActive(shoot::disable, shoot);

    //new ShooterTrigger(joystick, 3)
      //.whenActive(new JoystickToShoot(shoot, 0, 4500));
    //new ShooterTrigger(joystick, 2)
      //.whenActive(new JoystickToShoot(shoot, 1, 0));

    //PID Control of the Arm
    new JoystickButton(joystick, 6) 
      .whenPressed(() -> {picker.enable(); picker.setSetpoint(-550); picker.setSuckSpeed(0.3);}, picker);
    new JoystickButton(joystick, 5)
      .whenPressed(() -> {picker.enable(); picker.setSetpoint(550); picker.setSuckSpeed(0.0);}, picker);

/*
    new JoystickButton(joystick, 6)
      .whenPressed(new JoystickToArm(picker, 0, -550)); 
    new JoystickButton(joystick, 5)
      .whenPressed(new JoystickToArm(picker, 1, 0));

*/
    //new JoystickButton(joystick, 1)
      //.whileHeld(new StartEndCommand(() -> magazine.magSpeed(0.5), () -> magazine.magSpeed(0), magazine));

    //Magazine Pushforward
    new JoystickButton(joystick, 1)
      .whenHeld(new JoystickToMagazine(magazine, true));
    new JoystickButton(joystick, 8)
      .whenHeld(new JoystickToMagazine(magazine, false));

    //Hook controls
    new POVButton(joystick, 0)
      .whileHeld(new StartEndCommand(() -> climber.setPoleSpeed(0.5), () -> climber.setPoleSpeed(0), climber));
    new POVButton(joystick, 180)
      .whileHeld(new StartEndCommand(() -> climber.setPoleSpeed(-0.5), () -> climber.setPoleSpeed(0), climber));

/*
    new POVButton(joystick, 0)
      .whileHeld(new JoystickToRaise(climber, 0))
    new POVButton(joystick, 180)
      .whileHeld(new JoystickToRaise(climber, 1))
*/

    //Winch Controls
    new JoystickButton(joystick, 3)
      .whenHeld(new StartEndCommand (() -> climber.setWinchSpeed(0.4), () -> climber.setWinchSpeed(0), climber));

    //Shooter Adjusting


    //new JoystickButton(joystick, 7)
      //.whenHeld(new StartEndCommand(() -> shoot.setServoSpeed(1), () -> shoot.setServoSpeed(0), shoot));
    //new JoystickButton(joystick, 8)
      //.whenHeld(new StartEndCommand(() -> shoot.setServoSpeed(-1), () -> shoot.setServoSpeed(0), shoot));

  }
  

  public void disablePIDSubsystems(){
    this.shoot.disable();
    this.picker.disable();
  }


  public Command getAutonomousCommand() {
    AutonCommand auto = new AutonCommand(drive);
    return auto;
  }
  
}
