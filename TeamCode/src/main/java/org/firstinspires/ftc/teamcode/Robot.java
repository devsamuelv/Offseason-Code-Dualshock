package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.sony.SonyGamepadPS4;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.Subsystems.DriveSystem;

public class Robot extends OpMode {
    public DriveSystem drive;
    public SonyGamepadPS4 gamepadPS4 = new SonyGamepadPS4();

    @Override
    public void init() {
        drive = new DriveSystem(hardwareMap);
    }

    @Override
    public void loop() {


        if( gamepadPS4.left_stick_y > .1  ||
                gamepadPS4.left_stick_y < -.1 ||
                gamepadPS4.left_stick_x > .1  ||
                gamepadPS4.left_stick_x < -.1 ||
                gamepadPS4.right_stick_x > .1 ||
                gamepadPS4.right_stick_x < -.1) {

            drive.BaseDrive(-gamepadPS4.left_stick_x, -gamepadPS4.left_stick_y, gamepadPS4.right_stick_x);
        } else {
            drive.Stop();
        }
    }
}
