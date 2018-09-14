package org.usfirst.frc2846.testrobot0.subsystems;

import org.usfirst.frc2846.testrobot0.commands.ChassisDriveCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * Subsystem that contains the drive wheels for the robot.
 */
public class Chassis extends Subsystem {

    private WPI_TalonSRX leftMotor;
    private WPI_TalonSRX rightMotor;
    private DifferentialDrive robotDrive;

    public Chassis() {
        Preferences config = Preferences.getInstance();
        leftMotor = new WPI_TalonSRX(config.getInt("chassis.leftMotor.canID", 2));
        rightMotor = new WPI_TalonSRX(config.getInt("chassis.rightMotor.canID", 3));

        robotDrive = new DifferentialDrive(leftMotor, rightMotor);
        addChild(robotDrive);
        robotDrive.setSafetyEnabled(true);
        robotDrive.setExpiration(0.1);
        robotDrive.setMaxOutput(1.0);
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new ChassisDriveCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    /**
     * Drive the robot.
     * 
     * @param speed
     *            Amount of forward motion, in the range of -1.0 to 1.0.
     * @param rotation
     *            Amount of angular rotation, in the range of -1.0 to 1.0.
     */
    public void driveRobot(double speed, double rotation) {
        robotDrive.arcadeDrive(speed, rotation);
    }

}
