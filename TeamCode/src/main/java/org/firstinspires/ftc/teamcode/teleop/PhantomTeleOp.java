package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.core.Felicia;
import org.firstinspires.ftc.teamcode.library.DriveStyle;
import org.firstinspires.ftc.teamcode.library.DriverOrientedControl;

@TeleOp(name = "PhantomTeleOp")
public class PhantomTeleOp extends LinearOpMode {

    DriverOrientedControl drive;
    public double power = 0.8;
    public double turningMultiplier = 0.8;

    private boolean lastA = false;
    private boolean claw = false;
    //This bad boy
    DriveStyle.DriveType type = DriveStyle.DriveType.MECANUMARCADE;

    @Override

    public void runOpMode() throws InterruptedException {
        Felicia.init(hardwareMap, true, false);
        GamepadEx driverOp = new GamepadEx(gamepad1);// driver
        Servo launcher = hardwareMap.get(Servo.class, "launcher");
        waitForStart();
        MecanumDrive drive = new MecanumDrive(
                Felicia.frontLeft,
                Felicia.frontRight,
                Felicia.backLeft,
                Felicia.backRight
        );
        while (opModeIsActive()) {

//            intake.setPosition(gamepad1.left_stick_x);

            if(gamepad1.a && !lastA && !claw){
                Felicia.intake.open();
                lastA = true;
                claw = true;
            }
            else if(gamepad1.a && !lastA){
                Felicia.intake.close();
                lastA = true;
                claw = false;
            }
            else{
                lastA = gamepad1.a;
            }

            if (gamepad1.b){
                launcher.setPosition(1);
            }

            if(gamepad1.dpad_down){
                Felicia.slides.retract();
            }
            else if(gamepad1.dpad_up){
                Felicia.slides.extend();
            }
            else{
                Felicia.slides.stop();
            }
            telemetry.addData("Last A?", lastA);
            telemetry.addData("Claw?", claw);
//            telemetry.addData("IntakePos", intake.getPosition());

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
                        Felicia.imu.getRotation2d().getDegrees(),   // gyro value passed in here must be in degrees
                        false
                );
            }
            telemetry.update();
        }
    }
}