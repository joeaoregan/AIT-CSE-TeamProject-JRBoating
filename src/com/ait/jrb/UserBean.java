package com.ait.jrb;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ait.objects.User;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	private ArrayList<User> userList;

	// Removed extra and duplicate variables
	private int type;	// Default = User.CUSTOMER
	private String username;
	private String password;
	private String passwordConfirmation;	// NOT NEEDED
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private String bio;
	private String image;
	Double pricePerDay;	// Set the price to hire a Skipper for the day
			
	public UserBean() {		
		userList = new ArrayList<User>();
		
		resetBeanVars();	// Initialise / clear variables

		User root = new User(User.MANAGER, "root", "admin", "admin", "MasterUser", "Administrator", 
				"Athlone", "1234567", "", "profile.jpg", 0.0);
		User joe = new User(User.MANAGER, "joe1", "asdf", "asdf", "Joe", "O'Regan", 
				"Thurles", "0871234567", "", "profile.jpg", 0.0);
		User ademola = new User(User.MANAGER, "ademola", "asdf", "asdf", "Ademola", "Alade", 
				"Athlone", "1234567", "", "profile.jpg", 0.0);
		User elaine = new User(User.CUSTOMER, "elaine", "asdf", "asdf", "Elaine", "Santos", 
				"Athlone", "0870246810", "", "profile.jpg", 0.0);
		User kiev = new User(User.SKIPPER, "kiev", "asdf", "asdf", "Kiev", "Reynolds", 
				"Athlone", "0873691215", "", "profile.jpg", 0.0);
		User sorcha = new User(User.FRONT_DESK_STAFF, "sorcha", "asdf", "asdf", "Sorcha", "Bruton", 
				"Athlone", "0870481216", "", "profile.jpg", 0.0);

		addUser(root);
		addUser(joe);
		addUser(ademola);
		addUser(elaine);
		addUser(kiev);
		addUser(sorcha);
	}
	
	/*
	 * Initialise / Reset bean variables to clear the form data
	 */
	public void resetBeanVars() {
		this.type = User.CUSTOMER;	// default type (Manager can change from their view)
		username = "";
		password = "";
		passwordConfirmation = "";
		firstName = "";
		lastName = "";
		address = "";
		phone = "";
		image = "";
		bio = "";
		pricePerDay = 0.0;
	}

	/*
	 * Displays a string instead of using the integer user type
	 */
	public String displayType(int type) {
		switch (type) {
		case User.MANAGER:
			return "Manager";
		case User.CUSTOMER:
			return "Customer";
		case User.FRONT_DESK_STAFF:
			return "Front Desk Staff";
		case User.SKIPPER:
			return "Skipper";
		default:
			return null;
		}
	}
	
	/*
	 * Save form update / edit details
	 */
	public String saveAction() {
		UserBean userBean = Helper.getBean("userBean", UserBean.class);
		for (User user : userBean.getUserList()) {
			user.setCanEdit(false);
		}
		return null;
	}
	
	/*
	 * Find a user in the list of users using a username If a user is not found
	 * return null
	 */
	public User getUserByUsername(String username) {
		for (User findUser : userList) {
			if (findUser.getUsername().equals(username)) {
				return findUser;
			}
		}

		return null;
	}

	public String addUser(User user) {
		//System.out.println("Customer "+ users.size());
		if (user== null) {
			return "INVALID USER";
		}
		userList.add(user);
		return "USER ADDED OK";
	}
	
	public boolean checkUniqueUsername(String username) {
		for (User user : userList) {
			if (user.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}

	public int userCount() {
		return userList.size();
	}
	
	public String registerCustomerHandler() {
		String msg = "Username Already Exist";
		
		if (!password.equals(passwordConfirmation)) {
			msg = "PasswordDon't match";
		} else if (!checkUniqueUsername(username)) {
			User user = new User(User.CUSTOMER, username, password, passwordConfirmation, 
					firstName, lastName, address, phone, bio, image, pricePerDay);
			addUser(user);
			msg = "OK";
		}
		return msg;
	}

	/* GETTERS AND SETTERS */
	
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

	public Double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
}

/*
	public boolean login(String username, String password) {
		System.out.println("Customer "+ userList.size());
		for (User user : userList) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
*/