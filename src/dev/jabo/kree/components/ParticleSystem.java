package dev.jabo.kree.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import dev.jabo.kree.Circle;
import dev.jabo.kree.Component;
import dev.jabo.kree.GameObject;
import dev.jabo.kree.Particle;
import dev.jabo.kree.Random;

public class ParticleSystem extends Component {
	
	public static final int TYPE_CIRCULAR = 0;
	
	public int type;
	
	private int particleCount;
	
	public Particle[] particles;
	
	private int x, y;
	private int minimumSize, maximumSize;
	
	private int minimumVelocity, maximumVelocity;
	
	private Color color;
	
	public Circle range;
	
	private boolean alive;
	
	public ParticleSystem(GameObject gameObject, int particleType, int minimumSize, int maximumSize, int minimumVelocity, int maximumVelocity, int particleCount, int particleRange, Color color) {
		
		this.name = "Particle System";
		
		this.gameObject = gameObject;
		
		this.type = particleType;
		
		this.particleCount = particleCount;
		
		this.x = gameObject.transform.position.x;
		this.y = gameObject.transform.position.y;
		
		this.minimumSize = minimumSize;
		this.maximumSize = maximumSize;
		
		this.minimumVelocity = minimumVelocity;
		this.maximumVelocity = maximumVelocity;
		
		this.color = color;
		
		this.range = new Circle(new Point(this.x, this.y), particleRange);
		
		Initialize();
	}
	
	public void Initialize() {
		
		particles = new Particle[particleCount];		
		
		for(int  i = 0; i < particles.length; i++) {
			particles[i] = new Particle(this, i);
			particles[i].setVelocity(Random.range(minimumVelocity, maximumVelocity + 1));
			particles[i].setScale(Random.range(minimumSize, maximumSize + 1));
			particles[i].setPosition(x, y);
			if(this.type == ParticleSystem.TYPE_CIRCULAR) {
				
				particles[i].setDirection(Random.range(0, 8));
				
			}
			
		}
		
	}
	
	int particleLeft = 0;
	
	public void Update() {		
		particleLeft = 0;
		alive = true;
		for (Particle particle : particles) {
			if(particle == null) continue;			
			particle.Update();
			particleLeft++;
		}
		if(particleLeft == 0) {
			alive = false;
		}
	}
	
	public void Render(Graphics g) {
		for (Particle particle : particles) {
			if(particle == null) continue;
			g.setColor(color);
			particle.Render(g);
		}
	}
	
	public boolean isAlive() {
		return alive;
	}

}
