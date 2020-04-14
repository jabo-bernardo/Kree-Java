package dev.jabo.kree;

public class Transform {

	// GameObject properties
	public Vector2 position;
	public Vector2 scale;
	public float rotation;
	
	public Transform() {
		position = new Vector2(0, 0);
		scale = new Vector2(0, 0);
		rotation = 0;
	}
	
	// Move the game object by..
	public void translate(Vector2 position) {
		this.position.add(position);
	}
	
}
