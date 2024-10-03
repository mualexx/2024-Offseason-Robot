// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.TeleOpDriveCommand;
import frc.robot.subsystems.TankDrive;

public class RobotContainer {
  private TankDrive driveBase = new TankDrive();
  private CommandXboxController controller = new CommandXboxController(0);
  
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    driveBase.setDefaultCommand(new TeleOpDriveCommand(
      driveBase, 
      () -> controller.getLeftY(), 
      () -> controller.getRightY()
    ));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
