package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;

public class Drivetrain extends SubsystemBase {
  //Simple drivetrain using 4 SRXs and a DifferentialDrive system to control two masters that have two followers, since we're using gearboxes. 
  //instantiates SRXs and DifferentialDrive system
  private WPI_TalonSRX leftMaster;
  private WPI_TalonSRX leftFollower;
  private WPI_TalonSRX rightMaster;
  private WPI_TalonSRX rightFollower;

  private DifferentialDrive drive;

  private ADXRS450_Gyro gyro;

  public Drivetrain(int leftMasterint, int leftFollowerint, int rightMasterint, int rightFollowerint) {
    leftMaster = new WPI_TalonSRX(leftMasterint);
    leftFollower = new WPI_TalonSRX(leftFollowerint);
    rightMaster = new WPI_TalonSRX(rightMasterint);
    rightFollower = new WPI_TalonSRX(rightFollowerint);

    gyro = new ADXRS450_Gyro(SPI.Port.kMXP);

    //make our differential only control our masters, but...
    drive = new DifferentialDrive(leftMaster, rightMaster);
    //let out followers follow our masters.
    leftFollower.follow(leftMaster);
    rightFollower.follow(rightMaster);

    //set all motors to coast.
    leftMaster.setNeutralMode(NeutralMode.Coast);
    leftFollower.setNeutralMode(NeutralMode.Coast);
    rightMaster.setNeutralMode(NeutralMode.Coast);
    rightFollower.setNeutralMode(NeutralMode.Coast);
  }

  //nested method in method to drive.
  public void arcadeDrive(double forward, double turn){
    drive.arcadeDrive(forward, turn);

    //Gyro Stuff, temporary.
    SmartDashboard.putBoolean("IMU_Connected", gyro.isConnected());
    SmartDashboard.putNumber("Gyro Angle", gyro.getAngle());
    SmartDashboard.putNumber("IMU_IsRotating", gyro.getRate());
  }


}
