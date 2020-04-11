package dev.jabo.kree;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage sheet;
	
	private BufferedImage[] images;
	
	public SpriteSheet(Sprite sheet, int frameWidth, int frameHeight){
		this.sheet = sheet.image;
		
		images = new BufferedImage[this.sheet.getWidth() / frameWidth];
		for(int x = 0; x < this.sheet.getWidth() / frameWidth; x++) {
			images[x] = crop(x * frameWidth, 0, frameWidth, frameHeight);
		}
		
	}
	
	public BufferedImage[] GetFrames() {
		return images;
	}
	
	public BufferedImage crop(int x, int y, int width, int height){
		return sheet.getSubimage(x, y, width, height);
	}
	
}
