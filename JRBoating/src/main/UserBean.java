package main;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ait.nav.Helper;

@ManagedBean
@RequestScoped
public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username, password, passwordConfirmation, firstName, lastName, address, userType, phoneNumber,lUsername,lPassword;
	private boolean isManagerLoddgedIn, isCustomerLoggedIn, isFrontDeskLoggedIn, isSkipperLoggedIn;

	public UserBean() {

		isManagerLoddgedIn = false;
		isCustomerLoggedIn = false;
		isFrontDeskLoggedIn = false;
		isSkipperLoggedIn = false;
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

	public boolean isManagerLoddgedIn() {
		return isManagerLoddgedIn;
	}

	public void setManagerLoddgedIn(boolean isManagerLoddgedIn) {
		this.isManagerLoddgedIn = isManagerLoddgedIn;
	}

	public boolean isCustomerLoggedIn() {
		return isCustomerLoggedIn;
	}

	public void setCustomerLoggedIn(boolean isCustomerLoggedIn) {
		this.isCustomerLoggedIn = isCustomerLoggedIn;
	}

	public boolean isFrontDeskLoggedIn() {
		return isFrontDeskLoggedIn;
	}

	public void setFrontDeskLoggedIn(boolean isFrontDeskLoggedIn) {
		this.isFrontDeskLoggedIn = isFrontDeskLoggedIn;
	}

	public boolean isSkipperLoggedIn() {
		return isSkipperLoggedIn;
	}

	public void setSkipperLoggedIn(boolean isSkipperLoggedIn) {
		this.isSkipperLoggedIn = isSkipperLoggedIn;
	}

	public String registerCustomerHandler() {
		String msg = "Username Already Exist";
		JrBoatingBean jrBoatingDB = Helper.getBean("jrBoatingBean", JrBoatingBean.class);
		User user = new User(firstName, lastName, username, password, address, phoneNumber, "CUS");
		if (!jrBoatingDB.checkUniqueUsername(username)) {
			jrBoatingDB.addCustomer(user);
			msg = "OK";
		}
		System.out.println("User count = "+jrBoatingDB.userCount());
		return msg;
	}
	
}
	/*public String userLogin() {
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

		else  {
			// jrBoatingDB.login(lUsername, lPassword);
			msg = "customer";
		}
		return msg;

	}
}
*/
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
//	}
*/