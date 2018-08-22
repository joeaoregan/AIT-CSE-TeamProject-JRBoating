package com.ait.jrb;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ait.objects.Boat;
import com.ait.objects.PricingStructure;

@ManagedBean(name = "pricingBean")
@SessionScoped
public class PricingBean implements Serializable {
	private static final long serialVersionUID = 1L;
	// private Item item;
	// private int id;
	private String type;
	private String name;
	private int amount;
	private Double price;
	private int percent;

	ArrayList<PricingStructure> prices;

	public PricingBean() {
		resetFormVariables(); // initialise/reset the form data

		prices = new ArrayList<PricingStructure>();
	}

	public String addPricingHandler() {
		InventoryBean inventoryBean = Helper.getBean("inventoryBean", InventoryBean.class);
		for (Boat boat : inventoryBean.getBoats()) {
			if (boat.equals(type)) {
				this.type = boat.getType();
			}
		}
		// prices.add(new PricingStructure(id, name, amount, discount));
		addPricing(type, amount, percent);

		resetFormVariables();

		return null;
	}

	/*
	 * Reset the data in the input text fields of the form by clearing variables
	 */
	public void resetFormVariables() {
		this.type = "Cruiser";
		this.amount = 1;
		this.price = 0.0;
		this.percent = 1;
	}

	public void addPricing(String type, int amount, int percent) {
		prices.add(new PricingStructure(type, amount, percent));
	}

	public String saveAction() {
		for (PricingStructure price : prices) {
			price.setCanEdit(false);
		}
		return null;
	}

	public String editPricingStructure(PricingStructure pricingStructure) {
		pricingStructure.setCanEdit(true);
		return null;
	}

	public String deletePricingStructure(PricingStructure pricingStructure) {
		prices.remove(pricingStructure);
		return null;
	}

	public Boolean renderTable() {
		if (prices.size() > 0) {
			return true;
		}

		return false;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public ArrayList<PricingStructure> getPrices() {
		return prices;
	}

	public void setPrices(ArrayList<PricingStructure> prices) {
		this.prices = prices;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
