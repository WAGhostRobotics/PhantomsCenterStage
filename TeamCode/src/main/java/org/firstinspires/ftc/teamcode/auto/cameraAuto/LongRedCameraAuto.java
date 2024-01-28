package org.firstinspires.ftc.teamcode.auto.cameraAuto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "CameraRedLongitude")
public class LongRedCameraAuto extends CameraParent {
    @Override
    public void runOpMode() {
        super.useLong = true;
        super.redAlliance = true;
        super.runOpMode();
    }
}