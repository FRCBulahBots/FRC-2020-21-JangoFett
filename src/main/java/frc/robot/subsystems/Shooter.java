package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.EncoderType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj2.command.ProfiledPIDSubsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Shooter extends PIDSubsystem {
  // One Neo Motor (controlled by the CanSparkMax) and a pair of Servos
  public CANSparkMax shoot;
  private Servo bigBoys;
  private SimpleMotorFeedforward motorFeedforward;
  
  public Shooter(int shooterDeviceID, int bigBoysPort) {
    super(new PIDController(0.00017, 0, 0));
    shoot = new CANSparkMax(shooterDeviceID, MotorType.kBrushless);
    bigBoys = new Servo(bigBoysPort);
    motorFeedforward = new SimpleMotorFeedforward(0, 0.0002);
    setSetpoint(-4000);
    
    // setting servos limits; not too far and too in.
    bigBoys.setBounds(1.3, 1.5, 1.5, 1.5, 1.6);
  }

  public void setServoSpeed(double servoSpeedToSet) {
    bigBoys.set(servoSpeedToSet);
  }

  @Override
  protected double getMeasurement() {
    return shoot.getEncoder().getVelocity();
  }

  @Override
  protected void useOutput(double output, double setpoint) {
    shoot.set(output + motorFeedforward.calculate(setpoint));
  } 


}
