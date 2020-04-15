package dev.jabo.kree;

public class Transform {

	// GameObject properties
	private Vector2 position;
	private Vector2 scale;
	private float rotation;
	
	public Transform() {
		position = new Vector2(0, 0);
		scale = new Vector2(0, 0);
		rotation = 0;
	}
	
	// Move the game object by..
	public void translate(Vector2 position) {
		this.position.add(position);
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public Vector2 getScale() {
		return scale;
	}
	
	public float getRotation() {
		return rotation;
	}
	
	public void setPosition(Vector2 position) {
		this.position = position;
	}
	
	public void setScale(Vector2 scale) {
		this.scale = scale;
	}
	
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}
	
}
