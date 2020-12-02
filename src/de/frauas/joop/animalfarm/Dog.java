package de.frauas.joop.animalfarm;

public class Dog extends Animal implements Pet {
	private String name; 
	private Owner owner;

	public Dog(String name, float weight) {
		super(weight);
		this.age = 0;
		this.name = name;
	} 

	public Dog(String name, float weight, int age) {
		super(weight, age);
		this.name = name;
	}  
	
	public Dog(Dog dog) {
		super(dog.weight, dog.age);
		this.name = dog.name;
	}

	@Override
	public String toString(){
		return "Dog" + name + "\" with ID " + super.getId() + " is " + age + " y. old and weighs " + weight + " kg.";
	}
	
	@Override
	public void finalize(){
		super.finalize(); 
		System.out.println("Dog is dead.");
	} 

	@Override
	public void does(Activity activity) {
		super.weight += activity.kilograms();
		if(activity.calories() != 0)
			super.weight += activity.calories() / 26f ;
	}
 
	@Override
	public Animal copy() {
		return new Dog(this);
	} 

	@Override
	public void eats(int kilogram, Food food) { 
		System.out.println(this.name + " eats " +  kilogram + " kg " + food.getClass().getSimpleName());
		super.weight += kilogram;
		if((food.calories() * kilogram) != 0)
			super.weight += (food.calories() * kilogram) / 26f ;
	 
	}

	@Override
	public Owner getOwner() {
		return owner;
	}

	@Override
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
}
