
package main;

import java.util.ArrayList;

public class JrBoatingBean {
	Boat boat;
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
	
	public void addCustomer(User user) {
		users.add(user);
		
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
