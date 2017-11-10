package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by artembookpro on 08.11.17.
 */
@Autonomous
public class KPSS_Parking extends OpMode {
    DcMotor LF;
    DcMotor LB;
    DcMotor RF;
    DcMotor RB;
    /*
    int distance = 1;
    int diameter = 1;
    int ticks = 360*distance/diameter*3.14

    */

    public void init() {
        LF = hardwareMap.dcMotor.get("LF");
        LB = hardwareMap.dcMotor.get("LB");
        RF = hardwareMap.dcMotor.get("RF");
        RB = hardwareMap.dcMotor.get("RB");
    }
    @Override
    public void loop() {
        LF.setTargetPosition(14400);
        LB.setTargetPosition(14400);
        RF.setTargetPosition(14400);
        RB.setTargetPosition(14400);
    }
}
}
