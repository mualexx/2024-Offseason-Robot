package frc.robot.Commands;

import java.util.function.Supplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants.TankDriveConstants;
import frc.robot.Drive.TankDrive;

public class TeleOpDriveCommand extends Command{
    private TankDrive drive;

    private Supplier<Double> leftSupplier, rightSupplier;

    public TeleOpDriveCommand(TankDrive drive, Supplier<Double> leftSupplier, Supplier<Double> rightSupplier) {
        this.drive = drive;
        this.leftSupplier = leftSupplier;
        this.rightSupplier = rightSupplier;

        addRequirements(drive);
    }

    public void execute(){
        drive.tankCalculation(
            MathUtil.applyDeadband(leftSupplier.get(), 0) * TankDriveConstants.kMAXIMUM_SPEED, 
            MathUtil.applyDeadband(rightSupplier.get(), 0) * TankDriveConstants.kMAXIMUM_SPEED
        );
        
    }
}
