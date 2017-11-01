package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
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

    public static double findMax(double[] list){
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

        double POWER = 0.8;
        double listPower[3];

        waitForStart();

        while(opModeIsActive()) {

            listPower[0]= gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x;
            listPower[1]= gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x;
            listPower[2]= gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x;
            listPower[3]= gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x;

            double maxPower = findMax(listPower);

            motorfrontLeft.setPower(POWER * (gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x) / 3 / maxPower);
            motorbackLeft.setPower(POWER * (gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x) / 3 / maxPower);
            motorfrontRight.setPower(POWER * (gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x) / 3 / maxPower);
            motorbackRight.setPower(POWER * (gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x) / 3 / maxPower);

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
