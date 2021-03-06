/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class driveByTime extends Command {
     private double left;
     private double right;
     private double zero = 0.00;
     
  public driveByTime(double pLeft, double pRight, double time) {
    // this only drives as commanded, using the motors directly
    // there is NO corrections using vision or the onboard gyro
    // takes the incoming parameters and sets the private global variables to those values.
    // sets the time for the motors to run to be equal to the 
    requires(Robot.m_chassis);
    setTimeout(time);
    right = pRight;
    left = pLeft;
    
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
       Timer.delay(0.1);
       Robot.m_chassis.driveBoth(left, right);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
       Robot.m_chassis.driveBoth(zero, zero);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
       end();
  }
}
