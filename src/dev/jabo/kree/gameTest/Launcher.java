package dev.jabo.kree.gameTest;

import dev.jabo.kree.Game;
import dev.jabo.kree.SceneManager;
import dev.jabo.kree.Window;

public class Launcher {

	public static void main(String[] args) {
		
		Game game = new Game(new Window("My Window", 800, 600));
		
		MyScene myScene = new MyScene(game);
		
		SceneManager.SetScene(myScene);
		
		game.start();
		
	}
	
}
