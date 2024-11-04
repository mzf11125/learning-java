package index;

public class Vehicle {
	String plateNumber;
	String ownerName;
	String brandName;
	
	public Vehicle(String plateNumber, String ownerName, String brandName) {
		super();
		this.plateNumber = plateNumber;
		this.ownerName = ownerName;
		this.brandName = brandName;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	
}
