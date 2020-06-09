package dev.jabo.kree.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import dev.jabo.kree.Component;

public class MeshRenderer extends Component {
	
	public Color color;
	
	public MeshRenderer() {
		this.name = "Mesh Renderer";
		this.color = Color.BLACK;
	}

	@Override
	public void Update() {
		
	}

	@Override
	public void Render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform oldTransform = g2d.getTransform();
		g2d.rotate(Math.toRadians(gameObject.getTransform().getRotation()), gameObject.getTransform().getPosition().getX(), gameObject.getTransform().getPosition().getY());
	    if(gameObject != null) {
	    	g2d.setColor(color);
	    	g2d.fillRect((int)gameObject.getTransform().getPosition().getX() - ((int)gameObject.getTransform().getScale().getX() / 2), (int)gameObject.getTransform().getPosition().getY() - ((int)gameObject.getTransform().getScale().getY() / 2), (int)gameObject.getTransform().getScale().getX(), (int)gameObject.getTransform().getScale().getY());
		}
	    g2d.setTransform(oldTransform);
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

}
