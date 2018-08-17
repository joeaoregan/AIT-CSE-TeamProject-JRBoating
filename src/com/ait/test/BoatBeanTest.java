package com.ait.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.jrb.Boat;
import com.ait.jrb.BoatBean;
import com.ait.jrb.JrBoatingBean;

class BoatBeanTest {

	BoatBean boatBean;
	Boat boat;
	JrBoatingBean jrBoatingBean;

	@BeforeEach
	void setUp() throws Exception {
		boat = new Boat("Cruiser", 100.25, "image", 1);
		boatBean = new BoatBean();
		jrBoatingBean = new JrBoatingBean();
	}

	@Test
	void changeBoatType() {
		boatBean.setBoatType("Boat1");
		assertEquals("Boat1", boatBean.getBoatType());
	}

	@Test
	void changeBoatID() {
		boatBean.setBoatID("123");
		assertEquals("123", boatBean.getBoatID());
	}

	@Test
	void changeBoatQuantity() {
		boatBean.setQuantity(2);
		assertEquals(2, boatBean.getQuantity());
	}

	@Test
	void changePrice() {
		boatBean.setPrice(3.25);
		assertEquals(Double.valueOf(3.25), boatBean.getPrice());
	}

	@Test
	void testChangeImage() {
		boatBean.setImage("Test image");
		assertEquals("Test image", boatBean.getImage());
	}

	@Test
	void testAddBoat() {
		assertEquals("OK", boatBean.addBoat(boat));
		assertEquals(1, boatBean.boatCount());
	}

	@Test
	void testAddSameBoatAgain() {
		assertEquals("OK", boatBean.addBoat(boat));
		assertEquals(1, boatBean.boatCount());
		assertEquals("BOAT TYPE EXISTS", boatBean.addBoat(boat));
		assertEquals(1, boatBean.boatCount());
	}

	@Test
	void testRemoveBoat() {
		assertEquals("OK", boatBean.addBoat(boat));
		assertEquals(1, boatBean.boatCount());
		boatBean.removeBoat(boat);
		assertEquals(0, boatBean.boatCount());
	}

	@Test
	void testFindBoat() {
		boat = new Boat("D1234", "Cruiser", 100.25, "image", 1);
		boatBean.addBoat(boat);
		assertEquals(1, boatBean.boatCount());
		assertEquals(boat, boatBean.findBoat("Cruiser"));
	}
	

	@Test
	void testFindBoatFailed() {
		boat = new Boat("D1234", "Cruiser", 100.25, "image", 1);
		boatBean.addBoat(boat);
		boatBean.removeBoat(boat);
		//assertEquals(0, boatBean.boatCount());
		assertEquals(null, boatBean.findBoat("Cruiser"));
	}


	@Test
	void testBoatTypeAvailable() {
		boat = new Boat("D1234", "Canoe", 100.25, "image", 1);
		Boat boat2 = new Boat("D1234", "Canoe", 100.25, "image", 1);
		boatBean.addBoat(boat);
		boatBean.addBoat(boat2);
		assertEquals(true, boatBean.boatTypeAvailable("Canoe"));

	}

	@Test
	void testBoatTypeNotAvailable() {
		boat = new Boat("D1234", "Canoe", 100.25, "image", 1);
		boatBean.addBoat(boat);
		assertFalse(boatBean.boatTypeAvailable("Destroyer"));
	}

	@Test
	void testSetProductID() {
		boatBean.setProductID("test");
		assertEquals("test", boatBean.getProductID());
	}

	@Test
	void testGetBoatInventory() {
		ArrayList<Boat> boats = new ArrayList<Boat>();
		boatBean.setBoatInventory(boats);
		assertEquals(boats, boatBean.getBoatInventory());
	}

	@Test
	void testSBoatType() {
		boatBean.setSboatType("test");
		assertEquals("test", boatBean.getSboatType());
	}
	
}
