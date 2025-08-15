package org.firstinspires.ftc.teamcode.components;

import static com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.BRAKE;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

public class Component {
    Component(){

    }
    Component(HardwareMap hardwareMap){

    }
    public DcMotorEx setUpEncoderMotor(
            HardwareMap hardwareMap,
            String identifier, DcMotor.Direction direction,
            double pidf_p, double pidf_i, double pidf_d, double pidf_f) {
        return setUpEncoderMotor(hardwareMap, identifier, direction, pidf_p, pidf_i, pidf_d, pidf_f, true);
    }

    @SuppressWarnings("SameParameterValue")
    public DcMotorEx setUpEncoderMotor(
            HardwareMap hardwareMap,
            String identifier, DcMotor.Direction direction,
            double pidf_p, double pidf_i, double pidf_d, double pidf_f, boolean withEncoder) {
        DcMotorEx drive = hardwareMap.get(DcMotorEx.class, identifier);
        drive.setDirection(direction);
        drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        drive.setZeroPowerBehavior(BRAKE);
        drive.setPower(0);
        // we might want to make the default RUN_TO_POSITION.  RUN_TO_POSITION
        // targets a specific final position of the motor based on its internal
        // encoders.  RUN_USING_ENCODER targets a specific velocity using the
        // encoders.
        if (!withEncoder) {
            drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        } else {
            drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            //default behavior for wheels is brake but this one is float NOT REALLY PRACTICAL
            //drive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            PIDFCoefficients drivePidf = new PIDFCoefficients(pidf_p, pidf_i, pidf_d, pidf_f);
            drive.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, drivePidf);
        }
        return drive;
    }
}
