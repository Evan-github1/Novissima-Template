package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class LinearSlide {
    private DcMotor slideMotor;

    public LinearSlide(HardwareMap h) {
        slideMotor = h.get(DcMotor.class, "slideMotor");
        slideMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void ascend(double power) {
        slideMotor.setPower(power);
    }
    public void descend(double power) {
        slideMotor.setPower(-power);
    }
    public void stop() {
        slideMotor.setPower(0);
    }
}
