package dev.jabo.kree.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import dev.jabo.kree.Input;
import dev.jabo.kree.Scene;
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
	
	public TextInput(Scene parentScene, Vector2 position, Vector2 scale) {
		
		transform.position = position;
		transform.scale = scale;
		
		collider = new Rectangle(position.x, position.y, scale.x, scale.y);
		
		AddToScene(parentScene);
		
	}
	
	char lastKey = '\u0000';
	
	int timeBeforeClear = 0;
	@Override
	public void Update() {
		
		if(Input.leftMouseDown) {
			if(collider.contains(new Point(Input.getMouse().x, Input.getMouse().y))) {
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
		g.setColor(backgroundColor);
		if(selected) {
			g.setColor(selectedColor);
		}
		g.fillRect(transform.position.x, transform.position.y, transform.scale.x, transform.scale.y);
		g.setColor(foregroundColor);
		g.setFont(font);
		drawTextLineByLine(g);
	}
	
	public void drawTextLineByLine(Graphics g) {
		
		String[] s = value.split(" ");
		
		int line = 1;
		int col = 0;
		
		String last = "";
		boolean endl = false;
		
		int curWidth = 0;
		
		for(String str : s) {
			int width = g.getFontMetrics(font).stringWidth(last); 
			curWidth += width + (col * 2);
			if(curWidth > transform.scale.x) {
				endl = true;
			}
			if(endl) {
				return;
			}
			last = str;
			g.drawString(str, transform.position.x + (curWidth) + ((transform.scale.y - font.getSize()) / 2), transform.position.y + font.getSize() * line + ((transform.scale.y - font.getSize()) / 2));
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

}
