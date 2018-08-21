package com.ait.objects;

//import java.util.ArrayList;

public class Order {

	///ArrayList<Item> boats = new ArrayList<Item>();	
	///ArrayList<Boat> boats = new ArrayList<Boat>();
	///ArrayList<Equipment> equipment = new ArrayList<Equipment>();	
	
	// WHAT IS NEEDED IN AN ORDER???
	
	String id;									// unique id of the order
	String custUsername;						// of the user who placed the order
		
	Boat boat;									// Can be an array
	
	int quantity;								// Number of boats hired
	int numDays;								// Number of days the boat is hired for
			
	//User skipper = OrderBean.getSkipper();	// Get the skipper that is booked
	User skipper = null;
	
	int dayHired;								// day (between 0 and numDays) for which Skipper is hired (1 day only)
	double skipperCost;							// In Skipper class = Skipper.price
		
	Double discount;							// Pricing structure applies discount
	
	//Equipment equipment = new Equipment();	// Can be an array of equipment
	
	Double deposit;								// 10% of the boat price
	Double totalPricePayNow;					// Skipper cost + boat deposit cost up front to secure the boat, and amount that needs to be paid now
	Double remainingPrice;						// Price to pay on the day

	private boolean canEdit;
	
	public Order() {
		id = "";
		custUsername = "";	
		boat = null;
		quantity = 0;
		numDays = 0;
		skipper = null;
		dayHired = 0;
		skipperCost = 0.0;
		discount = 0.0;
		deposit = 0.0;
		totalPricePayNow = 0.0;
		remainingPrice = 0.0;
	}

	public Order(String id, String custUsername, Boat boat, int quantity, int numDays, User skipper, int dayHired, double skipperCost, double discount, double deposit,
			double totalPricePayNow, double remainingPrice) {
		this.id = id;
		this.custUsername = custUsername;	
		this.boat = boat;
		this.quantity = quantity;
		this.numDays = numDays;
		this.skipper = skipper;
		this.dayHired = dayHired;
		this.skipperCost = skipperCost;
		this.discount = discount;
		this.deposit = deposit;
		this.totalPricePayNow = totalPricePayNow;	// will be the same as deposit if no equipment is purchased
		this.remainingPrice = remainingPrice;
	}

	public boolean isCanEdit() {
		return canEdit;
	}

	public void setCanEdit(boolean canEdit) {
		this.canEdit = canEdit;
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
	public Boat getBoat() {
		return boat;
	}
	public void setBoat(Boat boat) {
		this.boat = boat;
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
	public User getSkipper() {
		return skipper;
	}
	public void setSkipper(User skipper) {
		this.skipper = skipper;
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
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Double getDeposit() {
		return deposit;
	}
	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}
	public Double getTotalPricePayNow() {
		return totalPricePayNow;
	}
	public void setTotalPricePayNow(Double totalPricePayNow) {
		this.totalPricePayNow = totalPricePayNow;
	}
	public Double getRemainingPrice() {
		return remainingPrice;
	}
	public void setRemainingPrice(Double remainingPrice) {
		this.remainingPrice = remainingPrice;
	}
}
