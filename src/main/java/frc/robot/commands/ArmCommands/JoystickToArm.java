package frc.robot.commands.ArmCommands;


import frc.robot.subsystems.Pickup;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class JoystickToArm extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    Pickup pickup;
    boolean oil;
    

    public JoystickToArm(Pickup pickup){
        this.pickup = pickup;
        addRequirements(pickup);   
    }

    @Override
    public void initialize(){     
        oil = !oil;

        if (oil == true){
            pickup.setGoal(1);
            pickup.enable();
        }
        if (oil == false){
            pickup.setGoal(0.5);
            pickup.enable();
        }
    
    }

    @Override
    public boolean isFinished(){
        return true;
    }
    

}
