
package main;

public class Boat {
	private String boatID;
	private String boatType;
	private Double price;
	private String image;
	private int quantity;
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Boat(String boatID, String boatType, Double price, String image, int quantity) {
		this.boatType= boatType;
		this.boatID = boatID;
		this.price = price;
		this.image = image;
		this.quantity=quantity;
	

	}
	public String getBoatType() {
		return boatType;
	}

	public void setBoatType(String boatType) {
		this.boatType = boatType;
	}

	public String getBoatID() {
		return boatID;
	}

	public void setBoatID(String boatID) {
		this.boatID = boatID;
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

}
