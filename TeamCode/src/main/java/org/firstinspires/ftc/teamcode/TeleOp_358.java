package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import static java.lang.Math.*;

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

    //This function finds the magnitude of the left stick of a gamepad.
    public Double magnitudeLeftStick(Gamepad gamepad){
        return sqrt(pow(gamepad.left_stick_x, 2) + pow(gamepad.left_stick_y, 2));
    }

    //This function finds the max value given 4 values.
    public Double findMax(Double d1, Double d2, Double d3, Double d4){
        return max(max(d1, d2), max(d3, d4));
    }

    public void runOpMode() throws InterruptedException{

        fL = hardwareMap.dcMotor.get("frontLeft");    //EH2 - 1
        bL = hardwareMap.dcMotor.get("backLeft");     //EH2 - 2
        fR = hardwareMap.dcMotor.get("frontRight");   //EH2 - 0
        bR = hardwareMap.dcMotor.get("backRight");    //EH2 - 3
        lS = hardwareMap.dcMotor.get("linearSlide");  //EH5 - 0
        left = hardwareMap.servo.get("left");         //EH2 - 0
        right = hardwareMap.servo.get("right");       //EH2 - 1
        arm = hardwareMap.servo.get("arm");           //EH5 - 0
        color = hardwareMap.colorSensor.get("color"); //EH5 - 0
        retract = hardwareMap.dcMotor.get("retract"); //EH5 - 1
        release = hardwareMap.dcMotor.get("release"); //EH5 - 2

        fL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        fL.setDirection(DcMotor.Direction.REVERSE);
        left.setDirection(Servo.Direction.REVERSE);
        bL.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while(opModeIsActive()) {
            //auto-servo is held in place
            arm.setPosition(.95);


            //Defining drive, strafe, and rotation power.
            double drive = gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double rotate = gamepad1.right_stick_x;

            //Defining the motor power distribution.
            double flPower = drive - strafe - rotate;
            double blPower = drive + strafe - rotate;
            double frPower = drive + strafe + rotate;
            double brPower = drive - strafe + rotate;

            //Defining the joystick magnitude and maximum power.
            //double POWER = -1 * pow(Range.clip(max(magnitudeLeftStick(gamepad1), abs(rotate)), -1, 1), 3) / (0.5 * pow(gamepad1.right_trigger, 2) + 1);
            double joyStick = Range.clip(max(magnitudeLeftStick(gamepad1), abs(rotate)), -1, 1);
            double POWER = -1 * joyStick * abs(joyStick);
            telemetry.addData("POWER: ", POWER);
            double maxPower = findMax(abs(flPower), abs(blPower), abs(frPower), abs(brPower)); // greatest value of all motor powers
            telemetry.addData("maxPower: ", maxPower);
            telemetry.update();

            //Sets the power for all the drive motors.
            fL.setPower(POWER * flPower / maxPower);
            bL.setPower(POWER * blPower / maxPower);
            fR.setPower(POWER * frPower / maxPower);
            bR.setPower(POWER * brPower / maxPower);


            //Controls rack and pinion
            //lS ... lift system motor speed
            lS.setPower(0);

            if(gamepad2.right_bumper){
                lS.setPower(-0.5);
            }

            if(gamepad2.left_bumper){
                lS.setPower(0.5);
            }

            //Controls UltraLord servos
            if(gamepad2.a){
                left.setPosition(1);
                right.setPosition(1);
            }

            if(!gamepad2.a){
                left.setPosition(0);
                right.setPosition(0);
            }

            // default to zero, unless button pressed
            release.setPower(0);
            retract.setPower(0);

            //Controls motors for Linear Slides
            if(gamepad2.dpad_up){
                release.setPower(-0.6);
                retract.setPower(-0.2);
            }

            if(gamepad2.dpad_down){
                retract.setPower(0.4);
                release.setPower(0.3);
            }

        }
    }
}