package com.training.entity;

public class SignUpDetails {

	private String firstName;
	private String lastName;
	private String userType;
	private int id;
	private String password;
	public SignUpDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SignUpDetails(String firstName, String lastName, String userType, int id, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userType = userType;
		this.id = id;
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastnamel(String lastnamel) {
		this.lastName = lastnamel;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "SignUpDetails [firstName=" + firstName + ", lastName=" + lastName + ", userType=" + userType + ", id="
				+ id + ", password=" + password + "]";
	}
	
	
	
	
}
