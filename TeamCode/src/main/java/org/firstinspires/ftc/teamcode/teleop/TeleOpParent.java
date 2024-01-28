//OUTDATED
package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.component.LinearSlide;
import org.firstinspires.ftc.teamcode.core.Felicia;
import org.firstinspires.ftc.teamcode.library.DriveStyle;
import org.firstinspires.ftc.teamcode.library.DriverOrientedControl;

@TeleOp(name = "DaddyTeleOp")
public class TeleOpParent extends LinearOpMode {

    DriverOrientedControl drive;
    public double power = 0.8;
    public double turningMultiplier = 0.8;

    //This bad boy
    DriveStyle.DriveType type = DriveStyle.DriveType.DRIVERORIENTED;

    @Override
    public void runOpMode() throws InterruptedException {
        Felicia.init(hardwareMap, true, false);

        GamepadEx driverOp = new GamepadEx(gamepad1);// driver
        GamepadEx driverOp2 = new GamepadEx(gamepad2);//other

        waitForStart();

        MecanumDrive drive = new MecanumDrive(
                Felicia.frontLeft,
                Felicia.frontRight,
                Felicia.backLeft,
                Felicia.backRight
        );

        while (opModeIsActive()) {

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
            if (gamepad1.a) {
                Felicia.planeLauncher.open();
            }
            telemetry.update();
        }
    }
}