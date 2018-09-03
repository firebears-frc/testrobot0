
package org.usfirst.frc2846.testrobot0.commands;

import org.usfirst.frc2846.testrobot0.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Default command to drive the robot chassis using the Joystick.
 */
public class ChassisDriveCommand extends Command {

    public ChassisDriveCommand() {
        requires(Robot.chassis);
    }

    @Override
    protected void execute() {
        double speed = Robot.oi.getjoystick().getY();
        double rotation = Robot.oi.getjoystick().getX();
        Robot.chassis.driveRobot(speed, rotation);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
