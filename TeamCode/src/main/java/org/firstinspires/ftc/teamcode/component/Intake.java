package org.firstinspires.ftc.teamcode.component;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake {

    private Servo intake;

    //Set Values
    private double OPEN;
    private double CLOSED;

    public void init(HardwareMap hwmap){
        OPEN = 0;
        CLOSED = 1;
        intake = hwmap.get(Servo.class, "intake");
    }

    public void open(){
        intake.setPosition(OPEN);
    }

    public void close(){
        intake.setPosition(CLOSED);
    }

}
