package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.component.LinearSlide;
import org.firstinspires.ftc.teamcode.component.Pivot;
import org.firstinspires.ftc.teamcode.core.Bot;

//@TeleOp(name="servotest")
public class PhantomTeleOp extends LinearOpMode {

    Bot bot;

    @Override
    public void runOpMode() throws InterruptedException{

        GamepadEx driverOp = new GamepadEx(gamepad1);// driver
        GamepadEx driverOp2 = new GamepadEx(gamepad2);//other

        bot = new Bot();
        bot.init(hardwareMap, true);

        waitForStart();

        Bot.pivot.setTargetPosition(Pivot.Pos.COLLAPSED.getPosition());
        Bot.pivot.update();
        Bot.inOutTake.closeFlap();
        Bot.planeLauncher.close();
        Bot.inOutTake.stopIntake();
        Bot.slides.setTargetPosition(LinearSlide.Pos.COLLAPSED_POSITION.getPosition());

        while(!isStopRequested()){

        }
    }
}
