package de.frauas.joop.myniceproject;

public class Grain extends Food { 
	
	public static final Grain CORN = new Grain(1000);
    public static final Grain WHEAT = new Grain(100);
    public static final Grain GRASS = new Grain(2000);
 
    private Grain(int calories) {
    	super(calories);
    } 

}

   