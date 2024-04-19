package frc.robot;

import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;

public class Constants {

    public static final class TankDriveConstants{
        public static final double kDRIVE_GEAR_RATIO = 0.0; //TBD

        public static final SupplyCurrentLimitConfiguration kDRIVE_CURRENT_LIMIT = new SupplyCurrentLimitConfiguration(true, 45, 0, 0);
    }
    public static final class HardwareConstants {
        public static final int kPDH_CAN = 1;

        public static final int kLEFT_LB_DRIVE_CAN = 2;
        public static final int kLEFT_RB_DRIVE_CAN = 3;
        public static final int kLEFT_TB_DRIVE_CAN = 4;
        public static final int kRIGHT_RB_DRIVE_CAN = 5;
        public static final int kRIGHT_LB_DRIVE_CAN = 6;
        public static final int kRIGHT_TB_DRIVE_CAN = 7;

        

    }
}
