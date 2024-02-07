package org.firstinspires.ftc.teamcode.auto.parkAuto;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.core.Felicia;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class AutoParent extends LinearOpMode {
    public boolean useLong;
    public boolean redAlliance;

    //For all Splines, x should be -1* the number you want
    @Override
    public void runOpMode() {
        Felicia.init(hardwareMap, false, redAlliance);
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
//        Felicia.webcam.init(hardwareMap);

        int startX = useLong ? 12 : 12;
        int startY = redAlliance ? -60 : 60;
        Pose2d startPose = new Pose2d(startX, startY, Math.toRadians(-90));

        //Forward- 13, 36, -90
        //Top- 19, 33, 0
        //Bottom- 5, 33, -180

        drive.setPoseEstimate(startPose);
        int midPosX = 5;
        int midPosY = 33;
        double angle = Math.toRadians(-180);

//                .addTemporalMarker(2, () -> Felicia.intake.open()) // Lower servo
//                .addTemporalMarker(2, () -> Felicia.intake.close())
        Trajectory trajectorySpike1 = drive.trajectoryBuilder(startPose)
                .strafeTo(new Vector2d(startX, midPosY+5))
                .build();
        Trajectory trajectorySpike2 = drive.trajectoryBuilder(trajectorySpike1.end())
                .splineTo(new Vector2d(midPosX, midPosY), angle)
                .build();
        Trajectory trajectoryPark = drive.trajectoryBuilder(trajectorySpike2.end())
                .lineToConstantHeading(new Vector2d(startX, midPosY+5))
                .splineTo(new Vector2d(60, 60), Math.toRadians(0))
                .build();
        waitForStart();

        drive.followTrajectory(trajectorySpike1);
        drive.followTrajectory(trajectorySpike2);
//        Felicia.intake.open();
//        sleep(2000);
        drive.followTrajectory(trajectoryPark);
    }
}
