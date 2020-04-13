package dev.jabo.kree.components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import dev.jabo.kree.Component;
import dev.jabo.kree.Sprite;

public class SpriteRenderer extends Component {

	private Sprite sprite;
	
	public SpriteRenderer(String path) {
		
		this.sprite = new Sprite(path);
		this.name = "Sprite Renderer";
		
	}
	
	@Override
	public void Update() {
		
	}

	@Override
	public void Render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform oldTransform = g2d.getTransform();
	    g2d.rotate(Math.toRadians(gameObject.transform.rotation), gameObject.transform.position.x, gameObject.transform.position.y);
	    if(gameObject != null)
	    	g2d.drawImage(sprite.image, gameObject.transform.position.x, gameObject.transform.position.y, gameObject.transform.scale.x, gameObject.transform.scale.y, null);
		g2d.setTransform(oldTransform);
	}

}
