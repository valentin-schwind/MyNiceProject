package de.frauas.joop.animalfarm;

public abstract class Food { 
	private int calories;  

	protected Food(int calories) { 
		this.calories = calories;  
	}
	
	public int calories() { 
		return this.calories; 
	}
}
