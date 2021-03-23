package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile.State;
import edu.wpi.first.wpilibj2.command.ProfiledPIDSubsystem;
import frc.robot.Constants;


public class Magazine extends ProfiledPIDSubsystem {
    private VictorSPX johnson;
    private SimpleMotorFeedforward magMotorFeedforward;
    private Ultrasonic sonic;

    public Magazine(int beltID, int sonic1, int sonic2){
        super(new ProfiledPIDController(0.02, 0, 0, new TrapezoidProfile.Constraints(0.0004, 0.0004), 0));
        johnson = new VictorSPX(beltID);
        sonic = new Ultrasonic(sonic1, sonic2);
        //johnson.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    
        //rockbottom.setDistancePerPulse( (2 * Math.PI) / 7);
        setGoal(Math.PI);
    }

    public void magSpeed(double input){
        johnson.set(ControlMode.PercentOutput, input);
    }

    @Override
    protected double getMeasurement() {
        return johnson.getSelectedSensorVelocity();
    }

    @Override
    protected void useOutput(double output, State setpoint) {
        johnson.set(ControlMode.Current, output + magMotorFeedforward.calculate(setpoint.position, setpoint.velocity));
    }
    



}
