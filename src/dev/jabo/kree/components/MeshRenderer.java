package dev.jabo.kree.components;

import java.awt.Graphics;

import dev.jabo.kree.Component;

public class MeshRenderer extends Component {
	
	public MeshRenderer() {
		this.name = "Mesh Renderer";
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

}
