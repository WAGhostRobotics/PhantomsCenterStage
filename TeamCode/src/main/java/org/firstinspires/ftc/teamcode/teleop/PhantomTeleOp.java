package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.component.InOutTake;
import org.firstinspires.ftc.teamcode.component.Pivot;
import org.firstinspires.ftc.teamcode.component.PlaneLauncher;

@TeleOp(name="servotest")
public class PhantomTeleOp extends LinearOpMode {

    PlaneLauncher planeLauncher;
    InOutTake inOutTake;
    Pivot pivot;
    //Create Slide

    @Override
    public void runOpMode() throws InterruptedException{

        planeLauncher = new PlaneLauncher();
        planeLauncher.init(hardwareMap);

        inOutTake = new InOutTake();
        inOutTake.init(hardwareMap);

        pivot = new Pivot();
        pivot.init(hardwareMap);

        //Create and init slide

        GamepadEx driverOp = new GamepadEx(gamepad1);// driver
        GamepadEx driverOp2 = new GamepadEx(gamepad2);//other

        waitForStart();

        pivot.setTargetPosition(Pivot.Pos.COLLAPSED.getPosition());
        pivot.update();
        inOutTake.closeFlap();
        planeLauncher.close();
        inOutTake.stopIntake();
        //Retract slide

        while(!isStopRequested()){
            if(gamepad1.y){
                pivot.setTargetPosition(Pivot.Pos.CLIMB.getPosition());
                //pivot.update();
            }
            if(gamepad1.a){
                planeLauncher.close();
            }
            if(gamepad1.left_trigger>0){
                inOutTake.stopIntake();
            }
            if(gamepad1.right_trigger>0){
                inOutTake.startIntake();
            }
            if(gamepad2.x){
                pivot.setTargetPosition(Pivot.Pos.OUT.getPosition());
                //pivot.update();
            }
            if(gamepad2.y){
                pivot.setTargetPosition(Pivot.Pos.PLACE.getPosition());
                //pivot.update();
            }
            if(gamepad2.b){
                pivot.setTargetPosition(Pivot.Pos.COLLAPSED.getPosition());
                //pivot.update();
            }
            if(gamepad2.left_trigger>0){
                //Retract Slide
            }
            if(gamepad2.right_trigger>0){
                //Extend Slide
            }
            if(gamepad2.left_bumper){
                inOutTake.openFlap();
            }
            if(gamepad2.right_bumper) {
                inOutTake.closeFlap();
            }
            //test
            pivot.update();
        }
    }
}
