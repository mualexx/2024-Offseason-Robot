package frc.robot.Drive;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonSRXPIDSetConfiguration;

import frc.robot.Constants.HardwareConstants;
import frc.robot.Constants.TankDriveConstants;

public class TankDrive {
    private TalonSRX leftLBDriveMotor = new TalonSRX(HardwareConstants.kLEFT_LB_DRIVE_CAN);
    private TalonSRX leftRBDriveMotor = new TalonSRX(HardwareConstants.kLEFT_RB_DRIVE_CAN);
    private TalonSRX leftTBDriveMotor = new TalonSRX(HardwareConstants.kLEFT_TB_DRIVE_CAN);
    private TalonSRX rightLBDriveMotor = new TalonSRX(HardwareConstants.kRIGHT_LB_DRIVE_CAN);
    private TalonSRX rightRBDriveMotor = new TalonSRX(HardwareConstants.kRIGHT_RB_DRIVE_CAN);
    private TalonSRX rightTBDriveMotor = new TalonSRX(HardwareConstants.kRIGHT_TB_DRIVE_CAN);

    /**
     * 
     * @param leftVelocity
     * @param rightVelocity
     */
    public void setVelocity(double leftVelocity, double rightVelocity){
        
    }
    
    public TankDrive() {
        leftLBDriveMotor.follow(leftTBDriveMotor);
        leftRBDriveMotor.follow(leftTBDriveMotor);

        rightLBDriveMotor.follow(rightTBDriveMotor);
        rightRBDriveMotor.follow(rightTBDriveMotor);

        leftTBDriveMotor.setInverted(false);
        rightTBDriveMotor.setInverted(true);

        leftLBDriveMotor.setInverted(InvertType.FollowMaster);
        leftRBDriveMotor.setInverted(InvertType.FollowMaster);
        rightLBDriveMotor.setInverted(InvertType.FollowMaster);
        rightRBDriveMotor.setInverted(InvertType.FollowMaster);


        leftTBDriveMotor.configSupplyCurrentLimit(TankDriveConstants.kDRIVE_CURRENT_LIMIT, 1000);

    }
}
