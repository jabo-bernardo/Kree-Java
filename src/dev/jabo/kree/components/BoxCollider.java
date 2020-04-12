package dev.jabo.kree.components;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import dev.jabo.kree.Component;
import dev.jabo.kree.Vector2;

public class BoxCollider extends Component {

	private Rectangle collider;
	
	public BoxCollider() {
		this.name = "Box Collider";
	}
	
	@Override
	public void Update() {
		if(collider == null) {
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
	
	public boolean Contains(Vector2 vector2) {
		return GetCollider().contains(new Point(vector2.x, vector2.y));
	}
	
	public Rectangle GetCollider() {
		if(collider != null) {
			return collider;
		}
		return new Rectangle();
	}

}
