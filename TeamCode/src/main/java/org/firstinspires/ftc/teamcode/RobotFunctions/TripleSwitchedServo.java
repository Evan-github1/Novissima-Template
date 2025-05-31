package org.firstinspires.ftc.teamcode.RobotFunctions;

import com.qualcomm.robotcore.hardware.Servo;

public class TripleSwitchedServo {

    public int servoSwitch = 0;
    protected Servo servo1, servo2;
    protected double pos1, pos2;
    protected double pos3;

    public TripleSwitchedServo(Servo servo1, double pos1, double pos2, double pos3) {
        this.servo1 = servo1;
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.pos3 = pos3;
    }
    public TripleSwitchedServo(Servo servo1, Servo servo2, double pos1, double pos2, double pos3) {
        this.servo1 = servo1;
        this.servo2 = servo2;
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.pos3 = pos3;
    }

    public void primaryPos() {
        servo1.setPosition(pos1);
        if (servo2 != null) {
            servo2.setDirection(Servo.Direction.REVERSE);
            servo2.setPosition(pos1);
        }
    }

    public void secondaryPos() {
        servo1.setPosition(pos2);
        if (servo2 != null) {
            servo2.setDirection(Servo.Direction.REVERSE);
            servo2.setPosition(pos2);
        }
    }

    public void tertiaryPos() {
        servo1.setPosition(pos3);
        if (servo2 != null) {
            servo2.setDirection(Servo.Direction.REVERSE);
            servo2.setPosition(pos3);
        }
    }

    public void quickSwitch() {
        if (servoSwitch == 0) {
            primaryPos();
            servoSwitch++;
        } else if (servoSwitch == 1) {
            secondaryPos();
            servoSwitch++;
        } else if (servoSwitch == 2) {
            tertiaryPos();
            servoSwitch = 0;
        }

        Movable.time = System.currentTimeMillis();
    }
}
