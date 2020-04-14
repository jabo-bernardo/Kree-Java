package dev.jabo.kree.components;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.jabo.kree.Component;

public class BoxCollider extends Component {

	private Rectangle collider;
	
	public boolean trigger;
	
	public BoxCollider() {
		this.name = "Box Collider";
	}
	
	@Override
	public void Update() {
		if(gameObject != null) {
			collider = new Rectangle(gameObject.transform.position.x, gameObject.transform.position.y, gameObject.transform.scale.x, gameObject.transform.scale.y);
		}
		collider.x = gameObject.transform.position.x;
		collider.y = gameObject.transform.position.y;
		collider.width = gameObject.transform.scale.x;
		collider.height = gameObject.transform.scale.y;
		
	}

	@Override
	public void Render(Graphics g) {
		
	}
	
	public boolean collidingWith(BoxCollider col) {
		if(collider == null) {
			return true;
		}
		if(collider.contains(col.getCollider())) {
			return true;
		}
		
		return false;
		
	}
	
	public Rectangle getCollider() {
		if(collider != null) {
			return collider;
		}
		return null;
	}

}
