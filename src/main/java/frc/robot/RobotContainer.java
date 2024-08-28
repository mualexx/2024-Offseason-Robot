// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Drive.TankDrive;

public class RobotContainer {
  private TankDrive driveBase = new TankDrive();
  private XboxController controller = new XboxController(0);

  
  public RobotContainer() {
    configureBindings();

    driveBase.tankCalculation(controller.getLeftX(), controller.getRightX());
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
