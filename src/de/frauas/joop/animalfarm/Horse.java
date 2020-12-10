package de.frauas.joop.animalfarm; 

public class Horse extends Animal {

	private String name;    

	public Horse(String name, float weight) {
		super(weight);
		this.age = 0;
		this.name = name;
	} 

	public Horse(String name, float weight, int age) {
		super(weight, age);
		this.name = name;
	}  
	
	public Horse (Horse horse) {
		super(horse.weight, horse.age);
		this.name = horse.name;
	}

	@Override
	public String toString(){
		return "Horse \"" + name + "\" with ID " + super.getId() + " is " + age + " y. old and weighs " + weight + " kg.";
	}
	
	@Override
	public void finalize(){
		super.finalize(); 
		System.out.println("Horse is dead.");
	} 

	@Override
	public void does(Activity activity) {
		super.weight += activity.kilograms();
		if(activity.calories() != 0)
			super.weight += activity.calories() / 70 ;
	}
 
	@Override
	public Animal copy() {
		return new Horse(this);
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
