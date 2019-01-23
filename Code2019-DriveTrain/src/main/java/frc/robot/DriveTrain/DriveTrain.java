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
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;

public class DriveTrain extends Subsystem {

  private static TalonSRX leftFront = new TalonSRX(1), leftMid = new TalonSRX(2), leftBack = new TalonSRX(3),
      rightFront = new TalonSRX(4), rightMid = new TalonSRX(5), rightBack = new TalonSRX(6);

  public static final TalonSRX[] motors = { leftFront, leftMid, leftBack, rightFront, rightMid, rightBack };
  public static final TalonSRX[] leftMotors = { leftFront, leftMid, leftBack };
  public static final TalonSRX[] rightMotors = { rightFront, rightMid, rightBack };

  public DriveTrain() {
    leftMid.follow(leftFront);
    leftBack.follow(leftFront);
    rightMid.follow(rightFront);
    rightBack.follow(rightFront);

    // left encoder code
    leftFront.setStatusFramePeriod(StatusFrameEnhanced.Status_3_Quadrature, 1, 10);
    leftFront.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
    leftFront.setSensorPhase(true);

    // right encoder code
    rightFront.setStatusFramePeriod(StatusFrameEnhanced.Status_3_Quadrature, 1, 10);
    rightFront.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
    rightFront.setSensorPhase(true);

  }

  public void drive(double right, double left) {
    leftFront.set(ControlMode.PercentOutput, left);
    rightFront.set(ControlMode.PercentOutput, right);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Drive());
  }

  public static void resetEncoders() {
    leftFront.setSelectedSensorPosition(0, 0, 10);
    rightFront.setSelectedSensorPosition(0, 0, 10);
  }
}
