package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Servo;

public class Shooter extends SubsystemBase {
  private CANSparkMax shoot;
  private Servo bigBoys;

  public Shooter(int shooterMotor, int bigBoysPort) {
    shooterMotor = new CANSparkMax(shooterMotor, MotorType.kBrushless);

  }

}
