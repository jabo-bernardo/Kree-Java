package dev.jabo.kree;

import java.awt.Graphics;

import dev.jabo.kree.ui.UserInterface;

public class SceneManager {

	public static Scene activeScene;
	
	public static Scene GetScene() {
		return activeScene;
	}
	
	public static void SetScene(Scene scene) {
		scene.Initialize();
		activeScene = scene;
	}
	
	public static void Update() {
		if(SceneManager.GetScene() != null) {
			SceneManager.GetScene().Update();
			for(GameObject obj : activeScene.gameObjects) {
				obj.Update();
			}
			for(UserInterface obj : activeScene.userInterfaces) {
				obj.Update();
			}
		}
	}
	
	public static void Render(Graphics g) {
		if(SceneManager.GetScene() != null) {
			SceneManager.GetScene().Render(g);
			for(GameObject obj : activeScene.gameObjects) {
				obj.Render(g);
			}
			for(UserInterface obj : activeScene.userInterfaces) {
				obj.Render(g);
			}
		}
	}
	
}
