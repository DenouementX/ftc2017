package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by lawrencemao on 11/7/17.
 */

@TeleOp

public class TeleOp_358 extends LinearOpMode {

    DcMotor fL;
    DcMotor bL;
    DcMotor fR;
    DcMotor bR;
    DcMotor lS;
    DcMotor retract;
    DcMotor release;
    Servo left;
    Servo right;
    Servo arm;
    ColorSensor color;

    public Double magnitudeLeftStick(Gamepad gamepad){
        return Math.sqrt(Math.pow(gamepad.left_stick_x, 2) + Math.pow(gamepad.left_stick_y, 2));
    }

    public void runOpMode() throws InterruptedException{

        fL = hardwareMap.dcMotor.get("frontLeft");    //EH2 - 1
        bL = hardwareMap.dcMotor.get("backLeft");     //EH2 - 2
        fR = hardwareMap.dcMotor.get("frontRight");   //EH2 - 0
        bR = hardwareMap.dcMotor.get("backRight");    //EH2 - 3
        lS = hardwareMap.dcMotor.get("linearSlide");  //EH5 - 0
        left = hardwareMap.servo.get("left");         //EH2 - ???
        right = hardwareMap.servo.get("right");       //EH2 - ???
        arm = hardwareMap.servo.get("arm");           //EH5 - 0
        color = hardwareMap.colorSensor.get("color"); //EH5 - 0
        retract = hardwareMap.dcMotor.get("retract"); //EH5 - 1
        release = hardwareMap.dcMotor.get("release"); //EH5 - 2

        fL.setDirection(DcMotor.Direction.REVERSE);
        left.setDirection(Servo.Direction.REVERSE);
        bL.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while(opModeIsActive()) {
            //auto-servo is held in place
            arm.setPosition(.95);

            double POWER = -1 * Range.clip(Math.max(Range.clip(magnitudeLeftStick(gamepad1), -1, 1), Math.abs(gamepad1.right_stick_x)), -1, 1);
            double maxPower = Math.max(Math.max(Math.abs(gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x),
                    Math.abs(gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x)),
                    Math.max(Math.abs(gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x),
                            Math.abs(gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x)));

            fL.setPower(POWER * (gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x) / maxPower);
            bL.setPower(POWER * (gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x) / maxPower);
            fR.setPower(POWER * (gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x) / maxPower);
            bR.setPower(POWER * (gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x) / maxPower);

            lS.setPower(0);
            release.setPower(0);
            retract.setPower(0);

            if(gamepad2.right_bumper){
                lS.setPower(0.5);
            }

            if(gamepad2.left_bumper){
                lS.setPower(-0.5);
            }

            if(gamepad2.a){
                left.setPosition(1);
                right.setPosition(1);
            }

            if(!gamepad2.a){
                left.setPosition(0);
                right.setPosition(0);
            }

            if(gamepad2.dpad_up){
                release.setPower(-0.6);
                retract.setPower(-0.2);
                // also turn retract motor
            }

            if(gamepad2.dpad_down){
                retract.setPower(0.4);
                release.setPower(0.3);
                // also turn release motor
            }

        }
    }
}