package org.firstinspires.ftc.teamcode.auto.parkAuto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "RedLongitude")
public class LongRedAuto extends AutoParent {
    @Override
    public void runOpMode() {
        super.useLong = true;
        super.redAlliance = true;
        super.runOpMode();
    }
}