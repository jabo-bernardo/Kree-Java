package dev.jabo.kree.gameTest;

import java.awt.Graphics;

import dev.jabo.kree.Game;
import dev.jabo.kree.GameObject;
import dev.jabo.kree.Input;
import dev.jabo.kree.Scene;
import dev.jabo.kree.Vector2;
import dev.jabo.kree.components.LookAtObject;
import dev.jabo.kree.components.MeshRenderer;

public class MyScene extends Scene {
	
	GameObject player = new GameObject(this, "Player");
	
	public MyScene(Game game) {
		super(game);

	}

	@Override
	public void Initialize() {
		
		player.setScale(new Vector2(32, 32));
		player.setPosition(new Vector2(400, 300));
		player.addComponent(new MeshRenderer());
		player.addComponent(new LookAtObject());
		
	}

	
	@Override
	public void Update() {
		((LookAtObject) player.getComponent("Look at Object")).setTarget(Input.getMouse());
	}

	@Override
	public void Render(Graphics g) {
			    
	}

}
