package org.firstinspires.ftc.teamcode.RobotFunctions;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.QuickConfig;

public abstract class Movable extends LinearOpMode implements QuickConfig {
    static protected DcMotor FLW;
    static protected DcMotor BLW;
    static protected DcMotor FRW;
    static protected DcMotor BRW;

    static protected double angle, desVol, vx, vy, v1, v2, max;
    @Override
    public void runOpMode() throws InterruptedException {
        config(FLW, "FLW");
        config(BLW, "BLW");
        config(FRW, "FRW");
        config(BRW, "BRW");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
    }

    protected void moveWheels(float x, float y) {
        double correctedX = -x;
        angle = Math.atan2(y, correctedX);
        desVol = Math.sqrt(Math.pow(correctedX, 2) + Math.pow(y, 2));

        vx = desVol * Math.cos(angle);
        vy = desVol * Math.sin(angle);
        v1 = vy + vx;
        v2 = vy - vx;
        max = Math.max(Math.abs(v1), Math.abs(v2));

        if(max > 1){
            v1 /= max;
            v2 /= max;
        }

        FLW.setPower(v1);
        FRW.setPower(v2);
        BRW.setPower(v1);
        BLW.setPower(v2);
    }

    protected abstract void updatePhoneConsole();
}