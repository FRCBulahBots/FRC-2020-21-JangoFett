/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.simulation.JoystickSim;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile.Constraints;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Magazine;
import frc.robot.subsystems.Pickup;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Vision;
import frc.robot.commands.ArmCommands.JoystickToSuck;
import frc.robot.commands.ClimberCommands.JoystickToPull;
import frc.robot.commands.ClimberCommands.JoystickToRaise;
import frc.robot.commands.ShooterCommands.JoystickToAdjust;
import frc.robot.commands.ShooterCommands.JoystickToShoot;
import frc.robot.commands.ShooterCommands.trigger;
import frc.robot.commands.AutonCommand;
import frc.robot.commands.ArmCommands.JoystickToArm;
import edu.wpi.first.wpilibj2.command.StartEndCommand;



public class RobotContainer {

  private final Joystick joystick = new Joystick (Constants.joystick);

  private final Drivetrain drive = new Drivetrain(Constants.leftMasterChief, Constants.leftFollower, Constants.rightMasterChief, Constants.rightFollower);
  public final Pickup picker = new Pickup(Constants.armMover, Constants.pickupDeviceID, Constants.armA, Constants.armB);
  private final Climb climber = new Climb(Constants.climbMotor, Constants.winchmotor1, Constants.winchmotor2);
  public final Shooter shoot = new Shooter(Constants.shooterDeviceID, Constants.bigBoysPort);
  private final Magazine magazine = new Magazine(Constants.beltMotor, 0 , 1);
  private final Vision vision = new Vision();


  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();  
    //simple lambda expression to make robot drive using left and right joystick.
    drive.setDefaultCommand(new RunCommand(() -> drive.arcadeDrive(0.70 * joystick.getRawAxis(1), -0.9 * joystick.getRawAxis(4)), drive));

  }


  private void configureButtonBindings() {


    new trigger(joystick, 3)
      .whenActive(shoot::enable, shoot);
    new trigger(joystick, 2)
      .whenActive(shoot::disable, shoot);

    

    //double offset = 0;
    new JoystickButton(joystick, 6) 
      .whenPressed(() -> {picker.setSetpoint(-550); picker.enable();}, picker);
    new JoystickButton(joystick, 5)
      .whenPressed(() -> {picker.setSetpoint(0); picker.enable();}, picker);

    new JoystickButton(joystick, 8)
      .whileHeld(new StartEndCommand(() -> magazine.magSpeed(0.5), () -> magazine.magSpeed(0), magazine));

    //controls the servos of the shooter by using the Up and Down D-Pad.
    new POVButton(joystick, 0)
      .whileHeld(new StartEndCommand(() -> climber.setPoleSpeed(0.5), () -> climber.setPoleSpeed(0), climber));
    new POVButton(joystick, 180)
      .whileHeld(new StartEndCommand(() -> climber.setPoleSpeed(-0.5), () -> climber.setPoleSpeed(0), climber));

      //new JoystickButton(joystick, 7)
      //.whenHeld(new RunCommand(() -> climber.setWinchSpeed(0.6), climber));

      //new JoystickButton(joystick, 3)
      //.whenHeld(new StartEndCommand (() -> climber.setWinchSpeed(0.4), () -> climber.setWinchSpeed(0), climber));


    //new JoystickButton(joystick, 7)
      //.whenHeld(new StartEndCommand(() -> shoot.setServoSpeed(1), () -> shoot.setServoSpeed(0), shoot));
    //new JoystickButton(joystick, 8)
      //.whenHeld(new StartEndCommand(() -> shoot.setServoSpeed(-1), () -> shoot.setServoSpeed(0), shoot));

  }
  

  public void disablePIDSubsystems(){
    this.shoot.disable();
    picker.setSetpoint(0);
    this.picker.enable();
  }


  public Command getAutonomousCommand() {
    AutonCommand auto = new AutonCommand(drive);
    return auto;
  }
  
}
