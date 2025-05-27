package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.dfrobot.HuskyLens;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.RobotFunctions.Movable;
import org.firstinspires.ftc.teamcode.RobotFunctions.Push;

@TeleOp
public class Evan_Polymorphism_Code extends Movable implements Push {

    private static Servo LPushServo;
    private static Servo RPushServo;

    static protected HuskyLens huskyLens;

    static protected ColorSensor colorSensor;

    @Override
    public void runOpMode() throws InterruptedException {
        super.runOpMode();

        config(LPushServo, "LIP");
        config(RPushServo, "RIP");

        config(huskyLens, "huskylens");
        config(colorSensor, "colorsensor");
        huskyLens.selectAlgorithm(HuskyLens.Algorithm.COLOR_RECOGNITION);


        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.update();

            // game loop
            moveWheels(gamepad1.left_stick_x, gamepad1.left_stick_y);

            if (gamepad1.a) {
                extend(LPushServo, RPushServo);
            } else if (gamepad1.b) {
                retract(LPushServo, RPushServo);
            }
        }
    }

    public void updatePhoneConsole() {
        telemetry.update();
    }
}