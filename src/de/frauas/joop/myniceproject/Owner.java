package de.frauas.joop.myniceproject;

import java.util.ArrayList;
import java.util.List;

public class Owner implements Person {
	private List<Pet> pets = new ArrayList<Pet>();
	private String name;

    public Owner(String name) {
    	this.name = name;
    }
    
    public void addPet(Pet pet) {
    	pet.setOwner(this);
    	pets.add(pet);
    }
    
    public List<Pet> getPets() {
    	return pets;
    }


    public void feedPet(Pet animal, int kilogram, Food food) {  
        animal.eats(kilogram, food);
    }

	@Override
	public String getName() { 
		return name;
	}
}
