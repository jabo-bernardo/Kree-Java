package dev.jabo.kree.ui;

import java.awt.Color;
import java.awt.Graphics;

import dev.jabo.kree.Scene;
import dev.jabo.kree.Vector2;

public class ProgressBar extends UserInterface {
	
	private float value = 100, maxValue = 150;
	
	private Color backgroundColor = new Color(25, 25, 25);
	private Color foregroundColor = new Color(255, 125, 25);
	
	private int padding = 4;

	public ProgressBar(Scene parentScene) {		
		
		transform.position = new Vector2(0, 0);
		transform.scale = new Vector2(128, 24);
		
		AddToScene(parentScene);		
	}
	
	public ProgressBar(Scene parentScene, Vector2 position) {
		
		transform.position = position;		
		AddToScene(parentScene);		
	}
	
	public ProgressBar(Scene parentScene, Vector2 position, Vector2 scale) {
		
		transform.position = position;
		transform.scale = scale;
		
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
		g.fillRect(transform.position.x, transform.position.y, transform.scale.x, transform.scale.y);		
		g.setColor(foregroundColor);
		g.fillRect(transform.position.x + padding, transform.position.y + padding, (int) ((value / maxValue) * (transform.scale.x - (padding * 2))), transform.scale.y - (padding * 2));
	}
	
	// Misc
	public void add(float value) {
		this.value += value;
	}
	
	public void subtract(float value) {
		this.value -= value;
	}
	
	// Setters
	public void setValue(float value) {
		this.value = value;
	}
	
	public void setMaxValue(float maxValue) {
		this.maxValue = maxValue;
	}
	
	public void setColor(Color foregroundColor, Color backgroundColor) {
		this.foregroundColor = foregroundColor;
		this.backgroundColor = backgroundColor;
	}
	
	public void setPadding(int padding) {
		this.padding = padding;
	}
	
	// Getters
	public float getValue() {
		return value;
	}
	
	public float getMaxValue() {
		return maxValue;
	}

}
