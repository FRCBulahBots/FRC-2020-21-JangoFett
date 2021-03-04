package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

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

   // SmartDashboard.putNumber("Enc", leftFollower.getSelectedSensorPosition());

    //Gyro Stuff, temporary.
   // SmartDashboard.putBoolean("IMU_Connected", gyro.isConnected());
   // SmartDashboard.putNumber("Gyro Angle", gyro.getAngle());
   // SmartDashboard.putNumber("IMU_IsRotating", gyro.getRate());

    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");
    //read values periodically
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);

    //post to smart dashboard periodically
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("LimelightArea", area);
  }

  
  public double returnGyroAngle(){
    return gyro.getAngle();
  }


}
