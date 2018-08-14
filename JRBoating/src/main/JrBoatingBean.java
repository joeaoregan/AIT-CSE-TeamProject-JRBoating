<<<<<<< HEAD
package main;

import java.util.ArrayList;

public class JrBoatingBean {

	ArrayList<Boat> boats;
	
	
	public JrBoatingBean() {
		boats = new ArrayList<Boat> ();
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
	/*public String viewBoat () {
		StringBuilder string = new StringBuilder();
		for (Boat boat : boats) {
			string.append(boats.toString());	
		}	
	}*/
	
	
}
=======
package main;

import java.util.ArrayList;

public class JrBoatingBean {

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
>>>>>>> branch 'master' of https://sorchabruton@bitbucket.org/boating/jrboating.git
