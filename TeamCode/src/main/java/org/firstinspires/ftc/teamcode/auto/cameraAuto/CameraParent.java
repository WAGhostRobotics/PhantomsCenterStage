package org.firstinspires.ftc.teamcode.auto.cameraAuto;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.core.Felicia;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.library.vision.SpikeDetect;

public class CameraParent extends LinearOpMode {
    public boolean useLong;
    public boolean redAlliance;

    Trajectory trajectorySpike;
    Trajectory trajectoryPark;

    String place;
    //For all Splines, x should be -1* the number you want
    @Override
    public void runOpMode() {
        Felicia.init(hardwareMap, false, redAlliance);
        Felicia.webcam.init(hardwareMap);

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        SpikeDetect.Location location = Felicia.webcam.getLocation();
        place = "";

        Pose2d startPose = new Pose2d(-60, 24, Math.toRadians(0));
        drive.setPoseEstimate(startPose);

        while(opModeInInit()) {
            switch (location) {
                case LEFT:
                    trajectorySpike = drive.trajectoryBuilder(new Pose2d())
                        .strafeTo(new Vector2d(1,2))
                        .build();
                    trajectoryPark = drive.trajectoryBuilder(new Pose2d())
                        .splineTo(new Vector2d(1,2), Math.toRadians(-90))
                        .build();
                    place="Left";
                    break;
                case MID:
                    trajectorySpike = drive.trajectoryBuilder(new Pose2d())
                        .forward(24)
                        .build();
                    trajectoryPark = drive.trajectoryBuilder(new Pose2d())
                        .splineTo(new Vector2d(24,48), Math.toRadians(90))
                        .build();
                    place="Middle";
                    break;
                case RIGHT:
                    trajectorySpike = drive.trajectoryBuilder(new Pose2d())
                            .strafeTo(new Vector2d(1,2))
                            .build();
                    trajectoryPark = drive.trajectoryBuilder(new Pose2d())
                            .splineTo(new Vector2d(1,2), Math.toRadians(-90))
                            .build();
                    place="Right";
                    break;
            }
        }
        waitForStart();

        if(isStopRequested()) return;

        drive.followTrajectory(trajectorySpike);
        Felicia.intake.open();
        drive.followTrajectory(trajectoryPark);
        Felicia.webcam.stopStreaming();

        telemetry.addData("Place", place);
        telemetry.update();
    }
}
