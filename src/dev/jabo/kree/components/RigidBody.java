package dev.jabo.kree.components;

import java.awt.Graphics;

import dev.jabo.kree.Component;
import dev.jabo.kree.GameObject;
import dev.jabo.kree.Vector2;

public class RigidBody extends Component {
	
	private float acceleration = 0.25f;
	private float xVelocity = 0;
	private float yVelocity = 0;
	private float mass = 1;
	public boolean gravity = true;
	
	public RigidBody() {
		this.name = "RigidBody";
	}
	
	@Override
	public void Update() {
		this.yVelocity += acceleration * mass;
		
		for(GameObject obj : gameObject.getParentScene().gameObjects) {
			if(obj.getID() == gameObject.getID())
				continue;
			if(obj.getComponent("Box Collider") != null) {
				Vector2 gameObjectPos = gameObject.getTransform().getPosition();
				Vector2 colliderObjectPos = obj.getTransform().getPosition();
				Vector2 gameObjectScale = gameObject.getTransform().getScale();
				Vector2 colliderObjectScale = obj.getTransform().getScale();
				
				if(gameObjectPos.getX() + gameObjectScale.getX() < colliderObjectPos.getX()) {
					continue;
				}
				
				if(gameObjectPos.getX() > colliderObjectPos.getX() + colliderObjectScale.getX()) {
					continue;
				}
				
				if(gameObjectPos.getY() > colliderObjectPos.getY() + colliderObjectScale.getY()) {
					continue;
				}
				
				if(gameObjectPos.getY() + gameObjectScale.getY() < colliderObjectPos.getY()) {
					continue;
				}
				
				if(gameObjectPos.getY() + gameObjectScale.getY() > colliderObjectPos.getY() + 16 && gameObjectPos.getY() < colliderObjectPos.getY() + colliderObjectScale.getY() - 16) {
					if(((BoxCollider) obj.getComponent("Box Collider")).trigger)
						continue;
					if(gameObjectPos.getX() < colliderObjectPos.getX()) {
						// Right
						gameObjectPos.setX(colliderObjectPos.getX() - gameObjectScale.getX() - 1);
						return;
					}
					if(gameObjectPos.getX() + gameObjectScale.getX() > colliderObjectPos.getX()) {
						// Left
						gameObjectPos.setX(colliderObjectPos.getX() + colliderObjectScale.getX() + 1);
						return;
					}
				}
				
				if(gameObjectPos.getY() + gameObjectScale.getY() >= colliderObjectPos.getY()) {
					if(((BoxCollider) obj.getComponent("Box Collider")).trigger)
						continue;
					// Bottom
					if(gameObjectPos.getY() + gameObjectScale.getY() > colliderObjectPos.getY()) {
						if(gameObjectPos.getY() + gameObjectScale.getY() < colliderObjectPos.getY() + 16) {
							if(gravity)
								gameObjectPos.subtractY(1);;
						}
					}
					// Top
					if(gameObjectPos.getY() + gameObjectScale.getY() > colliderObjectPos.getY()) {
						if(gameObjectPos.getY() + gameObjectScale.getY() > colliderObjectPos.getY() + colliderObjectScale.getY() - 16) {
							if(gravity)
								gameObjectPos.addY(1);;
						}
					}
					this.yVelocity = 0;
				}
			}
		}
		if(gravity)
			gameObject.getTransform().translate(new Vector2((int) xVelocity, (int) yVelocity));
		xVelocity = 0;
		
	}
	
	public void addHorizontalForce(int xForce) {
		this.xVelocity = xForce;
	}
	
	public void setMass(float mass) {
		this.mass = mass;
	}

	@Override
	public void Render(Graphics g) {
		
	}

}
