package com.ait.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.objects.Boat;

class BoatTest {
	Boat boat;

	@BeforeEach
	void setUp() {
		boat = new Boat("Cruiser", 1.23, "image", 1, "description", "link");
	}

	@Test
	void testBoatConstructor() {
		assertEquals("Cruiser", boat.getType());
		assertEquals(1.23, boat.getPrice());
		assertEquals("image", boat.getImage());
		assertEquals(1, boat.getQuantity());
		assertEquals("description", boat.getDescription());
		assertEquals("link", boat.getLink());
	}

	@Test
	void changeBoatType() {
		boat.setType("Boat1");
		assertEquals("Boat1", boat.getType());
	}

	@Test
	void changePrice() {
		boat.setPrice(3.25);
		assertEquals(3.25, boat.getPrice());
	}

	@Test
	void testChangeImage() {
		boat.setImage("Test image");
		assertEquals("Test image", boat.getImage());
	}

	@Test
	void testChangeQuantity() {
		boat.setQuantity(1);
		assertEquals(1, boat.getQuantity());
	}

	@Test
	void testChangeDescription() {
		boat.setDescription("test");
		assertEquals("test", boat.getDescription());
	}

	@Test
	void testChangeLink() {
		boat.setLink("link1");
		assertEquals("link1", boat.getLink());
	}

	@Test
	void testBoatEditable() {
		boat.setCanEdit(true);
		assertTrue(boat.getCanEdit());
	}

	@Test
	void testBoatNotEditable() {
		boat.setCanEdit(false);
		assertFalse(boat.getCanEdit());
	}

	@Test
	void testBoatEquals() {
		boat.equals(boat.getType());
		assertTrue(boat.equals("Cruiser"));
	}

	@Test
	void testBoatNotEquals() {
		boat.equals(boat.getType());
		assertFalse(boat.equals("Canoe"));
		assertTrue(boat.equals("Cruiser"));
	}
}
