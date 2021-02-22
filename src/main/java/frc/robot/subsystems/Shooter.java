package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Servo;

public class Shooter extends SubsystemBase {
  //One Neo Motor (controlled by the CanSparkMax) and a pair of Servos 
  private CANSparkMax shoot;
  private Servo bigBoys;

  public Shooter(int shooterDeviceID, int bigBoysPort) {
    shoot = new CANSparkMax(shooterDeviceID, MotorType.kBrushless);
    bigBoys = new Servo(bigBoysPort);
    
    //setting servos limits; not too far and too in.
    bigBoys.setBounds(1.1, 1.5, 1.5, 1.5, 1.7);
  }

  //setter methods to control
  public void setShootSpeed(double speedToSet){
    shoot.set(speedToSet);
  }
  public void setServoSpeed(double servoSpeedToSet){
    bigBoys.set(servoSpeedToSet);
  }

}
