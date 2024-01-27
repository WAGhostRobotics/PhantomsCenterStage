package org.firstinspires.ftc.teamcode.core;

import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.component.Intake;
import org.firstinspires.ftc.teamcode.component.LinearSlide;
import org.firstinspires.ftc.teamcode.component.Imu;
import org.firstinspires.ftc.teamcode.component.PlaneLauncher;


public class Bot {
    public static HardwareMap hardwareMap;
    public static RevIMU imu;

    public static Motor frontLeft;
    public static Motor frontRight;
    public static Motor backLeft;
    public static Motor backRight;

    public static PlaneLauncher planeLauncher;
    public static LinearSlide slides;
    public static Intake intake;
//    public static imu imu;

    public static void init(HardwareMap hwMap, boolean initTeleOp) {

        hardwareMap = hwMap;
        imu = new RevIMU(hwMap);
        imu.init();

        planeLauncher = new PlaneLauncher();
        planeLauncher.init(hardwareMap);

        intake = new Intake();
        intake.init(hardwareMap);

        slides = new LinearSlide();
        slides.init(hardwareMap);

        frontLeft = new Motor(hwMap, "leftFront");
        frontRight = new Motor(hwMap, "rightFront");
        backLeft = new Motor(hwMap, "leftBack");
        backRight = new Motor(hwMap, "rightBack");

        frontLeft.setInverted(true);
        frontRight.setInverted(false);
        backLeft.setInverted(true);
        backRight.setInverted(true);

        frontLeft.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
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