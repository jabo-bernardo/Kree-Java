/*
 * 
 * Component 
 * parent of all GameObject components
 * 
 */

package dev.jabo.kree;

import java.awt.Graphics;

public abstract class Component {
	
	protected GameObject gameObject;

	protected String name;
	
	public abstract void Update();
	
	public abstract void Render(Graphics g);
	
}
