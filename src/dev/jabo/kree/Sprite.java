package dev.jabo.kree;

import java.awt.image.BufferedImage;

public class Sprite {

	private BufferedImage image;
	
	public Sprite(String path) {
		
		// Loads image
		this.image = ImageLoader.loadImage(path);
		
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
}
