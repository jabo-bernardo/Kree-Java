package dev.jabo.kree;

import java.awt.Graphics;

public abstract class Component {
	
	// Instance of the parent
	protected GameObject gameObject;
	
	// Component name
	protected String name;
	
	// If true component will not update nor render
	public boolean disabled;
	
	public abstract void Update();
	
	public abstract void Render(Graphics g);
	
}
