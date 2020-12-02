package de.frauas.joop.myniceproject;

public abstract class Food { 
	private int calories;  

	protected Food(int calories) { 
		this.calories = calories;  
	}
	
	public int calories() { 
		return this.calories; 
	}
}
