package org.firstinspires.ftc.teamcode;

public enum Function {
    MOVE_WHEELS(false),
    ARM_LIFT(false),
    CLAW_GRIP(false);

    boolean activated = false;
    Function(boolean activated) {
        this.activated = activated;
    }
}
