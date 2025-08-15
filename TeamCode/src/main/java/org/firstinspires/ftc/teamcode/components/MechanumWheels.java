package org.firstinspires.ftc.teamcode.components;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MechanumWheels extends Component{
    DcMotorEx driveFrontLeft;
    DcMotorEx driveFrontRight;
    DcMotorEx driveRearLeft;
    DcMotorEx driveRearRight;
    public MechanumWheels(HardwareMap hardwareMap){
        driveFrontLeft = setUpEncoderMotor(hardwareMap, "fl", DcMotorEx.Direction.FORWARD, 12, 10, 0.0, 5.0);
        driveFrontRight = setUpEncoderMotor(hardwareMap, "fr", DcMotorEx.Direction.FORWARD, 12, 10, 0.0, 5.0);
        driveRearLeft = setUpEncoderMotor(hardwareMap, "rl", DcMotorEx.Direction.REVERSE, 12, 10, 0.0, 5.0);
        driveRearRight = setUpEncoderMotor(hardwareMap, "rr", DcMotorEx.Direction.REVERSE, 12, 10, 0.0, 5.0);

    }
}
