/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

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
    //PWM
    public static int bigBoysPort = 0;
    public static int poleMotor = 1;

    //CAN
    public static int leftMasterChief = 0;
    public static int leftFollower = 1;
    public static int rightMasterChief = 2;
    public static int rightFollower = 3;
    public static int armMover = 4;
    public static int beltMotor = 5;
    public static int pickupDeviceID = 7;
    public static int shooterDeviceID = 8;
    public static int climbmotor1 = 9;
    public static int climbmotor2 = 10;

    

    //DIO
    public static int armA = 0;
    public static int armB = 1;
    
    //USB
    public static int joystick = 0;

    //Pickup/Magazine Constants
    public static final double kShooterFreeRPS = 5676;

    public static final double kSVolts = 0.05;
    public static final double kVVoltSecondsPerRotation = 12.0 / kShooterFreeRPS;

    public static final double kCosVolts = 1;
    public static final double kVVoltSecondPerRad = 0.1;
    public static final double kAVoltSecondSquaredPerRad = 0.1;

    public static final double kMaxVelocityRadPerSecond = 3;
    public static final double kMaxAccelerationRadPerSecSquared = 10;





}
