package dev.jabo.kree;

public class Transform {

	public Vector2 position;
	public Vector2 scale;
	
	public Transform() {
		position = new Vector2(0, 0);
		scale = new Vector2(0, 0);
	}
	
	public void Translate(Vector2 position) {
		this.position.Add(position);
	}
	
}
