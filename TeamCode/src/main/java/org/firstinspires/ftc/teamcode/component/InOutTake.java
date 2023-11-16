package org.firstinspires.ftc.teamcode.component;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class InOutTake {

    private DcMotor intake;
    private Servo flap;
//    private Servo box2;

    //set values
    private double doorPower;
    private double OPEN;
    private double CLOSE;

    public void init(HardwareMap hwMap){
        //replace flap with box1 in competition
        intake = hwMap.get(DcMotor.class, "intake");
        flap = hwMap.get(Servo.class, "flap");
//        box2 = hwMap.get(Servo.class, "box2");
    }

    public void openFlap(){
        flap.setPosition(OPEN);
    }

//    public void open2(){
//        box2.setPosition(OPEN);
//    }

    public void closeFlap(){
        flap.setPosition(CLOSE);
    }

//    public void close2(){
//        box2.setPosition(CLOSE);
//    }

    public void startIntake(){
        intake.setPower(1);
    }

    public void stopIntake(){
        intake.setPower(0);
    }

    public double getFlapPosition(){
        return flap.getPosition();
    }

//    public double getBox2Position(){
//        return box2.getPosition();
//    }
}