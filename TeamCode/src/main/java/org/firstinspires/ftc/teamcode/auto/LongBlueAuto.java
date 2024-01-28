package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Longitude")
public class LongBlueAuto extends AutoParent {
    @Override
    public void runOpMode() {
        super.useLong = true;
        super.redAlliance = false;
        super.runOpMode();
    }
}