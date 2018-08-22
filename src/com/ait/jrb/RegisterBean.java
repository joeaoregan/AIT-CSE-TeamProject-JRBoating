package com.ait.jrb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ait.objects.User;

@ManagedBean(name = "registerBean")
@SessionScoped
public class RegisterBean {
	private int type;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private String bio;
	private String image;
	double pricePerDay;
	
	String message;

	User newUser;

	public RegisterBean() {
		newUser = null;
		resetFormVariables();
	}

	public void resetFormVariables() {
		type = User.CUSTOMER;	// Default, manager can change
		username = "";
		password = "";
		firstName = "";
		lastName = "";
		address = "";
		phone = "";
		
		// Skipper Only
		bio = "";
		pricePerDay = 0.0;	// Skipper
		

		image = "profile.jpg"; // Change in user account
		message = "";
	}

	public String createUser() {
		UserBean userBean = Helper.getBean("userBean", UserBean.class);
		newUser = new User(type, username, password, firstName, lastName, address, phone, bio, image, pricePerDay);
		message = userBean.addUser(newUser);
		resetFormVariables();
		return null;
	}
	
	public String getObscuredPassword() {
		return (firstLetter(password) + "..." + lastLetter(password));
	}

	public String register2() {
		return ("/customer/RegistrationVerify.xhtml");
	}

	private String firstLetter(String s) {
		return (s.substring(0, 1));
	}

	private String lastLetter(String s) {
		int length = s.length();
		return (s.substring(length - 1, length));
	}

	
	
	
	

	public String getFirstName() {
		return firstName;
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

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public User getNewUser() {
		return newUser;
	}

	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}
}
