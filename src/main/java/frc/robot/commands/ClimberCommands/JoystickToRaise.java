package frc.robot.commands.ClimberCommands;


import frc.robot.subsystems.Climb;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class JoystickToRaise extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    Climb climb;
    int direction;

    public JoystickToRaise(Climb climber, int direction){
        this.climb = climber;
        this.direction = direction;
        addRequirements(climb);   
    }

    @Override
    public void initialize(){     
        if (direction == 0)
            climb.setPoleSpeed(-1.0);
        if (direction == 1)
            climb.setPoleSpeed(1.0);
    }

    @Override
    public void end(boolean interrupted){
        climb.setPoleSpeed(0);
    }

    @Override
    public boolean isFinished(){
        return true;
    }
    

}
