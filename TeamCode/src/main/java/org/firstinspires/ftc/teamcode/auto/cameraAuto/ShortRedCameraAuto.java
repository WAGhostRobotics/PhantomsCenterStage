package org.firstinspires.ftc.teamcode.auto.cameraAuto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "CameraRedShorty")
public class ShortRedCameraAuto extends CameraParent {
    @Override
    public void runOpMode() {
        super.useLong = false;
        super.redAlliance = true;
        super.runOpMode();
    }
}