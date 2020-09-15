package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveSystem {
    public Hardware hwmap;

    public DriveSystem(HardwareMap hmap) {
        hwmap = new Hardware(hmap);

        hwmap.Init();
    }

    public void BaseDrive(double leftx, double lefty, double rightx) {
        double r = Math.hypot(leftx, lefty);
        double robotAngle = Math.atan2(leftx, lefty) - Math.PI / 4;
        double localRightX = rightx;

        double v1 = r * Math.cos(robotAngle) + localRightX;
        double v2 = r * Math.sin(robotAngle) - localRightX;
        double v3 = r * Math.sin(robotAngle) + localRightX;
        double v4 = r * Math.cos(robotAngle) - localRightX;

        if(leftx > .1 || leftx < -.1) {
            v1 -= v1 / 7;
            v3 -= v3 / 7;
        }

        drive_by_command(false,-v1,-v2,-v3,-v4);
    }

    public void drive_by_command(boolean strafe, double rightF,double rightB, double leftF,double leftB)
    {
        // Define Commands
        if(strafe)
        {
            hwmap.dc_base_front_right.setPower(-rightF);
            hwmap.dc_base_back_right.setPower(rightB);
            hwmap.dc_base_front_left.setPower(leftF);
            hwmap.dc_base_back_left.setPower(-leftB);
        }
        else {
            hwmap.dc_base_front_right.setPower(rightF);
            hwmap.dc_base_back_right.setPower(rightB);
            hwmap.dc_base_front_left.setPower(leftF);
            hwmap.dc_base_back_left.setPower(leftB);
        }
    }
    // Method for Stopping the Drive Train
    public void Stop() {
        // Define Commands
        hwmap.dc_base_front_right.setPower(0);
        hwmap.dc_base_back_right.setPower(0);
        hwmap.dc_base_front_left.setPower(0);
        hwmap.dc_base_back_left.setPower(0);
    }
}
