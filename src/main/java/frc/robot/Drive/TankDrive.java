package frc.robot.Drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonSRXPIDSetConfiguration;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.HardwareConstants;
import frc.robot.Constants.TankDriveConstants;

public class TankDrive extends SubsystemBase{
    private TalonSRX leftLDriveMotor = new TalonSRX(HardwareConstants.kLEFT_L_DRIVE_CAN);
    private TalonSRX leftRDriveMotor = new TalonSRX(HardwareConstants.kLEFT_R_DRIVE_CAN);
    private TalonSRX leftCDriveMotor = new TalonSRX(HardwareConstants.kLEFT_C_DRIVE_CAN);
    private TalonSRX rightLDriveMotor = new TalonSRX(HardwareConstants.kRIGHT_L_DRIVE_CAN);
    private TalonSRX rightRDriveMotor = new TalonSRX(HardwareConstants.kRIGHT_R_DRIVE_CAN);
    private TalonSRX rightCDriveMotor = new TalonSRX(HardwareConstants.kRIGHT_C_DRIVE_CAN);
    

    private DifferentialDrive drive;

    public TankDrive() {
        leftLDriveMotor.follow(leftCDriveMotor);
        leftRDriveMotor.follow(leftCDriveMotor);

        rightLDriveMotor.follow(rightCDriveMotor);
        rightRDriveMotor.follow(rightCDriveMotor);

        leftCDriveMotor.setInverted(false);
        rightCDriveMotor.setInverted(true);

        leftLDriveMotor.setInverted(InvertType.FollowMaster);
        leftRDriveMotor.setInverted(InvertType.FollowMaster);
        rightLDriveMotor.setInverted(InvertType.FollowMaster);
        rightRDriveMotor.setInverted(InvertType.FollowMaster);

        leftCDriveMotor.configSupplyCurrentLimit(TankDriveConstants.kDRIVE_CURRENT_LIMIT, 1000);
        rightCDriveMotor.configSupplyCurrentLimit(TankDriveConstants.kDRIVE_CURRENT_LIMIT, 1000);

        leftCDriveMotor.config_kP(0, TankDriveConstants.kDRIVE_P, 1000);
        leftCDriveMotor.config_kI(0, TankDriveConstants.kDRIVE_I, 1000);
        leftCDriveMotor.config_kD(0, TankDriveConstants.kDRIVE_D, 1000);

        rightCDriveMotor.config_kP(0, TankDriveConstants.kDRIVE_P, 1000);
        rightCDriveMotor.config_kI(0, TankDriveConstants.kDRIVE_I, 1000);
        rightCDriveMotor.config_kD(0, TankDriveConstants.kDRIVE_D, 1000);

        leftCDriveMotor.setNeutralMode(NeutralMode.Brake);
        rightCDriveMotor.setNeutralMode(NeutralMode.Brake);

        // Init tank
        drive = new DifferentialDrive(
            (double speed) -> leftCDriveMotor.set(ControlMode.Velocity, speed * TankDriveConstants.kMAXIMUM_SPEED * TankDriveConstants.kDRIVE_GEAR_RATIO),
            (double speed) -> rightCDriveMotor.set(ControlMode.Velocity, speed * TankDriveConstants.kMAXIMUM_SPEED * TankDriveConstants.kDRIVE_GEAR_RATIO)
        );
    }

     /**
     * 
     * @param leftVelocity
     * @param rightVelocity
     */
    public void setVelocity(double leftVelocity, double rightVelocity){
        leftCDriveMotor.set(ControlMode.Velocity, leftVelocity);
        rightCDriveMotor.set(ControlMode.Velocity, rightVelocity);
    }
    /**
     * Runs the Tank Drive equivalent using left and right speed
     * @param leftSpeed In Percentage
     * @param rightSpeed In Percentage
     */
    public void tankCalculation(double leftSpeed, double rightSpeed){
        drive.tankDrive(leftSpeed, rightSpeed); 
    }
    
}
