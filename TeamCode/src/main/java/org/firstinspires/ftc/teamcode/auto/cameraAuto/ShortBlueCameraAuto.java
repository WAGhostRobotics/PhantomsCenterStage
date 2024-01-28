package org.firstinspires.ftc.teamcode.auto.cameraAuto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "CameraBlueShorty")
public class ShortBlueCameraAuto extends CameraParent {
    @Override
    public void runOpMode() {
        super.useLong = false;
        super.redAlliance = false;
        super.runOpMode();
    }
}