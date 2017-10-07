package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by lawrencemao on 10/5/17.
 */

/*
What this autonomous program will do...
    Jewels - *Keep in mind, robot starts on balancing stone* When autonomous starts,
    servo will turn 90 degrees counterclockwise (up to down). There will be a color sensor attached
    to the end of the servo arm to detect the correct ball at close range. The robot will then
    turn 90 degrees clockwise or counterclockwise. This program assumes the robot will start at
    the right side of the field when facing the drivers. Hence, if it turns counterclockwise, it
    won't have to reposition. If it turns clockwise, then turn 180 degrees to reset.
    to knock off the enemy colored jewel.

    Glyphs - Right when starting, run Vuforia and allow phone to decode left, right, or middle.
    Then run Jewel code and then after Jewel code is run, move foward (Assume the glyph is loaded
    in the correct position) with a delay corresponding to the decoded info. Then turn 90 degrees
    clockwise and put glyph into cryptobox. *Note, later in the season, we may want to put sensors
    on the bottom of the robot to help align it with the cryptobox*

    Parking - For now, a timed return seems like the best option. However, later, we may want to
    use a gyro or some form of PID.
 */

public class Auto_Red extends OpMode{

    Servo left;

    public void init(){
        left = hardwareMap.servo.get("left");
    }

    public void loop(){
        if (gamepad1.a) {
            left.setPosition(1);
        }
        else{
            left.setPosition(0);
        }
    }
}
