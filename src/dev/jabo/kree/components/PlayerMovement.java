package dev.jabo.kree.components;

import java.awt.Graphics;

import dev.jabo.kree.Component;
import dev.jabo.kree.Debug;
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
			gameObject.getTransform().translate(Vector2.left.subtractX(movementSpeed));
			Vector2.left.addX(movementSpeed);
		}
		// Right key
		if(Input.isKeyPressed(39)) {
			gameObject.getTransform().translate(Vector2.right.addX(movementSpeed));
			Vector2.right.subtractX(movementSpeed);
		}
		// Up key
		if(Input.isKeyPressed(38)) {
			gameObject.getTransform().translate(Vector2.up.subtractY(movementSpeed));
			Vector2.up.addY(movementSpeed);
		}
		// Down key
		if(Input.isKeyPressed(40)) {
			gameObject.getTransform().translate(Vector2.down.addY(movementSpeed));
			Vector2.down.subtractY(movementSpeed);
		}
		
	}

	@Override
	public void Render(Graphics g) {
		
	}

}
