package com.ait.objects;

public class User {
	public final static int CUSTOMER = 0;
	public final static int MANAGER = 1;
	public final static int SKIPPER = 2;
	public final static int FRONT_DESK_STAFF = 3;

	private int type;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private String bio; // Information about the user (Skipper)
	private String image;
	private double pricePerDay; // Price to hire (Skipper)
	private boolean canEdit; // editing forms

	// Constructor
	public User(int type, String username, String password, String firstName, String lastName, String address,
			String phone, String bio, String image, double pricePerDay) {
		this.type = type;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.bio = bio;
		this.image = image;
		this.pricePerDay = pricePerDay;
	}

	public boolean equals(String username) {
		if (this.username == username) {
			return true;
		}
		else return false;
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

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public boolean getCanEdit() {
		return canEdit;
	}

	public void setCanEdit(boolean canEdit) {
		this.canEdit = canEdit;
	}
}