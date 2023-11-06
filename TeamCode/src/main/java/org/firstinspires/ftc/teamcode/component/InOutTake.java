package org.firstinspires.ftc.teamcode.component;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class InOutTake {

    private DcMotor intake;
    private Servo box1;
    private Servo box2;

    private double doorPower;
    private double OPEN;
    private double CLOSE;

    public void init(HardwareMap hwMap){
        intake = hwMap.get(DcMotor.class, "intake");
        box1 = hwMap.get(Servo.class, "box1");
        box2 = hwMap.get(Servo.class, "box2");
    }

    public void open1(){
        box1.setPosition(OPEN);
    }

    public void open2(){
        box2.setPosition(OPEN);
    }

    public void close1(){
        box1.setPosition(CLOSE);
    }

    public void close2(){
        box2.setPosition(CLOSE);
    }

    public void intake(){
        intake.setPower(1);
    }

    public double getBox1Position(){
        return box1.getPosition();
    }

    public double getBox2Position(){
        return box2.getPosition();
    }
}