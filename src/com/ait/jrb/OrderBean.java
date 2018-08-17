package com.ait.jrb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ait.jrb.Helper;

@ManagedBean
@RequestScoped
public class OrderBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cartBoatType;
	private int quantity;
	
	private ArrayList<Boat> boatList;

	public OrderBean() {
		boatList = new ArrayList<Boat>();
		boatList.add(new Boat("1", "destroyer", 20.0, "destroy.jpg", 4));
		boatList.add(new Boat("2", "yacht", 10.0, "yacht.jpg", 8));
	}

	public String getCartBoatType() {
		return cartBoatType;
	}

	public void setCartBoatType(String cartBoatType) {
		this.cartBoatType = cartBoatType;
	}

	public int getQuantity() {
		return quantity;		
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String addToCart() {
		BoatBean boatBean = Helper.getBean("boatBean", BoatBean.class);
		Boat boat = boatBean.findBoat(cartBoatType);
		boatList.add(boat);
		return null;
	}

	public List<Boat> searchBoats() {
		BoatBean boatBean = Helper.getBean("boatBean", BoatBean.class);
		boatList.add(boatBean.findBoat(cartBoatType));
		return boatList;
	}
//	
//	public String removeHandler() {
//		CartBean cart = Helper.getBean("cartBean", CartBean.class);
//		cart.removeItemFromCart(productID);
//		return null;
//		
//	}


	public ArrayList<Boat> getBoatList() {
		return boatList;
	}


	public void setBoatList(ArrayList<Boat> boatList) {
		this.boatList = boatList;
	}
}
