package frc.robot.commands.ClimberCommands;

import frc.robot.subsystems.Climb;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class JoystickToPull extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    Climb climb;


    public JoystickToPull(Climb climber){
        this.climb = climber;
        addRequirements(climb);   
        
    }

    @Override
    public void initialize(){    
        climb.setWinchSpeed(1.0);
            if (climb.winchmotor1.getMotorOutputVoltage() >= 13f){
                climb.setWinchSpeed(0);
            }
    }

    @Override
    public void end(boolean interrupted){
        climb.setWinchSpeed(0);
    }

    @Override
    public boolean isFinished(){
        return true;
    }
    

}
