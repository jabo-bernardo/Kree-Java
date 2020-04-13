package dev.jabo.kree.ui;

import java.awt.Color;
import java.awt.Graphics;

import dev.jabo.kree.Scene;
import dev.jabo.kree.Vector2;

public class ProgressBar extends UserInterface {
	
	private Vector2 position = new Vector2(0, 0);
	private Vector2 scale = new Vector2(128, 32);
	
	private float value = 100, maxValue = 150;
	
	private Color backgroundColor = new Color(25, 25, 25);
	private Color foregroundColor = new Color(255, 125, 25);
	
	private int padding = 4;

	public ProgressBar(Scene parentScene) {
		
		
		
		AddToScene(parentScene);		
	}
	
	public ProgressBar(Scene parentScene, Vector2 position) {
		
		this.position = position;
		
		AddToScene(parentScene);		
	}
	
	public ProgressBar(Scene parentScene, Vector2 position, Vector2 scale) {
		
		this.position = position;
		this.scale = scale;
		
		AddToScene(parentScene);		
	}
	
	@Override
	public void Update() {
		if(value > maxValue) {
			value = maxValue; 
		}
		if(value <= 0) {
			value = 0; 
		}
	}

	@Override
	public void Render(Graphics g) {
		
		g.setColor(backgroundColor);
		g.fillRect(position.x, position.y, scale.x, scale.y);		
		g.setColor(foregroundColor);
		g.fillRect(position.x + padding, position.y + padding, (int) ((value / maxValue) * (scale.x - (padding * 2))), scale.y - (padding * 2));
	}
	
	// Misc
	public void Add(float value) {
		this.value += value;
	}
	
	public void Subtract(float value) {
		this.value -= value;
	}
	
	// Setters
	public void SetValue(float value) {
		this.value = value;
	}
	
	public void SetMaxValue(float maxValue) {
		this.maxValue = maxValue;
	}
	
	public void SetColor(Color foregroundColor, Color backgroundColor) {
		this.foregroundColor = foregroundColor;
		this.backgroundColor = backgroundColor;
	}
	
	public void SetPosition(Vector2 position) {
		this.position = position;
	}
	
	public void SetScale(Vector2 scale) {
		this.scale = scale;
	}
	
	public void SetPadding(int padding) {
		this.padding = padding;
	}
	
	// Getters
	public float GetValue() {
		return value;
	}
	
	public float GetMaxValue() {
		return maxValue;
	}
	
	public Vector2 GetPosition() {
		return position;
	}
	
	public Vector2 GetScale() {
		return scale;
	}

}
