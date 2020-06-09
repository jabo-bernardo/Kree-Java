package dev.jabo.kree;

public class Transform {

	// GameObject properties
	private Vector2 position;
	private Vector2 scale;
	private float rotation;

	/**
	 *
	 * @author jabo-bernardo
	 *
	 * */
	public Transform() {
		position = new Vector2(0, 0);
		scale = new Vector2(0, 0);
		rotation = 0;
	}
	
	/**
	 *
	 * @author jabo-bernardo
	 *
	 * @param position Translate the object towards the given position
	 *
	 * */
	public void translate(Vector2 position) {
		this.position.add(position);
	}

	/**
	 *
	 * @author jabo-bernardo
	 *
	 * @return Vector2
	 *
	 * */
	public Vector2 getPosition() {
		return position;
	}

	/**
	 *
	 * @author jabo-bernardo
	 *
	 * @return Vector2
	 *
	 * */
	public Vector2 getScale() {
		return scale;
	}

	/**
	 *
	 * @author jabo-bernardo
	 *
	 * @return float
	 *
	 * */
	public float getRotation() {
		return rotation;
	}

	/**
	 *
	 * @author jabo-bernardo
	 *
	 * @param position A Vector2 to be set as position
	 *
	 * */
	public void setPosition(Vector2 position) {
		this.position = position;
	}

	/**
	 *
	 * @author jabo-bernardo
	 *
	 * @param scale A Vector2 to be set as scale
	 *
	 * */
	public void setScale(Vector2 scale) {
		this.scale = scale;
	}

	/**
	 *
	 * @author jabo-bernardo
	 *
	 * @param rotation A float to be set as rotation
	 *
	 * */
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}
	
}
