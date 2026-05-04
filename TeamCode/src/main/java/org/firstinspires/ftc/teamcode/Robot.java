package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Subsystems.Intake;
import org.firstinspires.ftc.teamcode.Subsystems.LinearSlide;

// hi, I'm a 'robot.'
// hi 'robot,' I'm 'a.'
public class Robot {
    public LinearSlide l;
    public Intake i;

    public Robot(HardwareMap h) {
        l = new LinearSlide(h);
        i = new Intake(h);
    }

}
