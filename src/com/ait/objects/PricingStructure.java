package com.ait.objects;

public class PricingStructure {
	//private Item item;

	private String type;
	private int amount;
	private double discount;
	private Boolean canEdit;
	
	public PricingStructure(String type, int amount, double discount) {
		this.type = type;
		this.amount = amount;
		this.discount = discount;
		this.canEdit=false;
	}
	
	@Override
	public String toString() {
		String priceStr = null;
		priceStr = "If " + type + "(s) are hired for " + amount + " day(s) or more a discount of " + (discount*100.0) + "% is applied.";
		return priceStr;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
}
