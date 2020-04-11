package dev.jabo.kree.components;

import java.awt.Graphics;

import dev.jabo.kree.Animation;
import dev.jabo.kree.Component;
import dev.jabo.kree.Debug;

public class Animator extends Component {

	private Animation[] allAnimation;
	private Animation activeAnimation;
	
	public Animator(Animation[] animationData) {
		this.allAnimation = animationData;
	}
	
	@Override
	public void Update() {
		if(activeAnimation != null) 
			activeAnimation.Update();
	}

	@Override
	public void Render(Graphics g) {
		if(activeAnimation != null) {
			g.drawImage(activeAnimation.getCurrentFrame(), gameObject.transform.position.x, gameObject.transform.position.y, gameObject.transform.scale.x, gameObject.transform.scale.y, null);
		}
	}
	
	public void SetActiveAnimation(String name) {
		for(Animation anim : allAnimation) {
			if(anim.GetAnimationName() == name) {
				activeAnimation = anim;
			}
		}
	}

}
