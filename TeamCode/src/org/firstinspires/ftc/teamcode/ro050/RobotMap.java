package org.firstinspires.ftc.teamcode.ro050;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RobotMap {

    public DcMotor stangaFata;
    public DcMotor dreaptaFata;
    public DcMotor stangaSpate;
    public DcMotor dreaptaSpate;
    public BNO055IMU imu;

    public RobotMap(HardwareMap hardwareMap) {
        stangaFata = hardwareMap.get(DcMotor.class, "stangaFata");
        dreaptaFata = hardwareMap.get(DcMotor.class, "dreaptaFata");
        stangaSpate = hardwareMap.get(DcMotor.class, "stangaSpate");
        dreaptaSpate = hardwareMap.get(DcMotor.class, "dreaptaSpate");

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();

//        parameters.mode                = BNO055IMU.SensorMode.IMU;
        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.loggingEnabled      = false;


        imu = hardwareMap.get(BNO055IMU.class, "imu");

        imu.initialize(parameters);

    }

    public void stopDriving() {
        stangaFata.setPower(0);
        stangaSpate.setPower(0);
        dreaptaFata.setPower(0);
        dreaptaSpate.setPower(0);
    }

}
