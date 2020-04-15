package dev.jabo.kree.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import dev.jabo.kree.Input;
import dev.jabo.kree.Scene;
import dev.jabo.kree.Transform;
import dev.jabo.kree.Vector2;

public class Button extends UserInterface {
	
	private boolean hovering;
	private boolean clicked;
	
	private Rectangle collider;
	
	private Point mousePoint;
	
	private Color backgroundColor, foregroundColor, hoverColor;
	
	private String text;
	
	private Font font;
	
	public Button(Scene parentScene, String text, Vector2 position, Vector2 scale) {
		
		this.text = text;
		
		transform = new Transform();
		transform.position = position;
		transform.scale = scale;
		
		backgroundColor = Color.GRAY;
		foregroundColor = Color.BLACK;
		hoverColor = Color.LIGHT_GRAY;
		
		font = new Font("Arial",  Font.PLAIN, 16);
		
		collider = new Rectangle();
		mousePoint = new Point();
		
		AddToScene(parentScene);
		
	}
	
	@Override
	public void Update() {
		
		collider.x = transform.position.x;
		collider.y = transform.position.y;
		collider.width = transform.scale.x;
		collider.height = transform.scale.y;
		
		mousePoint.x = Input.getMouse().x;
		mousePoint.y = Input.getMouse().y;
		
		if(collider.contains(mousePoint)) {
			hovering = true;
			if(!clicked) {
				if(Input.leftMouseDown) {
					clicked = true;
				} else {
					clicked = false;
				}
			}
		} else {
			hovering = false;
		}
	}

	@Override
	public void Render(Graphics g) {
		
		g.setColor(backgroundColor);
		if(hovering) {
			g.setColor(hoverColor);
		}
		g.fillRect(transform.position.x, transform.position.y, transform.scale.x, transform.scale.y);
		g.setColor(foregroundColor);
		g.setFont(font);
		g.drawString(text, transform.position.x + ((transform.scale.x / 2) - (g.getFontMetrics(font).stringWidth(text) / 2)), (transform.position.y + font.getSize()- 3) + ((transform.scale.y / 2) - (font.getSize() / 2)));
		
	}
	
	public boolean onClick() {
		return clicked;
	}
	
	public boolean onHover() {
		return hovering;
	}
	
	public void setColor(Color backgroundColor, Color foregroundColor, Color hoverColor) {
		this.backgroundColor = backgroundColor;
		this.foregroundColor = foregroundColor;
		this.hoverColor = hoverColor;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void setFont(Font font) {
		this.font = font;
	}

}
