package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Hardware {
    public DcMotor dc_base_back_right, dc_base_back_left, dc_base_front_right, dc_base_front_left;

    public DcMotor.RunMode TowerRunMode = DcMotor.RunMode.STOP_AND_RESET_ENCODER;
    public DcMotor.RunMode BaseRunMode = DcMotor.RunMode.RUN_WITHOUT_ENCODER;
    public DcMotor.ZeroPowerBehavior ZeroRunMode = DcMotor.ZeroPowerBehavior.BRAKE;

    private DcMotorSimple.Direction ForwardDir = DcMotorSimple.Direction.FORWARD;
    private DcMotorSimple.Direction BackwardsDir = DcMotorSimple.Direction.REVERSE;
    public HardwareMap hwMap;

    public Hardware(HardwareMap hmap) {
        hwMap = hmap;
    }

    public void Init() {
        dc_base_front_right = hwMap.get(DcMotor.class, "motor_base_right_front");
        dc_base_front_left = hwMap.get(DcMotor.class, "motor_base_left_front");
        dc_base_back_left = hwMap.get(DcMotor.class, "motor_base_back_left");
        dc_base_back_right = hwMap.get(DcMotor.class, "motor_base_back_right");

        dc_base_back_right.setMode(BaseRunMode);
        dc_base_back_left.setMode(BaseRunMode);
        dc_base_front_left.setMode(BaseRunMode);
        dc_base_front_right.setMode(BaseRunMode);

        dc_base_back_right.setZeroPowerBehavior(ZeroRunMode);
        dc_base_back_left.setZeroPowerBehavior(ZeroRunMode);
        dc_base_front_left.setZeroPowerBehavior(ZeroRunMode);
        dc_base_front_right.setZeroPowerBehavior(ZeroRunMode);

        dc_base_back_left.setDirection(BackwardsDir);
        dc_base_back_right.setDirection(BackwardsDir);
    }
}
