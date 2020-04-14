package dev.jabo.kree;

import java.awt.Graphics;

import dev.jabo.kree.ui.UserInterface;

public abstract class Scene {
	
	protected Game game;
	
	// GameObjects in scene
	public GameObject[] gameObjects = new GameObject[0];
	
	// UserInterfaces in scene
	public UserInterface[] userInterfaces = new UserInterface[0];
	
	public Scene(Game game) {
		this.game = game;
	}

	public abstract void Initialize();
	
	public abstract void Update();
	
	public abstract void Render(Graphics g);
	
	
	
}
