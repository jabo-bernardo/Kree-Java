package dev.jabo.kree.ui;

import java.awt.Graphics;

import dev.jabo.kree.Scene;
import dev.jabo.kree.Transform;
import dev.jabo.kree.Vector2;

public abstract class UserInterface {
	
	public Transform transform = new Transform();

	public abstract void Update();
	
	public abstract void Render(Graphics g);
	
	protected void AddToScene(Scene parentScene) {
		// Add UI to Scene
		UserInterface[] newUserInterfaceList = new UserInterface[parentScene.userInterfaces.length + 1];
		for(int i = 0; i < parentScene.userInterfaces.length; i++) {
			newUserInterfaceList[i] = parentScene.userInterfaces[i];
		}
		newUserInterfaceList[parentScene.userInterfaces.length] = this;
		parentScene.userInterfaces = newUserInterfaceList;
		// End
	}
	
	// Getters and Setters
	
	public Vector2 getScale() {
		return transform.scale;
	}
	
	public Vector2 getPosition() {
		return transform.position;
	}
	
	public void setPosition(Vector2 position) {
		transform.position = position;
	}
	
	public void setScale(Vector2 scale) {
		transform.scale = scale;
	}
	
}
