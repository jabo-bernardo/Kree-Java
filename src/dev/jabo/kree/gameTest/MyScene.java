package dev.jabo.kree.gameTest;

import java.awt.Graphics;

import dev.jabo.kree.Game;
import dev.jabo.kree.GameObject;
import dev.jabo.kree.Scene;
import dev.jabo.kree.components.Prefs;

public class MyScene extends Scene {

	private GameObject PrefsManager = new GameObject(this, "PrefsManager");

	public MyScene(Game game) {
		super(game);

	}

	@Override
	public void Initialize() {

		PrefsManager.addComponent(new Prefs());
		((Prefs) PrefsManager.getComponent("Prefs")).storeFloat("myStorage", 8);

	}


	@Override
	public void Update() {


	}

	@Override
	public void Render(Graphics g) {

	}

}