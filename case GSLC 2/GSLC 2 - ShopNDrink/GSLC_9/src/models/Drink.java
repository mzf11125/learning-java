package models;

import interfaces.Displayable;

public abstract class Drink implements Displayable {

	protected String name;
	protected int price;
	
	public Drink(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public abstract void showDetails();

}
