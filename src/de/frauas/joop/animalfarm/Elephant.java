package de.frauas.joop.animalfarm; 

public class Elephant extends Animal {

	private String name;    

	public Elephant(String name, float weight) {
		super(weight);
		this.age = 0;
		this.name = name;
	} 

	public Elephant(String name, float weight, int age) {
		super(weight, age);
		this.name = name;
	}  
	
	public Elephant(Elephant elephant) {
		super(elephant.weight, elephant.age);
		this.name = elephant.name;
	}

	@Override
	public String toString(){
		return "Elephant \"" + name + "\" with ID " + super.getId() + " is " + age + " y. old and weighs " + weight + " kg.";
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
			super.weight += activity.calories() / 70 ;
	}
 
	@Override
	public Animal copy() {
		return new Elephant(this);
	} 

	@Override
	public void eats(int kilogram, Food food) {
		if(food instanceof Grain) {
			System.out.println(this.name + " eats " +  kilogram + " kg " + food.getClass().getSimpleName());
			super.weight += kilogram;
			if((food.calories() * kilogram) != 0)
				super.weight += (food.calories() * kilogram) / 70 ;
		} else {
			System.out.println(this.name + " is a herbivore");
		}
	}

}
