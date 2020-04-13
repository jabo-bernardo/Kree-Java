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
		gameObject.transform.rotation =  (float) (Math.atan2(gameObject.transform.position.y - target.y, gameObject.transform.position.x - target.x) - Math.PI / 2);;
	}

	@Override
	public void Render(Graphics g) {
		
	}
	
	public void setTarget(GameObject target) {
		this.target = target.transform.position;
		this.objectTarget = target;
	}
	
	public void setTarget(Vector2 target) {
		this.target = target;
	}
	
}
