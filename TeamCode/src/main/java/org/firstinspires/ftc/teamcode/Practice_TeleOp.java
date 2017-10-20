package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by kevinwang on 10/20/17.
 */

@TeleOp(name = "Practice_TeleOp")

public class Practice_TeleOp extends LinearOpMode{

    DcMotor motorLeftFront = null;
    DcMotor motorLeftBack = null;
    DcMotor motorRightFront = null;
    DcMotor motorRightBack = null;

    public void runOpMode() throws InterruptedException{
        motorLeftFront = hardwareMap.dcMotor.get("frontLeft");
        motorLeftBack = hardwareMap.dcMotor.get("backLeft");
        motorRightFront = hardwareMap.dcMotor.get("frontRight");
        motorRightBack = hardwareMap.dcMotor.get("backRight");

        motorLeftFront.setDirection(DcMotor.Direction.REVERSE);
        //motorLeftBack.setDirection(DcMotor.Direction.REVERSE);

        double POWER = .5;

        waitForStart();

        while(opModeIsActive()){

            motorLeftBack.setPower(gamepad1.left_stick_y);
            motorLeftFront.setPower(gamepad1.left_stick_y);
            motorRightBack.setPower(gamepad1.right_stick_y);
            motorRightFront.setPower(gamepad1.right_stick_y);

            idle();
        }
    }
}
