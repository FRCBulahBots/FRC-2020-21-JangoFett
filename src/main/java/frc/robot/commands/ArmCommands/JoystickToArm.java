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
    public void execute(){     
    //unused for now lol, gotta test 
    
    }

    @Override
    public boolean isFinished(){
        return true;
    }
    

}