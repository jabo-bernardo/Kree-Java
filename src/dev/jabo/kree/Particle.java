package dev.jabo.kree;

import java.awt.Graphics;
import java.awt.Point;

import dev.jabo.kree.components.ParticleSystem;

public class Particle {
	
	public static final int DIRECTION_360DEG = 0;
	public static final int DIRECTION_45DEG = 4;
	public static final int DIRECTION_90DEG = 1;
	public static final int DIRECTION_135DEG = 5;
	public static final int DIRECTION_180DEG = 2;
	public static final int DIRECTION_225DEG = 6;
	public static final int DIRECTION_270DEG = 3;
	public static final int DIRECTION_315DEG = 7;
	
	private ParticleSystem parent;
	
	private int direction;
	private int x, y;
	private int width, height;
	
	private float velocity;
	
	private int id;
	
	float xMove;
	float yMove;

	public Particle(ParticleSystem parent, int id) {
		
		this.parent = parent;
		this.id = id;
		
		Initialize();
	}
	
	public void Initialize() {
		
	}
	
	public void Update() {
		
		if(!inRange()) {
			Destroy();
		}
		
		if(parent.type == ParticleSystem.TYPE_CIRCULAR) {
			switch(direction) {
				case DIRECTION_360DEG:
					this.y -= velocity;
				break;
				case DIRECTION_90DEG:
					this.x += velocity;
				break;
				case DIRECTION_180DEG:
					this.y += velocity;
				break;
				case DIRECTION_270DEG:
					this.x -= velocity;
				break;
				case DIRECTION_45DEG:
					this.x += velocity;
					this.y -= velocity;
				break;
				case DIRECTION_135DEG:
					this.x += velocity;
					this.y += velocity;
				break;
				case DIRECTION_225DEG:
					this.x -= velocity;
					this.y -= velocity;
				break;
				case DIRECTION_315DEG:
					this.x -= velocity;
					this.y += velocity;
				break;
			}
		}
		
	}
	
	public void Render(Graphics g) {
		g.fillRect(x, y, width, height);
	}
	
	public boolean inRange() {
		if(parent.range.contains(new Point(x, y))) {
			return true;
		}
		return false;
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setVelocity(float vel) {
		this.velocity = vel;
	}
	
	public void setScale(int scale) {
		this.width = scale;
		this.height = scale;
	}
	
	public void setDirection(int dir) {
		this.direction = dir;
	}
	
	public void Destroy() {
		parent.particles[id] = null;
	}
	
}
