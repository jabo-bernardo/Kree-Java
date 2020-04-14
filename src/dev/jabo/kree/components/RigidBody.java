package dev.jabo.kree.components;

import java.awt.Graphics;

import dev.jabo.kree.Component;
import dev.jabo.kree.GameObject;
import dev.jabo.kree.Vector2;

public class RigidBody extends Component {
	
	private float acceleration = 0.25f;
	private float xVelocity = 0;
	private float yVelocity = 0;
	public float mass = 1;
	
	public RigidBody() {
		this.name = "RigidBody";
	}
	
	@Override
	public void Update() {
		this.yVelocity += acceleration * mass;
		
		for(GameObject obj : gameObject.getParentScene().gameObjects) {
			if(obj.id == gameObject.id)
				continue;
			if(obj.getComponent("Box Collider") != null) {
				if(((BoxCollider) obj.getComponent("Box Collider")).trigger)
					return;
				Vector2 gameObjectPos = gameObject.transform.position;
				Vector2 colliderObjectPos = obj.transform.position;
				Vector2 gameObjectScale = gameObject.transform.scale;
				Vector2 colliderObjectScale = obj.transform.scale;
				
				if(gameObjectPos.x + gameObjectScale.x < colliderObjectPos.x) {
					continue;
				}
				
				if(gameObjectPos.x > colliderObjectPos.x + colliderObjectScale.x) {
					continue;
				}
				
				if(gameObjectPos.y > colliderObjectPos.y + colliderObjectScale.y) {
					continue;
				}
				
				if(gameObjectPos.y + gameObjectScale.y < colliderObjectPos.y) {
					continue;
				}
				
				if(gameObjectPos.y + gameObjectScale.y > colliderObjectPos.y + 16 && gameObjectPos.y < colliderObjectPos.y + colliderObjectScale.y - 16) {
					if(gameObjectPos.x < colliderObjectPos.x) {
						// Right
						gameObjectPos.x = colliderObjectPos.x - gameObjectScale.x - 1;
						return;
					}
					if(gameObjectPos.x + gameObjectScale.x > colliderObjectPos.x) {
						// Left
						gameObjectPos.x = colliderObjectPos.x + colliderObjectScale.x + 1;
						return;
					}
				}
				
				if(gameObjectPos.y + gameObjectScale.y >= colliderObjectPos.y) {
					// Bottom
					if(gameObjectPos.y + gameObjectScale.y > colliderObjectPos.y) {
						if(gameObjectPos.y + gameObjectScale.y < colliderObjectPos.y + 16) {
							gameObjectPos.y -= 1;
						}
					}
					// Top
					if(gameObjectPos.y + gameObjectScale.y > colliderObjectPos.y) {
						if(gameObjectPos.y + gameObjectScale.y > colliderObjectPos.y + colliderObjectScale.y - 16) {
							gameObjectPos.y += 1;
						}
					}
					this.yVelocity = 0;
				}
			}
		}
		gameObject.transform.translate(new Vector2((int) xVelocity, (int) yVelocity));
		xVelocity = 0;
		
	}
	
	public void addHorizontalForce(int xForce) {
		this.xVelocity = xForce;
	}

	@Override
	public void Render(Graphics g) {
		
	}

}
