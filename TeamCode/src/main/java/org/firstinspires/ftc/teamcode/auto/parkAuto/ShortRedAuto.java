package org.firstinspires.ftc.teamcode.auto.parkAuto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.auto.parkAuto.AutoParent;

@Autonomous(name = "RedShorty")
public class ShortRedAuto extends AutoParent {
    @Override
    public void runOpMode() {
        super.useLong = false;
        super.redAlliance = true;
        super.runOpMode();
    }
}