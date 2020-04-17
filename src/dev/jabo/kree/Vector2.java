package dev.jabo.kree;

public class Vector2 {
	
	public static Vector2 left = new Vector2(-1, 0);
	public static Vector2 right = new Vector2(1, 0);
	public static Vector2 up = new Vector2(0, -1);
	public static Vector2 down = new Vector2(0, 1);

	private int x, y;
	
	public Vector2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// Returns the distance between two vectors
	public static int distance(Vector2 v1, Vector2 v2) {
		return (int) Math.floor(
			Math.sqrt(
				Math.pow(v2.x - v1.x, 2) +
				Math.pow(v2.y - v1.y, 2)
			)
		);
	}
	
	// Vector Maths
	public void add(Vector2 vector) {
		this.x += vector.x;
		this.y += vector.y;
	}
	
	public void subtract(Vector2 vector) {
		this.x -= vector.x;
		this.y -= vector.y;
	}
	
	public void divide(Vector2 vector) {
		this.x /= vector.x;
		this.y /= vector.y;
	}
	
	public void multiply(Vector2 vector) {
		this.x *= vector.x;
		this.y *= vector.y;
	}
	
	// Move towards a vector
	public void moveTowards(Vector2 to, float speed) {
		if(to == null)
			return;
		
		if(distance(this, to) < speed) {
			return;
		}
		
	    int fX = to.x - this.x;
	    int fY = to.y - this.y;
	    float dist = (float) Math.sqrt( fX*fX + fY*fY );
	    float step = (speed / dist);
	    this.x += fX * step;
	    this.y += fY * step;
	
	}
	
	public void subtractX(int x) {
		this.x -= x;
	}
	
	public void subtractY(int y) {
		this.y -= y;
	}
	
	public void addX(int x) {
		this.x += x;
	}
	
	public void addY(int y) {
		this.y += y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return y;
	}
	
	public int getX() {
		return x;
	}
	
}
