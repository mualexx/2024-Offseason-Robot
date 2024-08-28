package frc.robot;

import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;

public class Constants {

    public static final class TankDriveConstants{
        public static final double kDRIVE_GEAR_RATIO = 84.0 / 12.0; //TBD

        public static final SupplyCurrentLimitConfiguration kDRIVE_CURRENT_LIMIT = new SupplyCurrentLimitConfiguration(true, 45, 0, 0);

        public static final double kMAXIMUM_SPEED = 100.0; //TODO

        public static final double kDRIVE_P = 0.0; //TODO
        public static final double kDRIVE_I = 0.0; //TODO
        public static final double kDRIVE_D = 0.0; //TODO
    }
    public static final class HardwareConstants {
        public static final int kPDH_CAN = 1;

        public static final int kLEFT_L_DRIVE_CAN = 2;
        public static final int kLEFT_R_DRIVE_CAN = 3;
        public static final int kLEFT_C_DRIVE_CAN = 4;
        public static final int kRIGHT_R_DRIVE_CAN = 5;
        public static final int kRIGHT_L_DRIVE_CAN = 6;
        public static final int kRIGHT_C_DRIVE_CAN = 7;

        

    }
}
