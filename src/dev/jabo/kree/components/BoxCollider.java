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
			collider = new Rectangle((int)(gameObject.getTransform().getPosition().getX() - (gameObject.getTransform().getScale().getX() / 2)), (int)(gameObject.getTransform().getPosition().getY() - (gameObject.getTransform().getScale().getX() / 2)), (int)gameObject.getTransform().getScale().getX(), (int)gameObject.getTransform().getScale().getY());
		}
		collider.x = (int)gameObject.getTransform().getPosition().getX();
		collider.y = (int)gameObject.getTransform().getPosition().getY();
		collider.width = (int)gameObject.getTransform().getScale().getX();
		collider.height = (int)gameObject.getTransform().getScale().getY();
		
	}

	@Override
	public void Render(Graphics g) {
		
	}
	
	public boolean collidingWith(BoxCollider col) {
		if(collider == null && col.getCollider() == null) {
			return false;
		} else {
			if(	collider.x + collider.width > col.getCollider().x &&
				collider.x < col.getCollider().x + col.getCollider().width &&
				collider.y + collider.height > col.getCollider().y &&
				collider.y < col.getCollider().y + col.getCollider().height) {
				return true;
			}
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
