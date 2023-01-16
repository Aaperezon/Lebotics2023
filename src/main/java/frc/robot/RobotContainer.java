// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.ChassisCommand;
import frc.robot.commands.GripperCommand;
import frc.robot.subsystems.ChassisSubsystem;
import frc.robot.subsystems.GripperSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  
  private final ChassisSubsystem chassisSubsystem = new ChassisSubsystem();
  private final ChassisCommand chassisCommand = new ChassisCommand(chassisSubsystem);
  private final GripperSubsystem gripperSubsystem = new GripperSubsystem();
  private final GripperCommand gripperCommand = new GripperCommand(gripperSubsystem);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return null;
  }

  public Command getChassisCommand(){
    return chassisCommand;
  }
  public Command getGripperCommand(){
    return gripperCommand;
  }
}