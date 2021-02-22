package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.controller.ArmFeedforward;
import edu.wpi.first.wpilibj.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile.State;
import edu.wpi.first.wpilibj2.command.ProfiledPIDSubsystem;
import frc.robot.Constants;

public class Magazine extends ProfiledPIDSubsystem {
    private final WPI_TalonSRX johnson;
    private final Encoder rockbottom;
    public SimpleMotorFeedforward magMotorFeedforward;

    public Magazine(int beltID, int mag1, int mag2){
        super(new ProfiledPIDController(0.02, 0, 0, new TrapezoidProfile.Constraints(Constants.kMaxVelocityRadPerSecond, Constants.kMaxAccelerationRadPerSecSquared), 0));
        johnson = new WPI_TalonSRX(beltID);
        rockbottom = new Encoder(mag1, mag2, true, Encoder.EncodingType.k4X);
    
        //rockbottom.setDistancePerPulse( (2 * Math.PI) / 7);
        setGoal(Math.PI);
    }

    @Override
    public double getMeasurement() {
        return rockbottom.getRate() + Math.PI;
    }

    @Override
    protected void useOutput(double output, State setpoint) {
        johnson.setVoltage(output + magMotorFeedforward.calculate(setpoint.position, setpoint.velocity));
    }
    
    public void setMagSpeed(double speedToSet){
        johnson.set(speedToSet);
    }


}
