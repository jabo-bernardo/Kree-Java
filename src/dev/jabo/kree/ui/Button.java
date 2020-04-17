package dev.jabo.kree.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import dev.jabo.kree.Input;
import dev.jabo.kree.Scene;
import dev.jabo.kree.Sprite;
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
	
	private Sprite backgroundImage;
	
	public Button(Scene parentScene, String text, Vector2 position, Vector2 scale) {
		
		this.text = text;
		
		transform = new Transform();
		transform.setPosition(position);
		transform.setScale(scale);
		
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
		
		collider.x = transform.getPosition().getX();
		collider.y = transform.getPosition().getY();
		collider.width = transform.getScale().getX();
		collider.height = transform.getScale().getY();
		
		mousePoint.x = Input.getMouse().getX();
		mousePoint.y = Input.getMouse().getY();
		
		if(collider.contains(mousePoint)) {
			hovering = true;
			if(Input.leftMouseDown) {
				
				clicked = true;
				
			} else {
				
				clicked = false;
				
			}
		} else {
			hovering = false;
		}
	}

	@Override
	public void Render(Graphics g) {
		
		if(backgroundImage == null) {
			g.setColor(backgroundColor);
			if(hovering) {
				g.setColor(hoverColor);
			}
			g.fillRect(transform.getPosition().getX(), transform.getPosition().getY(), transform.getScale().getX(), transform.getScale().getY());
		} else {
			g.drawImage(backgroundImage.getImage(), transform.getPosition().getX(), transform.getPosition().getY(), transform.getScale().getX(), transform.getScale().getY(), null);
		}
		g.setColor(foregroundColor);
		g.setFont(font);
		g.drawString(text, transform.getPosition().getX() + ((transform.getScale().getX() / 2) - (g.getFontMetrics(font).stringWidth(text) / 2)), (transform.getPosition().getY() + font.getSize()- 3) + ((transform.getScale().getY() / 2) - (font.getSize() / 2)));
		
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
	
	public void setBackgroundImage(Sprite spr) {
		this.backgroundImage = spr;
	}

}
