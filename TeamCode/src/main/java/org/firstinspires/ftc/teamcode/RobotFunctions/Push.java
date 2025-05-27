package org.firstinspires.ftc.teamcode.RobotFunctions;
import com.qualcomm.robotcore.hardware.Servo;

public interface Push {
    default void extend(Servo left, Servo right) {
        left.setDirection(Servo.Direction.REVERSE);

        left.setPosition(1);
        right.setPosition(1);
    }
    default void retract(Servo left, Servo right) {
        left.setDirection(Servo.Direction.REVERSE);

        left.setPosition(0);
        right.setPosition(0);
    }
}
