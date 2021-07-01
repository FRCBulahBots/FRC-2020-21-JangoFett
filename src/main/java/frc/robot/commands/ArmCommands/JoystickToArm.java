package frc.robot.commands.ArmCommands;

import frc.robot.subsystems.Pickup;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class JoystickToArm extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    Pickup pickup;
    int dir;
    int goal;

    public JoystickToArm(Pickup pickup, int dir, int goal){
        this.pickup = pickup;
        this.dir = dir;
        this.goal = goal;
        addRequirements(pickup);   
    }

    @Override
    public void execute(){   
        if (dir == 0) pickup.setSetpoint(goal); pickup.enable(); pickup.setSuckSpeed(0.3);
        if (dir == 1) pickup.setSetpoint(0); pickup.enable(); pickup.setSuckSpeed(0);
    }

    @Override
    public boolean isFinished(){
        return true;
    }

}
