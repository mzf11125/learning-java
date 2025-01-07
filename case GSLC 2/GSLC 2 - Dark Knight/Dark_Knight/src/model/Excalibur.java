package model;

public class Excalibur extends Item{

	public Excalibur() {
		this.printDetail();
	}

	@Override
	public void printDetail() {
		System.out.println("  Increase the wearer's damage by 10%");
	}

}
