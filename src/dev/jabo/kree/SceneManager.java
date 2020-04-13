package dev.jabo.kree;

import java.awt.Graphics;

import dev.jabo.kree.ui.UserInterface;

public class SceneManager {

	public static Scene activeScene;
	
	public static Scene getScene() {
		return activeScene;
	}
	
	public static void setScene(Scene scene) {
		scene.Initialize();
		activeScene = scene;
	}
	
	public static void Update() {
		if(SceneManager.getScene() != null) {
			SceneManager.getScene().Update();
			for(GameObject obj : activeScene.gameObjects) {
				obj.Update();
			}
			for(UserInterface obj : activeScene.userInterfaces) {
				obj.Update();
			}
		}
	}
	
	public static void Render(Graphics g) {
		if(SceneManager.getScene() != null) {
			SceneManager.getScene().Render(g);
			for(GameObject obj : activeScene.gameObjects) {
				obj.Render(g);
			}
			for(UserInterface obj : activeScene.userInterfaces) {
				obj.Render(g);
			}
		}
	}
	
}
