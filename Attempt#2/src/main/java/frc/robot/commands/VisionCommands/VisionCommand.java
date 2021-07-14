package frc.robot.commands.VisionCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Vision;
import frc.robot.subsystems.Drivetrain;

public class VisionCommand extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    Drivetrain drive;
    Vision vision;
    boolean dir;

    public VisionCommand(Vision vision, Drivetrain drive, boolean dir) {
        this.vision = vision; 
        this.dir = dir;
        this.drive = drive;
    }

    @Override
    public void execute() {
        
        
    }


}
