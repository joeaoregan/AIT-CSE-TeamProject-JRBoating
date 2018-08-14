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
