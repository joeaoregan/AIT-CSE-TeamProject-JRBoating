package com.ait.objects;

//import java.util.ArrayList;

public class Order {

	///ArrayList<Item> boats = new ArrayList<Item>();
	
	///ArrayList<Boat> boats = new ArrayList<Boat>();
	///ArrayList<Equipment> equipment = new ArrayList<Equipment>();
	
	
	
	// WHAT IS NEEDED IN AN ORDER???
	
	int id;								// unique id of the order
	String custUsername;				// of the user who placed the order
		
	//Boat boat = new Boat();		
	int quantity;						// Number of boats hired
	int numDays;						// Number of days the boat is hired for
			
	//User skipper = OrderBean.getSkipper();			// Get the skipper that is booked
	
	int dayHired;						// day (between 0 and numDays) for which Skipper is hired (1 day only)
	Double skipperCost;					// In Skipper class = Skipper.price
		
	///Double discount;					// Pricing structure applies discount
	
	//Equipment equipment = new Equipment();
	
	Double deposit;						// 10% of the boat price
	Double totalPricePayNow;			// Skipper cost + boat deposit cost up front to secure the boat, and amount that needs to be paid now
	Double remainingPrice;				// Price to pay on the day
}
