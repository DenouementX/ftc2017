package org.firstinspires.ftc.teamcode;

/* Created by KPSS*/

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class Auto_Blue extends OpMode{

ColorSensor color_sensor;
Servo servo;

    DcMotor front_left;
    /*
    DcMotor front_right;
    DcMotor back_left;
    DcMotor back_right;
    */
    public void init(){
        servo = hardwareMap.servo.get ("servo");
        color_sensor = hardwareMap.colorSensor.get("colosensor");
        front_left = hardwareMap.dcMotor.get ("front_left");
        /*
        front_right = hardwareMap.dcMotor.get ("front_right");
        back_left = hardwareMap.dcMotor.get ("back_left");
        back_right = hardwareMap.dcMotor.get ("back_right");
        */
    }

    public void loop () {
        servo.setPosition(0.5);
        if (color_sensor.blue()) {
            front_left.setPower(1);
            /*
            front_right.setPower(1);
            back_left.setPower(1);
            back_left.setPower(1);
            */
        }
        if (color_sensor.alpha() => 750) {
            front_left.setPower(-1);
            /*
            front_right.setPower(-1);
            back_left.setPower(-1);
            back_left.setPower(-1);
            */
        }
        else (color_sensor.alpha() <= 470) {
            servo.setPosition(0);
            /*
            front_left.setPower(0);
            front_right.setPower(0);
            back_left.setPower(0);
            back_left.setPower(0);
            */
        }
    }

}
