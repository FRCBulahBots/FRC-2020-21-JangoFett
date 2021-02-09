package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Servo;

public class Shooter extends SubsystemBase {
  private CANSparkMax shoot;
  private Servo bigBoys;

  public Shooter(int shooterDeviceID, int bigBoysPort) {
    shoot = new CANSparkMax(shooterDeviceID, MotorType.kBrushless);
    bigBoys = new Servo(bigBoysPort);
    
    bigBoys.setBounds(1.1, 1.5, 1.5, 1.5, 1.7);
  }

  public void setShootSpeed(double speedToSet){
    shoot.set(speedToSet);
  }
  public void setServoSpeed(double servoSpeedToSet){
    bigBoys.set(servoSpeedToSet);
  }
  public void yayayCoding(){


  }

}
