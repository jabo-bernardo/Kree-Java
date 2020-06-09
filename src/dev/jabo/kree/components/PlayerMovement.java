package dev.jabo.kree.components;

import java.awt.Graphics;

import dev.jabo.kree.Component;
import dev.jabo.kree.Debug;
import dev.jabo.kree.Input;
import dev.jabo.kree.Vector2;

public class PlayerMovement extends Component {

	public static final int ARROWS = 0;
	public static final int WASD = 1;

	public float movementSpeed = 0.5f;
	public int movementKeys = ARROWS;
	
	public PlayerMovement(float movementSpeed, int movementKeys) {
		this.name = "Player Movement";
		this.movementSpeed = movementSpeed;
		this.movementKeys = movementKeys;
	}
	
	@Override
	public void Update() {
		if(movementKeys == ARROWS) {
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
		} else if(movementKeys == WASD) {
			// Left key A
			if(Input.isKeyPressed(65)) {
				gameObject.getTransform().translate(Vector2.left.subtractX(movementSpeed));
				Vector2.left.addX(movementSpeed);
			}
			// Right key D
			if(Input.isKeyPressed(68)) {
				gameObject.getTransform().translate(Vector2.right.addX(movementSpeed));
				Vector2.right.subtractX(movementSpeed);
			}
			// Up key W
			if(Input.isKeyPressed(87)) {
				gameObject.getTransform().translate(Vector2.up.subtractY(movementSpeed));
				Vector2.up.addY(movementSpeed);
			}
			// Down key S
			if(Input.isKeyPressed(83)) {
				gameObject.getTransform().translate(Vector2.down.addY(movementSpeed));
				Vector2.down.subtractY(movementSpeed);
			}
		}
		
	}

	@Override
	public void Render(Graphics g) {
		
	}

}
