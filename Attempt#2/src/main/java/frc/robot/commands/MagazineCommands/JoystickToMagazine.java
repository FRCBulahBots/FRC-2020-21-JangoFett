package frc.robot.commands.MagazineCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Magazine;

public class JoystickToMagazine extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    Magazine mag;
    boolean dir;

    public JoystickToMagazine(Magazine mag, boolean dir){
        this.mag = mag;
        this.dir = dir;
        addRequirements(mag);   
    }

    @Override
    public void initialize() {
       if (dir) mag.magSpeed(0.5);
       if (!dir) mag.magSpeed(-0.5);
    }


    @Override
    public void end(boolean interrupted) {
        mag.magSpeed(0);
    }

}
