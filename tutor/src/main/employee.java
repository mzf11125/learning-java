package main;

public class employee {

	private int employeeID;
	private String gender;
	private int salary;
	
	public employee(int employeeID, String gender, int salary) {
		super();
		this.employeeID = employeeID;
		this.gender = gender;
		this.salary = salary;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

}
