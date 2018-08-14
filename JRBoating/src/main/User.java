package main;

public class User {
	
	private String username;
	private String password;
	private String passwordConfirmation;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private String userType;
	
	public User(String username, String password, String passwordConfirmation, String firstName, String lastName,
			String address, String phone, String userType) {
		this.username = username;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.userType = userType;
	}

	public Boolean passwordsMatch() {
		if (password.equals(passwordConfirmation)) {
			return true;
		}
		return false;
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

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
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
}