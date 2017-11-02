package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by lawrencemao on 10/31/17.
 */

@TeleOp
public class ultraLord_test extends OpMode{
    DcMotor lift;
    Servo rServo;
    Servo lServo;
    double lPos = 1;
    double rPos = 1;

    public void init(){
        lift = hardwareMap.dcMotor.get("lift");
        lServo = hardwareMap.servo.get("lS");
        rServo = hardwareMap.servo.get("rS");
    }

    public void loop(){
        lift.setPower(gamepad1.left_stick_y);
        lServo.setPosition(lPos);
        rServo.setPosition(rPos);
        telemetry.addData("Left Servo: ", lPos);
        telemetry.addData("Right Servo: ", rPos);
    }
}