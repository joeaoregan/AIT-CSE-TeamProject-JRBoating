package com.ait.objects;

public class PricingStructure {
	//private Item item;

	private String type;
	private int amount;
	private int percent;
	
	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	private Boolean canEdit;
	
	public PricingStructure(String type, int amount, int percent) {
		this.type = type;
		this.amount = amount;
		this.percent = percent;
		
		this.canEdit=false;
	}
		
	@Override
	public String toString() {
		String priceStr = null;
		priceStr = "If " + type + "(s) are hired for " + amount + " day(s) or more a discount of " + percent + "% is applied.";
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

	public Boolean getCanEdit() {
		return canEdit;
	}

	public void setCanEdit(Boolean canEdit) {
		this.canEdit = canEdit;
	}
}
