package org.firstinspires.ftc.teamcode;

import android.media.AudioManager;

import com.qualcomm.ftccommon.SoundPlayer;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp

public class Sound extends LinearOpMode {

    int soundID;

    @Override
    public void runOpMode() throws InterruptedException {
        soundID = hardwareMap.appContext.getResources()
                .getIdentifier("guzzlord_scream", "raw",
                        hardwareMap.appContext.getPackageName());

        SoundPlayer.getInstance().preload(hardwareMap.appContext, soundID);
        SoundPlayer.getInstance().startPlaying(hardwareMap.appContext, soundID);

        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.a || (gamepad1.left_stick_button && gamepad1.right_stick_button)) {
                SoundPlayer.getInstance().startPlaying(hardwareMap.appContext, soundID);
            }
        }

    }

}
