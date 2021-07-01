package frc.robot.commands.ShooterCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class JoystickToAdjust extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    Shooter shoot;
    int direction;

    public JoystickToAdjust(Shooter john, int direction){
        this.shoot = john;
        this.direction = direction;
        addRequirements(shoot);   
    }

    @Override
    public void initialize(){     
        if (direction == 0)
            shoot.setServoSpeed(1.0);
        if (direction == 1)
            shoot.setServoSpeed(-1.0);
    }

    @Override
    public boolean isFinished(){
        return true;
    }
    

}
