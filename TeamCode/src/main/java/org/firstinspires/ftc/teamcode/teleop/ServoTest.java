/** This is the code used for the field-centric driving tutorial
 This is by no means a perfect code
 There are a number of improvements that can be made
 So, feel free to add onto this and make it better
 */

package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.core.Bot;
import org.firstinspires.ftc.teamcode.library.DriveStyle;
import org.firstinspires.ftc.teamcode.library.DriverOrientedControl;

@TeleOp(name = "ServoTest")
public class ServoTest extends LinearOpMode {

    DriverOrientedControl drive;
    public double power = 0.8;
    public double turningMultiplier = 0.8;
    private boolean lastA = false;
    //This bad boy
    DriveStyle.DriveType type = DriveStyle.DriveType.MECANUMARCADE;

    Servo claw;

    @Override
    public void runOpMode() throws InterruptedException {
        Bot.init(hardwareMap, true);

//        claw=hardwareMap.get(Servo.class, "claw");
        GamepadEx driverOp = new GamepadEx(gamepad1);// driver
        waitForStart();
//        claw.setPosition(0);
        MecanumDrive drive = new MecanumDrive(
                Bot.frontLeft,
                Bot.frontRight,
                Bot.backLeft,
                Bot.backRight
        );

        while (opModeIsActive()) {

//            if (gamepad1.a){
//                claw.setPosition(1);
//            }
//            if (gamepad1.b){
//                claw.setPosition(0);
//            }
            if(gamepad1.a && !lastA){
//                claw.setPosition(0);
                lastA = true;
            }
            else if(gamepad1.a && !lastA){
//                claw.setPosition(1);
                lastA = true;
            }
            else if(gamepad1.a){
                lastA = true;
            }
            else{
                lastA = false;
            }
            if(gamepad1.a){
                claw.setPosition(0);
            }
            if(gamepad1.b){
                claw.setPosition(1);
            }
            telemetry.addData("Last A?", lastA);

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