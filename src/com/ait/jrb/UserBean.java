package com.ait.jrb;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ait.objects.User;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<User> userList;

	// Removed extra and duplicate variables
	private int type; // Default = User.CUSTOMER
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private String bio;
	private String image;
	Double pricePerDay; // Set the price to hire a Skipper for the day

	public UserBean() {
		userList = new ArrayList<User>();

		resetBeanVars(); // Initialise / clear variables

		User root = new User(User.MANAGER, "root", "admin", "MasterUser", "Administrator", "Athlone", "1234567", "",
				"profile.jpg", 0.0);
		User joe = new User(User.MANAGER, "joe1", "asdf", "Joe", "O'Regan", "Thurles", "0871234567", "", "profile.jpg",
				0.0);
		User ademola = new User(User.MANAGER, "ademola", "asdf", "Ademola", "Alade", "Athlone", "1234567", "",
				"profile.jpg", 0.0);
		User elaine = new User(User.CUSTOMER, "elaine", "asdf", "Elaine", "Santos", "Athlone", "0870246810", "",
				"profile.jpg", 0.0);
		User kiev = new User(User.SKIPPER, "kiev", "asdf", "Kiev", "Reynolds", "Athlone", "0873691215", "",
				"profile.jpg", 0.0);
		User sorcha = new User(User.FRONT_DESK_STAFF, "sorcha", "asdf", "Sorcha", "Bruton", "Athlone", "0870481216", "",
				"profile.jpg", 0.0);

		addUser(root);
		addUser(joe);
		addUser(ademola);
		addUser(elaine);
		addUser(kiev);
		addUser(sorcha);
	}

	public String resetLoginInfo() {
		username = "";
		firstName = "";
		lastName = "";
		address = "";
		
		return "LOGIN DETAILS RESET";
	}
	
	/*
	 * Initialise / Reset bean variables to clear the form data
	 */
	public void resetBeanVars() {
		this.type = User.CUSTOMER; // default type (Manager can change from their view)
		username = "";
		password = "";
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
	 * XXXXXXX HELPER XXXXXXXXXXX Save form update / edit details
	 */
	public String saveAction() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Successful", "Details Saved"));
		
		UserBean userBean = Helper.getBean("userBean", UserBean.class);
		for (User user : userBean.getUserList()) {
			user.setCanEdit(false);
		}
		
		return null;
	}
	
	public String addUser(User user) {
		if (user == null) {
			return "INVALID USER";
		}
		
		if (!checkUniqueUsername(user.getUsername())) {
			userList.add(user);	
			return "USER ADDED OK";
		}
		
		return "USERNAME NOT UNIQUE";
	}
	
	public String removeUserHandler(User user) {
		deleteUser(user);
		return null;
	}
	
	public String deleteUser(User user) {
		if (user != null) {
			userList.remove(user);
			return "USER REMOVED";
		}
		return null;
	}
/*
	public String deleteUserByUsername(String username) {
		for (User user : userList) {
			if (username.equalsIgnoreCase(user.getUsername())) {
				userList.remove(user);
				return "USER REMOVED";
			}
		}
		return null;
	}
*/
	public String editUser(User user) {
		user.setCanEdit(true);
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