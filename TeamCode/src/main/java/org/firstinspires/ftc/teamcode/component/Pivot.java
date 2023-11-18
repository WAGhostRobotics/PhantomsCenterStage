package org.firstinspires.ftc.teamcode.component;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Pivot {

    private Servo pivotServo1;
    private Servo pivotServo2;

    public enum Pos{
        //Update Values
        OUT(10),
        COLLAPSED(0),
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

        pivotServo1 = hwMap.get(Servo.class, "pServo1");
        pivotServo2 = hwMap.get(Servo.class, "pServo2");
    }

    public void setTargetPosition(int position){
        targetPos = position;
    }

    public double getTargetPosition(){
        return targetPos;
    }

    public void update(){
        pivotServo1.setPosition(targetPos);
        pivotServo2.setPosition(targetPos);
    }
}
