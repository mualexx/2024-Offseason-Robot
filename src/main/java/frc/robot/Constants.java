package frc.robot;

import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;

public class Constants {
    public static final class RobotConstants {
        public static final int kCAN_TIMEOUT = 5000; // ms
    }

    public static final class TankDriveConstants {
        public static final SupplyCurrentLimitConfiguration kDRIVE_CURRENT_LIMIT = 
            new SupplyCurrentLimitConfiguration(true, 40, 50, 1.0);

        public static final double kDEFAULT_MAX_SPEED = 0.5; // Percent
        public static final double kHIGH_MAX_SPEED = 0.75;
    }
    public static final class HardwareConstants {
        public static final int kPDH_CAN = 7;

        public static final int kLEFT_L_DRIVE_CAN = 3; // 5
        public static final int kLEFT_R_DRIVE_CAN = 1; // 6
        public static final int kLEFT_C_DRIVE_CAN = 2; // 4
        public static final int kRIGHT_R_DRIVE_CAN = 6; // 1
        public static final int kRIGHT_L_DRIVE_CAN = 5; // 3
        public static final int kRIGHT_C_DRIVE_CAN = 4; // 2
    }
}
