package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.HardwareDevice;

/**
 * Created by artembookpro on 03.10.17.
 */

@TeleOp
public class KPSS_Superviser extends OpMode{

    ColorSensor color_sensor;

    DcMotor right;
    public void init()
    {
        right = hardwareMap.dcMotor.get ("right");

        color_sensor = hardwareMap.colorSensor.get ("color");

    }
    public void loop(){
        telemetry.addData("Color_Sensor: ", color_sensor.alpha());

        if (color_sensor.alpha() > 400) {
            right.setPower(1);
        }
        right.setPower(0);

    }
}