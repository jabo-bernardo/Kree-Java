package dev.jabo.kree;

public class Random {

	public static int Range(int min, int max) {
		int rand = (int) (Math.random() * max);
		while (rand < min) {
			rand = (int) (Math.random() * max);
		}
		return rand;
	}
	
	public static float Range(float min, float max) {
		float rand = (float) (Math.random() * max);
		while (rand < min) {
			rand = (float) (Math.random() * max);
		}
		return rand;
	}
	
	public static double Range(double min, double max) {
		double rand = Math.random() * max;
		while(rand < min) {
			rand = Math.random() * max;
		}		
		return rand;
	}
	
}
