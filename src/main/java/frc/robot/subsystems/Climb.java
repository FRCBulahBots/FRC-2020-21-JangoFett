package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climb extends SubsystemBase {
    
    public VictorSP polemotor;
    public VictorSPX winchmotor1;

    public Climb (int poleID, int winchID){
        this.polemotor = new VictorSP(poleID);
        this.winchmotor1 = new VictorSPX(winchID);
    }

    public void setPoleSpeed(double dawg){
        polemotor.setSpeed(dawg);
    }
    
    public void setWinchSpeed(double kat){
        winchmotor1.set(ControlMode.PercentOutput, kat);
    }
}
