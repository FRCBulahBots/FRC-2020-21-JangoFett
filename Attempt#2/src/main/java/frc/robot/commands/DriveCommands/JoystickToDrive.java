package frc.robot.commands.DriveCommands;

import frc.robot.subsystems.Drivetrain;

import java.util.function.DoubleSupplier;
import java.util.function.DoubleToLongFunction;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class JoystickToDrive extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    Drivetrain drive;
    DoubleSupplier axis1, axis2;

    public JoystickToDrive(Drivetrain drive, DoubleSupplier axis1, DoubleSupplier axis2) {
        this.drive = drive;
        this.axis1 = axis1;
        this.axis2 = axis2;
        addRequirements(drive);
    }

    @Override
    public void execute(){     
        drive.arcadeDrive(axis1.getAsDouble(), axis2.getAsDouble());
    }

}
