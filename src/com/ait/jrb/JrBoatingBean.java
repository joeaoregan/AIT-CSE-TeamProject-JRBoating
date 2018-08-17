
package com.ait.jrb;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class JrBoatingBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static  ArrayList<User> users = new ArrayList<User>();

	
	


	// Return type ArrayList because it is an ArrayList
	// getBoats() because it is a getter for boats (This is the naming convention)
	//public ArrayList<Boat> getBoatList() {

	

	public boolean checkUniqueUsername(String username) {
		for (User user : users) {
			if (user.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}

	public boolean addCustomer(User user) {
		System.out.println("Customer "+ users.size());
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

	
}
