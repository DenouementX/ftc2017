package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;
import com.sun.tools.javac.code.Attribute;

/**
 * Created by kevinwang on 10/27/17.
 */

@TeleOp(name = "TeleOp Test")

public class TeleOp_Test extends LinearOpMode{

    DcMotor motorfrontLeft;
    DcMotor motorbackLeft;
    DcMotor motorfrontRight;
    DcMotor motorbackRight;

    private double findMax(double[] list){
        double max = list[0];
        for (int count = 0; count < list.length; count++){
            if (list[count] > max){
                max = list[count];
            }
        }
        return max;
    }

    public void runOpMode() throws InterruptedException{

        motorfrontLeft = hardwareMap.dcMotor.get("frontLeft");
        motorbackLeft = hardwareMap.dcMotor.get("backLeft");
        motorfrontRight = hardwareMap.dcMotor.get("frontRight");
        motorbackRight = hardwareMap.dcMotor.get("backRight");

        motorfrontLeft.setDirection(DcMotor.Direction.REVERSE);
        //motorbackLeft.setDirection(DcMotor.Direction.REVERSE);

        double POWER = Range.clip(Math.max(Math.sqrt(Math.pow(gamepad1.left_stick_x, 2) + Math.pow(gamepad1.left_stick_y, 2)), Math.abs(gamepad1.right_stick_x)), -1, 1);
        double[] listPower = new double[4];

        waitForStart();

        while(opModeIsActive()) {

            listPower[0]= Math.abs(gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x);
            listPower[1]= Math.abs(gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x);
            listPower[2]= Math.abs(gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x);
            listPower[3]= Math.abs(gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x);

            double maxPower = findMax(listPower);

            motorfrontLeft.setPower(POWER * (gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x) / maxPower);
            motorbackLeft.setPower(POWER * (gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x) / maxPower);
            motorfrontRight.setPower(POWER * (gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x) / maxPower);
            motorbackRight.setPower(POWER * (gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x) / maxPower);

            if(gamepad1.left_bumper){

                POWER = POWER + 0.05;

                if(POWER > 1){

                    POWER = 1;
                }
            }

            if(gamepad1.right_bumper){

                POWER = POWER - 0.05;

                if(POWER < 0){

                    POWER = 0;

                }
            }

            telemetry.addData("POWER: ", POWER);
            telemetry.addData("maxPower: ", maxPower);

        }
    }
}
