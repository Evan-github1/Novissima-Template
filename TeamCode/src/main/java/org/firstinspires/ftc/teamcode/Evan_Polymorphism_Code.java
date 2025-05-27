package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.dfrobot.HuskyLens;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.RobotFunctions.Axel;
import org.firstinspires.ftc.teamcode.RobotFunctions.BottomNod;
import org.firstinspires.ftc.teamcode.RobotFunctions.Movable;
import org.firstinspires.ftc.teamcode.RobotFunctions.Push;
import org.firstinspires.ftc.teamcode.RobotFunctions.BottomTwist;
import org.firstinspires.ftc.teamcode.RobotFunctions.Swing;
import org.firstinspires.ftc.teamcode.RobotFunctions.TopNod;

@TeleOp
public class Evan_Polymorphism_Code extends Movable
        implements Push, BottomTwist, Swing, BottomNod, Axel, TopNod {

    private static long time;
    private static boolean pushSwitch, twistingBottomSwitch, bottomNodSwitch, axelSwitch, topNodSwitch;
    private static int swingSwitch;

    private static Servo LPushServo, RPushServo;
    private static Servo twistingBottomServo;
    private static Servo LSwingServo, RSwingServo;
    private static Servo bottomNodServo;
    private static Servo axelServo;
    private static Servo topNodServo;

    static protected HuskyLens huskyLens;

    static protected ColorSensor colorSensor;

    static {
        time = System.currentTimeMillis();
        pushSwitch = false; // retracted
        twistingBottomSwitch = false; // default pos
        swingSwitch = 1; // default pos, 0 is back
        bottomNodSwitch = false; // up
        axelSwitch = false; // up
        topNodSwitch = false; // forward
    }

    @Override
    public void runOpMode() throws InterruptedException {
        super.runOpMode();

        LPushServo = hardwareMap.get(Servo.class, "LIP");
        RPushServo = hardwareMap.get(Servo.class, "RIP");

        twistingBottomServo = hardwareMap.get(Servo.class, "ITS");

        LSwingServo = hardwareMap.get(Servo.class, "LOFS");
        RSwingServo = hardwareMap.get(Servo.class, "ROFS");

        bottomNodServo = hardwareMap.get(Servo.class, "IRS");

        axelServo = hardwareMap.get(Servo.class, "IFS");

        topNodServo = hardwareMap.get(Servo.class, "ORS");

        //huskyLens = hardwareMap.get(HuskyLens.class, "huskylens");
        //colorSensor = hardwareMap.get(ColorSensor.class, "colorsensor");
        //huskyLens.selectAlgorithm(HuskyLens.Algorithm.COLOR_RECOGNITION);

        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.update();

            moveWheels(gamepad1.left_stick_x, gamepad1.left_stick_y);

            if (gamepad1.a && delay()) {
                if (!pushSwitch) {
                    extend(LPushServo, RPushServo);
                } else {
                    retract(LPushServo, RPushServo);
                }
                pushSwitch = !pushSwitch;
                time = System.currentTimeMillis();
            } else if (gamepad1.b && delay()) {
                if (!twistingBottomSwitch) {
                    defaultPos(twistingBottomServo);
                } else {
                    sidePos(twistingBottomServo);
                }
                twistingBottomSwitch = !twistingBottomSwitch;
                time = System.currentTimeMillis();
            } else if (gamepad1.x && delay()) {
                if (swingSwitch == 0) {
                    backPos(LSwingServo, RSwingServo);
                    swingSwitch++;
                } else if (swingSwitch == 1) {
                    defaultPos(LSwingServo, RSwingServo);
                    swingSwitch++;
                } else if (swingSwitch == 2) {
                    frontPos(LSwingServo, RSwingServo);
                    swingSwitch = 0;
                }
                time = System.currentTimeMillis();
            } else if (gamepad1.y && delay()) {
                if (!bottomNodSwitch) {
                    faceUp(bottomNodServo);
                } else {
                    faceDown(bottomNodServo);
                }
                bottomNodSwitch = !bottomNodSwitch;
                time = System.currentTimeMillis();
            }

            // breakkkkkkkkkkkKKKKKKKK!!KK!K11111!1!11

            if (gamepad2.a && delay()) {
                if (!axelSwitch) {
                    up(axelServo);
                } else {
                    flat(axelServo);
                }
                axelSwitch = !axelSwitch;
                time = System.currentTimeMillis();
            } else if (gamepad2.b && delay()) {
                if (!topNodSwitch) {
                    faceForward(topNodServo);
                } else {
                    faceBackward(topNodServo);
                }
                topNodSwitch = !topNodSwitch;
                time = System.currentTimeMillis();
            }

            updatePhoneConsole();
        }
    }

    private boolean delay() {
        return System.currentTimeMillis() - time >= 250;
    }
    public void updatePhoneConsole() {
        telemetry.update();
    }
}