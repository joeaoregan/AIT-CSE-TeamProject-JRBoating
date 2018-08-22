package com.ait.jrb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ait.objects.User;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
	public static final int PASSWORD_FIELD_LENGTH = 4;
	public static final String PASSWORD_LENGTH_MESSAGE = "Password must be " + PASSWORD_FIELD_LENGTH + " or more characters";
	
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;

	private User loggedUser;

	private Boolean userLoggedIn; // Show the login top menu

	// New
	private String message;
	private Boolean loggedInCustomer;
	private Boolean loggedInManager;
	private Boolean loggedInFDS;
	private Boolean loggedInSkipper;

	public LoginBean() {
		userLoggedIn = false;

		username = "";
		password = "";
		message = "";
		loggedUser = null;

		initUsersLoggedIn();
	}
	
	public String passwordLengthMessage() {
		return PASSWORD_LENGTH_MESSAGE;
	}
	public int passwordLength() {
		//return Integer.toString(PASSWORD_FIELD_LENGTH);
		return PASSWORD_FIELD_LENGTH;
	}

	public String displayType() {
		if (loggedUser != null) {
			switch (loggedUser.getType()) {
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
		return null;
	}

	public String showLoginPage() {
		username = "";
		password = "";
		message = "";
		loggedUser = getUser();

		return "/login";
	}

	public User getUser() {
		UserBean userBean = Helper.getBean("userBean", UserBean.class);

		for (User user : userBean.getUserList()) {
			if (user.equals(username)) {
				return user;
			}
		}

		return null;
	}

	public String loginHandler() {
		UserBean userBean = Helper.getBean("userBean", UserBean.class);
		User user = userBean.getUserByUsername(username);

		message = "";

		if (user != null) {
			loggedUser = user;
			userLoggedIn = true;

			if (user.getPassword().equals(password)) {
				if (user.getType() == User.MANAGER) {
					setUserLoggedIn(User.MANAGER);
					return "/manager/HomeManager";
				} else if (user.getType() == User.CUSTOMER) {
					setUserLoggedIn(User.CUSTOMER);
					return "/index";
				} else if (user.getType() == User.FRONT_DESK_STAFF) {
					setUserLoggedIn(User.FRONT_DESK_STAFF);
					return "/index";
				} else if (user.getType() == User.SKIPPER) {
					setUserLoggedIn(User.SKIPPER);
					return "/skipper/SkipperBookings";
				}
			}
		}

		message = "USER NOT FOUND";
		
		return "login";
	}

	/*
	 * Log out the user - BETTER WAY MIGHT BE TO ADD A LOGGED IN BOOLEAN VARIABLE TO
	 * USER CLASS
	 */
	public String logoutHandler() {
		initUsersLoggedIn();

		UserBean userBean = Helper.getBean("userBean", UserBean.class);

		username = "";
		password = "";

		// XXX NEED TO CREATE A FUNCTION TO CLEAR USER DETAILS IN USER BEAN
		if (userBean != null) {
			userBean.setUsername(""); // reset the username
			userBean.setFirstName(""); // reset the first name
			userBean.setLastName(""); // reset the last name
			userBean.setAddress(""); // reset the address

			userLoggedIn = false;
			loggedUser = null;
		}

		return "/index.xhtml"; // Return to homepage
	}

	public void setUserLoggedIn(int type) {
		switch (type) {
		case User.CUSTOMER:
			loggedInCustomer = true;
			loggedInManager = false;
			loggedInFDS = false;
			loggedInSkipper = false;
			break;
		case User.FRONT_DESK_STAFF:
			loggedInCustomer = false;
			loggedInManager = false;
			loggedInFDS = true;
			loggedInSkipper = false;
			break;
		case User.MANAGER:
			loggedInCustomer = false;
			loggedInManager = true;
			loggedInFDS = false;
			loggedInSkipper = false;
			break;
		case User.SKIPPER:
			loggedInCustomer = false;
			loggedInManager = false;
			loggedInFDS = false;
			loggedInSkipper = true;
			break;
		default:
			break;
		}
	}

	/*
	 * Set all user types as logged out
	 */
	public void initUsersLoggedIn() {
		loggedInCustomer = false;
		loggedInManager = false;
		loggedInFDS = false;
		loggedInSkipper = false;
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

	public User getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getLoggedInCustomer() {
		return loggedInCustomer;
	}

	public void setLoggedInCustomer(Boolean loggedInCustomer) {
		this.loggedInCustomer = loggedInCustomer;
	}

	public Boolean getLoggedInManager() {
		return loggedInManager;
	}

	public void setLoggedInManager(Boolean loggedInManager) {
		this.loggedInManager = loggedInManager;
	}

	public Boolean getLoggedInFDS() {
		return loggedInFDS;
	}

	public void setLoggedInFDS(Boolean loggedInFDS) {
		this.loggedInFDS = loggedInFDS;
	}

	public Boolean getLoggedInSkipper() {
		return loggedInSkipper;
	}

	public void setLoggedInSkipper(Boolean loggedInSkipper) {
		this.loggedInSkipper = loggedInSkipper;
	}

	public Boolean getUserLoggedIn() {
		return userLoggedIn;
	}

	public void setUserLoggedIn(Boolean userLoggedIn) {
		this.userLoggedIn = userLoggedIn;
	}

	public static String getPasswordLengthMessage() {
		return PASSWORD_LENGTH_MESSAGE;
	}
}