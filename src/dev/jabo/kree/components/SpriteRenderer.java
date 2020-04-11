package dev.jabo.kree.components;

import java.awt.Graphics;

import dev.jabo.kree.Component;
import dev.jabo.kree.Sprite;

public class SpriteRenderer extends Component {

	private Sprite sprite;
	
	public SpriteRenderer(String path) {
		
		this.sprite = new Sprite(path);
		
	}
	
	@Override
	public void Update() {
		
	}

	@Override
	public void Render(Graphics g) {
		g.drawImage(sprite.image, gameObject.transform.position.x, gameObject.transform.position.y, gameObject.transform.scale.x, gameObject.transform.scale.y, null);
	}

}
