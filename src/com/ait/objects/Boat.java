package com.ait.objects;

public class Boat {
	private String type;
	private double price;
	private String image;
	private int quantity;
	private boolean canEdit;
	private String description;
	private String link;
	
	public Boat(String type, Double price, String image, int quantity, String description, String link) {
		this.type= type;
		this.price = price;
		this.image = image;
		this.quantity=quantity;
		this.description=description;
		this.link = link;
	}
	
	public Boolean equals(String type) {
		if (this.type.equalsIgnoreCase(type)) {
			return true;
		}			
		
		return false;
	}
		
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
	//@Override
	//public String toString() {
	//	return "ID: " + id + ", Type: " + type + ", Price: " + price;
	//}

	public boolean isCanEdit() {
		return canEdit;
	}

	public void setCanEdit(boolean canEdit) {
		this.canEdit = canEdit;
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

	public void setPrice(double price) {
		this.price = price;
	}
}
