package com.ait.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.objects.Boat;
import com.ait.objects.Order;
import com.ait.objects.User;

class OrderTest {
	
	Order order;
	//Order order1;
	Boat boat; // boat to be hired
	User skipper;

	@BeforeEach
	void setUp() throws Exception {
		//order1 = new Order();
		
		skipper = new User(User.SKIPPER, "skip", "pass", "Joe", "O'Regan", "Thurles", "123456", "bio",
		"profile.jpg", 0.0);
		boat = new Boat("Cruiser", 100.0, "image", 1, "description", "link");		
		
		order = new  Order("Order1", "joe1", boat, 1, 10, skipper, 5, 100.0, 0.0, 110.0,
				110, 90);
	}
	
	@Test
	void testOrderID() {
		assertEquals("Order1", order.getId());
		order.setId("Order2");
		assertEquals("Order2", order.getId());
	}

	@Test
	void testOrderGetCustomerUsername() {
		assertEquals("joe1", order.getCustUsername());
		order.setCustUsername("elaine");
		assertEquals("elaine", order.getCustUsername());
	}
	
	@Test
	void testOrderGetBoat() {
		assertEquals(boat, order.getBoat());

		Boat boat2 = new Boat("Canoe", 50.0, "image", 1, "description", "link");
		order.setBoat(boat2);
		assertEquals(boat2, order.getBoat());
	}

	@Test
	void testOrderQuantity() {
		assertEquals(1, order.getQuantity());

		order.setQuantity(2);
		assertEquals(2, order.getQuantity());
	}

	@Test
	void testOrderNumDays() {
		assertEquals(10, order.getNumDays());

		order.setNumDays(20);
		assertEquals(20, order.getNumDays());
	}

	@Test
	void testOrderSkipper() {
		assertEquals(skipper, order.getSkipper());

		User skipper2 = new User(User.SKIPPER, "kiev", "pass", "Kiev", "Reynolds", "Athlone", "123456", "bio",
		"profile.jpg", 0.0);
		order.setSkipper(skipper2);
		assertEquals(skipper2, order.getSkipper());
	}
	
	@Test
	void testOrderSkipperDayHired() {
		assertEquals(5, order.getDayHired());
		order.setDayHired(6);
		assertEquals(6, order.getDayHired());
	}
	
	@Test
	void testOrderSkipperCost() {
		assertEquals(100.0, order.getSkipperCost());
		order.setSkipperCost(125.0);
		assertEquals(125.0, order.getSkipperCost());
	}
	
	@Test
	void testOrderDiscountApplied() {
		assertEquals(Double.valueOf(0.0), order.getDiscount());
		order.setDiscount(15.0);
		assertEquals(Double.valueOf(15.0), order.getDiscount());
	}
	
	@Test
	void testOrderDepositToPay() {
		assertEquals(Double.valueOf(110.0), order.getDeposit());
		order.setDeposit(150.0);
		assertEquals(Double.valueOf(150.0), order.getDeposit());
	}
	
	@Test
	void testOrderTotalPricePayNow() {
		assertEquals(Double.valueOf(110.0), order.getTotalPricePayNow());
		order.setTotalPricePayNow(150.0);
		assertEquals(Double.valueOf(150.0), order.getTotalPricePayNow());
	}
	
	@Test
	void testOrderRemainingPrice() {
		assertEquals(Double.valueOf(90.0), order.getRemainingPrice());
		order.setRemainingPrice(150.0);
		assertEquals(Double.valueOf(150.0), order.getRemainingPrice());
	}
}
