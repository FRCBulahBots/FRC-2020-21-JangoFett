package frc.robot.commands.ArmCommands;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.Pickup;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class JoystickToSuck extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    public Pickup pickup;
    public Joystick joy;
    public int direction;

    public JoystickToSuck(Pickup pickup, int direction){
        this.pickup = pickup;
        this.direction = direction;

        addRequirements(pickup);   
    }

    @Override
    public void initialize(){
        if (direction == 0)
            pickup.setSuckSpeed(-0.10);
        if (direction == 1)
            pickup.setSuckSpeed(0.10);
    } 

    @Override
    public void end(boolean interuption){
        pickup.setSuckSpeed(0.0);
    }

    @Override
    public boolean isFinished(){
        return true;
    }

    

}
