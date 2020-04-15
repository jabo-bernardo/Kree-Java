package dev.jabo.kree.gameTest;

import java.awt.Graphics;

import dev.jabo.kree.Component;
import dev.jabo.kree.Input;
import dev.jabo.kree.Vector2;

public class PlayerMovement extends Component {

	public float movementSpeed = 0.5f;
	
	public PlayerMovement(float movementSpeed) {
		this.name = "Player Movement";
		this.movementSpeed = movementSpeed;
	}
	
	@Override
	public void Update() {
		
		// Left key
		if(Input.isKeyPressed(37)) {
			gameObject.getTransform().translate(Vector2.left);
		}
		// Right key
		if(Input.isKeyPressed(39)) {
			gameObject.getTransform().translate(Vector2.right);
		}
		// Up key
		if(Input.isKeyPressed(38)) {
			gameObject.getTransform().translate(Vector2.up);
		}
		// Down key
		if(Input.isKeyPressed(40)) {
			gameObject.getTransform().translate(Vector2.down);
		}
		
	}

	@Override
	public void Render(Graphics g) {
		
	}

}
