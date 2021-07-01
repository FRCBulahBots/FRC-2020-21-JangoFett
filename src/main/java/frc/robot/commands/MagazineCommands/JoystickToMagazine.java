package frc.robot.commands.MagazineCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Magazine;

public class JoystickToMagazine extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    Magazine mag;
    int dir;

    public JoystickToMagazine(Magazine mag, int dir){
        this.mag = mag;
        this.dir = dir;
        addRequirements(mag);   
    }

    @Override
    public void execute(){     
        if (dir == 0) mag.magSpeed(0.5);
        if (dir == 1) mag.magSpeed(-0.5);
    }

    @Override
    public void end(boolean interrupted) {
        mag.magSpeed(0);
    }

    @Override
    public boolean isFinished(){
        return true;
    }
    

}
