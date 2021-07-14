package frc.robot.commands.VisionCommands;


import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class AutonCommand extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    Drivetrain drive;
    boolean oil;
    

    public AutonCommand(Drivetrain drive){
        this.drive = drive;
        addRequirements(drive);   
    }

    @Override
    public void execute(){  
        drive.arcadeDrive(0.5f, 0.5f);
        Timer.delay(1);
        drive.arcadeDrive(0, 0);
    
    }

}
