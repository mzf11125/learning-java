package models;

public class SoftDrink extends Drink {

	private String brand;

	public SoftDrink(String name, int price, String brand) {
		super(name, price);
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public void showDetails() {
		System.out.printf(" %10s %10d %10s\n", this.name, this.price, this.brand);
	}

}
