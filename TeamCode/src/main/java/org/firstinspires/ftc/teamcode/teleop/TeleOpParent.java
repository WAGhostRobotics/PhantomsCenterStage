/** This is the code used for the field-centric driving tutorial
 This is by no means a perfect code
 There are a number of improvements that can be made
 So, feel free to add onto this and make it better
 */

package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.ToggleButtonReader;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.core.Bot;
import org.firstinspires.ftc.teamcode.library.DriveStyle;


public class TeleOpParent extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Bot.init(hardwareMap, true);
        waitForStart();

        MecanumDrive drive = new MecanumDrive(
                Bot.frontLeft,
                Bot.frontRight,
                Bot.backLeft,
                Bot.backRight
        );

        while (opModeIsActive()) {
            //code goes here oh yeah
        }
    }
}