package dev.jabo.kree;

import java.awt.image.BufferedImage;

public class Animation {

	// Speed (ms)
	private int speed, index;
	
	private BufferedImage[] frames;
	
	// Name of animation
	private String name;
	
	// Timing variables
	private long lastTime, timer;
	
	public Animation(String name, SpriteSheet spr, int speed){
		
		this.name = name;
		
		this.speed = speed;
		this.frames = spr.getFrames();
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
		
	}
	
	public void Update(){
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer > speed){
			index++;
			timer = 0;
			if(index >= frames.length)
				index = 0;
		}
	}
	
	public String getAnimationName() {
		return name;
	}
	
	public BufferedImage getCurrentFrame(){
		return frames[index];
	}
	
}
