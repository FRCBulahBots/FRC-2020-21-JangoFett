/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj2.command.ProfiledPIDSubsystem;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.controller.ArmFeedforward;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile.State;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Pickup extends PIDSubsystem{
  public CANSparkMax suckMotor;
  public TalonSRX armMotor;
  public Encoder armEncoder;
  public ArmFeedforward armFeedForward;

  public Pickup(int pick, int suck, int armA, int armB) {
    super(new PIDController(0.003, 0, 0));
    suckMotor = new CANSparkMax(suck, MotorType.kBrushless);
    armMotor = new TalonSRX(pick);
    armMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
  }

  @Override
  protected double getMeasurement() {
    return armMotor.getSelectedSensorPosition();
  }


  @Override
  protected void useOutput(double output, double setpoint) {
    armMotor.set(ControlMode.PercentOutput, output);
    suckMotor.set((setpoint / 550) * 0.3);
  }

  
  public void setSuckSpeed(double speed) {
    suckMotor.set(speed);
  }



}
