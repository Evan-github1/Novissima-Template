package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class TestTest extends LinearOpMode {

    static private Servo servo;
    static private Servo servo2;
    static private String servoName;
    static private String servoName2;
    static private int currentLetterNum;
    static private boolean capsLock;

    static private double servoPos, servoPos2;
    static private double incValue;
    static private boolean servoConfirmed;
    static private boolean twoServoMode;
    static private boolean onServo1;

    static private long delay;

    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        reset();
        waitForStart();

        while(opModeIsActive()) {
            if (servoConfirmed) {
                if (addButtonDelay()) {
                    if (gamepad2.dpad_left) {
                        // inc servo pos
                        if (onServo1) {
                            servoPos -= incValue;
                        } else {
                            servoPos2 -= incValue;
                        }
                        delay = System.currentTimeMillis();
                    } else if (gamepad2.dpad_right) {
                        // dec servo pos
                        if (onServo1) {
                            servoPos += incValue;
                        } else {
                            servoPos2 += incValue;
                        }
                        delay = System.currentTimeMillis();
                    } else if (gamepad2.dpad_up) {
                        // inc inc value
                        incValue += .02;
                        delay = System.currentTimeMillis();
                    } else if (gamepad2.dpad_down) {
                        // dec inc value
                        incValue -= .02;
                        delay = System.currentTimeMillis();
                    } else if (gamepad2.right_bumper && gamepad2.left_bumper) {
                        reset();
                    }
                }
                servo.setPosition(servoPos);
                telemetry.addData("Servo position", servoPos);
                if (twoServoMode) {
                    servo2.setPosition(servoPos2);
                    telemetry.addData("Servo 2 position", servoPos2);
                }
                telemetry.addData("Increment value", incValue);
            } else {
                final String letters = "abcdefghijklmnopqrstuvwxyz";
                if (addButtonDelay()) {
                    if (gamepad1.dpad_right && currentLetterNum < 25) {
                        // go to next letter
                        currentLetterNum++;
                        delay = System.currentTimeMillis();
                    } else if (gamepad1.dpad_left && currentLetterNum > 0) {
                        // go to previous letter
                        currentLetterNum--;
                        delay = System.currentTimeMillis();
                    } else if (gamepad1.dpad_up) {
                        capsLock = true;
                    } else if (gamepad1.dpad_down) {
                        capsLock = false;
                    } else if (gamepad1.b) {
                        // add character to servo name
                        if (!capsLock) {
                            if (onServo1) {
                                servoName += letters.charAt(currentLetterNum);
                            } else {
                                servoName2 += letters.charAt(currentLetterNum);
                            }
                        } else {
                            if (onServo1) {
                                servoName += (letters.toUpperCase()).charAt(currentLetterNum);
                            } else {
                                servoName2 += (letters.toUpperCase()).charAt(currentLetterNum);
                            }
                        }
                        delay = System.currentTimeMillis();
                    } else if (gamepad1.a) {
                        // delete last character
                        try {
                            if (onServo1) {
                                servoName = servoName.substring(0, servoName.length() - 1);
                            } else {
                                servoName2 = servoName2.substring(0, servoName2.length() - 1);
                            }
                        } catch (Exception e) {} // swallow exception
                        delay = System.currentTimeMillis();
                    } else if (gamepad1.y) {
                        twoServoMode = true;
                        delay = System.currentTimeMillis();
                    } else if (gamepad1.x && twoServoMode) {
                        onServo1 = !onServo1;
                        delay = System.currentTimeMillis();
                    }
                }
                telemetry.addData("Current servo #1 name", servoName);
                if (twoServoMode) {
                    telemetry.addData("Current servo #2 name", servoName2);
                }
                telemetry.addData("Current letter", letters.charAt(currentLetterNum));
                telemetry.addData("Caps Lock", capsLock);
            }

            // try to fetch servo with current servoName
            try {
                servo = hardwareMap.get(Servo.class, servoName);
                telemetry.addData("Success", servoName + " is detected.");
                servoConfirmed = true;
            } catch (Exception e) {
                telemetry.addData("Error", "\"" + servoName + "\"" +
                        " is not a servo. Please re-check your spelling and/or configuration.");
                servoConfirmed = false;
            } finally {
                telemetry.update();
            }
        }
    }

    private void reset() {
        servoName = "";
        servoName2 = "";
        currentLetterNum = 0;
        capsLock = false;
        twoServoMode = false;
        onServo1 = true;
        servoPos = 0;
        incValue = .05;
        servoConfirmed = false;
        delay = System.currentTimeMillis();
    }

    private boolean addButtonDelay() {
        return System.currentTimeMillis() - delay > 300;
    }
}