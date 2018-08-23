package com.ait.jrb;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.ait.objects.User;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class GrowlView {

	private String firstName;
	private String lastName;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public String saveMessage() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		context.addMessage(null, new FacesMessage("Successful", "Add user: " + firstName + " " + lastName));

		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error"));
		
		//context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));
		

		UserBean userBean = Helper.getBean("userBean", UserBean.class);
		RegisterBean registerBean = Helper.getBean("registerBean", RegisterBean.class);
		User newUser = new User(User.CUSTOMER, registerBean.getUsername(), registerBean.getPassword(), firstName, lastName, "", "", "", "", 0.0);
		message = userBean.addUser(newUser);
		
		return null;
	}
}
