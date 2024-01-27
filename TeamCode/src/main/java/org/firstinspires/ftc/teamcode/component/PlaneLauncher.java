package org.firstinspires.ftc.teamcode.component;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.CRServo;

public class PlaneLauncher {

    private CRServo pLauncher;
    public void init(HardwareMap hwmap){
        pLauncher = hwmap.get(CRServo.class, "launcher");
    }

    public void open(){
        pLauncher.setPower(1);
    }

    public void close(){
        pLauncher.setPower(0);
    }

}
