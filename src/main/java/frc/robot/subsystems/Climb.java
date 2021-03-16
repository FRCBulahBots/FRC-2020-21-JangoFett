package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climb extends SubsystemBase {

    public TalonSRX polemotor;
    public VictorSPX winchmotor1;
    public VictorSPX winchmotor2;

    public Climb (int poleID, int winchID, int winch2ID){
        this.polemotor = new TalonSRX(poleID);
        this.winchmotor1 = new VictorSPX(winchID);
        this.winchmotor2 = new VictorSPX(winch2ID);

        polemotor.setNeutralMode(NeutralMode.Coast);
    
        winchmotor2.setInverted(InvertType.FollowMaster);
        winchmotor2.follow(winchmotor1);
    }

    public void setPoleSpeed(double dawg){
        polemotor.set(ControlMode.PercentOutput, dawg);
    }
    
    public void setWinchSpeed(double kat){
        winchmotor1.set(ControlMode.PercentOutput, kat);
    }
}
