package dev.jabo.kree.ui;

import java.awt.Color;
import java.awt.Graphics;

import dev.jabo.kree.Scene;
import dev.jabo.kree.Sprite;
import dev.jabo.kree.Vector2;

public class ProgressBar extends UserInterface {
	
	private float value = 100, maxValue = 150;
	
	private Color backgroundColor = new Color(25, 25, 25);
	private Color foregroundColor = new Color(255, 125, 25);
	
	private int padding = 4;
	
	private Sprite backgroundImage, foregroundImage;
	
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
		
		if(backgroundImage == null) {
			g.setColor(backgroundColor);
			g.fillRect((int)transform.getPosition().getX(), (int)transform.getPosition().getY(), (int)transform.getScale().getX(), (int)transform.getScale().getY());
		} else {
			g.drawImage(backgroundImage.getImage(), (int)transform.getPosition().getX(), (int)transform.getPosition().getY(), (int)transform.getScale().getX(), (int)transform.getScale().getY(), null);
		}
		
		if(foregroundImage == null) {
			g.setColor(foregroundColor);
			g.fillRect((int)transform.getPosition().getX() + padding, (int)transform.getPosition().getY() + padding, (int) ((value / maxValue) * (transform.getScale().getX() - (padding * 2))), (int)transform.getScale().getY() - (padding * 2));
		} else {
			g.drawImage(foregroundImage.getImage(), (int)transform.getPosition().getX() + padding, (int)transform.getPosition().getY() + padding, (int) ((value / maxValue) * (transform.getScale().getX() - (padding * 2))), (int)transform.getScale().getY() - (padding * 2), null);
		}
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
	
	public void setBackgroundImage(Sprite spr) {
		this.backgroundImage = spr;
	}
	
	public void setForegroundImage(Sprite spr) {
		this.foregroundImage = spr;
	}
	
	// Getters
	public float getValue() {
		return value;
	}
	
	public float getMaxValue() {
		return maxValue;
	}

}
