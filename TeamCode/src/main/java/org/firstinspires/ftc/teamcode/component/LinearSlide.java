package org.firstinspires.ftc.teamcode.component;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class LinearSlide {

    private DcMotorEx slideMotor;

    public enum Pos{
        //Update Values
        COLLAPSED_POSITION(10),
        MIDDLE_POSITION(20),
        FORWARD_POSITION(30);

        int position;

        Pos(int position) {
            this.position = position;
        }

        public int getPosition() {
            return position;
        }
    }

    private int targetPos;
    private int multiplier;
    private double power;

    public void init(HardwareMap hwMap){
        power = 0.5;
        slideMotor = hwMap.get(DcMotorEx.class, "slideMotor");
        slideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void setTargetPosition(int position){
        multiplier = 1;
        targetPos = position;
        if(slideMotor.getCurrentPosition()>position){
            multiplier = -1;
        }
        slideMotor.setPower(multiplier * 0.5);
        slideMotor.setTargetPosition(targetPos);
    }

    public void stopMotor(){
        slideMotor.setPower(0);
    }

    public double getTargetPosition(){
        return targetPos;
    }

//    public void update(){
//        slideMotor.setTargetPosition(targetPos);
//    }
}
