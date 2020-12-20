package org.firstinspires.ftc.teamcode.ro050;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Basic TeleOP")
public class BasicTeleOP extends LinearOpMode {
    RobotMap robot = null;

    @Override
    public void runOpMode() throws InterruptedException {
        robot = new RobotMap(hardwareMap);

        waitForStart();
        while(opModeIsActive()) {
            robot.stangaFata.setPower(gamepad1.left_stick_y);
            robot.stangaSpate.setPower(gamepad1.left_stick_y);
            robot.dreaptaFata.setPower(-gamepad1.left_stick_y);
            robot.dreaptaSpate.setPower(-gamepad1.left_stick_y);

            telemetry.addData("Imu angle: ", robot.imu.getAngularOrientation());
            telemetry.update();
        }
    }
}
