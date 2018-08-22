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
	Order order;

	@BeforeEach
	void setUp() throws Exception {
		orderBean = new OrderBean();
	}

	@Test
	void testChangeCartType() {
		orderBean.setBoatType("BoatType");
		assertEquals("BoatType", orderBean.getBoatType());
	}

	@Test
	void testChangeQuantity() {
		orderBean.setFormQuantity(5);
		assertEquals(5, orderBean.getFormQuantity());
	}

	@Test
	void testChangeNumberOfDays() {
		orderBean.setFormNumDays(10);
		assertEquals(10, orderBean.getFormNumDays());
	}

	@Test
	void testChangeDaysHired() {
		orderBean.setFormDayHired(1);
		assertEquals(1, orderBean.getFormDayHired());
	}

	@Test
	void testChangeDeposit() {
		orderBean.setFormDeposit(12.56);
		assertEquals(12.56, orderBean.getFormDeposit(), 0.0);
	}

	@Test
	void testChangeFormTotalCost() {
		orderBean.setFormTotalCost(12.56);
		assertEquals(12.56, orderBean.getFormTotalCost(), 0.0);
	}

	@Test
	void testChangeSkipper() {
		User skipper1 = new User(User.SKIPPER, "kiev", "asdf", "Kiev", "Reynolds", "Athlone", "1234567",
				"About Kiev", "profile.jpg", 50.0);
		orderBean.setSkipper(skipper1);
		assertEquals(skipper1, orderBean.getSkipper());
	}

	@Test
	void testChangeBoat() {
		Boat boat = new Boat("Cruiser", 1.23, "image", 1, "description", "link");
		orderBean.setBoatSelected(boat);
		assertEquals(boat, orderBean.getBoatSelected());
	}

	@Test
	void testChangeOrders() {
		ArrayList<Order> orders = new ArrayList<Order>();
		orderBean.setAllOrders(orders);
		assertEquals(orders, orderBean.getAllOrders());
	}
	@Test
	void testChangeCurrentOrder() {
		Order order= new Order();
		orderBean.setCurrentOrder(order);
		assertEquals(order, orderBean.getCurrentOrder());
	}
	//to be reviewed ref SB
	@Test
	void testTotalDeposits() {
		Order order= new Order();
		ArrayList<Order> orders= new ArrayList<Order>();
		order.setTotalPricePayNow(10.10);
		orders.add(order);
		assertEquals(0.0, orderBean.totalDeposits(),0.0);
	}
	//to be reviewed ref SB
	@Test
	void testOrderTotal() {
		Order order= new Order();
		ArrayList<Order> orders= new ArrayList<Order>();
		order.setTotalPricePayNow(10.10);
		order.setRemainingPrice(12.10);
		orders.add(order);
		assertEquals(0.0, orderBean.orderTotal(),0.0);
	}

}