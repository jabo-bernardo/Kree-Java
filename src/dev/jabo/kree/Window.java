package dev.jabo.kree;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {

	// Main Window
	private JFrame window;
	// Drawing Pad
	private Canvas canvas;
	
	private String windowTitle;
	private int windowWidth, windowHeight;
	
	public Window(String windowTitle, int windowWidth, int windowHeight) {
		
		this.windowTitle = windowTitle;
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		
		createWindow();
		
	}
	
	private void createWindow() {
		
		window = new JFrame(windowTitle);
		window.setSize(new Dimension(windowWidth, windowHeight));
		window.setLocationRelativeTo(null); // Center the window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false); // Don't resize
		window.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(windowWidth, windowHeight));
		canvas.setMinimumSize(new Dimension(windowWidth, windowHeight));
		canvas.setMaximumSize(new Dimension(windowWidth, windowHeight));
		canvas.setFocusable(false); // false so we can receive user inputs
		
		window.add(canvas);
		window.pack();
		
	}
	
	public int getWindowWidth() {
		return windowWidth;
	}
	
	public int getWindowHeight() {
		return windowHeight;
	}
	
	public String getWindowTitle() {
		return windowTitle;
	}
	
	public JFrame getWindow() {
		return window;
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
}
