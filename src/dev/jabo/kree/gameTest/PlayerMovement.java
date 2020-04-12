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
		if(Input.IsKeyPressed(37)) {
			gameObject.transform.Translate(Vector2.left);
		}
		// Right key
		if(Input.IsKeyPressed(39)) {
			gameObject.transform.Translate(Vector2.right);
		}
		// Up key
		if(Input.IsKeyPressed(38)) {
			gameObject.transform.Translate(Vector2.up);
		}
		// Down key
		if(Input.IsKeyPressed(40)) {
			gameObject.transform.Translate(Vector2.down);
		}
		
	}

	@Override
	public void Render(Graphics g) {
		
	}

}
