package main;

public class Employee extends Main{
	private String employeeID;
	private String employeeName;
	private int salary;
	
	public Employee(String employeeID, String employeeName, int salary) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.salary = salary;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	

	


}
