package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  //Simple drivetrain using 4 SRXs and a DifferentialDrive system to control two masters that have two followers, since we're using gearboxes. 
  //instantiates SRXs and DifferentialDrive system
  private WPI_TalonSRX leftMaster;
  private WPI_TalonSRX leftFollower;
  private WPI_TalonSRX rightMaster;
  private WPI_TalonSRX rightFollower;
  private AHRS navxAhrs;

  private DifferentialDrive drive;


  public Drivetrain(int leftMasterint, int leftFollowerint, int rightMasterint, int rightFollowerint) {
    leftMaster = new WPI_TalonSRX(leftMasterint);
    leftFollower = new WPI_TalonSRX(leftFollowerint);
    rightMaster = new WPI_TalonSRX(rightMasterint);
    rightFollower = new WPI_TalonSRX(rightFollowerint);

    navxAhrs = new AHRS();

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

    //Navx Stuff, temporary.
    SmartDashboard.putBoolean("IMU_Connected", navxAhrs.isConnected());
    SmartDashboard.putBoolean("IMU_IsCalibrating", navxAhrs.isCalibrating());
    SmartDashboard.putNumber("Gyro Angle", navxAhrs.getAngle());
    SmartDashboard.putBoolean("IMU_IsMoving", navxAhrs.isMoving());
    SmartDashboard.putBoolean("IMU_IsRotating", navxAhrs.isRotating());
  }


}
