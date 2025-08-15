package org.firstinspires.ftc.teamcode.tele_code;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.components.Component;
import org.firstinspires.ftc.teamcode.components.MechanumWheels;

import java.util.ArrayList;

@TeleOp(name = "teleop")
public class Teleop extends OpMode {
    ArrayList<Component> components = new ArrayList<>();

    @Override
    public void init() {
        components.add(new MechanumWheels(hardwareMap));
    }

    public void loop() {

    }
}