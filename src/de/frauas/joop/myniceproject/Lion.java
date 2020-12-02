package de.frauas.joop.myniceproject;

public class Lion extends Animal {
	public Fur fur;
	private String name;   

	public static class Fur {
		private String furColor;
		private Lion lion; 
		public Fur(Lion lion, String furColor) {
			this.furColor = furColor;
			this.lion = lion;
		}
		public void showFur() {
			System.out.println(lion.name + " has " + furColor.toLowerCase() + " fur!");
		}
	}

	public Lion(String name, float weight) {
		super(weight);
		this.age = 0;
		this.name = name; 
	} 

	public Lion(String name, float weight, int age) {
		super(weight, age);
		this.name = name; 
	}  
	
	public Lion(Lion lion) {
		super(lion.weight, lion.age);  
		this.name = lion.name;
		if(this.fur != null)
			this.fur = new Lion.Fur(lion, lion.fur.furColor);
	}

	@Override
	public String toString(){
		return "Lion \"" + name + "\" with ID " + super.getId() + " is " + age + " y. old and weighs " + weight + " kg.";
	}
	
	@Override
	public void finalize(){
		super.finalize(); 
		fur = null;
		System.out.println("Lion is dead.");
	} 

	@Override
	public void does(Activity activity) {
		super.weight += activity.kilograms();
		if(activity.calories() != 0)
			super.weight += activity.calories() / 70 ;
	}

	@Override 
	public void eats(int kilogram, Food food) {
		if(food instanceof Meat) {
			System.out.println(this.name + " eats " + kilogram + " kg " + food.getClass().getSimpleName());
			super.weight += kilogram;
			if((food.calories() * kilogram) != 0)
				super.weight += (food.calories() * kilogram) / 70 ;
		} else {
			System.out.println(this.name + " is a carnivore");
		}
	} 
	 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Animal copy() {
		return new Lion(this);
	}
}