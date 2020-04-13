package dev.jabo.kree.gameTest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import dev.jabo.kree.Game;
import dev.jabo.kree.Input;
import dev.jabo.kree.Scene;
import dev.jabo.kree.Vector2;
import dev.jabo.kree.ui.ProgressBar;
import dev.jabo.kree.ui.Text;
import dev.jabo.kree.ui.TextInput;

public class MyScene extends Scene {
	
	Text myText = new Text(this, "Health: 32", new Vector2(100, 128), 128);
	TextInput myTextInput = new TextInput(this, new Vector2(25, 25), new Vector2(128, 64));
	ProgressBar myBar = new ProgressBar(this);
	
	public MyScene(Game game) {
		super(game);

	}

	@Override
	public void Initialize() {
		
		
		
		myTextInput.setFont(new Font("Arial", Font.BOLD, 24));
		myText.setColor(new Color(255, 100, 100));
		
		
		
	}

	@Override
	public void Update() {
		myText.setText(myTextInput.getValue());
		
		if(Input.leftMouseDown) {
			myBar.add(0.5f);
		}
		
		if(Input.rightMouseDown) {
			myBar.subtract(0.5f);
		}
	}

	@Override
	public void Render(Graphics g) {
		
	}

}
