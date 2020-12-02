package de.frauas.joop.animalfarm;

public interface Pet {
	public abstract void setOwner(Owner owner);
	public abstract Owner getOwner();
	public abstract void eats(int kilogram, Food food);
}
