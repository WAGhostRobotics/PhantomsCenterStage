package org.firstinspires.ftc.teamcode.auto.parkAuto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.auto.parkAuto.AutoParent;

@Autonomous(name = "BlueShorty")
public class ShortBlueAuto extends AutoParent {
    @Override
    public void runOpMode() {
        super.useLong = false;
        super.redAlliance = false;
        super.runOpMode();
    }
}