package frc.robot.commands.DriveCommands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class JoystickToDrive extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    Drivetrain drive;
    Joystick joy;
    int axis1, axis2;

    public JoystickToDrive(Drivetrain drive, int axis1, int axis2) {
        this.drive = drive;
        this.axis1 = axis1;
        this.axis2 = axis2;
        addRequirements(drive);
    }

    @Override
    public void execute(){     
        drive.arcadeDrive(0.7 * joy.getRawAxis(axis1), -0.9 * joy.getRawAxis(axis2));
    }

}
