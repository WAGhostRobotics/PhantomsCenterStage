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

    Trajectory trajectoryPark1;
    Trajectory trajectoryPark2;

    //For all Splines, x should be -1* the number you want
    @Override
    public void runOpMode() {
        Felicia.init(hardwareMap, false, redAlliance);
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        if (!useLong) {
            trajectoryPark1 = drive.trajectoryBuilder(new Pose2d())
                    .forward(48)
                    .build();
        }
        else{
            if (redAlliance){
                trajectoryPark1 = drive.trajectoryBuilder(new Pose2d())
                        .strafeLeft(10)
                        .build();
            }
            else{
                trajectoryPark1 = drive.trajectoryBuilder(new Pose2d())
                        .strafeRight(10)
                        .build();
            }
            trajectoryPark2 = drive.trajectoryBuilder(trajectoryPark1.end())
                    .forward(96)
                    .build();
        }
        waitForStart();
//        sleep(15000);
        drive.followTrajectory(trajectoryPark1);
        drive.followTrajectory(trajectoryPark2);
    }
}