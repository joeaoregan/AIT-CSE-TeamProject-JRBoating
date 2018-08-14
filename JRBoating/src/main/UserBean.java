package main;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username, password, passwordConfirmation, firstName, lastName, address, userType, phoneNumber;
	private boolean isManagerLoddgedIn, isCustomerLoggedIn, isFrontDeskLoggedIn, isSkipperLoggedIn;
	JrBoatingBean jrBoatingDB;
	public UserBean() {
		jrBoatingDB = Helper.getBean("jrboatingBean", JrBoatingBean.class);
		isManagerLoddgedIn = false;
		isCustomerLoggedIn = false;
		isFrontDeskLoggedIn = false;
		isSkipperLoggedIn = false;
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

	public String registerCustomer() {
		String msg = "ERROR";
		if (username == null || username.equals("") || password == null || password.equals("")
				|| passwordConfirmation == null || passwordConfirmation.equals("") || firstName == null
				|| firstName.equals("") || lastName == null || lastName.equals("") || address == null
				|| address.equals("") || phoneNumber == null || phoneNumber.equals("")) {
			msg = "All input must be filled";
		} else {
		
			if (!jrBoatingDB.checkUniqueUsername(username)) {
				User user = new User(firstName, lastName, username, password, address, phoneNumber, "CUS");
				jrBoatingDB.addCustomer(user);
				msg = "OK";

			}

		}
		return msg;
	}

<<<<<<< HEAD

=======
	public String userLogin() {
		String msg = null;
		if (username.equals("root")) {
			if(jrBoatingDB.login(username, password)) {
				msg = "manager";
				isManagerLoddgedIn = true;
			}	
		} else if (username.equals("fd")) {
			if(jrBoatingDB.login(username, password)) {
				isFrontDeskLoggedIn = true;
				msg = "frontdesk";
			}
		}
		else if (username.equals("sk")) {
			if(jrBoatingDB.login(username, password)) {
				isSkipperLoggedIn = true;
				msg = "skipper";
			}	
		}
		else {
			jrBoatingDB.login(username, password);
			msg = "customer";
		}
		//// boolean isUserLoggedIn=false;
		//// if(isManagerLoddgedIn)
		//// isUserLoggedIn= true;
		//// else if(isFrontDeskLoggedIn) {
		//// isUserLoggedIn= true;
		//// }else if(isCustomerLoggedIn) {
		//// isUserLoggedIn= true;
		//// }else if(isSkipperLoggedIn) {
		//// isUserLoggedIn= true;
		//// }
		// return isUserLoggedIn;
		// }
		return msg;
	}
>>>>>>> branch 'master' of https://a00212817@bitbucket.org/boating/jrboating.git
}
