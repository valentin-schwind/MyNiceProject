package de.frauas.joop.myniceproject;

public class Meat extends Food { 
	
	public static final Meat FISH = new Meat(1000);
	public static final Meat GROUNDMEAT = new Meat(1400);
	
    private Meat(int calories) {
    	super(calories);
    } 

}

   