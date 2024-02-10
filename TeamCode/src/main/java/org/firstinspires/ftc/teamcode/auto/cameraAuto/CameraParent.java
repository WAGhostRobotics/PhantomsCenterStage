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

    Trajectory LtrajectorySpike1;
    Trajectory LtrajectorySpike2;
    Trajectory LtrajectoryPark;
    Trajectory MtrajectorySpike1;
    Trajectory MtrajectorySpike2;
    Trajectory MtrajectoryPark;
    Trajectory RtrajectorySpike1;
    Trajectory RtrajectorySpike2;
    Trajectory RtrajectoryPark;
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

        //Forward- 13, 32, -90
        //Top- 13, *30*, 0
        //Bottom- 9, 33, -180
        drive.setPoseEstimate(startPose);

        int place = 0;
        int finalPlace = 0;
        boolean run = true;

        waitForStart();

//        SpikeDetect.Location location = Felicia.webcam.getLocation();
//
//        if (location == SpikeDetect.Location.LEFT){
//            place = 1;
//        }
//        else if (location == SpikeDetect.Location.MID){
//            place = 2;
//        }
//        else if (location == SpikeDetect.Location.RIGHT){
//            place = 3;
//        }
            LtrajectorySpike1 = drive.trajectoryBuilder(startPose)
                    .strafeTo(new Vector2d(startX, 35*YMult))
                    .build();
            LtrajectorySpike2 = drive.trajectoryBuilder(LtrajectorySpike1.end())
                    .splineTo(new Vector2d(13, 30*YMult), Math.toRadians(0))
                    .build();
            LtrajectoryPark = drive.trajectoryBuilder(LtrajectorySpike2.end())
                    .lineToConstantHeading(new Vector2d(startX, (35)*YMult))
                    .splineTo(new Vector2d(60, 60*YMult), Math.toRadians(0))
                    .build();
            MtrajectorySpike1 = drive.trajectoryBuilder(startPose)
                    .strafeTo(new Vector2d(startX, 37*YMult))
                    .build();
            MtrajectorySpike2 = drive.trajectoryBuilder(MtrajectorySpike1.end())
                    .splineTo(new Vector2d(13, 32*YMult), Math.toRadians(-90))
                    .build();
            MtrajectoryPark = drive.trajectoryBuilder(MtrajectorySpike2.end())
                    .lineToConstantHeading(new Vector2d(startX, (37)*YMult))
                    .splineTo(new Vector2d(60, 60*YMult), Math.toRadians(0))
                    .build();
            RtrajectorySpike1 = drive.trajectoryBuilder(startPose)
                    .strafeTo(new Vector2d(startX, 38*YMult))
                    .build();
            RtrajectorySpike2 = drive.trajectoryBuilder(RtrajectorySpike1.end())
                    .splineTo(new Vector2d(9, 33*YMult), Math.toRadians(-180))
                    .build();
            RtrajectoryPark = drive.trajectoryBuilder(RtrajectorySpike2.end())
                    .lineToConstantHeading(new Vector2d(startX, (38)*YMult))
                    .splineTo(new Vector2d(60, 60*YMult), Math.toRadians(0))
                    .build();

        SpikeDetect.Location location;

        while(!isStopRequested() && run){

            location = Felicia.webcam.getLocation();

            if (location == SpikeDetect.Location.LEFT){
                place = 1;
                finalPlace = 1;
            }
            else if (location == SpikeDetect.Location.MID){
                place = 2;
                finalPlace = 2;
            }
            else if (location == SpikeDetect.Location.RIGHT){
                place = 3;
                finalPlace = 3;
            }

            if (place != 0){
                run = false;
                switch (place){
                    case 1:
                        drive.followTrajectory(LtrajectorySpike1);
                        drive.followTrajectory(LtrajectorySpike2);
                        Felicia.intake.open();
                        sleep(2000);
                        drive.followTrajectory(LtrajectoryPark);
                    case 2:
                        drive.followTrajectory(MtrajectorySpike1);
                        drive.followTrajectory(MtrajectorySpike2);
                        Felicia.intake.open();
                        sleep(2000);
                        drive.followTrajectory(MtrajectoryPark);
                    case 3:
                        drive.followTrajectory(RtrajectorySpike1);
                        drive.followTrajectory(RtrajectorySpike2);
                        Felicia.intake.open();
                        sleep(2000);
                        drive.followTrajectory(RtrajectoryPark);
                }
                Felicia.webcam.stopStreaming();
            }


            telemetry.addData("Loc", finalPlace);
            telemetry.update();
        }
    }
}