package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by lawrencemao on 12/5/17.
 */

@TeleOp
public class lmao extends OpMode{

    Servo left;
    Servo right;

    public void init(){
        left = hardwareMap.servo.get("left");
        right = hardwareMap.servo.get("right");

        left.setDirection(Servo.Direction.REVERSE);
    }

    public void loop() {

        if (!gamepad1.a) {
            left.setPosition(0);
            right.setPosition(0);
        }
        else if (gamepad1.a){
            left.setPosition(1);
            right.setPosition(1);
        }

    }

}
