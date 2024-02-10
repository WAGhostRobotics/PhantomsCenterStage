package org.firstinspires.ftc.teamcode.component;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class LinearSlide {

    private DcMotor slideMotor1;
    private DcMotor slideMotor2;

    private int targetPos;
    private double power;

    public void init(HardwareMap hwMap){
        power = 1;
        slideMotor1 = hwMap.get(DcMotor.class, "slideMotor1");
        slideMotor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        slideMotor2 = hwMap.get(DcMotor.class, "slideMotor2");
        slideMotor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void extend(){
        slideMotor1.setPower(power);
        slideMotor2.setPower(power);
    }
    public void retract(){
        slideMotor1.setPower(-1*power);
        slideMotor2.setPower(-1*power);
    }
    public void stop(){
        slideMotor1.setPower(0.1);
        slideMotor2.setPower(0.1);
    }
}
