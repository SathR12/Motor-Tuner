/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class playSong extends CommandBase {
    public playSong() {
        addRequirements(RobotContainer.BOOMBOX);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        RobotContainer.BOOMBOX.addSongs();
        RobotContainer.BOOMBOX.playSong();
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }


    
}
