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

public class Shooter extends SubsystemBase {
  // One Neo Motor (controlled by the CanSparkMax) and a pair of Servos
  private CANSparkMax shoot;
  private Servo bigBoys;
  private CANEncoder pain;

  public Shooter(int shooterDeviceID, int bigBoysPort) {
    shoot = new CANSparkMax(shooterDeviceID, MotorType.kBrushless);
    pain = shoot.getEncoder(EncoderType.kQuadrature, 7);
    bigBoys = new Servo(bigBoysPort);

    // setting servos limits; not too far and too in.
    bigBoys.setBounds(1.1, 1.5, 1.5, 1.5, 1.7);
  }

  public void setServoSpeed(double servoSpeedToSet) {
    bigBoys.set(servoSpeedToSet);
  }

  public void setShootSpeed(double leftBumper, double rightBumper){
    shoot.set((-leftBumper + rightBumper));

    //if (pain.getVelocity() >= 5000)
    //  shoot.set(0.85);
  }

}
