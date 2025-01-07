package models;

public class Coffee extends Drink {

	private double caffeine;
	
	public Coffee(String name, int price, double caffeine) {
		super(name, price);
		this.caffeine = caffeine;
	}

	public double getCaffeine() {
		return caffeine;
	}

	public void setCaffeine(double caffeine) {
		this.caffeine = caffeine;
	}

	@Override
	public void showDetails() {
		System.out.printf(" %10s %10d %10.2f\n", this.name, this.price, this.caffeine);
	}

}
