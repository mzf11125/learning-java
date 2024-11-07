package model;

import java.util.Vector;

public class member {
	private String name;
	private String ID;
	private Vector<toys> userStorage;
	
	public member(String name, String iD, Vector<toys> userStorage) {
		super();
		this.name = name;
		ID = iD;
		this.userStorage = userStorage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public Vector<toys> getUserStorage() {
		return userStorage;
	}
	public void setUserStorage(Vector<toys> userStorage) {
		this.userStorage = userStorage;
	}
}
