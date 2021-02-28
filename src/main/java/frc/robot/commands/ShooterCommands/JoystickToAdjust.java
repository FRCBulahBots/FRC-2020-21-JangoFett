package frc.robot.commands.ShooterCommands;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class JoystickToAdjust extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    Shooter shooter;
    int direction;

    public JoystickToAdjust(Shooter john, int direction){
        this.shooter = john;
        this.direction = direction;
        addRequirements(shooter);   
    }

    @Override
    public void initialize(){     
        if (direction == 0)
            shooter.setServoSpeed(1.0);
        if (direction == 1)
            shooter.setServoSpeed(-1.0);
    }



    @Override
    public boolean isFinished(){
        return true;
    }
    

}
