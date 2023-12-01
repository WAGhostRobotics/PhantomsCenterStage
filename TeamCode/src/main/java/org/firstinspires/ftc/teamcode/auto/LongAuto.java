package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.core.Bot;

@Autonomous(name = "Longitude")
public class LongAuto extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException{
        Bot.init(hardwareMap, false);
        waitForStart();

        while (!isStopRequested()){
            Bot.backLeft.setTargetDistance(10);
            Bot.frontLeft.setTargetDistance(10);
            Bot.backRight.setTargetDistance(10);
            Bot.frontRight.setTargetDistance(10);
        }
    }


}
