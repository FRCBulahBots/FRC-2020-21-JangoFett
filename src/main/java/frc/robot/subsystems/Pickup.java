/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.ProfiledPIDSubsystem;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.controller.ArmFeedforward;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile.State;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Pickup extends ProfiledPIDSubsystem{
  private CANSparkMax suckMotor;
  public TalonSRX armMotor;
  public Encoder armEncoder;
  public ArmFeedforward armFeedForward;
  public double startPos;
  public double endPos;

  public Pickup(int pick, int suck, int armA, int armB) {
    super(new ProfiledPIDController(0.001f, 0, 0, new TrapezoidProfile.Constraints(1000, 1000), 0));
    suckMotor = new CANSparkMax(suck, MotorType.kBrushless);
    armMotor = new TalonSRX(pick);
    armMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    armFeedForward = new ArmFeedforward(0.001, 0.001, 0);
    setGoal(0);
  }

  @Override
  protected void useOutput(double output, State setpoint) {
    //System.out.println(output);
    System.out.println(armMotor.getSelectedSensorPosition());
    armMotor.set(ControlMode.PercentOutput, output);
  }

  @Override
  protected double getMeasurement() {
    return armMotor.getSelectedSensorPosition();
  }


  public void setSuckSpeed(double speed) {
    suckMotor.set(speed);
  }

  public void setArmSpeed(double speed){
    armMotor.set(ControlMode.PercentOutput, speed);
  }

  public double getInitPos(){
    return armMotor.getSelectedSensorPosition();
  }

}
