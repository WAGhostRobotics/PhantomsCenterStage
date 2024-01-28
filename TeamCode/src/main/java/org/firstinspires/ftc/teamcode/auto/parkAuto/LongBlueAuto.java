package org.firstinspires.ftc.teamcode.auto.parkAuto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "BlueLongitude")
public class LongBlueAuto extends AutoParent {
    @Override
    public void runOpMode() {
        super.useLong = true;
        super.redAlliance = false;
        super.runOpMode();
    }
}