package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.dfrobot.HuskyLens;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public abstract class Movable extends LinearOpMode {
    static protected DcMotor FLW;
    static protected DcMotor BLW;
    static protected DcMotor FRW;
    static protected DcMotor BRW;
    static protected HuskyLens huskyLens;
    static protected ColorSensor colorSensor;

    static protected double angle, desVol, vx, vy, v1, v2, max;
    @Override
    public void runOpMode() throws InterruptedException {
        FLW = hardwareMap.get(DcMotor.class, "FLW");
        BLW = hardwareMap.get(DcMotor.class, "BLW");
        BRW = hardwareMap.get(DcMotor.class, "BRW");
        FRW = hardwareMap.get(DcMotor.class, "FRW");
        huskyLens = hardwareMap.get(HuskyLens.class, "huskylens");
        colorSensor = hardwareMap.get(ColorSensor.class, "colorsensor");
        huskyLens.selectAlgorithm(HuskyLens.Algorithm.COLOR_RECOGNITION);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
    }

    protected void colorDetection() {
        HuskyLens.Block[] blocks = huskyLens.blocks();

        // Check if any colors are detected
        if (blocks.length > 0) {
            telemetry.addData("Detected Colors", blocks.length);

            // Loop through each detected color block
            for (HuskyLens.Block block : blocks) {
                    /*
                     red ID = 1
                     blue ID = 2
                     yellow ID = 3
                    */
                int colorID = block.id;
                switch (colorID) {
                    case 1:
                        telemetry.addData("Red Detected!", "");
                        break;
                    case 2:
                        telemetry.addData("Blue Detected!", "");
                        break;
                    case 3:
                        telemetry.addData("Yellow Detected!", "");
                        break;
                }
                telemetry.addData("Color ID", colorID);
            }
        } else {
            telemetry.addData("Status", "No Colors Detected");
        }

        telemetry.update();
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