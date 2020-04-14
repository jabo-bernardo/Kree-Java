package dev.jabo.kree;

public class Random {
	
	/*
	 * 
	 * Handles all the randomness
	 * 
	 * */

	// Integer
	public static int range(int min, int max) {
		int rand = (int) (Math.random() * max);
		while (rand < min) {
			rand = (int) (Math.random() * max);
		}
		return rand;
	}
	
	// Float
	public static float range(float min, float max) {
		float rand = (float) (Math.random() * max);
		while (rand < min) {
			rand = (float) (Math.random() * max);
		}
		return rand;
	}
	
	// Double
	public static double range(double min, double max) {
		double rand = Math.random() * max;
		while(rand < min) {
			rand = Math.random() * max;
		}		
		return rand;
	}
	
	// Choose on given parameter
	public static Object choose(Object[] choice) {
		return choice[range(0, choice.length - 1)];
	}
	
}
