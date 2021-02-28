package frc.robot.commands.MagazineCommands;

import frc.robot.subsystems.Magazine;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class JoystickToMagazine extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    Magazine mag;
    boolean oil;
    

    public JoystickToMagazine(Magazine mag){
        this.mag = mag;
        addRequirements(mag);   
    }

    @Override
    public void execute(){     
    
    
    }

    @Override
    public boolean isFinished(){
        return true;
    }
    

}
