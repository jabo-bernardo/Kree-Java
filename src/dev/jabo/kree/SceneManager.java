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
			
			// Update Scene
			SceneManager.getScene().Update();
			
			// Update gameObject
			for(GameObject obj : activeScene.gameObjects) {
				obj.Update();
			}
			
			// Update UI
			for(UserInterface obj : activeScene.userInterfaces) {
				obj.Update();
			}
		}
	}
	
	public static void Render(Graphics g) {
		if(SceneManager.getScene() != null) {
			
			// Render Scene
			SceneManager.getScene().Render(g);
			
			// Render GameObject
			for(GameObject obj : activeScene.gameObjects) {
				obj.Render(g);
			}
			
			// Render UI
			for(UserInterface obj : activeScene.userInterfaces) {
				obj.Render(g);
			}
		}
	}
	
}
