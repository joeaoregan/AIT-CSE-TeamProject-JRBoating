package main;

public class Boat {
	private int boatID;
	private String boatType;
	private Double price;
	private String image;
	
	public Boat() {
		this.boatType= boatType;
		this.boatID = boatID;
		this.price = price;
		this.image = image;
	}
	
	public Boat(int boatID, String boatType, Double price, String image) {
		this.boatType= boatType;
		this.boatID = boatID;
		this.price = price;
		this.image = image;

	}
	public String getBoatType() {
		return boatType;
	}

	public void setBoatType(String boatType) {
		this.boatType = boatType;
	}

	public int getBoatID() {
		return boatID;
	}

	public void setBoatID(int boatID) {
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
