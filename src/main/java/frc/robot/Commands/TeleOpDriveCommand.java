package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.TankDriveConstants;
import frc.robot.subsystems.TankDrive;
import java.util.function.BooleanSupplier;

public class TeleOpDriveCommand extends Command {
    private TankDrive drive;

    private Supplier<Double> leftSupplier, rightSupplier;
    private BooleanSupplier highSpeedSupplier;

    public TeleOpDriveCommand(TankDrive drive, Supplier<Double> leftSupplier, Supplier<Double> rightSupplier, BooleanSupplier highSpeedSupplier) {
        this.drive = drive;
        this.leftSupplier = leftSupplier;
        this.rightSupplier = rightSupplier;
        this.highSpeedSupplier = highSpeedSupplier;

        addRequirements(drive);
    }

    @Override
    public void execute(){
        if (highSpeedSupplier.getAsBoolean()) {
            drive.setMaxSpeed(TankDriveConstants.kDEFAULT_MAX_SPEED);
        } else {
            drive.setMaxSpeed(TankDriveConstants.kHIGH_MAX_SPEED);
        }

        drive.tankCalculation(
            MathUtil.applyDeadband(leftSupplier.get(), 0.05), 
            MathUtil.applyDeadband(rightSupplier.get(), 0.05)
        );
    }
}
