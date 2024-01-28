package org.firstinspires.ftc.teamcode.component;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class LinearSlide {

    private DcMotor slideMotor;

    private int targetPos;
    private double power;

    public void init(HardwareMap hwMap){
        power = 0.1;
//        slideMotor = hwMap.get(DcMotorEx.class, "slideMotor");
//        slideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void extend(){
        slideMotor.setPower(power);
    }
    public void retract(){
        slideMotor.setPower(-1*power);
    }
    public void stopMotor(){
        slideMotor.setPower(0);
    }
}
