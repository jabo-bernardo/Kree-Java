package dev.jabo.kree;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio {
	
	private String path;
    private File sound;
    private Clip soundClip;
    
    public Audio(final String path) {
        this.path = path;
        this.load();
    }
    
    public void load() {
        this.sound = new File(this.path);
    }
    
    public boolean isPlaying() {
    	if(soundClip != null) {
    		if(soundClip.isRunning()) {
    			return true;
    		}
    	}
        return false;
    }
    
    public void play(final boolean loop) {
        try {
            this.soundClip = AudioSystem.getClip();
            try {
                this.soundClip.open(AudioSystem.getAudioInputStream(this.sound));
                if (loop) {
                    this.soundClip.loop(-1);
                }
                this.soundClip.start();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            catch (UnsupportedAudioFileException e2) {
                e2.printStackTrace();
            }
        }
        catch (LineUnavailableException e3) {
            e3.printStackTrace();
        }
    }
    
    public void play() {
        try {
            this.soundClip = AudioSystem.getClip();
            try {
                this.soundClip.open(AudioSystem.getAudioInputStream(this.sound));
                this.soundClip.start();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            catch (UnsupportedAudioFileException e2) {
                e2.printStackTrace();
            }
        }
        catch (LineUnavailableException e3) {
            e3.printStackTrace();
        }
    }
    
    public void stop() {
        this.soundClip.stop();
    }

}
