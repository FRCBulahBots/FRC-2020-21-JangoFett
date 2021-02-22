package frc.robot.commands.ShooterCommands;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class JoystickToAdjust extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    Shooter shooter;
    Joystick joy;
    boolean oil2;
    

    public JoystickToAdjust(Shooter john){
        this.shooter = john;
        oil2 = false;
        addRequirements(shooter);   
    }

    @Override
    public void initialize(){     
        oil2 = !oil2;

        if (oil2 = true)
            shooter.setServoSpeed(1.0);
        if (oil2 = false)
            shooter.setServoSpeed(-1.0);
    }


    @Override
    public boolean isFinished(){
        return true;
    }
    

}
