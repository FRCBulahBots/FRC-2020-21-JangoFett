/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Encoder;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static int leftMasterChief = 0;
    public static int leftFollower = 1;
    public static int rightMasterChief = 2;
    public static int rightFollower = 3;

    public static int joystick = 0;

    public static class ArmManipulator {   
        public WPI_TalonSRX armMotor;
        public Encoder armEncoder;
        public double kP = 0.002f; // Proportional controller constant
        public int TargetPosition = 0; // Target Positional value of Arm (Defual target is 0;)

        public ArmManipulator(int armManipulatorMotor, int encA, int encB){
            armMotor = new WPI_TalonSRX(armManipulatorMotor);
            armEncoder = new Encoder(encA, encB, true, Encoder.EncodingType.k4X);
            armEncoder.setDistancePerPulse(7);
        }

        
        public enum ArmPositions { // Enum containing all of the possible Arm Postions we may want to move to
            FULLYRETRACTED(0),
            BALLPICKUP(1404);
    
            private final int id;
            ArmPositions(int id) { this.id = id; }
            public int getValue() { return id; }
        }
        
    }
}
