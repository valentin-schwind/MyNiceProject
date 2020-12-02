package de.frauas.joop.animalfarm; 

public abstract class Animal {
	private static int counter = 0;
	private int id = 0;
	protected int age;
	protected float weight;

	Animal(){
		this.counter++;
		this.id = this.counter;
		System.out.println("Animal created."); 
	}
	
	Animal(Animal animal){
		this.age = animal.age;
		this.weight = animal.weight;
		this.counter = animal.counter;
		this.id = animal.id;
		System.out.println("Animal copied."); 
	}

	Animal(float weight) {
		this(); 
		this.weight = weight;
	}

	Animal(float weight, int age) {
		this();
		this.age = age;
		this.weight = weight;
	}

	public Float getWeight() {
		return weight;
	}

	public Integer getAge() {
		return age;
	}

	public Integer getId() {
		return id;
	} 

	@Override
	public void finalize() {
		System.out.println("Animal is dead.");
	}
	
	public abstract Animal copy();
	public abstract void does(Activity activity); 
	public abstract void eats(int kilogram, Food food); 
	
	/*
	@Override
	public int compareTo(Object o) { 
		Integer ageLhs = this.age;
		Integer ageRhs = ((Animal)o).getAge();
        return ageLhs.compareTo(ageRhs);
    }*/
}
