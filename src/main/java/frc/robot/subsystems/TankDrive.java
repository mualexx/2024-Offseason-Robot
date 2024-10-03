package frc.robot.subsystems;

import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.HardwareConstants;
import frc.robot.Constants.RobotConstants;
import frc.robot.Constants.TankDriveConstants;

public class TankDrive extends SubsystemBase{
    // Motors
    private TalonSRX leftLDriveMotor = new TalonSRX(HardwareConstants.kLEFT_L_DRIVE_CAN);
    private TalonSRX leftRDriveMotor = new TalonSRX(HardwareConstants.kLEFT_R_DRIVE_CAN);
    private TalonSRX leftCDriveMotor = new TalonSRX(HardwareConstants.kLEFT_C_DRIVE_CAN);
    private TalonSRX rightLDriveMotor = new TalonSRX(HardwareConstants.kRIGHT_L_DRIVE_CAN);
    private TalonSRX rightRDriveMotor = new TalonSRX(HardwareConstants.kRIGHT_R_DRIVE_CAN);
    private TalonSRX rightCDriveMotor = new TalonSRX(HardwareConstants.kRIGHT_C_DRIVE_CAN);

    private DifferentialDrive drive;

    // Config
    private double currentMaxSpeed = TankDriveConstants.kDEFAULT_MAX_SPEED;

    public TankDrive() {
        // Set up all motor configs
        TalonSRX[] motors = {leftLDriveMotor, leftRDriveMotor, leftCDriveMotor, rightLDriveMotor, rightRDriveMotor, rightCDriveMotor};

        for (TalonSRX motor : motors) {
            motor.setNeutralMode(NeutralMode.Brake);
            ErrorCode resp = motor.configSupplyCurrentLimit(TankDriveConstants.kDRIVE_CURRENT_LIMIT, RobotConstants.kCAN_TIMEOUT);

            if (!resp.equals(ErrorCode.OK)) {
                String msg = String.format(
                    "Failed to set current limits on TankDrive SRX %s: %s", 
                    motor.getDeviceID(),
                    resp.toString()
                );
                DriverStation.reportError(msg, false);
                throw new RuntimeException(msg); // This will crash code and restart
            }
        }

        // Config leaders
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

        // Init tank
        drive = new DifferentialDrive(
            (double lSpeed) -> leftCDriveMotor.set(TalonSRXControlMode.PercentOutput, lSpeed * currentMaxSpeed), 
            (double rSpeed) -> rightCDriveMotor.set(TalonSRXControlMode.PercentOutput, rSpeed * currentMaxSpeed)
        );
    }

    /**
     * Sets the new max speed.
     * @param newMaxSpeed Percentage
     */
    public void setMaxSpeed(double newMaxSpeed) {
        // Sanity check
        if (newMaxSpeed < 0.0 || newMaxSpeed > 1.0) {
            DriverStation.reportError(String.format("New max speed (%f) is out of range (0.0 - 1.0)", newMaxSpeed), false);
            return;
        }

        currentMaxSpeed = newMaxSpeed;
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
