package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.core.Bot;

@TeleOp(name="servotest")
public class ServoTest extends LinearOpMode {

    int position;
    Servo servo;

    @Override
    public void runOpMode() throws InterruptedException{

        position = 0;
        //Bot.init(hardwareMap, true);
        servo = hardwareMap.get(Servo.class, "servy");

        waitForStart();


        while (!isStopRequested()){

//            if (gamepad1.a){
//                position+=10;
//            }
//            else if (gamepad1.x){
//                position-=10;
//            }
//
//            Bot.slide.setTargetPosition(position);
//
//            telemetry.addData("Slide Position", position);
//            telemetry.update();
            servo.setPosition(1);
        }
    }
}
