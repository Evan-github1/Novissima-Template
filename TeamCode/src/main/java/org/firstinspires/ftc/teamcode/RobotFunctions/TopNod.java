package org.firstinspires.ftc.teamcode.RobotFunctions;

import com.qualcomm.robotcore.hardware.Servo;

public interface TopNod {
    default void faceForward(Servo servo) {
        servo.setPosition(.85);
    }

    default void faceBackward(Servo servo) {
        servo.setPosition(0);
    }
}
