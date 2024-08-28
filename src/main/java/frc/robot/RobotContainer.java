// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Drive.TankDrive;
import frc.robot.Commands.TeleOpDriveCommand;

public class RobotContainer {
  private TankDrive driveBase = new TankDrive();
  private CommandXboxController controller = new CommandXboxController(0);

  
  public RobotContainer() {
    configureBindings();

  }

  private void configureBindings() {
    Trigger isTeleop = new Trigger(DriverStation::isTeleopEnabled);
    
    controller.a().negate().and(isTeleop).whileTrue(new TeleOpDriveCommand(
      driveBase,
      () -> controller.getLeftY(),
      () -> controller.getRightY())
     .repeatedly());
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
