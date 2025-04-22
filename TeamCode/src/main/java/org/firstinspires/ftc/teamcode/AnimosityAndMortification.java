package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class AnimosityAndMortification extends Movable {

    @Override
    public void runOpMode() throws InterruptedException {
        super.runOpMode();
        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.update();

            // game loop
            moveWheels(gamepad1.left_stick_x, gamepad1.left_stick_y);

            if (gamepad1.a) {

            }
        }
    }


    public void updatePhoneConsole() {
        telemetry.update();
    }
}