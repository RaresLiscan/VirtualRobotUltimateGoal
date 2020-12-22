package org.firstinspires.ftc.teamcode.cyberpunk;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.ftc16072.MecanumDrive;

@TeleOp(name = "CyberPunk Teleop", group = "cyberpunk")
public class TeleOP extends OpMode {
    private MecanumDrive mecanumDrive = new MecanumDrive();
    private double[] distances;

    // Code to run ONCE when the driver hits INIT
    @Override
    public void init() {
        mecanumDrive.init(hardwareMap);
    }

    // Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
    @Override
    public void loop() {
        double forward = gamepad1.left_stick_y * -1; //The y direction on the gamepad is reversed idk why
        double rotate = gamepad1.right_stick_x;

        mecanumDrive.frontLeft.setPower(forward + rotate);
        mecanumDrive.frontRight.setPower(forward - rotate);
        mecanumDrive.backLeft.setPower(forward + rotate);
        mecanumDrive.backRight.setPower(forward - rotate);
        distances = mecanumDrive.getDistanceCm();
        telemetry.addData("distance fwd", distances[0]);
        telemetry.addData("distance right", distances[1]);

    }
}
