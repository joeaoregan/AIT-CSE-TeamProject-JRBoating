
package main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	
	public Boat viewBoat(String boatType) {
		for (Boat aBoat: boats) {
			if(aBoat.getBoatType().equalsIgnoreCase(boatType)) {
				return aBoat;
			}
		}return null;
	}

	public boolean checkUniqueUsername(String username) {
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

	public int userCount() {
		return users.size();
	}

	public boolean login(String username, String password) {
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
<<<<<<< HEAD

=======
	
	public boolean boatTypeAvailable(String boatType) {
		for (Boat aBoat: boats) {
			if(aBoat.getBoatType().equalsIgnoreCase(boatType)){
				return true;
			}
		}return false;
	}
>>>>>>> branch 'Sorcha' of https://a00212817@bitbucket.org/aitcse4/jrboating.git
}
