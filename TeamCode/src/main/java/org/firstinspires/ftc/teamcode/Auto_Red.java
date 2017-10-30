package org.firstinspires.ftc.teamcode;

//main
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;

//vuforia portion
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

@Autonomous

enum State {
    INITIALIZE, MOVE, CHECK, STOP
}

public class Auto_Red extends LinearOpMode {

    OpenGLMatrix lastLocation = null;

    VuforiaLocalizer vuforia;

    @Override
    public void runOpMode() {

        Servo jewel;
        ColorSensor color;
        State state;
        DcMotor LF;
        DcMotor LB;
        DcMotor RF;
        DcMotor RB;
        int position = 0;

        state = State.INITIALIZE;

        switch (state){

            case INITIALIZE:

                state = state.MOVE;
                jewel = hardwareMap.servo.get("jewel");
                color = hardwareMap.colorSensor.get("color");
                LF = hardwareMap.dcMotor.get("LF");
                LB = hardwareMap.dcMotor.get("LB");
                RF = hardwareMap.dcMotor.get("RF");
                RB = hardwareMap.dcMotor.get("RB");

                //setting up camera and vuforia
                int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
                VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

                parameters.vuforiaLicenseKey = "AXzW9CD/////AAAAGTPAtr9HRUXZmowtd9p0AUwuXiBVONS/c5x1q8OvjMrQ8/XJGxEp0TP9Kl8PvqSzeXOWIvVa3AeB6MyAQboyW/Pgd/c4a4U/VBs1ouUsVBkEdbaq1iY7RR0cjYr3eLwEt6tmI37Ugbwrd5gmxYvOBQkGqzpbg2U2bVLycc5PkOixu7PqPqaINGZYSlvUzEMAenLOCxZFpsayuCPRbWz6Z9UJfLeAbfAPmmDYoKNXRFll8/jp5Ie7iAhSQgfFggWwyiqMRCFA3GPTsOJS4H1tSiGlMjVzbJnkusPKXfJ0dK3OH9u7ox9ESpi91T0MemXw3nn+/6QRvjGtgFH+wMDuQX7ta89+yW+wqdXX9ZQu8BzY";

                parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
                this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);

                VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
                VuforiaTrackable relicTemplate = relicTrackables.get(0);
                relicTemplate.setName("relicVuMarkTemplate");

                telemetry.addData(">", "Press Play to start");
                telemetry.update();
                waitForStart();

                relicTrackables.activate();

                jewel.setPosition(1.0);

                RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);
                //Params LEFT CENTER RIGHT into integers
                while (vuMark != RelicRecoveryVuMark.LEFT || vuMark != RelicRecoveryVuMark.CENTER || vuMark !=RelicRecoveryVuMark.RIGHT) {
                        telemetry.addData("VuMark", "not visible");
                        telemetry.update();
                }

                telemetry.addData("VuMark", "%s visible", vuMark);
                telemetry.addData("RED: ", color.red());
                telemetry.addData("BLUE: ", color.blue());

                if (vuMark == RelicRecoveryVuMark.LEFT) {
                    position = 1;
                }
                if (vuMark == RelicRecoveryVuMark.CENTER) {
                    position = 2;
                }
                if (vuMark == RelicRecoveryVuMark.RIGHT) {
                    position = 3;
                }
                telemetry.addData("Pos: ", position);

                break;

            case MOVE:
                //state = state.CHECK;
                break;
            case CHECK:
                //if (this.getTime() > 1000) state = state.STOP;
                break;
            case STOP:
                //this.StopDrive();
                break;
        }
    }
}