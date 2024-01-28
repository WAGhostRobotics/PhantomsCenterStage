package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

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