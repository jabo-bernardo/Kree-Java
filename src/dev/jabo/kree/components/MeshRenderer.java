package dev.jabo.kree.components;

import java.awt.Color;
import java.awt.Graphics;

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
		if(gameObject != null) {
			g.fillRect(gameObject.transform.position.x, gameObject.transform.position.y, gameObject.transform.scale.x, gameObject.transform.scale.y);
		}
	}
	
	public void SetColor(Color color) {
		this.color = color;
	}

}
