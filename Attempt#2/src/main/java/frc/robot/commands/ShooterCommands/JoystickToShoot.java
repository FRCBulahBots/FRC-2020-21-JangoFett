package frc.robot.commands.ShooterCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class JoystickToShoot extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    public Shooter shoot;
    private int dir;
    private int goal;

    public JoystickToShoot(Shooter shoot, int dir, int goal) {
        this.shoot = shoot;
        this.dir = dir;
        addRequirements(shoot);  
        this.goal = goal; 
    }

    @Override
    public void initialize() {
        shoot.enable();
        shoot.setSetpoint(goal);
    }

    @Override
    public boolean isFinished(){
        return true;
    }

    @Override
    public void end(boolean interrupted) {
        shoot.disable();
        shoot.setSetpoint(0);
    }

}
