package com.ait.jrb;

public class User {
	// Use to set type integer, access with User.CUSTOMER_ID etc
	public final static int CUSTOMER_ID = 0;
	public final static int MANAGER_ID = 1;
	public final static int SKIPPER_ID = 2;
	public final static int FRONT_DESK_STAFF_ID = 3;

	private String username;
	private String password;
	//private String userType;	// ints work faster
	private int type;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;

	public User(String firstName, String lastName, String username, String password, String address, String phone,
			int type) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
/*
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
*/
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
