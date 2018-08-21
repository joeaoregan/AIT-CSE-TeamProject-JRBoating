package com.ait.jrb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ait.objects.Boat;

@ManagedBean(name = "searchBoatBean")
@SessionScoped
public class SearchBoatBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Boat boat;
	
	private String typeSearched;
	private String message;
	private String rendered;

	public SearchBoatBean() {
		boat = null;
		rendered = "false";
	}
	

	public String searchHandler() {
		//System.out.println(searchBoat(typeSearched));
		
		if (searchBoat(typeSearched).equals("BOAT FOUND")) {
			return "/customer/SearchVerify.xhtml";
		}
		
		return null;
	}

	public String searchBoat(String type) {
		BoatBean boatBean = Helper.getBean("boatBean", BoatBean.class);
		for (Boat boat : boatBean.getBoatInventory()) {
			if (type.equalsIgnoreCase(boat.getType())) {

				this.boat = boat;
				message = "BOAT FOUND";
				rendered = "true";
				return message;
			}
		}

		boat = null;
		rendered = "false";
		message = "BOAT NOT FOUND";
		return message;
	}
	

	public Boat getBoat() {
		return boat;
	}

	public void setBoat(Boat boat) {
		this.boat = boat;
	}


	public String getTypeSearched() {
		return typeSearched;
	}


	public void setTypeSearched(String typeSearched) {
		this.typeSearched = typeSearched;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getRendered() {
		return rendered;
	}


	public void setRendered(String rendered) {
		this.rendered = rendered;
	}
}

// private String type;
// private double price;
// private String image;
// private int quantity;
// private String description;

// this.type = boat.getType();
// this.price = boat.getPrice();
// this.image = boat.getImage();
// this.quantity = boat.getQuantity();
// this.description = boat.getDescription();