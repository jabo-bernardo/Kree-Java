package dev.jabo.kree;

public class Vector2 {
	
	public static Vector2 left = new Vector2(-1, 0);
	public static Vector2 right = new Vector2(1, 0);
	public static Vector2 up = new Vector2(0, -1);
	public static Vector2 down = new Vector2(0, 1);

	public int x, y;
	
	public Vector2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	static int Distance(Vector2 v1, Vector2 v2) {
		return (int) Math.floor(
			Math.sqrt(
				Math.pow(v2.x - v1.x, 2) +
				Math.pow(v2.y - v1.y, 2)
			)
		);
	}
	
	public void Add(Vector2 vector) {
		this.x += vector.x;
		this.y += vector.y;
	}
	
	public void Subtract(Vector2 vector) {
		this.x -= vector.x;
		this.y -= vector.y;
	}
	
	public void Divide(Vector2 vector) {
		this.x /= vector.x;
		this.y /= vector.y;
	}
	
	public void Multiply(Vector2 vector) {
		this.x *= vector.x;
		this.y *= vector.y;
	}
	
	public void MoveTowards(Vector2 to, float speed) {
		if(to == null)
			return;
		
		if(Distance(this, to) < speed) {
			return;
		}
		
	    int fX = to.x - this.x;
	    int fY = to.y - this.y;
	    float dist = (float) Math.sqrt( fX*fX + fY*fY );
	    float step = (speed / dist);
	    this.x += fX * step;
	    this.y += fY * step;
	
	}
	
}
