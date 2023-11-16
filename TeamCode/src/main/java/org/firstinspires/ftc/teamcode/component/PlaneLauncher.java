package org.firstinspires.ftc.teamcode.component;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class PlaneLauncher {

    private Servo pLauncher;

    //Set Values
    private double UP;
    private double DOWN;

    public void init(HardwareMap hwmap){
        pLauncher = hwmap.get(Servo.class, "launcher");
    }

    public void open(){
        pLauncher.setPosition(UP);
    }

    public void close(){
        pLauncher.setPosition(DOWN);
    }

}
