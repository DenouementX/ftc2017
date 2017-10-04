package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.HardwareDevice;

/**
 * Created by artembookpro on 03.10.17.
 */


public class KPSS_Superviser extends OpMode{

    ColorSensor color_sensor;

    DcMotor right;
    public void init()
    {
        right = hardwareMap.dcMotor.get ("right");

        color_sensor = hardwareMap.colorSensor.get ("color");

    }
    public void loop(){
        while (color_sensor.alpha() < 20) {
            float right_power = -gamepad1.right_stick_y;

            right_power = Range.clip(right_power, -1, 1);

            right.setPower(right_power);
        }
    }
}