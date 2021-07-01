/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.controller.ArmFeedforward;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;

public class Pickup extends PIDSubsystem{
  public CANSparkMax suckMotor;
  public TalonSRX armMotor;
  public Encoder armEncoder;
  public ArmFeedforward armFeedForward;
  public static PIDController controller = new PIDController(0.003, 0, 0);

  public Pickup(int pick, int suck, int armA, int armB) {
    super(controller);
    suckMotor = new CANSparkMax(suck, MotorType.kBrushless);
    armMotor = new TalonSRX(pick);
    armMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    controller.setTolerance(20);
    
  }

  @Override
  protected double getMeasurement() {
    return armMotor.getSelectedSensorPosition();
  }


  @Override
  protected void useOutput(double output, double setpoint) {
    armMotor.set(ControlMode.PercentOutput, output);
  }

  
  public void setSuckSpeed(double speed) {
    suckMotor.set(speed);
  }



}
