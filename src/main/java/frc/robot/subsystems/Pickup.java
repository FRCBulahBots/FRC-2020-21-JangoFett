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
import edu.wpi.first.wpilibj.controller.ArmFeedforward;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile.State;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Pickup extends ProfiledPIDSubsystem{
  private CANSparkMax suckMotor;
  public WPI_TalonSRX armMotor;
  public Encoder armEncoder;
  public double kP = 0.002f;
  public ArmFeedforward armFeedForward;

  /*
   * public enum ArmPositions { 
   * Postions we may want to move to
   * 
   * FULLYRETRACTED(0), UPRIGHT(546), BALLPICKUP(1404);
   * 
   * private final int id; ArmPositions(int id) { this.id = id; } public int
   * getValue() { return id; } }
   */

  public Pickup(int pick, int suck, int armA, int armB) {
    super(new ProfiledPIDController(0.002f, 0, 0, new TrapezoidProfile.Constraints(Constants.kMaxVelocityRadPerSecond, Constants.kMaxAccelerationRadPerSecSquared), 0));
    armEncoder = new Encoder(armA, armB, true, Encoder.EncodingType.k4X);
    suckMotor = new CANSparkMax(suck, MotorType.kBrushless);
    armMotor = new WPI_TalonSRX(pick);

    armEncoder.setDistancePerPulse((2.0 * Math.PI )/ 7);
    setGoal(0.5);
  }

  @Override
  protected double getMeasurement() {
    return armEncoder.getDistance() + 0.5;
  }

  @Override
  protected void useOutput(double output, State setpoint) {
    double feedforward = armFeedForward.calculate(setpoint.position, setpoint.velocity);
    armMotor.setVoltage(output + feedforward);
  }
  
  public void setSuckSpeed(double speed) {
    suckMotor.set(speed);
  }

}
