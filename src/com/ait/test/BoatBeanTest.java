package com.ait.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.jrb.BoatBean;
import com.ait.objects.Boat;

class BoatBeanTest {

	BoatBean boatBean; // 4 boats are added in the constructor
	Boat boat;

	@BeforeEach
	void setUp() throws Exception {
		boat = new Boat("Cruiser1", 100.25, "image", 1, "description","link");
		boatBean = new BoatBean();
	}

	@Test
	void testEditItemNull() {
		boat.setCanEdit(true);
		assertEquals(null, boatBean.editItem(boat));
	}

	@Test
	void testsaveAction() {
		assertEquals("OK", boatBean.addNewBoat(boat));
		assertEquals(5, boatBean.boatCount());
		boat.setCanEdit(false);
		assertEquals(null, boatBean.saveAction());
	}

	@Test
	void testBoatDetails() { // 4 boats are already added in constructor. Next boat added
								// will be id=5
		assertEquals("OK", boatBean.addNewBoat(boat));
		assertEquals("ID: Boat5, Type: Cruiser1, Price: 100.25", boatBean.boatDetails("Boat5"));
	}

	@Test
	void testBoatDetailsReturnNull() {
		assertEquals(null, boatBean.boatDetails("Boat222"));
	}

	@Test
	void changeBoatType() {
		boatBean.setBoatType("Boat1");
		assertEquals("Boat1", boatBean.getBoatType());
	}

	@Test
	void changeBoatQuantity() {
		boatBean.setQuantity(2);
		assertEquals(2, boatBean.getQuantity());
	}

	@Test
	void changeInfoMessage() {
		boatBean.setInfoMessage("Test");
		assertEquals("Test", boatBean.getInfoMessage());
	}

	@Test
	void changeDescription() {
		boatBean.setDescription("Test");
		assertEquals("Test", boatBean.getDescription());
	}

	@Test
	void changePrice() {
		boatBean.setPrice(3.25);
		assertEquals(3.25, boatBean.getPrice());
	}

	@Test
	void testChangeImage() {
		boatBean.setImage("Test image");
		assertEquals("Test image", boatBean.getImage());
	}

	@Test
	void testAddBoatOK() {
		assertEquals("OK", boatBean.addNewBoat(boat));
		assertEquals(5, boatBean.boatCount());

	}

	@Test
	void testAddBoatNull() {
		assertEquals("INVALID BOAT", boatBean.addNewBoat(null));
		assertEquals(4, boatBean.boatCount());

	}

	@Test
	void testAddSameBoatAgain() {
		assertEquals("OK", boatBean.addNewBoat(boat));
		assertEquals(5, boatBean.boatCount());
		assertEquals("BOAT TYPE EXISTS", boatBean.addNewBoat(boat));
		assertEquals(5, boatBean.boatCount());
	}

	@Test
	void testRemoveBoatOK() {
		assertEquals("OK", boatBean.addNewBoat(boat));
		assertEquals(null, boatBean.removeBoat(boat));
		assertEquals(4, boatBean.boatCount());
	}

	@Test
	void testFindBoat() {
		assertEquals("OK", boatBean.addNewBoat(boat));
		assertEquals(5, boatBean.boatCount());
		assertEquals(boat, boatBean.findBoat("Cruiser1"));
	}

	@Test
	void testFindBoatFailed() {
		boat = new Boat("Cruiser", 100.25, "image", 1, "description","link");
		assertEquals(null, boatBean.findBoat("333"));
	}

	@Test
	void testSearchBoats() {
		boat = new Boat("Cruiser", 100.25, "image", 1, "description","link");
		assertEquals(null, boatBean.findBoat("333"));
	}
	
	@Test
	void testBoatTypeAvailable() {
		boat = new Boat("Canoe", 100.25, "image", 1, "description","link");
		Boat boat2 = new Boat("Canoe", 100.25, "image", 1, "description","link");
		boatBean.addNewBoat(boat);
		boatBean.addNewBoat(boat2);
		assertEquals(true, boatBean.boatTypeAvailable("Canoe"));

	}

	@Test
	void testBoatTypeNotAvailable() {
		boat = new Boat("Canoe", 100.25, "image", 1, "description","link");
		boatBean.addNewBoat(boat);
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
	@Test
	void testChangeLink() {
		boatBean.setLink("link");
		assertEquals("link", boatBean.getLink());
	}
	@Test
	void testAddBoatHandler() {
		assertEquals(null, boatBean.addBoatHandler());
	}

}
