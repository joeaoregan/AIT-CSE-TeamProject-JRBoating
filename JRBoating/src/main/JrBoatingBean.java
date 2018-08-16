
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
	private static  ArrayList<Boat> boats = new ArrayList<Boat>();
	private static  ArrayList<User> users = new ArrayList<User>();

	public String addBoat(Boat boat) {

		for (Boat aboat : boats) {
			System.out.println();
			if (aboat.getBoatType().equalsIgnoreCase(boat.getBoatType())) {
				aboat.setQuantity(aboat.getQuantity() + boat.getQuantity());
				return "OK";
			}
		}
		System.out.println("Not equal");
		boats.add(boat);
		return null;

	}

	public void removeBoat(Boat boat) {
		boats.remove(boat);
	}

	public int boatCount() {
		return boats.size();
	}

	public List<Boat> getBoatList() {
		return boats;
	}

	public Boat viewBoat(String boatType) {
		for (Boat aBoat : boats) {
			if (aBoat.getBoatType().equalsIgnoreCase(boatType)) {
				return aBoat;
			}
		}
		return null;
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

	public boolean boatTypeAvailable(String boatType) {
		for (Boat aBoat : boats) {
			if (aBoat.getBoatType().equalsIgnoreCase(boatType)) {
				return true;
			}
		}
		return false;
	}
}
