package index;

public class Car extends Vehicle{

	String ACStatus;
	public Car(String plateNumber, String ownerName, String brandName, String ACStatus) {
		super(plateNumber, ownerName, brandName);
		this.ACStatus = ACStatus;
	}
	public String getACStatus() {
		return ACStatus;
	}
	public void setACStatus(String aCStatus) {
		ACStatus = aCStatus;
	}

}
