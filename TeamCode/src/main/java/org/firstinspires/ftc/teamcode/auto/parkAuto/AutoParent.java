package org.firstinspires.ftc.teamcode.auto.parkAuto;

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

        Trajectory trajectoryPark = drive.trajectoryBuilder(new Pose2d())
                .strafeRight(15)
                .build();
        Trajectory trajectoryPark2 = drive.trajectoryBuilder(new Pose2d())
                .forward(distance)
                .build();

        waitForStart();

        if(isStopRequested()) return;

        sleep(20000);
        drive.followTrajectory(trajectoryPark);
        drive.followTrajectory(trajectoryPark2);

        telemetry.addData("Wonky Location", location);
        telemetry.update();
    }
}
