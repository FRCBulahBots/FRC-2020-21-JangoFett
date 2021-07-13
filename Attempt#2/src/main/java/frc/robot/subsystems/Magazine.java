package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Magazine extends SubsystemBase {
    private VictorSP johnson;
    //to-do, refine this stupid process

    public Magazine(int beltID){

        johnson = new VictorSP(beltID);
        //johnson.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
        //rockbottom.setDistancePerPulse( (2 * Math.PI) / 7);
        //setGoal(Math.PI);
    }

    public void magSpeed(double input){
        johnson.set(input);
    }

}
