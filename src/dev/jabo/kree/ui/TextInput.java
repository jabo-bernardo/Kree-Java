package dev.jabo.kree.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import dev.jabo.kree.Input;
import dev.jabo.kree.Scene;
import dev.jabo.kree.Sprite;
import dev.jabo.kree.Vector2;

public class TextInput extends UserInterface {
	
	private Color backgroundColor = new Color(200, 200, 200);
	private Color foregroundColor = Color.BLACK;
	private Color selectedColor = new Color(225, 225, 225);
	
	private int charLimit = 14;
	
	private String value = "";
	
	private Rectangle collider;
	
	private boolean selected = false;
	
	private Font font = new Font("Arial", Font.BOLD, 16);
	
	private Sprite backgroundImage;
	
	public TextInput(Scene parentScene, Vector2 position, Vector2 scale) {
		
		transform.setPosition(position);
		transform.setScale(scale);
		
		collider = new Rectangle(position.getX(), position.getY(), scale.getX(), scale.getY());
		
		AddToScene(parentScene);
		
	}
	
	char lastKey = '\u0000';
	
	int timeBeforeClear = 0;
	@Override
	public void Update() {
		
		collider.x = transform.getPosition().getX();
		collider.y = transform.getPosition().getY();
		collider.width = transform.getScale().getX();
		collider.height = transform.getScale().getY();
		
		if(Input.leftMouseDown) {
			if(collider.contains(new Point(Input.getMouse().getX(), Input.getMouse().getY()))) {
				selected = true;
			} else {
				selected = false;
			}
		}
		
		timeBeforeClear++;
		if(timeBeforeClear > 40) {
			lastKey = '\u0000';
			timeBeforeClear = 0;
		}
		
		if(selected) {
			if(Input.keyPressed) {
				if(Input.lastKey == lastKey) {return;}
				if(Input.lastKey == '') {
					if(this.value.length() > 0) {
						this.value =this. value.substring(0, value.length() - 1);
						lastKey = Input.lastKey;
					}
					return;
				}
				if(this.value.length() < charLimit) {
					this.value += Input.lastKey;
					lastKey = Input.lastKey;
				}
			}
		}
		
	}

	@Override
	public void Render(Graphics g) {
		if(backgroundImage == null) {
			g.setColor(backgroundColor);
			if(selected) {
				g.setColor(selectedColor);
			}
			g.fillRect(transform.getPosition().getX(), transform.getPosition().getY(), transform.getScale().getX(), transform.getScale().getY());
		} else {
			g.drawImage(backgroundImage.getImage(), transform.getPosition().getX(), transform.getPosition().getY(), transform.getScale().getX(), transform.getScale().getY(), null);
		}
		g.setColor(foregroundColor);
		g.setFont(font);
		drawTextLineByLine(g);
	}
	
	private void drawTextLineByLine(Graphics g) {
		
		String[] s = value.split(" ");
		
		int line = 1;
		int col = 0;
		
		String last = "";
		boolean endl = false;
		
		int curWidth = 0;
		
		for(String str : s) {
			int width = g.getFontMetrics(font).stringWidth(last); 
			curWidth += width + (col * 2);
			if(curWidth > transform.getScale().getX()) {
				endl = true;
			}
			if(endl) {
				return;
			}
			last = str;
			g.drawString(str, transform.getPosition().getX() + (curWidth) + ((transform.getScale().getY() - font.getSize()) / 2), transform.getPosition().getY() + font.getSize() * line + ((transform.getScale().getY() - font.getSize()) / 2));
			col++;
		}
		
	}
	
	public void setFont(Font font) {
		this.font = font;
	}
	
	public void limitCharacter(int limit) {
		charLimit = limit;
	}
	
	public void setColor(Color backgroundColor, Color foregroundColor, Color selectedColor) {
		this.backgroundColor = backgroundColor;
		this.foregroundColor = foregroundColor;
		this.selectedColor = selectedColor;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setBackgroundImage(Sprite spr) {
		this.backgroundImage = spr;
	}

}
