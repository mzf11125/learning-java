package model;

public class physicalToys extends toys{
	private int availableCopies;
	
	public physicalToys(String code, String title, int availableCopies) {
		super(code, title);
		this.availableCopies = availableCopies;
	}

	public int getAvailableCopies() {
		return availableCopies;
	}

	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
	}
}
