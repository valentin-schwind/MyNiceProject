package de.frauas.joop.animalfarm;

public enum Activity {
	SLEEPING(-1000, 0), 
	PLAYING(-6000, 0), 
	POO(0, -40),
	SEARCHINGFOOD(0, -40); 
	
	private int calories; 
	private int kilograms;  

	private Activity(int calories, int kilograms) { 
		this.calories = calories; 
		this.kilograms = kilograms; 
	}
	
	public int calories() { 
		return this.calories; 
	}
	
	public int kilograms() { 
		return this.kilograms; 
	}
}
