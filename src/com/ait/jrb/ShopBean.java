package com.ait.jrb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ait.jrb.Helper;

@ManagedBean
@RequestScoped
public class ShopBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cartBoatType;
	private int quantity;
	private ArrayList<Boat> searchBoat;

	public ShopBean() {
		searchBoat = new ArrayList<Boat>();
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

	public void addToCart() {
		JrBoatingBean jrBoatingBeanDB = Helper.getBean("jrBoatingBean", JrBoatingBean.class);
		searchBoat.add(jrBoatingBeanDB.viewBoat(cartBoatType));
	}

	public List<Boat> searchBoats() {
		JrBoatingBean jrBoatingBeanDB = Helper.getBean("jrBoatingBean", JrBoatingBean.class);
		searchBoat.add(jrBoatingBeanDB.viewBoat(cartBoatType));
		return searchBoat;
	}
//	
//	public String removeHandler() {
//		CartBean cart = Helper.getBean("cartBean", CartBean.class);
//		cart.removeItemFromCart(productID);
//		return null;
//		
//	}

}
