package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

  private WPI_TalonSRX leftMaster;
  private WPI_TalonSRX leftFollower;
  private WPI_TalonSRX rightMaster;
  private WPI_TalonSRX rightFollower;

  private DifferentialDrive drive;

  public Drivetrain(int leftMasterint, int leftFollowerint, int rightMasterint, int rightFollowerint) {
    leftMaster = new WPI_TalonSRX(leftMasterint);
    leftFollower = new WPI_TalonSRX(leftFollowerint);
    rightMaster = new WPI_TalonSRX(rightMasterint);
    rightFollower = new WPI_TalonSRX(rightFollowerint);

    drive = new DifferentialDrive(leftMaster, rightMaster);
    
    leftFollower.follow(leftMaster);
    rightFollower.follow(rightMaster);

    leftMaster.setNeutralMode(NeutralMode.Coast);
    leftFollower.setNeutralMode(NeutralMode.Coast);
    rightMaster.setNeutralMode(NeutralMode.Coast);
    rightFollower.setNeutralMode(NeutralMode.Coast);
  }

  public void arcadeDrive(double forward, double turn){
    drive.arcadeDrive(forward, turn);
  }
}
