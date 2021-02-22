package frc.robot.commands.ClimberCommands;

import frc.robot.subsystems.Climb;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class JoystickToPull extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    Climb climb;
    int direction;
    boolean extendus;

    public JoystickToPull(Climb climber, int direction){
        this.climb = climber;
        this.direction = direction;
        extendus = false;
        addRequirements(climb);   
        
    }

    @Override
    public void initialize(){    
        extendus = !extendus;
        
        if (extendus = true)
            climb.setWinchSpeed(-1.0);
        if (extendus = false)
            climb.setWinchSpeed(1.0);
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
