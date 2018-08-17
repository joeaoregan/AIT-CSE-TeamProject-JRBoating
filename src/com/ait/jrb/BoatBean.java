
package com.ait.jrb;

import java.io.Serializable;
import java.util.ArrayList;
//import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class BoatBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String boatID;
	private String productID; // Used in boat.xhtml but not declared
	private String boatType;
	private String sboatType;
	private Double price;
	private String image=null;
	private int quantity;
		
	private ArrayList<Boat> boatInventory = new ArrayList<Boat>();

	public BoatBean() {
		boatInventory.add(new Boat("Boat1", "Cruiser", 250.0, "cruiser.jpg", 10));
		boatInventory.add(new Boat("Boat2", "Canal Barge", 200.0, "canalbarge.jpg", 10));
		boatInventory.add(new Boat("Boat3", "Yacht", 100.0, "sailingboat.jpg", 10));
		boatInventory.add(new Boat("Boat4", "Canoes", 50.0, "canoe.jpg", 10));
	}
	
	public String addBoat(Boat boat) {
		for (Boat aboat : boatInventory) {
			if (aboat.getType().equalsIgnoreCase(boat.getType())) {
				return "BOAT TYPE EXISTS";				
			}
		}
		
		boatInventory.add(boat);
		return "OK";
	}
	
/*
	public String addBoat() {

		if (UserBean.isManagerLoddgedIn()) {
			Boat boat = new Boat(boatID, boatType, price, image, quantity);
			addBoat(boat);
		}
		
		return null;	// warning must have String return type
	}
*/
	
	public void removeBoat(Boat boat) {
		System.out.println("before remove " + boatInventory.size());
		boatInventory.remove(boat);
		System.out.println("after remove " + boatInventory.size());
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
	
	public Boat findBoat(String boatType) {
		for (Boat aBoat : boatInventory) {
			if (aBoat.getType().equalsIgnoreCase(boatType)) {
				return aBoat;
			}
		}
		return null;
	}

	public ArrayList<Boat> searchBoats() {
		ArrayList<Boat> searchBoatList = new ArrayList<Boat>();
		//JrBoatingBean jrBoatingBeanDB = Helper.getBean("jrBoatingBean", JrBoatingBean.class);

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
	public void setBoatInventory(ArrayList<Boat> boatInventory) {
		this.boatInventory = boatInventory;
	}
}