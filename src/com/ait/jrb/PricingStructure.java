package com.ait.jrb;

public class PricingStructure {
	//private Item item;
	private int id;
	private String name;
	private int amount;
	private double discount;
	private Boolean canEdit;
	
	public PricingStructure(int id, String name, int amount, double discount) {
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.discount = discount;
		this.canEdit=false;
		//this.item = null;
	}
	
	@Override
	public String toString() {
		//ShopBean shopBean = Helper.getBean("shopBean", ShopBean.class);
		String priceStr =null;
		//for (Item item : shopBean.getItems()) {
			//if (item.equals(id)) {
				//priceStr = "If " + item.getName() + "(s) are hired for " + amount + " day(s) or more a discount of " + (discount*100.0) + "% is applied.";				
			//} 
		//}
		priceStr = "If " + name + "(s) are hired for " + amount + " day(s) or more a discount of " + (discount*100.0) + "% is applied.";
		return priceStr;
	}
	/*
	public Item getItem() {
		ShopBean shopBean = Helper.getBean("shopBean", ShopBean.class);
		for (Item item : shopBean.getItems()) {
			if (item.equals(id)) {
				this.item = item;
			}
		}
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
*/
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

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Boolean getCanEdit() {
		return canEdit;
	}

	public void setCanEdit(Boolean canEdit) {
		this.canEdit = canEdit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
