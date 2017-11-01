package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


/**
 * Created by KPSS on 30.10.17.
 */
@TeleOp

public class Ultra_Test extends OpMode{

    DcMotor lifting;
    Servo rightservo;
    Servo leftservo;
    public void init(){
        lifting = hardwareMap.dcMotor.get("frontLeft");
        rightservo = hardwareMap.servo.get("rightservo");
        leftservo = hardwareMap.servo.get("leftservo");
    }
    public void loop(){
        lifting.setPower(gamepad1.left_stick_y);
        rightservo.setPosition(0.5);
        leftservo.setPosition(0.5);
    }
}
