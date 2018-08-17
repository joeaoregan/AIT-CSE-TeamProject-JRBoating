
package com.ait.jrb;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ait.jrb.Helper;

@ManagedBean
@SessionScoped
public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username, password, passwordConfirmation, firstName, lastName, address, userType, phoneNumber,
			lUsername, lPassword;
	private static boolean isManagerLoddgedIn, isCustomerLoggedIn, isFrontDeskLoggedIn, isSkipperLoggedIn;

	private static  ArrayList<User> users = new ArrayList<User>();
	
	public UserBean() {
		isManagerLoddgedIn = false;
		isCustomerLoggedIn = false;
		isFrontDeskLoggedIn = false;
		isSkipperLoggedIn = false;

		User joe = new User("Joe", "O'Regan", "joe", "asdf", "Thurles", "0861234567", User.MANAGER_ID);	
		User elaine = new User("Elaine", "Santos", "elaine", "asdf", "Athlone", "0860246810", User.CUSTOMER_ID);
		addUser(joe);
		addUser(elaine);
	}

	public boolean checkUniqueUsername(String username) {
		for (User user : users) {
			if (user.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}

	public boolean addUser(User user) {
		//System.out.println("Customer "+ users.size());
		return users.add(user);
	}

	public int userCount() {
		return users.size();
	}

	public boolean login(String username, String password) {
		System.out.println("Customer "+ users.size());
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	public static void setManagerLoddgedIn(boolean isManagerLoddgedIn) {
		UserBean.isManagerLoddgedIn = isManagerLoddgedIn;
	}

	public static void setCustomerLoggedIn(boolean isCustomerLoggedIn) {
		UserBean.isCustomerLoggedIn = isCustomerLoggedIn;
	}

	public static void setSkipperLoggedIn(boolean isSkipperLoggedIn) {
		UserBean.isSkipperLoggedIn = isSkipperLoggedIn;
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

	public String registerCustomerHandler() {
		String msg = "Username Already Exist";
		JrBoatingBean jrBoatingDB = Helper.getBean("jrBoatingBean", JrBoatingBean.class);
		System.out.println("Reg " + password);
		System.out.println("CReg " + passwordConfirmation);
		if (!password.equals(passwordConfirmation)) {
			msg = "PasswordDon't match";
		} else if (!checkUniqueUsername(username)) {
			//User user = new User(firstName, lastName, username, password, address, phoneNumber, "CUS");
			User user = new User(firstName, lastName, username, password, address, phoneNumber, User.CUSTOMER_ID);
			addUser(user);
			msg = "OK";
		}
		return msg;
	}
	

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
//		if (jrBoatingDB.login(lUsername, lPassword)) {
//			isFrontDeskLoggedIn = true;
//			msg = "frontdesk";
//		}
		}

		else if (lUsername.equals("sk")) {
			msg = "skipper";
//		if (jrBoatingDB.login(lUsername, lPassword)) {
//			isSkipperLoggedIn = true;
//			msg = "skipper";
//		}
		}

		else {
			if (login(lUsername, lPassword)) {
				isCustomerLoggedIn = true;
				return "CustomerBoat.xhtml";
			}
		}
		return msg;

	}
	
	public String logout() {
		isManagerLoddgedIn = false;
		System.out.println("here");
		return "index.xhtml";
	}
}

/*
//	public String userLogin() {
//		System.out.println(username);
//		String msg = null;
//		if (username.equals("root")) {
//			if (jrBoatingDB.login(username, password)) {
//
//		String msg = "error";
//		if (username.equals("root") && password.equals("admin")) {
//				msg = "manager";
//				isManagerLoddgedIn = true;
//			
//		}
//		if (username.equals("fd")) {
//			msg = "frontdesk";
////			if (jrBoatingDB.login(username, password)) {
////				isFrontDeskLoggedIn = true;
////				msg = "frontdesk";
////			}
//		} 
//		if (username.equals("sk")) {
//			msg = "skipper";
////			if (jrBoatingDB.login(username, password)) {
////				isSkipperLoggedIn = true;
////				msg = "skipper";
////			}
//		} 
//		if(username.equals("any")){	
//			//jrBoatingDB.login(username, password);
//			msg = "customer";
//		}
//		return msg;
>>>>>>> refs/remotes/origin/master
//	}
}
*/