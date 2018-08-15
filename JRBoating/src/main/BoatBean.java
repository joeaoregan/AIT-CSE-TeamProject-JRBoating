package main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ait.nav.Helper;

@ManagedBean
@RequestScoped
public class BoatBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int boatID;
	private String boatType;
	private String sboatType;
	private Double price;
	private String image;
	
	
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
	

	public void viewBoat() {
		JrBoatingBean jrBoatingBeanDB = Helper.getBean("jrBoatingBean", JrBoatingBean.class);
		jrBoatingBeanDB.viewBoat(boatType);		
	}
	
	public List<Boat> searchBoats() {
		ArrayList<Boat> searchBoat = new ArrayList<Boat>();
		JrBoatingBean jrBoatingBeanDB = Helper.getBean("jrBoatingBean", JrBoatingBean.class);
		Boat boat = new Boat(437,"canon",234.4,"hello");
		jrBoatingBeanDB.addBoat(boat);
		searchBoat.add(jrBoatingBeanDB.viewBoat(sboatType));
		return searchBoat;
	}
	
	

}
