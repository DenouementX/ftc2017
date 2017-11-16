package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by kevinwang on 11/15/17.
 */

@TeleOp

public class TeleOp_Drive_Code extends LinearOpMode{

    //Declaring all the motors, servos, and sensors.
    DcMotor fL;
    DcMotor bL;
    DcMotor fR;
    DcMotor bR;
    DcMotor lS;
    Servo left;
    Servo right;
    Servo arm;
    ColorSensor color;

    //This function finds the magnitude of the left stick of a gamepad.
    public Double magnitudeLeftStick(Gamepad gamepad){
        return Math.sqrt(Math.pow(gamepad.left_stick_x, 2) + Math.pow(gamepad.left_stick_y, 2));
    }

    //Run OpMode code.
    public void runOpMode() throws InterruptedException{

        //Defining where to find the motors, servos, and sensors.
        fL = hardwareMap.dcMotor.get("frontLeft");
        bL = hardwareMap.dcMotor.get("backLeft");
        fR = hardwareMap.dcMotor.get("frontRight");
        bR = hardwareMap.dcMotor.get("backRight");
        lS = hardwareMap.dcMotor.get("linearSlide");
        left = hardwareMap.servo.get("left");
        right = hardwareMap.servo.get("right");
        arm = hardwareMap.servo.get("arm");
        color = hardwareMap.colorSensor.get("color");

        //Defining the directions of the motors and servos.
        fL.setDirection(DcMotorSimple.Direction.REVERSE);
        bL.setDirection(DcMotorSimple.Direction.REVERSE);
        left.setDirection(Servo.Direction.REVERSE);

        waitForStart();

        //TeleOp process.
        while (opModeIsActive()){

            //Auto-servo is held in place.
            arm.setPosition(.95);

            double POWER = -1 * Range.clip(Math.max(Range.clip(magnitudeLeftStick(gamepad1), -1, 1), Math.abs(gamepad1.right_stick_x)), -1, 1);
        }
    }
}
