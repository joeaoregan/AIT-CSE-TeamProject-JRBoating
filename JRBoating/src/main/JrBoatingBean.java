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
	
	
}
