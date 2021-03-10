package frc.robot.commands.ShooterCommands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.controller.PIDController;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PIDCommand;

public class JoystickToShoot extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    public Shooter shoot;
    private double leftBumper;
    private double rightBumper;


    public JoystickToShoot(Shooter shoot, double leftBumper, double rightBumper) {
        this.shoot = shoot;
        this.leftBumper = leftBumper;
        this.rightBumper = rightBumper;
        addRequirements(shoot);   
    }

    @Override
    public void execute(){
        if (leftBumper >= 0.1 && rightBumper == 0)
            shoot.enable();
        if (rightBumper >= 0.1 && leftBumper == 0)
            shoot.disable();
    } 

}
