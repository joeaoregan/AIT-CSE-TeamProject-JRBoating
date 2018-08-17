package com.ait.jrb;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "pricingBean")
@SessionScoped
public class PricingBean implements Serializable {
	private static final long serialVersionUID = 1L;
	//private Item item;
	private int id;
	private String name;
	private int amount;
	private Double price;
	private Double discount;
	
	ArrayList<PricingStructure> prices;
	
	public PricingBean() {
		this.id = 0;
		this.amount = 0;
		this.price = 0.0;
		this.discount = 0.0;
		prices = new ArrayList<PricingStructure>();
	}
	
/*
	public void getValues(int id, String name) {
		this.id = id;
		this.name = name;
		//return this.id;
	}
	*/
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
	
	public String addPricingHandler() {
		//ShopBean shopBean = Helper.getBean("shopBean", ShopBean.class);
		//for (Item item : shopBean.getItems()) {
		//	if (item.equals(id)) {
		//		this.name = item.getName();
		//	}
		//}
		BoatBean boatBean = Helper.getBean("jrBoatingBean", BoatBean.class);
		for (Boat boat : boatBean.getBoatInventory()) {
			if (boat.equals(id)) {
				this.name = boat.getType();
			}
		}
		//prices.add(new PricingStructure(id, name, amount, discount));
		addPricing(id,name, amount,discount);
		this.amount = 0;
		return null;
	}
	
	public void addPricing(int id, String name, int amount, double discount) {
		prices.add(new PricingStructure(id, name, amount, discount));		
	}
	
	public String renderTable() {
		if (prices.size() > 0) {
			return "true";
		}
		return "false";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
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
}
