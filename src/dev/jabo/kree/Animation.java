package dev.jabo.kree;

import java.awt.image.BufferedImage;

public class Animation {

	private int speed, index;
	private long lastTime, timer;
	private BufferedImage[] frames;
	
	private String name;
	
	public Animation(String name, SpriteSheet spr, int speed){
		
		this.name = name;
		
		this.speed = speed;
		this.frames = spr.GetFrames();
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
	
	public String GetAnimationName() {
		return name;
	}
	
	public BufferedImage getCurrentFrame(){
		return frames[index];
	}
	
}
