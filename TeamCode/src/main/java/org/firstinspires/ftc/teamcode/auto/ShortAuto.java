package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.core.Bot;

@Autonomous(name = "Shorty")
public class ShortAuto extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException{
        Bot.init(hardwareMap, false);
        waitForStart();

        while (opModeIsActive() && !isStopRequested()){
            Bot.backLeft.setTargetDistance(50);
            Bot.frontLeft.setTargetDistance(50);
            Bot.backRight.setTargetPosition(50);
            Bot.frontRight.setTargetDistance(5000);

            telemetry.addData("rb Pos", Bot.backRight.getCurrentPosition());
            telemetry.addData("rb RPM", Bot.backRight.getMaxRPM());
            telemetry.addData("rb atTarget", Bot.backRight.atTargetPosition());
            telemetry.addData("rb atTarget", Bot.backRight.getDistance());
            telemetry.update();
        }
    }


}
