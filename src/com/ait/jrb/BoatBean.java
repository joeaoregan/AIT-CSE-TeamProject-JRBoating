
package com.ait.jrb;

import java.io.Serializable;
import java.util.ArrayList;
//import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ait.objects.Boat;

@ManagedBean(name = "boatBean")
@RequestScoped
public class BoatBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String boatID;
	private String boatType;
	private double price;
	private String image;
	private int quantity;
	private String description;
	private String productID; // Used in boat.xhtml but not declared
	private String sboatType;
	private String infoMessage;

	private ArrayList<Boat> boatInventory; 

	public BoatBean() { //there are 4 boats already in the arrayList when boat bean is called
		boatInventory= new ArrayList<Boat>();
		boatID = "";
		boatType = "";
		price = 0.0;
		image = "";
		quantity = 0;
		description = "";

		infoMessage = "Add a new boat";

		// Add boats to boat list
		addNewBoat(new Boat("Cruiser", 250.0, "cruiser.jpg", 10, "Cruiser description"));
		addNewBoat(new Boat("Canal Barge", 200.0, "canalbarge.jpg", 10, "Canal Barge description"));
		addNewBoat(new Boat("Sailing Boat", 100.0, "sailingboat.jpg", 10, "Sailing Boat description"));
		addNewBoat(new Boat("Canoe", 50.0, "canoe.jpg", 10, "Canoe description"));
	}

	/*
	 * Manage inventory edit/save form details
	 */
	public String editItem(Boat boat) {
		boat.setCanEdit(true);
		return null;
	}

	public String saveAction() {
		for (Boat boat : boatInventory) {
			boat.setCanEdit(false);
		}
		return null;
	}

	public String boatDetails(String productID) {
		for (Boat boat : boatInventory) {
			if (boat.getId().equals(productID))
				return "ID: " + boat.getId() + ", Type: " + boat.getType() + ", Price: "
						+ Double.toString(boat.getPrice());
		}
		
		return null;
	}

	public String addBoatHandler() {
		infoMessage = addNewBoat(new Boat(boatType, price, image, quantity, description));

		return null;
	}

	public String addNewBoat(Boat boat) {
		if (boat == null) {
			return "INVALID BOAT";
		}

		for (Boat aboat : boatInventory) {
			if (aboat.getId().equalsIgnoreCase(boat.getId())) {
				return "BOAT TYPE EXISTS";
			}
		}
		boat.setId("Boat" + (boatInventory.size() + 1)); // set boat id to Boat1, Boat2, etc.
		boatInventory.add(boat);
		return "OK";
	}

	public String removeBoat(Boat boat) {
		boatInventory.remove(boat);
		return null;
	}

	public int boatCount() {
		return boatInventory.size();
	}

	public boolean boatTypeAvailable(String boatType) {
		for (Boat aBoat : boatInventory) {
			if (aBoat.getType().equalsIgnoreCase(boatType)) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Boat> getBoatInventory() {
		return boatInventory;
	}

	public void setBoatInventory(ArrayList<Boat> boatInventory) {
		this.boatInventory = boatInventory;
	}

	public Boat findBoat(String boatID) {
		for (Boat aBoat : boatInventory) {
			if (aBoat.getId().equalsIgnoreCase(boatID)) {
				return aBoat;
			}
		}
		return null;
	}

	public ArrayList<Boat> searchBoats() {
		ArrayList<Boat> searchBoatList = new ArrayList<Boat>();
		// JrBoatingBean jrBoatingBeanDB = Helper.getBean("jrBoatingBean",
		// JrBoatingBean.class);

		searchBoatList.add(findBoat(boatType));

		return searchBoatList;
	}

	public String getBoatID() {
		return boatID;
	}

	public void setBoatID(String boatID) {
		this.boatID = boatID;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getBoatType() {
		return boatType;
	}

	public void setBoatType(String boatType) {
		this.boatType = boatType;
	}

	public String getSboatType() {
		return sboatType;
	}

	public void setSboatType(String sboatType) {
		this.sboatType = sboatType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getInfoMessage() {
		return infoMessage;
	}

	public void setInfoMessage(String infoMessage) {
		this.infoMessage = infoMessage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}