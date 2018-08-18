
package com.ait.jrb;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<User> userList;
	
	private String username, password, passwordConfirmation, firstName, lastName, address, userType, phoneNumber,
			lUsername, lPassword;

	// New
	private String phone, type, bio, image;
	Double pricePerDay;
	
	
	public UserBean() {
		userList = new ArrayList<User>();

		User joe = new User(User.MANAGER_ID, "joe1", "asdf", "asdf", "Joe", "O'Regan", 
				"Thurles", "0871234567", "", "profile.jpg", 0.0);
		User elaine = new User(User.CUSTOMER_ID, "elaine", "asdf", "asdf", "Elaine", "Santos", 
				"Athlone", "0870246810", "", "profile.jpg", 0.0);
		User kiev = new User(User.SKIPPER_ID, "kiev", "asdf", "asdf", "Kiev", "Reynolds", 
				"Athlone", "0873691215", "", "profile.jpg", 0.0);
		User sorcha = new User(User.FRONT_DESK_STAFF_ID, "sorcha", "asdf", "asdf", "Sorcha", "Bruton", 
				"Athlone", "0870481216", "", "profile.jpg", 0.0);
		
		addUser(joe);
		addUser(elaine);
		addUser(kiev);
		addUser(sorcha);
	}

	public String displayType(int userType) {
		/*
		 * if (userType == User.MANAGER) { return "Manager"; } else if (userType ==
		 * User.CUSTOMER) { return "Customer"; } else if (userType ==
		 * User.FRONT_DESK_STAFF) { return "Front Desk Staff"; } else if (userType ==
		 * User.SKIPPER) { return "Skipper"; } return null;
		 */
		//switch (user.getUserType()) {
		switch (userType) {
		case User.MANAGER_ID:
			return "Manager";
		case User.CUSTOMER_ID:
			return "Customer";
		case User.FRONT_DESK_STAFF_ID:
			return "Front Desk Staff";
		case User.SKIPPER_ID:
			return "Skipper";
		default:
			return null;
		}
	}
	
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

	public boolean login(String username, String password) {
		System.out.println("Customer "+ userList.size());
		for (User user : userList) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
		
	
	public String getlUsername() {
		return lUsername;
	}

	public void setlUsername(String lUsername) {
		this.lUsername = lUsername;
	}

	public String getlPassword() {
		return lPassword;
	}

	public void setlPassword(String lPassword) {
		this.lPassword = lPassword;
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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String registerCustomerHandler() {
		String msg = "Username Already Exist";
		//System.out.println("Reg " + password);
		//System.out.println("CReg " + passwordConfirmation);
		if (!password.equals(passwordConfirmation)) {
			msg = "PasswordDon't match";
		} else if (!checkUniqueUsername(username)) {
			//User user = new User(firstName, lastName, username, password, address, phoneNumber, "CUS");
			//User user = new User(firstName, lastName, username, password, address, phoneNumber, User.CUSTOMER_ID);

			User user = new User(User.CUSTOMER_ID, username, password, passwordConfirmation, 
					firstName, lastName, address, phoneNumber, bio, image, pricePerDay);
			addUser(user);
			msg = "OK";
		}
		return msg;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
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
public static void setManagerLoddgedIn(boolean isManagerLoddgedIn) {
	UserBean.isManagerLoddgedIn = isManagerLoddgedIn;
}

public static void setCustomerLoggedIn(boolean isCustomerLoggedIn) {
	UserBean.isCustomerLoggedIn = isCustomerLoggedIn;
}

public static void setSkipperLoggedIn(boolean isSkipperLoggedIn) {
	UserBean.isSkipperLoggedIn = isSkipperLoggedIn;
}
*/
/*
public static boolean isManagerLoddgedIn() {
	return isManagerLoddgedIn;
}

public boolean isCustomerLoggedIn() {
	return isCustomerLoggedIn;
}

public boolean isFrontDeskLoggedIn() {
	return isFrontDeskLoggedIn;
}

public void setFrontDeskLoggedIn(boolean isFrontDeskLoggedIn) {
	UserBean.isFrontDeskLoggedIn = isFrontDeskLoggedIn;
}

public boolean isSkipperLoggedIn() {
	return isSkipperLoggedIn;
}
*/

/*
*	BETTER TO CHECK BY USERTYPE
*
public String userLogin() {
	String msg = "error";
	//JrBoatingBean jrBoatingDB = Helper.getBean("jrBoatingBean", JrBoatingBean.class);

	if (lUsername.equals("root")) {
		if (lUsername.equals("root") && lPassword.equals("admin")) {
			msg = "manager";
			isManagerLoddgedIn = true;
			return "admin.xhtml";
		}
	}

	else if (lUsername.equals("fd")) {
		msg = "frontdesk";
//	if (jrBoatingDB.login(lUsername, lPassword)) {
//		isFrontDeskLoggedIn = true;
//		msg = "frontdesk";
//	}
	}

	else if (lUsername.equals("sk")) {
		msg = "skipper";
//	if (jrBoatingDB.login(lUsername, lPassword)) {
//		isSkipperLoggedIn = true;
//		msg = "skipper";
//	}
	}

	else {
		if (login(lUsername, lPassword)) {
			isCustomerLoggedIn = true;
			return "CustomerBoat.xhtml";
		}
	}
	return msg;

}
*/

/*
public String logout() {
	isManagerLoddgedIn = false;
	System.out.println("here");
	return "index.xhtml";
}
*/