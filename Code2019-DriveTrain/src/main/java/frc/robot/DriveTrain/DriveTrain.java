/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.DriveTrain;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Encoder;

public class DriveTrain extends Subsystem {

  private static TalonSRX leftFront = new TalonSRX(1), leftMid = new TalonSRX(2), leftBack = new TalonSRX(3),
      rightFront = new TalonSRX(4), rightMid = new TalonSRX(5), rightBack = new TalonSRX(6);

  private static Encoder enc = new Encoder(1, 2);

  public DriveTrain() {
    leftMid.follow(leftFront);
    leftBack.follow(leftFront);
    rightMid.follow(rightFront);
    rightBack.follow(rightFront);
  }

  public void drive(double right, double left) {
    leftFront.set(ControlMode.PercentOutput, left);
    rightFront.set(ControlMode.PercentOutput, right);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Drive());
  }
}
