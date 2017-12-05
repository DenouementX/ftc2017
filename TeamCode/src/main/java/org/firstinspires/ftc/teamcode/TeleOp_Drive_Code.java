package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by kevinwang on 12/5/17.
 */

public class TeleOp_Drive_Code{

    static void TeleOpDriveCode(Gamepad gamePad, DcMotor frontLeft){
        frontLeft.setPower(gamePad.left_stick_y);
    }

}