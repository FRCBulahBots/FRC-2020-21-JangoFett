package frc.robot.commands.ShooterCommands;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class JoystickToShoot extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    public Shooter shoot;
    public Joystick joy;
    public int direction;

    public JoystickToShoot(Shooter shoot, int direction) {
        this.shoot = shoot;
        this.direction = direction;

        addRequirements(shoot);   
    }

    @Override
    public void initialize(){
        if (direction == 0)
            shoot.setShootSpeed(-0.10);
        if (direction == 1)
            shoot.setShootSpeed(0.10);
    } 

    @Override
    public void end(boolean interuption){
        shoot.setShootSpeed(0.0);
    }

    @Override
    public boolean isFinished(){
        return true;
    }

    

}
