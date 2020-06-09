package dev.jabo.kree;

import java.awt.image.BufferedImage;

public class Sprite {

	private BufferedImage image;


	/**
	 *
	 * @author jabo-bernardo
	 *
	 * @param path Path to your image
	 *
	 * */
	public Sprite(String path) {
		
		// Loads image
		this.image = ImageLoader.loadImage(path);
		
	}

	/**
	 *
	 * @author jabo-bernardo
	 *
	 * @return BufferedImage
	 *
	 * */
	public BufferedImage getImage() {
		return image;
	}
	
}
