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
	    g2d.rotate(gameObject.transform.rotation, gameObject.transform.position.x, gameObject.transform.position.y);
	    if(gameObject != null) {
	    	g2d.fillRect(gameObject.transform.position.x - 16, gameObject.transform.position.y - 16, gameObject.transform.scale.x, gameObject.transform.scale.y);
		}
	    g2d.setTransform(oldTransform);
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

}
