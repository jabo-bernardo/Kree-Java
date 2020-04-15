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
	
	// Constructors
	public ProgressBar(Scene parentScene) {		
		
		transform.setPosition(new Vector2(0, 0));
		transform.setScale(new Vector2(128, 24));
		
		AddToScene(parentScene);		
	}
	
	public ProgressBar(Scene parentScene, Vector2 position) {
		
		transform.setPosition(position);		
		AddToScene(parentScene);		
	}
	
	public ProgressBar(Scene parentScene, Vector2 position, Vector2 scale) {
		
		transform.setPosition(position);
		transform.setScale(scale);
		
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
		g.fillRect(transform.getPosition().getX(), transform.getPosition().getY(), transform.getScale().getX(), transform.getScale().getY());		
		g.setColor(foregroundColor);
		g.fillRect(transform.getPosition().getX() + padding, transform.getPosition().getY() + padding, (int) ((value / maxValue) * (transform.getScale().getX() - (padding * 2))), transform.getScale().getY() - (padding * 2));
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
