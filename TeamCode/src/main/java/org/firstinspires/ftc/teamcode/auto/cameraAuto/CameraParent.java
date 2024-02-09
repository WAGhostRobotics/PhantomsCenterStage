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

    Trajectory trajectorySpike1;
    Trajectory trajectorySpike2;
    Trajectory trajectoryPark;
    //For all Splines, x should be -1* the number you want
    @Override
    public void runOpMode() {
        Felicia.init(hardwareMap, false, redAlliance);
        Felicia.webcam.init(hardwareMap);

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        int startX = 12;
        int YMult = redAlliance ? -1 : 1;

        Pose2d startPose = new Pose2d(startX, 60*YMult, Math.toRadians(-90*YMult));
        drive.setPoseEstimate(startPose);

        SpikeDetect.Location location = Felicia.webcam.getLocation();

        int place = 0;

        if (location == SpikeDetect.Location.LEFT){
            place = 1;
        }
        else if (location == SpikeDetect.Location.MID){
            place = 2;
        }
        else if (location == SpikeDetect.Location.RIGHT){
            place = 3;
        }

        //Forward- 13, 32, -90
        //Top- 13, *30*, 0
        //Bottom- 9, 33, -180
        drive.setPoseEstimate(startPose);

        while(opModeInInit()) {
            switch (place) {
                case 1:
                    trajectorySpike1 = drive.trajectoryBuilder(startPose)
                        .strafeTo(new Vector2d(startX, 35*YMult))
                        .build();
                    trajectorySpike2 = drive.trajectoryBuilder(trajectorySpike1.end())
                        .splineTo(new Vector2d(13, 30*YMult), Math.toRadians(0))
                        .build();
                    trajectoryPark = drive.trajectoryBuilder(trajectorySpike2.end())
                        .lineToConstantHeading(new Vector2d(startX, (35)*YMult))
                        .splineTo(new Vector2d(60, 60*YMult), Math.toRadians(0))
                        .build();
//                    place="Left";
                    break;
                case 2:
                    trajectorySpike1 = drive.trajectoryBuilder(startPose)
                            .strafeTo(new Vector2d(startX, 37*YMult))
                            .build();
                    trajectorySpike2 = drive.trajectoryBuilder(trajectorySpike1.end())
                            .splineTo(new Vector2d(13, 32*YMult), Math.toRadians(-90))
                            .build();
                    trajectoryPark = drive.trajectoryBuilder(trajectorySpike2.end())
                            .lineToConstantHeading(new Vector2d(startX, (37)*YMult))
                            .splineTo(new Vector2d(60, 60*YMult), Math.toRadians(0))
                            .build();
//                    place="Middle";
                    break;
                case 3:
                    trajectorySpike1 = drive.trajectoryBuilder(startPose)
                            .strafeTo(new Vector2d(startX, 38*YMult))
                            .build();
                    trajectorySpike2 = drive.trajectoryBuilder(trajectorySpike1.end())
                            .splineTo(new Vector2d(9, 33*YMult), Math.toRadians(-180))
                            .build();
                    trajectoryPark = drive.trajectoryBuilder(trajectorySpike2.end())
                            .lineToConstantHeading(new Vector2d(startX, (38)*YMult))
                            .splineTo(new Vector2d(60, 60*YMult), Math.toRadians(0))
                            .build();
//                    place="Right";
                    break;
            }
        }
        waitForStart();

        while(!isStopRequested()){
            if(location== SpikeDetect.Location.MID)
            telemetry.addData("Loc", location);
            telemetry.update();
        }

        drive.followTrajectory(trajectorySpike1);
        drive.followTrajectory(trajectorySpike2);
        Felicia.intake.open();
        sleep(2000);
//        drive.followTrajectory(trajectoryPark);

        Felicia.webcam.stopStreaming();
    }
}

