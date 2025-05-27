package org.firstinspires.ftc.teamcode.RobotFunctions;

import com.qualcomm.robotcore.hardware.Servo;

public interface Swing {
    default void defaultPos(Servo left, Servo right) {
        left.setDirection(Servo.Direction.REVERSE);

        left.setPosition(.2);
        right.setPosition(.2);
    }
    default void backPos(Servo left, Servo right) {
        left.setDirection(Servo.Direction.REVERSE);

        left.setPosition(0);
        right.setPosition(0);
    }
    default void frontPos(Servo left, Servo right) {
        left.setDirection(Servo.Direction.REVERSE);

        left.setPosition(.55);
        right.setPosition(.55);
    }
}
