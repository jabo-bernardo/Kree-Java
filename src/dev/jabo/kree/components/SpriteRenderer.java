package dev.jabo.kree.components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import dev.jabo.kree.Component;
import dev.jabo.kree.Sprite;

public class SpriteRenderer extends Component {

	private Sprite sprite;
	
	public SpriteRenderer(Sprite spr) {
		
		this.sprite = spr;
		this.name = "Sprite Renderer";
		
	}
	
	@Override
	public void Update() {
		
	}

	@Override
	public void Render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform oldTransform = g2d.getTransform();
		g2d.rotate(Math.toRadians(gameObject.getTransform().getRotation()), gameObject.getTransform().getPosition().getX(), gameObject.getTransform().getPosition().getY());
	    if(gameObject != null)
	    	g2d.drawImage(sprite.getImage(), gameObject.getTransform().getPosition().getX() - (gameObject.getTransform().getScale().getX() / 2), gameObject.getTransform().getPosition().getY() - (gameObject.getTransform().getScale().getY() / 2), gameObject.getTransform().getScale().getX(), gameObject.getTransform().getScale().getY(), null);
		g2d.setTransform(oldTransform);
	}
	
	public void setSprite(Sprite spr) {
		this.sprite = spr;
	}

}
