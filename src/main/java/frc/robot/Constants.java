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

    //CAN
    public static int leftMasterChief = 0;
    public static int leftFollower = 1;
    public static int rightMasterChief = 2;
    public static int rightFollower = 3;
    public static int armMover = 4;
    public static int climbMotor = 5;
    public static int beltMotor = 6;
    public static int shooterDeviceID = 7;
    public static int pickupDeviceID = 8;
    public static int winchmotor1 = 9;
    public static int winchmotor2 = 10;
    

    //DIO
    public static int armA = 0;
    public static int armB = 1;
    
    //USB
    public static int joystick = 0;





}
