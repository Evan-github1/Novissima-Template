package org.firstinspires.ftc.teamcode;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import com.qualcomm.hardware.dfrobot.HuskyLens;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

// TODO: methods that make it easier to get the config name from the DriverStation. Implement the interface in a class.
   /*
   Example: You no longer have to do- "FLW = hardwareMap.get(DcMotor.class, "FLW");"
   You can just do- "config(FLW, "FLW");"
   */

// RAHH INTERFACESSS
public interface QuickConfig {
    default void config(Servo servo, String deviceName) {
        servo = hardwareMap.get(Servo.class, deviceName);
    }
    default void config(DcMotor motor, String deviceName) {
        motor = hardwareMap.get(DcMotor.class, deviceName);
    }
    default void config(HuskyLens camera, String deviceName) {
        camera = hardwareMap.get(HuskyLens.class, deviceName);
    }
    default void config(ColorSensor color_sensor, String deviceName) {
        color_sensor = hardwareMap.get(ColorSensor.class, deviceName);
    }
}
