package main;

import java.util.ArrayList;

public class JrBoatingBean {

	ArrayList<Boat> boats;
	ArrayList<User> customer;

	public JrBoatingBean() {
		boats = new ArrayList<Boat>();
		customer = new ArrayList<User>();
	}

	public void addBoat(Boat boat) {
		boats.add(boat);
	}

	public void removeBoat(Boat boat) {
		boats.remove(boat);
	}

	public boolean checkUniqueUsername(String username) {
		for (User user : customer) {
			if (user.getUsername().equals(username)) {
				return true;
			}

		}
		return false;
	}
	
	public void addCustomer(User user) {
		customer.add(user);
		
	}

}
