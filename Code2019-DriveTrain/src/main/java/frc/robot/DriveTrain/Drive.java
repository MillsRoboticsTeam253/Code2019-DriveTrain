package frc.robot.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Drive extends Command {

    public Drive() {
        requires(Robot.driveTrain);
    }

    protected void execute() {

        double throttle = Robot.oi.xboxController.getRawAxis(1);
        double turn = Robot.oi.xboxController.getRawAxis(2);
        double left = throttle + throttle * turn;
        double right = throttle - throttle * turn;// this is so extra

        Robot.driveTrain.drive(left, right);
    }

    protected boolean isFinished() {
        return false;
    }
}