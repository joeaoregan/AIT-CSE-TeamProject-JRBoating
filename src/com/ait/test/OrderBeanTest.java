package com.ait.test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;


import com.ait.jrb.OrderBean;
import com.ait.objects.Boat;
import com.ait.objects.Order;
import com.ait.objects.User;


class OrderBeanTest {
	OrderBean orderBean;
	

	@BeforeEach
	void setUp() {
		orderBean= new OrderBean();
	}
	@Test
	void testChangeCartType() {
		orderBean.setCartBoatType("CartBoatType");
		assertEquals("CartBoatType", orderBean.getCartBoatType());
	}
	@Test
	void testChangeId() {
		orderBean.setId("ID");
		assertEquals("ID", orderBean.getId());
	}
	@Test
	void testChangeCustUserName() {
		orderBean.setCustUsername("sorcha");
		assertEquals("sorcha", orderBean.getCustUsername());
	}
	@Test
	void testChangeQuantity() {
		orderBean.setQuantity(5);
		assertEquals(5, orderBean.getQuantity());
	}
	@Test
	void testChangeNumberOfDays() {
		orderBean.setNumDays(10);
		assertEquals(10, orderBean.getNumDays());
	}
	@Test
	void testChangeDaysHired() {
		orderBean.setDayHired(1);
		assertEquals(1, orderBean.getDayHired());
	}
	@Test
	void testChangeSkipperCost() {
		orderBean.setSkipperCost(12.56);
		assertEquals(12.56, orderBean.getSkipperCost(),0.0);
	}
	@Test
	void testChangeDeposit() {
		orderBean.setDeposit(12.56);
		assertEquals(12.56, orderBean.getDeposit(),0.0);
	}
	@Test
	void testChangeTotalPriceToPayPayNow() {
		orderBean.setTotalPricePayNow(12.56);
		assertEquals(12.56, orderBean.getTotalPricePayNow(),0.0);
	}
	@Test
	void testChangeRemainingPrice() {
		orderBean.setRemainingPrice(12.56);
		assertEquals(12.56, orderBean.getRemainingPrice(),0.0);
	}
	@Test
	void testChangeDiscount() {
		orderBean.setDiscount(12.56);
		assertEquals(12.56, orderBean.getDiscount(),0.0);
	}
	@Test
	void testChangeSkipper() {
		User skipper1=new User(User.SKIPPER, "root", "admin", "admin", "Joe", "Doe", "16 Main Road, Athlone", "123456", "bio",
				"profile.jpg", 40.0);
		orderBean.setSkipper(skipper1);
		assertEquals(skipper1, orderBean.getSkipper());
	}
	@Test
	void testChangeBoat() {
		Boat boat = new Boat("Cruiser", 1.23, "image", 1, "description");
		orderBean.setBoat(boat);
		assertEquals(boat, orderBean.getBoat());
	}
	@Test
	void testChangeOrders() {
		ArrayList<Order> orders= new ArrayList<Order>();
		orderBean.setOrders(orders);
		assertEquals(orders, orderBean.getOrders());
	}

	
}