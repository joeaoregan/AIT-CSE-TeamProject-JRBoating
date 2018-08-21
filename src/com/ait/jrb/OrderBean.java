package com.ait.jrb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ait.objects.Boat;
import com.ait.objects.Order;
import com.ait.objects.User;

@ManagedBean(name = "orderBean")
@RequestScoped
public class OrderBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cartBoatType;
		
	private String id;									// unique id of the order
	private String custUsername;						// of the user who placed the order	
	private int quantity;								// Number of boats hired
	private int numDays;								// Number of days the boat is hired for	
	private int dayHired;								// day (between 0 and numDays) for which Skipper is hired (1 day only)
	private double skipperCost;							// In Skipper class = Skipper.price	
	private double deposit;								// 10% of the boat price
	private double totalPricePayNow;					// Skipper cost + boat deposit cost up front to secure the boat, and amount that needs to be paid now
	private double remainingPrice;						// Price to pay on the day	
	private double discount;							// Pricing structure applies discount	
	private User skipper = null;	
	private Boat boat;									// Can be an array	
	//private Equipment equipment = new Equipment();	// Can be an array of equipment			
	
	private ArrayList<Order> orders;

	public OrderBean() {
		orders = new ArrayList<Order>();
	}

	public String getCartBoatType() {
		return cartBoatType;
	}

	public void setCartBoatType(String cartBoatType) {
		this.cartBoatType = cartBoatType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustUsername() {
		return custUsername;
	}

	public void setCustUsername(String custUsername) {
		this.custUsername = custUsername;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getNumDays() {
		return numDays;
	}

	public void setNumDays(int numDays) {
		this.numDays = numDays;
	}

	public int getDayHired() {
		return dayHired;
	}

	public void setDayHired(int dayHired) {
		this.dayHired = dayHired;
	}

	public double getSkipperCost() {
		return skipperCost;
	}

	public void setSkipperCost(double skipperCost) {
		this.skipperCost = skipperCost;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public double getTotalPricePayNow() {
		return totalPricePayNow;
	}

	public void setTotalPricePayNow(double totalPricePayNow) {
		this.totalPricePayNow = totalPricePayNow;
	}

	public double getRemainingPrice() {
		return remainingPrice;
	}

	public void setRemainingPrice(double remainingPrice) {
		this.remainingPrice = remainingPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public User getSkipper() {
		return skipper;
	}

	public void setSkipper(User skipper) {
		this.skipper = skipper;
	}

	public Boat getBoat() {
		return boat;
	}

	public void setBoat(Boat boat) {
		this.boat = boat;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

}


/*
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
	//boatList.add(new Boat("test", 20.0, "destroy.jpg", 4));
	boatList.add(boat);
	return null;
}

public List<Boat> searchBoats() {
	BoatBean boatBean = Helper.getBean("boatBean", BoatBean.class);
	//Boat boatToAdd = new Boat(cartBoatType, 20.0, "cruiser.jpg", quantity);
	boatList.add(boatBean.findBoat(cartBoatType));
	//boatList.add(boatToAdd);
	return boatList;
}

public ArrayList<Boat> getBoatList() {
	return boatList;
}


public void setBoatList(ArrayList<Boat> boatList) {
	this.boatList = boatList;
}

//public String removeHandler() {
//	CartBean cart = Helper.getBean("cartBean", CartBean.class);
//	cart.removeItemFromCart(productID);
//	return null;
//	
//}
* 
*/
