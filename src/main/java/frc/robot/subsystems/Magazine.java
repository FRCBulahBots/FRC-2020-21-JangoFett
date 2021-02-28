package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile.State;
import edu.wpi.first.wpilibj2.command.ProfiledPIDSubsystem;
import frc.robot.Constants;


public class Magazine extends ProfiledPIDSubsystem {
    private TalonSRX johnson;
    private SimpleMotorFeedforward magMotorFeedforward;

    public Magazine(int beltID, int mag1, int mag2){
        super(new ProfiledPIDController(0.02, 0, 0, new TrapezoidProfile.Constraints(Constants.kMaxVelocityRadPerSecond, Constants.kMaxAccelerationRadPerSecSquared), 0));
        johnson = new TalonSRX(beltID);
        johnson.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    
        //rockbottom.setDistancePerPulse( (2 * Math.PI) / 7);
        setGoal(Math.PI);
    }

    @Override
    public double getMeasurement() {
        return johnson.getSelectedSensorVelocity();
    }

    @Override
    protected void useOutput(double output, State setpoint) {
        johnson.set(ControlMode.Current, output + magMotorFeedforward.calculate(setpoint.position, setpoint.velocity));
    }
    



}
