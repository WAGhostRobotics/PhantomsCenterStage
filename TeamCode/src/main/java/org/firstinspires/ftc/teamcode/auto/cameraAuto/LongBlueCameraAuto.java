package org.firstinspires.ftc.teamcode.auto.cameraAuto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "CameraBlueLongitude")
public class LongBlueCameraAuto extends CameraParent {
    @Override
    public void runOpMode() {
        super.useLong = true;
        super.redAlliance = false;
        super.runOpMode();
    }
}