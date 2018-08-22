package com.ait.jrb;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import com.ait.objects.Boat;
import com.ait.objects.Order;
import com.ait.objects.User;

@ManagedBean(name = "orderBean")
@SessionScoped
public class OrderBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Boat boatSelected;
	private User skipper;

	private String boatType;
	private ArrayList<Order> allOrders; // List of orders
	private Order currentOrder;

	private int formQuantity;
	private int formNumDays;
	private int formDayHired;
	private double formDeposit;
	private double formTotalCost;
		
	public OrderBean() {
		boatSelected = null;
		skipper = null;
		
		boatType = "Cruiser"; // Selects the Cruiser as default radio button
		currentOrder = new Order();
		allOrders = new ArrayList<Order>();
		
		//addTestOrder();		 // Affects code coverage, uses Helper
	}
	
	public double orderTotal() {
		double total = 0.0;
		for (Order order : allOrders) {
			total += (order.getTotalPricePayNow() + order.getRemainingPrice());
		}
		return total;
	}
	public double totalDeposits() {
		double total = 0.0;
		for (Order order : allOrders) {
			total += order.getTotalPricePayNow();
		}
		return total;
	}
	
	public String totalOrderPrice(Order order) {
		return Double.toString(order.getTotalPricePayNow() + order.getRemainingPrice());
	}
	
	// Must be return type string for form
	public String selectBoat() {
		formDeposit = depositToPay();
		return null;
	}
	
	public double depositToPay() {
		formDeposit = (double) formQuantity * formNumDays * 0.1; // 10% deposit required for boats
		//return "€" + Double.toString(total);
		return formDeposit;	// format as currency
	}
	

	public String pricePerDay() {
		//boatSelected = getSelectedBoat();
		//if (boatSelected != null) {
		if ((boatSelected = getSelectedBoat()) != null) {
			return Double.toString(boatSelected.getPrice());
		}

		return "BOAT NOT FOUND";
	}

	public void addTestOrder() {
		InventoryBean inventoryBean = Helper.getBean("inventoryBean", InventoryBean.class);
		UserBean userBean = Helper.getBean("userBean", UserBean.class);
		
		allOrders.add(new Order("Order1", "elaine", inventoryBean.findBoat("Canoe"), 1, 5, userBean.getUserByUsername("kiev"), 3, 50.0, 0.0, 65.0, 65.0, 120.0));
		allOrders.add(new Order("Order2", "elaine", inventoryBean.findBoat("Canoe"), 1, 3, userBean.getUserByUsername("kiev"), 2, 50.0, 0.0, 60.0, 60.0, 100.0));	
	}

	public Boat getSelectedBoat() {
		InventoryBean inventoryBean = Helper.getBean("inventoryBean", InventoryBean.class);
		return inventoryBean.findBoat(boatType);
	}

	public String quantityInStock() {
		//System.out.println("test");
		boatSelected = getSelectedBoat();
		
		if (boatSelected != null) {
			return Integer.toString(boatSelected.getQuantity());
		}

		return "BOAT NOT FOUND";
	}
	
	
	
	public ArrayList<Order> getAllOrders() {
		return allOrders;
	}

	public void setAllOrders(ArrayList<Order> allOrders) {
		this.allOrders = allOrders;
	}

	public Order getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}

	public String getBoatType() {
		return boatType;
	}

	public void setBoatType(String boatType) {
		this.boatType = boatType;
	}

	public Boat getBoatSelected() {
		return boatSelected;
	}

	public void setBoatSelected(Boat boatSelected) {
		this.boatSelected = boatSelected;
	}

	public int getFormQuantity() {
		return formQuantity;
	}

	public void setFormQuantity(int formQuantity) {
		this.formQuantity = formQuantity;
	}

	public int getFormNumDays() {
		return formNumDays;
	}

	public void setFormNumDays(int formNumDays) {
		this.formNumDays = formNumDays;
	}

	public int getFormDayHired() {
		return formDayHired;
	}

	public void setFormDayHired(int formDayHired) {
		this.formDayHired = formDayHired;
	}

	public double getFormDeposit() {
		return formDeposit;
	}

	public void setFormDeposit(double formDeposit) {
		this.formDeposit = formDeposit;
	}

	public double getFormTotalCost() {
		return formTotalCost;
	}

	public void setFormTotalCost(double formTotalCost) {
		this.formTotalCost = formTotalCost;
	}

	public User getSkipper() {
		return skipper;
	}

	public void setSkipper(User skipper) {
		this.skipper = skipper;
	}

}

// order = new Order(id, custUsername, boat, quantity, numDays, skipper,
// dayHired, skipperCost, discount, deposit,
// totalPricePayNow, remainingPrice);

/*
 * private String id; private String custUsername; private int quantity; private
 * int numDays; private int dayHired; private double skipperCost; private double
 * deposit; private double totalPricePayNow; private double remainingPrice;
 * private double discount; private User skipper = null; private Boat boat; //
 * private Equipment equipment = new Equipment();
 */
/*
 * public ArrayList<Boat> searchBoats() { BoatBean boatBean =
 * Helper.getBean("boatBean", BoatBean.class); // Boat boatToAdd = new
 * Boat(cartBoatType, 20.0, "cruiser.jpg", quantity);
 * boatList.add(boatBean.findBoat(cartBoatType)); // boatList.add(boatToAdd);
 * return boatList; }
 */
/*
 * public String getCartBoatType() { return cartBoatType; }
 * 
 * public void setCartBoatType(String cartBoatType) { this.cartBoatType =
 * cartBoatType; }
 * 
 * public String getId() { return id; }
 * 
 * public void setId(String id) { this.id = id; }
 * 
 * public String getCustUsername() { return custUsername; }
 * 
 * public void setCustUsername(String custUsername) { this.custUsername =
 * custUsername; }
 * 
 * public int getQuantity() { return quantity; }
 * 
 * public void setQuantity(int quantity) { this.quantity = quantity; }
 * 
 * public int getNumDays() { return numDays; }
 * 
 * public void setNumDays(int numDays) { this.numDays = numDays; }
 * 
 * public int getDayHired() { return dayHired; }
 * 
 * public void setDayHired(int dayHired) { this.dayHired = dayHired; }
 * 
 * public double getSkipperCost() { return skipperCost; }
 * 
 * public void setSkipperCost(double skipperCost) { this.skipperCost =
 * skipperCost; }
 * 
 * public double getDeposit() { return deposit; }
 * 
 * public void setDeposit(double deposit) { this.deposit = deposit; }
 * 
 * public double getTotalPricePayNow() { return totalPricePayNow; }
 * 
 * public void setTotalPricePayNow(double totalPricePayNow) {
 * this.totalPricePayNow = totalPricePayNow; }
 * 
 * public double getRemainingPrice() { return remainingPrice; }
 * 
 * public void setRemainingPrice(double remainingPrice) { this.remainingPrice =
 * remainingPrice; }
 * 
 * public double getDiscount() { return discount; }
 * 
 * public void setDiscount(double discount) { this.discount = discount; }
 * 
 * public User getSkipper() { return skipper; }
 * 
 * public void setSkipper(User skipper) { this.skipper = skipper; }
 * 
 * public Boat getBoat() { return boat; }
 * 
 * public void setBoat(Boat boat) { this.boat = boat; }
 * 
 * public ArrayList<Order> getOrders() { return orders; }
 * 
 * public void setOrders(ArrayList<Order> orders) { this.orders = orders; }
 */
