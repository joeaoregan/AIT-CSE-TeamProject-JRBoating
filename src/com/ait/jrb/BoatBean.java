
package com.ait.jrb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class BoatBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String boatID;
	private String boatType;
	private String sboatType;
	private Double price;
	private String image=null;
	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSboatType() {
		return sboatType;
	}

	public void setSboatType(String sboatType) {
		this.sboatType = sboatType;
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

	public void addBoat() {
		if (UserBean.isManagerLoddgedIn()) {
			JrBoatingBean jrBoatingBeanDB = Helper.getBean("jrBoatingBean", JrBoatingBean.class);
			Boat boat = new Boat(boatID, boatType, price, image, quantity);
			jrBoatingBeanDB.addBoat(boat);
		}
	}

	public void removeBoat() {
		if (UserBean.isManagerLoddgedIn()) {
//			JrBoatingBean jrBoatingBeanDB = Helper.getBean("jrBoatingBean", JrBoatingBean.class);
//			Boat boat = new Boat(boatID, boatType, price, image);
//			jrBoatingBeanDB.removeBoat(boat);
		}
	}

	public List<Boat> viewBoats() {
		JrBoatingBean jrBoatingBeanDB = Helper.getBean("jrBoatingBean", JrBoatingBean.class);	
		return jrBoatingBeanDB.getBoatList();
	}

	public List<Boat> searchBoats() {
		ArrayList<Boat> searchBoat = new ArrayList<Boat>();
		JrBoatingBean jrBoatingBeanDB = Helper.getBean("jrBoatingBean", JrBoatingBean.class);
		searchBoat.add(jrBoatingBeanDB.viewBoat(sboatType));
		return searchBoat;
	}
}
