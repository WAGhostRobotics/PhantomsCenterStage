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

    public void init(HardwareMap hwMap){
        slideMotor = hwMap.get(DcMotorEx.class, "slideMotor");
        slideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void setTargetPosition(int position){
        targetPos = position;
    }

    public double getTargetPosition(){
        return targetPos;
    }

    public void update(){
        slideMotor.setTargetPosition(targetPos);
    }
}
