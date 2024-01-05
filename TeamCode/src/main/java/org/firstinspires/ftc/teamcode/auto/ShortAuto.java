package org.firstinspires.ftc.teamcode.auto;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.core.Bot;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.sequencesegment.TrajectorySegment;

@Autonomous(name = "Shorty")
public class ShortAuto extends LinearOpMode {

    private SampleMecanumDrive drive;

    @Override
    public void runOpMode() throws InterruptedException{
        Bot.init(hardwareMap, false);

        Trajectory trajectory = drive.trajectoryBuilder(new Pose2d())
                .forward(5)
                .build();
        waitForStart();

        drive.followTrajectory(trajectory);
    }


}
