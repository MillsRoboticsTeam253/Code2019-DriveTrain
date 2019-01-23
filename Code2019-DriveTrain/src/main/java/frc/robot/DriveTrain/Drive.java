package frc.robot.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Drive extends Command {

    public Drive() {
        requires(Robot.driveTrain);
    }

    protected void execute() {
        double left = Robot.oi.xboxController.getY();
        double right = Robot.oi.xboxController.getY();

        Robot.driveTrain.drive(left, right);
    }

    protected boolean isFinished() {
        return false;
    }
}