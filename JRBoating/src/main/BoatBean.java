package main;

import java.util.ArrayList;

public class BoatBean {
	private int boatID;
	private String boatType;
	private Double price;
	private String image;
	
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
	
	public void addBoat() {
		JrBoatingBean jrBoatingBeanDB = Helper.getBean("jrBoatingBean", JrBoatingBean.class);
		Boat boat = new Boat(boatID,boatType,price,image);
		jrBoatingBeanDB.addBoat(boat);
		
	}
	public void removeBoat() {
		JrBoatingBean jrBoatingBeanDB = Helper.getBean("jrBoatingBean", JrBoatingBean.class);
		Boat boat = new Boat(boatID,boatType,price,image);
		jrBoatingBeanDB.removeBoat(boat);			
	}
	

	/*public void viewBoat() {
		JrBoatingBean jrBoatingBeanDB = Helper.getBean("jrBoatingBean", JrBoatingBean.class);
		Boat boat = new Boat(boatID,boatType,price,image);
		jrBoatingBeanDB.viewBoat(boat);
	}*/

}
