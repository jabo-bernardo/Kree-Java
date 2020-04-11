package dev.jabo.kree;

import java.awt.image.BufferedImage;

public class Sprite {

	public BufferedImage image;
	
	public Sprite(String path) {
		
		this.image = ImageLoader.LoadImage(path);
		
	}
	
}
