package de.frauas.joop.myniceproject;

public interface Pet {
	public abstract void setOwner(Owner owner);
	public abstract Owner getOwner();
	public abstract void eats(int kilogram, Food food);
}
