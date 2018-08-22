package com.ait.jrb;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ait.objects.Boat;

@ManagedBean(name = "inventoryBean")
@SessionScoped
public class InventoryBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private ArrayList<Boat> boats;

	private String type;
	private double price;
	private String image;
	private int quantity;
	private String description;
	private String link;

	Boat newBoat;

	private String message;

	public InventoryBean() {
		boats = new ArrayList<Boat>();
		
		resetInventoryVariables();

		Boat cruiser = new Boat("Cruiser", 250.0, "boat3.jpg", 10, "Cruiser description", "/details.xhtml");
		Boat canalBarge = new Boat("Canal Barge", 200.0, "boat1.jpg", 15, "Canal Barge description", "/details.xhtml");
		Boat sailingBoat = new Boat("Sailing Boat", 100.0, "boat4.jpg", 20, "Sailing Boat description", "/details.xhtml");
		Boat canoe = new Boat("Canoe", 50.0, "boat2.jpg", 25, "Canoe description", "/details.xhtml");

		boats.add(cruiser);
		boats.add(canalBarge);
		boats.add(sailingBoat);
		boats.add(canoe);
	}

	public Boat findBoat(String type) {
		for (Boat aBoat : boats) {
			if (aBoat.getType().equalsIgnoreCase(type)) {
				return aBoat;
			}
		}

		return null;
	}
	
	public String saveAction() {
		for (Boat boat : boats) {
			boat.setCanEdit(false);
		}
		return null;
	}

	public String deleteBoat(Boat boat) {
		if (boat != null) {
			boats.remove(boat);
		}
		return null;
	}

	public String editBoat(Boat boat) {
		boat.setCanEdit(true);
		return null;
	}

	public void resetInventoryVariables() {
		type = "";
		price = 0.0;
		image = "";
		quantity = 0;
		description = "";
		link = "";
		message = "Add A New Boat";
	}

	public String createNewBoat() {
		newBoat = new Boat(type, price, image, quantity, description, link);
		// BoatBean boatBean = Helper.getBean("boatBean", BoatBean.class);
		// boatBean.getBoatInventory().add(newBoat);
		boats.add(newBoat);
		resetInventoryVariables();
		message = "BOAT ADDED";
		return null;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Boat getNewBoat() {
		return newBoat;
	}

	public void setNewBoat(Boat newBoat) {
		this.newBoat = newBoat;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<Boat> getBoats() {
		return boats;
	}

	public void setBoats(ArrayList<Boat> boats) {
		this.boats = boats;
	}

}
