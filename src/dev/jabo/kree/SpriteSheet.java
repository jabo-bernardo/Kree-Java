package dev.jabo.kree;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	// The image containing all the frames
	private BufferedImage sheet;
	
	// Frames
	private BufferedImage[] images;
	
	public SpriteSheet(Sprite sheet, int frameWidth, int frameHeight){
		this.sheet = sheet.getImage();
		
		images = new BufferedImage[this.sheet.getWidth() / frameWidth];
		for(int x = 0; x < this.sheet.getWidth() / frameWidth; x++) {
			images[x] = crop(x * frameWidth, 0, frameWidth, frameHeight);
		}
		
	}
	
	public BufferedImage[] getFrames() {
		return images;
	}
	
	private BufferedImage crop(int x, int y, int width, int height){
		return sheet.getSubimage(x, y, width, height);
	}
	
}
