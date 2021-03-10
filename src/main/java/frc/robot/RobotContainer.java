/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.simulation.JoystickSim;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile.Constraints;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Magazine;
import frc.robot.subsystems.Pickup;
import frc.robot.subsystems.Shooter;
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
  private final Pickup picker = new Pickup(Constants.armMover, Constants.pickupDeviceID, Constants.armA, Constants.armB);
  private final Climb climber = new Climb(Constants.poleMotor, Constants.climbmotor1);
  private final Shooter shoot = new Shooter(Constants.shooterDeviceID, Constants.bigBoysPort);
  private final Magazine magazine = new Magazine(Constants.beltMotor);


  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();  
      
    //simple lambda expression to make robot drive using left and right joystick.
    drive.setDefaultCommand(new RunCommand(() -> drive.arcadeDrive(0.7 * joystick.getRawAxis(1), -0.7 * joystick.getRawAxis(4)), drive));
    //another lambda expression to allow for dual-trigger shooter, 
    shoot.setDefaultCommand(new RunCommand(() -> new JoystickToShoot(shoot, joystick.getRawAxis(2), joystick.getRawAxis(3)), shoot));
    
    
  
  }


  private void configureButtonBindings() {


    //toggles arms from upright to pickup position.
    //new JoystickButton(joystick, 6)
    //.whenPressed(() -> {picker.setGoal(0.8); picker.enable();}, picker);
    //pulls/pushes ball into magazine or out of arm, WHEN HELD.
    new JoystickButton(joystick, 1)
      .whenHeld(new JoystickToSuck(picker, 0));
    new JoystickButton(joystick, 2)
      .whenHeld(new JoystickToSuck(picker, 1));

    new JoystickButton(joystick, 4)
      .whenPressed(shoot::enable, shoot);
    new JoystickButton(joystick, 3)
      .whenPressed(shoot::disable, shoot);

    new JoystickButton(joystick, 8)
      .whenPressed(() -> magazine.magSpeed(0.4));

    new JoystickButton(joystick, 7)
      .whenPressed(() -> picker.setArmSpeed(0.6));   

    //controls the servos of the shooter by using the Up and Down D-Pad.
    new POVButton(joystick, 0)
      .whenPressed(new JoystickToAdjust(shoot, 0));
    new POVButton(joystick, 180)
      .whenPressed(new JoystickToAdjust(shoot, 1));
  
  }

  public void disablePIDSubsystems(){
    this.shoot.disable();
  }


  public Command getAutonomousCommand() {
    AutonCommand auto = new AutonCommand(drive);
    return auto;
  }
  
}
