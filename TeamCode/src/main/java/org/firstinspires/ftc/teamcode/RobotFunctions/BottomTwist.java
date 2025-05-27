package org.firstinspires.ftc.teamcode.RobotFunctions;
import com.qualcomm.robotcore.hardware.Servo;

public interface BottomTwist {
    default void defaultPos(Servo servo) {
        servo.setPosition(0);
    }
    default void sidePos(Servo servo) {
        servo.setPosition(.5);
    }
}
