package org.firstinspires.ftc.teamcode;

/**
 * Created by lawrencemao on 9/28/17.
 */
                    import com.qualcomm.robotcore.eventloop.opmode.OpMode;
                    import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
                    import com.qualcomm.robotcore.hardware.DcMotor;
                    import com.qualcomm.robotcore.hardware.DcMotorSimple;
                    import com.qualcomm.robotcore.util.Range;

@TeleOp
public class KPSS extends OpMode{
    DcMotor right;
    DcMotor left;
    DcMotor left1;
    DcMotor right1;
    public void init() {
        right = hardwareMap.dcMotor.get ("right");
        left = hardwareMap.dcMotor.get ("left");
        right1 = hardwareMap.dcMotor.get ("right1");
        left1 = hardwareMap.dcMotor.get ("left1");

    }
    public void loop ()
    {
        float left_power = gamepad1.left_stick_y;
        float left1_power = gamepad1.left_stick_x;
        float right_power = gamepad1.right_stick_y;
        float right1_power = gamepad1.right_stick_x;

        left.setPower(left_power);
        left1.setPower(left1_power);
        right.setPower(right_power);
        right1.setPower(right1_power);
    }
}