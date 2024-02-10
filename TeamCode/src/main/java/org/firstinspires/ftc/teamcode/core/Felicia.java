package org.firstinspires.ftc.teamcode.core;

import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.component.Intake;
import org.firstinspires.ftc.teamcode.component.LinearSlide;
import org.firstinspires.ftc.teamcode.component.PlaneLauncher;
import org.firstinspires.ftc.teamcode.component.Webcam;


public class Felicia {
    public static HardwareMap hardwareMap;
    public static RevIMU imu;

    public static Motor frontLeft;
    public static Motor frontRight;
    public static Motor backLeft;
    public static Motor backRight;

    public static PlaneLauncher launcher;
    public static LinearSlide slides;
    public static Intake intake;
    public static Webcam webcam;
//    public static imu imu;

    public static void init(HardwareMap hwMap, boolean initTeleOp, boolean redAlliance) {

        hardwareMap = hwMap;
        imu = new RevIMU(hwMap);
        imu.init();

//        launcher = new PlaneLauncher();
//        launcher.init(hardwareMap);

        intake = new Intake();
        intake.init(hardwareMap);

        slides = new LinearSlide();
        slides.init(hardwareMap);

        webcam = new Webcam(redAlliance);

        frontLeft = new Motor(hwMap, "leftFront");
        frontRight = new Motor(hwMap, "rightFront");
        backLeft = new Motor(hwMap, "leftBack");
        backRight = new Motor(hwMap, "rightBack");

        frontLeft.setInverted(true);
        frontRight.setInverted(false);
        backLeft.setInverted(true);
        backRight.setInverted(false);

        frontLeft.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
    }

    public static void sleep(long milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}