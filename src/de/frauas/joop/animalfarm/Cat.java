package de.frauas.joop.animalfarm;

public class Cat extends Animal implements Pet {
	private String name; 
	private Owner owner;

	public Cat(String name, float weight) {
		super(weight);
		this.age = 0;
		this.name = name;
	} 

	public Cat(String name, float weight, int age) {
		super(weight, age);
		this.name = name;
	}  
	
	public Cat(Cat cat) {
		super(cat.weight, cat.age);
		this.name = cat.name;
	}

	@Override
	public String toString(){
		return "Cat \"" + name + "\" with ID " + super.getId() + " is " + age + " y. old and weighs " + weight + " kg.";
	}
	
	@Override
	public void finalize(){
		super.finalize(); 
		System.out.println("Elephant is dead.");
	} 

	@Override
	public void does(Activity activity) {
		super.weight += activity.kilograms();
		if(activity.calories() != 0)
			super.weight += activity.calories() / 26f ;
	}
 
	@Override
	public Animal copy() {
		return new Cat(this);
	} 

	@Override
	public void eats(int kilogram, Food food) {
		if(food instanceof Meat) {
			System.out.println(this.name + " eats " +  kilogram + " kg " + food.getClass().getSimpleName());
			super.weight += kilogram;
			if((food.calories() * kilogram) != 0)
				super.weight += (food.calories() * kilogram) / 26f ;
		} else {
			System.out.println(this.name + " is a carnivore");
		}
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
