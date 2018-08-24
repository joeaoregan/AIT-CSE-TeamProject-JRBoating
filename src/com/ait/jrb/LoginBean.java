package com.ait.jrb;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ait.objects.User;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
	public static final int PASSWORD_FIELD_LENGTH = 4;
	public static final String PASSWORD_LENGTH_MESSAGE = "Password must be " + PASSWORD_FIELD_LENGTH
			+ " or more characters";

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String message;

	private User loggedUser;

	private Boolean userLoggedIn;

	private Boolean loggedInCustomer;
	private Boolean loggedInManager;
	private Boolean loggedInFDS;
	private Boolean loggedInSkipper;

	public LoginBean() {
		resetVars();
		loggedUser = null;

		initUsersLoggedIn();
	}
	
	public void resetVars() {
		username = "";
		password = "";
		message = "";		
	}

	public String passwordLengthMessage() {
		return PASSWORD_LENGTH_MESSAGE;
	}

	public int passwordLength() {
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

	public String setUserLoggedIn(int type) {
		String message = null;
		
		switch (type) {
		case User.CUSTOMER:
			loggedInCustomer = true;
			loggedInManager = false;
			loggedInFDS = false;
			loggedInSkipper = false;
			message = "CUSTOMER LOGGED IN";
			break;
		case User.FRONT_DESK_STAFF:
			loggedInCustomer = false;
			loggedInManager = false;
			loggedInFDS = true;
			loggedInSkipper = false;
			message = "FRONT_DESK_STAFF LOGGED IN";
			break;
		case User.MANAGER:
			loggedInCustomer = false;
			loggedInManager = true;
			loggedInFDS = false;
			loggedInSkipper = false;
			message = "MANAGER LOGGED IN";
			break;
		case User.SKIPPER:
			loggedInCustomer = false;
			loggedInManager = false;
			loggedInFDS = false;
			loggedInSkipper = true;
			message = "SKIPPER LOGGED IN";
			break;
		default:
			message = "INVALID USER TYPE";
			break;
		}
		
		return message;
	}

	public void initUsersLoggedIn() {
		resetVars();
		
		userLoggedIn = false;		
		loggedInCustomer = false;
		loggedInManager = false;
		loggedInFDS = false;
		loggedInSkipper = false;
	}
	

	public User getUser() {
		UserBean userBean = Helper.getBean("userBean", UserBean.class);
//		for (User user : userBean.getUserList()) {
//			if (user.equals(username)) {
//				return user;
//			}
//		}
		return userBean.getUserByUsername(username);
	}

	public String loginHandler() {
		FacesContext context = FacesContext.getCurrentInstance();
				
		UserBean userBean = Helper.getBean("userBean", UserBean.class);
		User user = userBean.getUserByUsername(username); // get the user

		message = "USER NOT FOUND";
		
		if (user != null) {
			loggedUser = user;
			message =  redirectUser(user.getPassword(), user.getType()); // go to page, or password invalid
		}
		
		if (message.equals("USER NOT FOUND") || message.equals("login")) {
			message = "/login.xhtml";
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "USERNAME OR PASSWORD INCORRECT"));
		}		
		
		return message;
	}

	public String redirectUser(String password, int type) {
		userLoggedIn = true;
		
		if (this.password.equals(password)) {
			if (type == User.MANAGER) {
				setUserLoggedIn(User.MANAGER);
				return "/manager/manager-home.xhtml";
			} else if (type == User.CUSTOMER) {
				setUserLoggedIn(User.CUSTOMER);
				return "/index";
			} else if (type == User.FRONT_DESK_STAFF) {
				setUserLoggedIn(User.FRONT_DESK_STAFF);
				return "/index";
			} else if (type == User.SKIPPER) {
				setUserLoggedIn(User.SKIPPER);
				return "/skipper/SkipperBookings";
			}
		}

		return "login";
	}
	
	public String logoutHandler() {
		initUsersLoggedIn();

		UserBean userBean = Helper.getBean("userBean", UserBean.class);

		if (userBean != null) {
			userBean.resetLoginInfo();

			loggedUser = null;
			return "/index.xhtml";
		}
		
		return null;
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