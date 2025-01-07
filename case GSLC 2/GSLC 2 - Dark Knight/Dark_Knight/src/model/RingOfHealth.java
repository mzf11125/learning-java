package model;

public class RingOfHealth extends Item{

	public RingOfHealth() {
		this.printDetail();
	}

	@Override
	public void printDetail() {
		System.out.println("  Increase player's HP by 40");
		
	}

}
