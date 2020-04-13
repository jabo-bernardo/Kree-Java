package dev.jabo.kree.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import dev.jabo.kree.Scene;
import dev.jabo.kree.Vector2;

public class Text extends UserInterface {

	private String text;
	
	private Font font = new Font("Times New Roman", Font.PLAIN, 14);
	
	private int width = 0;
	private int height = 0;
	
	private boolean showBorder = false;
	
	private Color color = Color.black;
	
	public Text(Scene parentScene, String text, Vector2 position, int width) {
		this.position = position;
		this.text = text;
		
		this.width = width;
		
		AddToScene(parentScene);
	}
	
	@Override
	public void Update() {
		
		
		
	}

	@Override
	public void Render(Graphics g) {
		if(showBorder) {
			g.drawRect(position.x, position.y, width, height);
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
			if(curWidth > this.width) {
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
			g.drawString(str, this.position.x + (curWidth), this.position.y + font.getSize() * line);
			col++;
			this.height = font.getSize() * line;
		}
		
	}
	
	public void SetColor(Color color) {
		this.color = color;
	}
	
	public void ShowBorder() {
		showBorder = true;
	}
	
	public void HideBorder() {
		showBorder = false;
	}
	
	public void SetFont(Font font) {
		this.font = font;
	}
	
	public void SetText(String text) {
		this.text = text;
	}
	
	public String GetText() {
		return text;
	}

}
