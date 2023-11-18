/** This is the code used for the field-centric driving tutorial
 This is by no means a perfect code
 There are a number of improvements that can be made
 So, feel free to add onto this and make it better
 */

package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.ToggleButtonReader;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.component.LinearSlide;
import org.firstinspires.ftc.teamcode.component.Pivot;
import org.firstinspires.ftc.teamcode.core.Bot;
import org.firstinspires.ftc.teamcode.library.DriveStyle;
import org.firstinspires.ftc.teamcode.library.DriverOrientedControl;

@TeleOp(name = "DaddyTeleOp")
public class TeleOpParent extends LinearOpMode {

    DriverOrientedControl drive;
    public double power = 0.8;
    public double turningMultiplier = 0.8;

    DriveStyle.DriveType type = DriveStyle.DriveType.MECANUMARCADE;

    @Override
    public void runOpMode() throws InterruptedException {
        Bot.init(hardwareMap, true);

        GamepadEx driverOp = new GamepadEx(gamepad1);// driver
        GamepadEx driverOp2 = new GamepadEx(gamepad2);//other

        Bot.pivot.setTargetPosition(Pivot.Pos.COLLAPSED.getPosition());
        Bot.pivot.update();
        Bot.inOutTake.closeFlap();
        Bot.planeLauncher.close();
        Bot.inOutTake.stopIntake();
        Bot.slides.setTargetPosition(LinearSlide.Pos.COLLAPSED_POSITION.getPosition());

        waitForStart();

        MecanumDrive drive = new MecanumDrive(
                Bot.frontLeft,
                Bot.frontRight,
                Bot.backLeft,
                Bot.backRight
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
                        Bot.imu.getRotation2d().getDegrees(),   // gyro value passed in here must be in degrees
                        false
                );
            }
            if (gamepad1.y) {
                Bot.pivot.setTargetPosition(Pivot.Pos.CLIMB.getPosition());
                //pivot.update();
            }
            if (gamepad1.a) {
                Bot.planeLauncher.open();
            }
            //Check Intake
            if (gamepad1.left_trigger > 0) {
                Bot.inOutTake.stopIntake();
            }
            if (gamepad1.right_trigger > 0) {
                Bot.inOutTake.startIntake();
            }
            //Check Pivot
            if (gamepad2.x) {
                Bot.pivot.setTargetPosition(Pivot.Pos.OUT.getPosition());
                //pivot.update();
            }
            if (gamepad2.y) {
                Bot.pivot.setTargetPosition(Pivot.Pos.PLACE.getPosition());
                //pivot.update();
            }
            if (gamepad2.b) {
                Bot.pivot.setTargetPosition(Pivot.Pos.COLLAPSED.getPosition());
                //pivot.update();
            }
            //Check Slides after motor added
            if (gamepad2.left_trigger > 0) {
                Bot.slides.setTargetPosition(LinearSlide.Pos.COLLAPSED_POSITION.getPosition());
            }
            if (gamepad2.right_trigger > 0) {
                Bot.slides.setTargetPosition(LinearSlide.Pos.MIDDLE_POSITION.getPosition());
            }
            if (gamepad2.right_trigger > 0 && gamepad2.right_trigger>0) {
                Bot.slides.setTargetPosition(LinearSlide.Pos.FORWARD_POSITION.getPosition());
            }
            if (gamepad2.left_bumper) {
                Bot.inOutTake.openFlap();
            }
            if (gamepad2.right_bumper) {
                Bot.inOutTake.closeFlap();
            }
            //test
            Bot.pivot.update();
        }
    }
}