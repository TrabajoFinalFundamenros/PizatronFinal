package co.edu.unbosque.view;

import java.io.File;
import java.io.IOException;
import java.util.Timer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {
	File music ;
	AudioInputStream audio ;
	Clip clip ;
	FloatControl fc ;
	
	public void play() throws LineUnavailableException, UnsupportedAudioFileException, IOException {	
		 music = new File("music_106.wav");
		 audio = AudioSystem.getAudioInputStream(music);
		 clip = AudioSystem.getClip();
		 clip.open(audio);
		 fc =  (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
		clip.start();
	}
	
	public void volumeCH(float vol) {
		int stop=0; 
		clip.setFramePosition(0);
		System.out.println("volumen bajado");
		fc.setValue(vol);
		if(vol == 0.0) {
			clip.stop();
			stop = 1;
		}
		else clip.start();
	}

}
