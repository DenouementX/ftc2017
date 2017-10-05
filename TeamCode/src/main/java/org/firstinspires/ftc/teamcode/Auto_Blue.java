package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by lawrencemao on 10/5/17.
 */

@TeleOp
public class Auto_Blue extends OpMode{

    Servo left;

    public void init(){
        left = hardwareMap.servo.get("left");
    }

    public void loop(){
        if (gamepad1.a) {
            left.setPosition(1);
        }
        else{
            left.setPosition(0);
        }
    }

}