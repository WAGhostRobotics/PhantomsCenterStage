package org.firstinspires.ftc.teamcode.component;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Pivot {

    private DcMotor pMotor;

    public enum Pos{
        OUT(10),
        COLLAPSED(20),
        CLIMB(30),
        PLACE(40);

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
        pMotor = hwMap.get(DcMotor.class, "pMotor");
        pMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void setTargetPosition(int position){
        targetPos = position;
    }

    public double getTargetPosition(){
        return targetPos;
    }

    public void update(){
        pMotor.setTargetPosition(targetPos);
    }
}
