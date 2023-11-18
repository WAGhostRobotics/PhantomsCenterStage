package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.core.Bot;

@TeleOp(name="servoTestNonZero")
public class ServoTest extends LinearOpMode {

    double position;
    Servo servo;
//    Servo servo2;

    @Override
    public void runOpMode() throws InterruptedException{
        //Bot.init(hardwareMap, true);
        servo = hardwareMap.get(Servo.class, "servy");
//        servo2 = hardwareMap.get(Servo.class, "servy2");
        GamepadEx driverOp = new GamepadEx(gamepad1);// driver
//        servo.setDirection(Servo.Direction.REVERSE);
        servo.setPosition(-0.05);
//        servo2.setPosition(0);
        position = 0;
        waitForStart();
        //position = servo.getPosition();
        //servo.setDirection(Servo.Direction.REVERSE);

        servo.setPosition(servo.getPosition()+0.15);
        while (!isStopRequested()){
//            position = 0.05;
//
//
            //servo2.setPosition(position);
//            if (gamepad1.a){
//                position-=0.01;
//
//            }
//            servo2.setPosition(position);
            telemetry.addData("Current Position", servo.getPosition());
//            telemetry.addData("Current Position 2", servo2.getPosition());
            telemetry.addData("Target", position);
            telemetry.update();
        }
    }
}
