package main;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userAuthenticationBean")
@SessionScoped
public class UserAuthenticationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// The user constant that represents the manager
	private static final User MANAGER = new User("Manager", "", "root", "admin", "", "", "MANAGER");

	private String username;
	private String password;
	private String uiValidationMessage;
	private User loggedUser;

	//clears the current state of the bean and shows the login page
	public String showLoginPage() {
		username = "";
		password = "";
		uiValidationMessage = "";
		loggedUser = null;
		return "login";
	}

	public String doAuthentication() {
		User authenticatingUser = validateUser();
		if (authenticatingUser == null) {
			uiValidationMessage = "Pair username/password do not match any known user.";
			return "login";
		}
		loggedUser = authenticatingUser;
		return "index";
	}

	// returns 
	//	- user MANAGER, if the manager logs in successfully;
	//  - a known user, if pair username/password matches an existing user;
	//  - or null, if pair username/password don't match any registered users.
	private User validateUser() {
		User user = null;
		if (MANAGER.getUsername().equals(username) && MANAGER.getPassword().equals(password)) {
			user = MANAGER;
		}
		if (user == null) {
			// check if user exists
		}
		return user;
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

	public String getUiValidationMessage() {
		return uiValidationMessage;
	}

	public void setUiValidationMessage(String uiValidationMessage) {
		this.uiValidationMessage = uiValidationMessage;
	}

	public User getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
	}

}
