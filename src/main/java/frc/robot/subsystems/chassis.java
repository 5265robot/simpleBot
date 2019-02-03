/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * Add your docs here.
 */
public class chassis extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private VictorSP motor00;
  private VictorSP motor01;
  private SpeedControllerGroup rightMotors;
  private VictorSP motor02;
  private VictorSP motor03;
  private SpeedControllerGroup leftMotors;
  private DifferentialDrive drive00;


  public chassis() {
     motor00 = new VictorSP(0);
     addChild("motor00",motor00);
     motor00.setInverted(false);
     
     motor01 = new VictorSP(1);
     addChild("motor01",motor01);
     motor01.setInverted(false);
     
     rightMotors = new SpeedControllerGroup(motor00, motor01  );
     addChild("rightMotors",rightMotors);
     
     
     motor02 = new VictorSP(2);
     addChild("motor02",motor02);
     motor02.setInverted(false);
     
     motor03 = new VictorSP(3);
     addChild("motor03",motor03);
     motor03.setInverted(false);
     
     leftMotors = new SpeedControllerGroup(motor02, motor03  );
     addChild("leftMotors",leftMotors);
     
     
     drive00 = new DifferentialDrive(leftMotors, rightMotors);
     addChild("drive00",drive00);
     drive00.setSafetyEnabled(false);
     drive00.setExpiration(0.1);
     drive00.setMaxOutput(1.0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  public void periodic() {
      // Put code here to be run every loop
  }

  public void driveLeft(double ss){
      drive00.tankDrive(0.0,ss);
  }

  public void driveRight(double ss){
      drive00.tankDrive(ss,00);
  }

  public void driveBoth(double left, double right){
     drive00.tankDrive(left, right);
 }
}
