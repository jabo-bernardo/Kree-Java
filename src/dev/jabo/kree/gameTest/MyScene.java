package dev.jabo.kree.gameTest;

import java.awt.Graphics;

import dev.jabo.kree.Audio;
import dev.jabo.kree.Game;
import dev.jabo.kree.Input;
import dev.jabo.kree.Scene;

public class MyScene extends Scene {
	
	private Audio audioOnClick = new Audio("Assets/myAudio.wav");
	
	public MyScene(Game game) {
		super(game);

	}

	@Override
	public void Initialize() {

		
		
	}

	@Override
	public void Update() {

		if(Input.mouseClicked) {
			if(!audioOnClick.IsPlaying()) {
				audioOnClick.play();
			}
		}
		
	}

	@Override
	public void Render(Graphics g) {

		
	}

}
