package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.core.Bot;

@TeleOp(name="servotest")
public class ServoTest extends LinearOpMode {

    double position;
    Servo servo;
    //Servo servo2;

    @Override
    public void runOpMode() throws InterruptedException{
        //Bot.init(hardwareMap, true);
        servo = hardwareMap.get(Servo.class, "servy");
        //servo2 = hardwareMap.get(Servo.class, "servy2");
        GamepadEx driverOp = new GamepadEx(gamepad1);// driver
        waitForStart();
        //position = servo.getPosition();
        //servo.setDirection(Servo.Direction.REVERSE);
        while (!isStopRequested()){
//            position = 0.05;
//
//
            //servo2.setPosition(position);
            if (gamepad1.a){
                //position-=0.01;
                position+=0.01;

            }
            servo.setPosition(0.08);
            telemetry.addData("Servo Position", servo.getPosition());
            telemetry.addData("Target Position", position);
            telemetry.update();
        }
    }
}
