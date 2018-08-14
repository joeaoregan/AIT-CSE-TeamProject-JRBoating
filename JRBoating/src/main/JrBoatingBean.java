
package main;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean
@SessionScoped
public class JrBoatingBean implements Serializable {

	private static final long serialVersionUID = 1L;
	ArrayList<Boat> boats;
	ArrayList<User> users;

	public JrBoatingBean() {
		boats = new ArrayList<Boat>();
		users = new ArrayList<User>();
	}

	public void addBoat(Boat boat) {
		boats.add(boat);
	}

	public void removeBoat(Boat boat) {
		boats.remove(boat);
	}
	public int boatCount() {
		return boats.size();
	}

	public boolean checkUniqueUsername(String username) {
		System.out.println("In DBBBBB "+username);
		for (User user : users) {
			if (user.getUsername().equals(username)) {
				return true;
			}

		}
		return false;
	}
	
	public boolean addCustomer(User user) {
		return users.add(user);
		
	}
	
	public boolean login(String username, String password) {
		for(User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return true;
			}
			
		}
		
		return false;
		
	}

}
