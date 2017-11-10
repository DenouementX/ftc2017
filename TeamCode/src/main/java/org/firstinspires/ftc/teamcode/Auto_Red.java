package org.firstinspires.ftc.teamcode;

/**
 *  This current autonomous will simply knock off the jewel (30 points)
 *  and park in the safe zone (10 points)
 */

//main
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous

public class Auto_Red extends LinearOpMode {

    Servo jewel;
    ColorSensor color;
    DcMotor LF;
    DcMotor LB;
    DcMotor RF;
    DcMotor RB;
    double dPosition = 0.55;
    double oPosition = 0.05;

    public void runOpMode() throws InterruptedException {
        jewel = hardwareMap.servo.get("jewel");         //0 5
        color = hardwareMap.colorSensor.get("color");   //0 5 (I2C)
        LF = hardwareMap.dcMotor.get("LF");             //1 2
        LB = hardwareMap.dcMotor.get("LB");             //2 2
        RF = hardwareMap.dcMotor.get("RF");             //0 2
        RB = hardwareMap.dcMotor.get("RB");             //3 2

        LF.setDirection(DcMotor.Direction.REVERSE);
        LB.setDirection(DcMotor.Direction.REVERSE);

        double POWER = .5;

        waitForStart();

        while (opModeIsActive()) {

            jewel.setPosition(dPosition);

            if (color.blue()/2 > color.red()) {
                jewel.setPosition(oPosition);
                LF.setPower(POWER);
                LB.setPower(POWER);
                RF.setPower(POWER);
                RB.setPower(POWER);
                sleep(1000);
                jewel.setPosition(dPosition);
            }

            if (color.blue() < color.red()/2) {
                jewel.setPosition(oPosition);
                LF.setPower(-POWER);
                LB.setPower(-POWER);
                RF.setPower(-POWER);
                RB.setPower(-POWER);
                sleep(1000);
                jewel.setPosition(dPosition);
            }

            else{
                LF.setPower(0);
                LB.setPower(0);
                RF.setPower(0);
                RB.setPower(0);
            }

        }
    }
}