package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TankDrive;

public class TeleOpDriveCommand extends Command {
    private TankDrive drive;

    private Supplier<Double> leftSupplier, rightSupplier;

    public TeleOpDriveCommand(TankDrive drive, Supplier<Double> leftSupplier, Supplier<Double> rightSupplier) {
        this.drive = drive;
        this.leftSupplier = leftSupplier;
        this.rightSupplier = rightSupplier;

        addRequirements(drive);
    }

    @Override
    public void execute(){
        drive.tankCalculation(
            MathUtil.applyDeadband(leftSupplier.get(), 0.05), 
            MathUtil.applyDeadband(rightSupplier.get(), 0.05)
        );
    }
}
