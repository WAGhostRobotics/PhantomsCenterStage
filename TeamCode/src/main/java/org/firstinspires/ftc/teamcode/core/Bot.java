package org.firstinspires.ftc.teamcode.core;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.component.LinearSlide;


public class Bot {
    public static HardwareMap hardwareMap;

    public static LinearSlide slide;

//    public static Motor frontLeft;
//    public static Motor frontRight;
//    public static Motor backLeft;
//    public static Motor backRight;

    public static void init(HardwareMap hwMap, boolean initTeleOp) {
        // Assign HardwareMap
        hardwareMap = hwMap;

        slide = new LinearSlide();
        slide.init(hwMap);

//        frontLeft = new Motor(hwMap, "lf");
//        frontRight = new Motor(hwMap, "rf");
//        backLeft = new Motor(hwMap, "lr");
//        backRight = new Motor(hwMap, "rr");

//            frontLeft.setInverted(true);
//            frontRight.setInverted(true);
//            backLeft.setInverted(true);
//            backRight.setInverted(true);


//        frontLeft.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
//        frontRight.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
//        backLeft.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
//        backRight.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
    }


    /**
     * Sleeps for the given amount of milliseconds, or until the thread is interrupted. This is
     * simple shorthand for the operating-system-provided {@link Thread#sleep(long) sleep()} method.
     *
     * @param milliseconds amount of time to sleep, in milliseconds
     * @see Thread#sleep(long)
     */
    public static void sleep(long milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}