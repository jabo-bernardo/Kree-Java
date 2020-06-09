package dev.jabo.kree;

public class Vector2 {
	
	public static Vector2 left = new Vector2(-1, 0);
	public static Vector2 right = new Vector2(1, 0);
	public static Vector2 up = new Vector2(0, -1);
	public static Vector2 down = new Vector2(0, 1);

	private float x, y;

	/**
	 *
	 * @author jabo-bernardo, NikolaTesla13
	 *
	 * @param x Horizontal position of a Vector
	 * @param y vertical position of a Vector
	 *
	 * */
	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 *
	 * @author jabo-bernardo, NikolaTesla13
	 *
	 * @param v1
	 * @param v2
	 *
	 * @return int Distance between two Vectors
	 *
	 * */
	public static int distance(Vector2 v1, Vector2 v2) {
		return (int) Math.floor(
			Math.sqrt(
				Math.pow(v2.x - v1.x, 2) +
				Math.pow(v2.y - v1.y, 2)
			)
		);
	}

	/**
	 *
	 * @param to Target location in the screen
	 * @param speed How fast the Vector will move towards another object
	 *
	 * */
	public void moveTowards(Vector2 to, float speed) {
		if(to == null)
			return;

		if(distance(this, to) < speed) {
			return;
		}

		float fX = to.x - this.x;
		float fY = to.y - this.y;
		float dist = (float) Math.sqrt( fX*fX + fY*fY );
		float step = (speed / dist);
		this.x += fX * step;
		this.y += fY * step;

	}
	
	/**
	 *
	 * @author jabo-bernardo, NikolaTesla13
	 *
	 * @param vector A vector to add to the existing Vector.
	 *
	 * @return Vector2
	 * */
	public Vector2 add(Vector2 vector) {
		this.x += vector.x;
		this.y += vector.y;
		return this;
	}

	/**
	 *
	 * @author jabo-bernardo, NikolaTesla13
	 *
	 * @param vector A vector to subtract to the existing Vector.
	 *
	 * @return Vector2
	 * */
	public Vector2 subtract(Vector2 vector) {
		this.x -= vector.x;
		this.y -= vector.y;
        return this;
    }

	/**
	 *
	 * @author jabo-bernardo, NikolaTesla13
	 *
	 * @param vector A vector to divide to the existing Vector.
	 *
	 * @return Vector2
	 * */
	public Vector2 divide(Vector2 vector) {
		this.x /= vector.x;
		this.y /= vector.y;
		return this;
	}

	/**
	 *
	 * @author jabo-bernardo, NikolaTesla13
	 *
	 * @param vector A vector to multiply to the existing Vector.
	 *
	 * @return Vector2
	 * */
	public Vector2 multiply(Vector2 vector) {
		this.x *= vector.x;
		this.y *= vector.y;
		return this;
	}

	/**
	 *
	 * @author jabo-bernardo, NikolaTesla13
	 *
	 * @param x A float to subtract in the vector's x
	 *
	 * @return Vector2
	 * */
	public Vector2 subtractX(float x) {
		this.x -= x;
		return this;
	}

	/**
	 *
	 * @author jabo-bernardo, NikolaTesla13
	 *
	 * @param y A float to subtract in the vector's y
	 *
	 * @return Vector2
	 * */
	public Vector2 subtractY(float y) {
		this.y -= y;
		return this;
	}

	/**
	 *
	 * @author jabo-bernardo, NikolaTesla13
	 *
	 * @param x A float to add in the vector's x
	 *
	 * @return Vector2
	 * */
	public Vector2 addX(float x) {
		this.x += x;
		return this;
	}

	/**
	 *
	 * @author jabo-bernardo, NikolaTesla13
	 *
	 * @param y A float to add in the vector's y
	 *
	 * @return Vector2
	 * */
	public Vector2 addY(float y) {
		this.y += y;
		return this;
	}

	/**
	 *
	 * @author jabo-bernardo, NikolaTesla13
	 *
	 * @param x A float to set in the vector's x
	 *
	 * @return Vector2
	 * */
	public Vector2 setX(float x) {
		this.x = x;
		return this;
	}

	/**
	 *
	 * @author jabo-bernardo, NikolaTesla13
	 *
	 * @param y A float to set in the vector's y
	 *
	 * @return Vector2
	 * */
	public Vector2 setY(float y) {
		this.y = y;
		return this;
	}

	/**
	 *
	 * @author jabo-bernardo, NikolaTesla13
	 *
	 * @return float
	 * */
	public float getY() {
		return y;
	}

	/**
	 *
	 * @author jabo-bernardo, NikolaTesla13
	 *
	 * @return float
	 * */
	public float getX() {
		return x;
	}
	
}
