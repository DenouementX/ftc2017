package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by lawrencemao on 12/5/17.
 * Program for testing a new glyph mechanism
 */

@TeleOp
public class lmao extends OpMode{

    Servo left;
    Servo right;
    DcMotor l;
    DcMotor r;
    DcMotor lS;

    public void init(){
        left = hardwareMap.servo.get("left");
        right = hardwareMap.servo.get("right");
        l = hardwareMap.dcMotor.get("l");
        r = hardwareMap.dcMotor.get("r");
        lS = hardwareMap.dcMotor.get("lS");

        l.setDirection(DcMotor.Direction.REVERSE);
        left.setDirection(Servo.Direction.REVERSE);
    }

    public void loop() {

        l.setPower(gamepad1.left_stick_y);
        r.setPower(gamepad1.right_stick_y);
        lS.setPower(0);

        if (gamepad1.dpad_up){
            lS.setPower(-0.3);
        }

        if (gamepad1.dpad_down){
            lS.setPower(0.3);
        }

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