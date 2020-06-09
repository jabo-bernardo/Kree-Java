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

	/**
	 *
	 * @author jabo-bernardo
	 * @version v1.0
	 *
	 * @param windowTitle The text that will be shown in the top left of the window
	 * @param windowWidth The X dimension of the window
	 * @param windowHeight The Y dimension of the window
	 *
	 *
	 * */
	public Window(String windowTitle, int windowWidth, int windowHeight) {
		
		this.windowTitle = windowTitle;
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		
		createWindow();
		
	}

	/**
	 *
	 * @author jabo-bernardo
	 * @version v1.0
	 *
	 * */
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

	/**
	 *
	 * @author jabo-bernardo
	 * @version v1.0
	 *
	 * @return int The X dimension of the screen
	 *
	 * */
	public int getWindowWidth() {
		return windowWidth;
	}

	/**
	 *
	 * @return int The Y dimension of the screen
	 *
	 * */
	public int getWindowHeight() {
		return windowHeight;
	}

	/**
	 *
	 * @author jabo-bernardo
	 * @version v1.0
	 *
	 * @return String The title of the window
	 *
	 * */
	public String getWindowTitle() {
		return windowTitle;
	}

	/**
	 *
	 * @author jabo-bernardo
	 * @version v1.0
	 *
	 * @return JFrame The window object
	 *
	 * */
	public JFrame getWindow() {
		return window;
	}

	/**
	 *
	 * @author jabo-bernardo
	 * @version v1.0
	 *
	 * @return Canvas The drawing board
	 *
	 * */
	public Canvas getCanvas() {
		return canvas;
	}
	
}
