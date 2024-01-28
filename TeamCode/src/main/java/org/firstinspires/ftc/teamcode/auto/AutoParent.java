package org.firstinspires.ftc.teamcode.auto;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.component.Webcam;
import org.firstinspires.ftc.teamcode.core.Felicia;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.library.vision.SpikeDetect;

public class AutoParent extends LinearOpMode {
    private SampleMecanumDrive drive;
    private double distance;
    public boolean useLong;
    public boolean redAlliance;

    private SpikeDetect.Location location;
    //For all Splines, x should be -1* the number you want
    @Override
    public void runOpMode() {
        Felicia.init(hardwareMap, false, redAlliance);
        Felicia.webcam.init(hardwareMap);

        drive = new SampleMecanumDrive(hardwareMap);
        distance = useLong ? 97.5 : 48;

        location = Felicia.webcam.getLocation();

        Trajectory myTrajectory = drive.trajectoryBuilder(new Pose2d())
                .forward(distance)
                .build();

        waitForStart();

        if(isStopRequested()) return;

        drive.followTrajectory(myTrajectory);
    }
}
