package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile.State;
import edu.wpi.first.wpilibj2.command.ProfiledPIDSubsystem;
import frc.robot.Constants;

public class Magazine extends ProfiledPIDSubsystem {
    public WPI_VictorSPX johnson;
    public Encoder rockbottom;

    public Magazine(int beltID, int mag1, int mag2){
        super(new ProfiledPIDController(0.02, 0, 0, new TrapezoidProfile.Constraints(Constants.kMaxVelocityRadPerSecond, Constants.kMaxAccelerationRadPerSecSquared), 0));
        rockbottom.setDistancePerPulse( (2 * Math.PI) / 7);
        

    }

    @Override
    public double getMeasurement() {
        return rockbottom.getRate();
    }

    @Override
    protected void useOutput(double output, State setpoint) {

    }
    
    public void setMagSpeed(double speedToSet){
        johnson.set(speedToSet);
    }


}
