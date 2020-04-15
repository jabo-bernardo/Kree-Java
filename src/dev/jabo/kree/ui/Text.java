package dev.jabo.kree.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import dev.jabo.kree.Scene;
import dev.jabo.kree.Vector2;

public class Text extends UserInterface {

	private String text;
	
	private Font font = new Font("Times New Roman", Font.PLAIN, 14);
	
	private int height = 0;
	
	private boolean showBorder = false;
	
	private Color color = new Color(12, 12, 12);
	
	public Text(Scene parentScene, String text, Vector2 position, int width) {
		
		transform.setPosition(position);
		this.text = text;
		
		transform.setScale(new Vector2(width, 0));
		
		AddToScene(parentScene);
	}
	
	@Override
	public void Update() {
		
		
		
	}

	@Override
	public void Render(Graphics g) {
		if(showBorder) {
			g.drawRect(transform.getPosition().getX(), transform.getPosition().getY(), transform.getScale().getX(), height);
		}
		
		g.setFont(this.font);
		g.setColor(color);
		drawTextLineByLine(g);
	}
	
	public void drawTextLineByLine(Graphics g) {
		
		this.height = 0;
		
		String[] s = text.split(" ");
		
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
				line++;
				endl = false;
				curWidth = 0;
				col = 0;
				last = "";
			}
			last = str;
			g.drawString(str, transform.getPosition().getX() + (curWidth), transform.getPosition().getY() + font.getSize() * line);
			col++;
			this.height = font.getSize() * line;
		}
		
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void showBorder() {
		showBorder = true;
	}
	
	public void hideBorder() {
		showBorder = false;
	}
	
	public void setFont(Font font) {
		this.font = font;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}

}
