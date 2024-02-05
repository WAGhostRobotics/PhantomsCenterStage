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

        //Forward- 13, 36
        //Top- 26, 33
        //Bottom- -4, 33

        drive.setPoseEstimate(startPose);
        int midPosX = 26;
        int midPosY = 33;

        Trajectory trajectorySpike1 = drive.trajectoryBuilder(startPose)
                .strafeTo(new Vector2d(startX, midPosY))
                .build();
        Trajectory trajectorySpike2 = drive.trajectoryBuilder(trajectorySpike1.end())
                .strafeTo(new Vector2d(midPosX, midPosY))
                .build();
//        Trajectory trajectoryPark = drive.trajectoryBuilder(trajectorySpike2.end())
//                .splineTo(new Vector2d(60, 60), Math.toRadians(0))
//                .build();
        waitForStart();

        drive.followTrajectory(trajectorySpike1);
        drive.followTrajectory(trajectorySpike2);
        Felicia.intake.open();
//        drive.followTrajectory(trajectoryPark2);
    }
}
