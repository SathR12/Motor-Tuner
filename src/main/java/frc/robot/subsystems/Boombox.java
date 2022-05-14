/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


package frc.robot.subsystems;
import frc.robot.Constants;

import com.ctre.phoenix.music.Orchestra;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Joystick;

import java.util.ArrayList;


public class Boombox extends SubsystemBase {
    Orchestra boombox;
    TalonFX[] motors = {
        
        new TalonFX(Constants.RM1Port), new TalonFX(Constants.RM2Port), new TalonFX(Constants.RM3Port), 
        new TalonFX(Constants.LM1Port), new TalonFX(Constants.LM2Port), new TalonFX(Constants.LM3Port)
                    
    };

    String[] music = {"chrp_file1", "chrp_file2"};

    Joystick joycon;

    public void addSongs() {
        ArrayList<TalonFX> instruments = new ArrayList<TalonFX>();
        for (TalonFX ports: motors) {
            instruments.add(ports);
        }
    
        boombox = new Orchestra(instruments);
        joycon = new Joystick(0);
        queueSong(0);

        SmartDashboard.putBoolean("Playing", false);

    }

    public void queueSong(int selection) {
        boombox.loadMusic(music[selection]);
        System.out.println("Now playing: " + music[selection]);
    }

    public void playSong() {
        boolean playing = SmartDashboard.getBoolean("Playing", false);

        if (playing) {
            boombox.play();
        }

        else {
            boombox.stop();
        }


    }





}
