package dev.jabo.kree;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	// The image containing all the frames
	private BufferedImage sheet;
	
	// Frames
	private BufferedImage[] images;

	/**
	 *
	 * @author jabo-bernardo
	 *
	 * @param sheet The sprite sheet of the animation\
	 * @param frameWidth The horizontal size of each frame
	 * @param frameHeight The vertical size of each frame
	 *
	 * */
	public SpriteSheet(Sprite sheet, int frameWidth, int frameHeight){
		this.sheet = sheet.getImage();
		
		images = new BufferedImage[this.sheet.getWidth() / frameWidth];
		for(int x = 0; x < this.sheet.getWidth() / frameWidth; x++) {
			images[x] = crop(x * frameWidth, 0, frameWidth, frameHeight);
		}
		
	}

	/**
	 *
	 * @author jabo-bernardo
	 *
	 * @return BufferedImage[] returns all of the frames (cropped)
	 *
	 * */
	public BufferedImage[] getFrames() {
		return images;
	}
	
	private BufferedImage crop(int x, int y, int width, int height){
		return sheet.getSubimage(x, y, width, height);
	}
	
}
