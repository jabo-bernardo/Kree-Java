package dev.jabo.kree.components;

import java.awt.Graphics;

import dev.jabo.kree.Component;
import dev.jabo.kree.GameObject;
import dev.jabo.kree.Vector2;

public class LookAtObject extends Component {

	public Vector2 target;
	public GameObject objectTarget;	
	
	public LookAtObject() {
		this.name = "Look at Object";
	}

	@Override
	public void Update() {
		gameObject.getTransform().setRotation((float) Math.toDegrees((Math.atan2(gameObject.getTransform().getPosition().getY() - target.getY(), gameObject.getTransform().getPosition().getX() - target.getX()) - Math.PI / 2)));
	}

	@Override
	public void Render(Graphics g) {
		
	}
	
	public void setTarget(GameObject target) {
		this.target = target.getTransform().getPosition();
		this.objectTarget = target;
	}
	
	public void setTarget(Vector2 target) {
		this.target = target;
	}
	
}
