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

@TeleOp(name = "ZeroServoSetter")
public class ZeroOp extends LinearOpMode {

    Servo zero;

    @Override
    public void runOpMode() throws InterruptedException {

        zero = hardwareMap.get(Servo.class, "zero");
        GamepadEx driverOp = new GamepadEx(gamepad1);// driver
        waitForStart();
        zero.setPosition(0);

        while (opModeIsActive()) {
            telemetry.addData("0 pos?", zero.getPosition());
            telemetry.update();
        }
    }
}