package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.core.Bot;
import org.firstinspires.ftc.teamcode.library.DriveStyle;
import org.firstinspires.ftc.teamcode.library.DriverOrientedControl;

@TeleOp(name = "PhantomTeleOp")
public class PhantomTeleOp extends LinearOpMode {

    DriverOrientedControl drive;
    public double power = 0.8;
    public double turningMultiplier = 0.8;

    private boolean lastA = false;
    private boolean claw = false;
    private boolean lastB = false;
    private boolean launched = false;
    //This bad boy
    DriveStyle.DriveType type = DriveStyle.DriveType.MECANUMARCADE;

    CRServo launcher;
    Servo intake;

    @Override
    public void runOpMode() throws InterruptedException {
        Bot.init(hardwareMap, true);
        launcher = hardwareMap.get(CRServo.class, "launcher");
        intake = hardwareMap.get(Servo.class, "intake");
        GamepadEx driverOp = new GamepadEx(gamepad1);// driver
        waitForStart();
        MecanumDrive drive = new MecanumDrive(
                Bot.frontLeft,
                Bot.frontRight,
                Bot.backLeft,
                Bot.backRight
        );
        while (opModeIsActive()) {
//            if (gamepad1.b){
//                claw.setPosition(0);
//            }
            if(gamepad1.b && !lastB && launched){
                launcher.setPower(0);
                lastB = true;
                launched = false;
            }
            else if(gamepad1.b && !lastB){
                launcher.setPower(1);
                lastB = true;
                launched = true;
            }
            else if(gamepad1.b){
                lastB = true;
            }
            else{
                lastB = false;
            }

            if(gamepad1.a && !lastA && !claw){
                intake.setPosition(0);
                lastA = true;
                claw = true;
            }
            else if(gamepad1.a && !lastA){
                intake.setPosition(1);
                lastA = true;
                claw = false;
            }
            else if(gamepad1.a){
                lastA = true;
            }
            else{
                lastA = false;
            }
//            if(gamepad1.a){
//                claw.setPosition(0);
//            }
//            if(gamepad1.b){
//                claw.setPosition(1);
//            }
            telemetry.addData("Last A?", lastA);
            telemetry.addData("Claw?", claw);
            telemetry.addData("Last B?", lastB);
            telemetry.addData("Launched?", launched);

            //DRIVETRAIN STUFF
            if (type == DriveStyle.DriveType.MECANUMARCADE) {
                drive.driveRobotCentric(
                        power * driverOp.getLeftX(),
                        power * driverOp.getLeftY(),
                        power * driverOp.getRightX(),
                        false
                );
            } else if (type == DriveStyle.DriveType.DRIVERORIENTED) {
                drive.driveFieldCentric(
                        power * (Math.pow(driverOp.getLeftX(), 3)),
                        power * (Math.pow(driverOp.getLeftY(), 3)),
                        turningMultiplier * power * (Math.pow(driverOp.getRightX(), 3)),
                        Bot.imu.getRotation2d().getDegrees(),   // gyro value passed in here must be in degrees
                        false
                );
            }
            telemetry.update();
        }
    }
}