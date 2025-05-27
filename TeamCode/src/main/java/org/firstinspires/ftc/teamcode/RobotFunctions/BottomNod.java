package org.firstinspires.ftc.teamcode.RobotFunctions;

import com.qualcomm.robotcore.hardware.Servo;

public interface BottomNod {
    default void faceUp(Servo servo) {
        servo.setPosition(0);
    }

    default void faceDown(Servo servo) {
        servo.setPosition(.95);
    }
}
