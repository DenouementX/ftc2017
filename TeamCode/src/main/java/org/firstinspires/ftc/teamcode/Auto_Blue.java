package org.firstinspires.ftc.teamcode;

/* Created by KPSS*/

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class Auto_Blue extends OpMode{
ColorSensor color_sensor;
Servo servo;
    public void init(){
        servo = hardwareMap.servo.get ("servo");
        color_sensor = hardwareMap.colorSensor.get("colosensor");
    }

    public void loop () {
        servo.setPosition(0.5);
        if (color_sensor.alpha() < 20) {
            servo.setPosition(0.7);
            servo.setPosition(0);
        }
        if (color_sensor.alpha() < 20) {
            servo.setPosition(0.4);
            servo.setPosition(0);
        }
    }

}
