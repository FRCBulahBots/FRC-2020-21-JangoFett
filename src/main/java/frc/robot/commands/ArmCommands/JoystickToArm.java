package frc.robot.commands.ArmCommands;


import frc.robot.subsystems.Pickup;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class JoystickToArm extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    Pickup pickup;
    int dir;

    public JoystickToArm(Pickup pickup, int dir, int goal){
        this.pickup = pickup;
        this.dir = dir;
        addRequirements(pickup);   
    }

    @Override
    public void initialize() {
        if (!pickup.isEnabled())pickup.enable();
    }

    @Override
    public void execute(){   
        if (dir == 0) pickup.setSetpoint(-550);
        if (dir == 1) pickup.setSetpoint(0);
    }

    @Override
    public boolean isFinished(){
        return true;
    }

    @Override
    public void end(boolean interrupted) {
        pickup.disable();
    }
    

}
