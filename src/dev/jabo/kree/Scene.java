package dev.jabo.kree;

import java.awt.Graphics;

public abstract class Scene {
	
	protected Game game;
	
	public GameObject[] gameObjects = new GameObject[0];
	
	public Scene(Game game) {
		this.game = game;
	}

	public abstract void Initialize();
	
	public abstract void Update();
	
	public abstract void Render(Graphics g);
	
	
	
}
