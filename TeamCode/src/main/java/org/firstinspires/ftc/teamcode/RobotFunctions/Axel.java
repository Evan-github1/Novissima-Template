package org.firstinspires.ftc.teamcode.RobotFunctions;

import com.qualcomm.robotcore.hardware.Servo;

public interface Axel {
    default void flat(Servo servo) {
        servo.setPosition(.88);
    }

    default void up(Servo servo) {
        servo.setPosition(.33);
    }
}
