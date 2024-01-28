package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "ZeroServoSetter")
public class ZeroOp extends LinearOpMode {

    Servo zero;

    @Override
    public void runOpMode() throws InterruptedException {

        zero = hardwareMap.get(Servo.class, "zero");
        waitForStart();
        zero.setPosition(0);

        while (opModeIsActive()) {
            telemetry.addData("0 pos?", zero.getPosition());
            telemetry.update();
        }
    }
}