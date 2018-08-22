package com.ait.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.jrb.InventoryBean;
import com.ait.objects.Boat;

class InventoryBeanTest {
	InventoryBean inventoryBean;
	Boat boat;

	@BeforeEach
	void setUp() {
		inventoryBean = new InventoryBean();
		boat = new Boat("Cruiser", 1.23, "image", 1, "description", "link");
	}

	@Test
	void testChangeType() {
		inventoryBean.setType("type");
		assertEquals("type", inventoryBean.getType());
	}

	@Test
	void testChangePrice() {
		inventoryBean.setPrice(10.50);
		assertEquals(10.50, inventoryBean.getPrice(), 0.0);

	}

	@Test
	void testChangeImage() {
		inventoryBean.setImage("Image");
		assertEquals("Image", inventoryBean.getImage());
	}

	@Test
	void testChangeQuantity() {
		inventoryBean.setQuantity(5);
		assertEquals(5, inventoryBean.getQuantity());
	}

	@Test
	void testChangeDescription() {
		inventoryBean.setDescription("Description");
		assertEquals("Description", inventoryBean.getDescription());
	}

	@Test
	void testChangeLink() {
		inventoryBean.setLink("Link");
		assertEquals("Link", inventoryBean.getLink());
	}

	@Test
	void testChangeNewBoat() {
		inventoryBean.setNewBoat(boat);
		assertEquals(boat, inventoryBean.getNewBoat());
	}

	@Test
	void testChangeMessage() {
		inventoryBean.setMessage("Message");
		assertEquals("Message", inventoryBean.getMessage());
	}

	@Test
	void testChangeBoats() {
		ArrayList<Boat> boats = new ArrayList<Boat>();
		inventoryBean.setBoats(boats);
		assertEquals(boats, inventoryBean.getBoats());
	}

	@Test
	void testCanEdit() {
		assertEquals(null, inventoryBean.editBoat(boat));
	}

	@Test
	void testDeleteBoat() {
		assertEquals(null, inventoryBean.deleteBoat(boat));
	}

	@Test
	void testSaveAction() {
		assertEquals(null, inventoryBean.saveAction());
	}
	
	/*
	@Test
	void testFindBoat() {
		ArrayList boats= new ArrayList<Boat>();
		boats.add(boat);
		assertEquals("Cruiser", inventoryBean.findBoat("Cruiser"));
	}*/

}
