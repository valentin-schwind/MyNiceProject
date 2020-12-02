package de.frauas.joop.animalfarm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class AnimalFarm {

	public static void main(String[] args) {
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Elephant("Mrs. Jumbo", 4000f, 25));
		animals.add(new Elephant("Jumbo", 100f));
		animals.add(new Lion("Moto", 220f, 5));
		animals.add(new Cat("Kitty", 4f, 5));
		animals.add(new Dog("Bello", 6f, 3));
		 
		
		for(Animal animal : animals)  
			System.out.println(animal.toString());  
		
		for(Animal animal : animals) {
			animal.does(Activity.SLEEPING); 
			if(animal instanceof Elephant)
				animal.eats(10, Grain.CORN); 
			if(animal instanceof Lion)
				animal.eats(5, Meat.FISH);
			if(animal instanceof Cat)
				animal.eats(1, Meat.FISH);
			animal.does(Activity.POO);
		}
		
		animals.get(1).does(Activity.PLAYING);
		
		for(Animal animal : animals)
			System.out.println(animal.toString());  		
		
		((Lion)animals.get(2)).fur = new Lion.Fur((Lion)animals.get(2), "white");
		((Lion)animals.get(2)).setName("Moto 2");
		((Lion)animals.get(2)).fur.showFur();
		
		System.out.println("\nCopying array...");
		List<Animal> animalBackup = new ArrayList<Animal>();
		for(Animal animal : animals) 
			animalBackup.add(animal.copy());
		for(Animal animal : animalBackup) 
			System.out.println(animal.toString());  
		
		System.out.println("\nErasing original array...");
		 
		animals = null;
		
		System.gc();

		System.out.println("\nSorted by age...");
		for(Animal animal : animalBackup) 
			System.out.println(animal.toString()); 

		animalBackup.sort((Animal a, Animal b) -> a.getWeight().compareTo(b.getWeight()));
		System.out.println("\nSorted by weight...");
		for(Animal animal : animalBackup) 
			System.out.println(animal.toString());  
		
		System.out.println("\nOwner gets Pets...");
		Owner farmOwner = new Owner("Old MacDonald");
		
		System.out.println("\nOwner feeds Pets...");
		for(Animal animal : animalBackup) { 
			if(animal instanceof Pet)
				farmOwner.addPet((Pet)animal);
			if(animal instanceof Pet)
				farmOwner.feedPet((Pet)animal,1, Meat.FISH); 
		} 

		System.out.println("\nList Pets...");
		for(Pet pet : farmOwner.getPets()) 
			System.out.println(pet.toString() + " has the owner \"" + pet.getOwner().getName() + "\"");  
		
		Collections.sort(animalBackup, new Comparator<Animal>() {
		    @Override
		    public int compare(Animal a, Animal b) {
		        return a.getAge().compareTo(b.getAge());
		    }
		});
		
	}

} 