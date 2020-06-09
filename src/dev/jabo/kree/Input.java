package dev.jabo.kree;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import dev.jabo.kree.components.BoxCollider;

public class Input implements KeyListener, MouseMotionListener, MouseListener {
	
	/*
	 * 
	 * Handles all the user input
	 * 
	 * TODO: Mouse Scroll
	 * 
	 * */
	
	// Key related
	public static boolean[] keys = new boolean[256];
	public static boolean keyPressed = false;
	public static char lastKey; // Last key pressed
	
	// Mouse related
	public static boolean mouseClicked;	
	public static int mouseX, mouseY;
	public static boolean leftMouseDown;
	public static boolean middleMouseDown;
	public static boolean rightMouseDown;

	@Override
	public void keyPressed(KeyEvent arg0) {
		keys[arg0.getKeyCode()] = true;
		lastKey = (char) arg0.getKeyCode();
		keyPressed = true;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		keys[arg0.getKeyCode()] = false;
		keyPressed = false;		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// 
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// 
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// 
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// 
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		mouseClicked = true;
		if(arg0.getButton() == MouseEvent.BUTTON1) {
			leftMouseDown = true;
		}
		if(arg0.getButton() == MouseEvent.BUTTON2) {
			middleMouseDown = true;
		}
		if(arg0.getButton() == MouseEvent.BUTTON3) {
			rightMouseDown = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		mouseClicked = false;
		leftMouseDown = false;
		middleMouseDown = false;
		rightMouseDown = false;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		mouseX = arg0.getX();
		mouseY = arg0.getY();
	}
	
	// Returns the mouse position in Vector2
	public static Vector2 getMouse() {
		return new Vector2(mouseX, mouseY);
	}
	
	// Key pressed?
	public static boolean isKeyPressed(int keyCode) {
		return keys[keyCode];
	}
	
	// Is mouse in GameObject's scale and position
	public static boolean mouseIn(GameObject obj) {		
		if(obj.getComponent("Box Collider") != null) {
			BoxCollider col = (BoxCollider) obj.getComponent("Box Collider");
			if(col.getCollider().contains(new Point((int)getMouse().getX(), (int)getMouse().getY()))) {
				return true;
			}
		}		
		return false;		
	}
	
}
