package org.firstinspires.ftc.teamcode.component;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class PlaneLauncher {

    public Servo pLauncher;
    public void init(HardwareMap hwmap){
        pLauncher = hwmap.get(Servo.class, "launcher");
    }

    public void launch(){
        pLauncher.setPosition(0.8);
    }

}
