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
		typeSearched = "";
		message = "";
		rendered = "false";
	}

	public String searchHandler() {
		if (searchBoat(typeSearched).equals("BOAT FOUND")) {
			//typeSearched = "";
			return "/customer/SearchVerify.xhtml";
		}
		//typeSearched = "";
		return null;
	}

	public String searchBoat(String type) {
		InventoryBean inventoryBean = Helper.getBean("inventoryBean", InventoryBean.class);
		return boatFound(inventoryBean.findBoat(type));
	}

	public String boatFound(Boat boat) {
		typeSearched = "";
		rendered = "false";
		message = "BOAT NOT FOUND";
		
		if (boat != null) {
			this.boat = boat;
			rendered = "true";
			message =  "BOAT FOUND";
		}
		
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