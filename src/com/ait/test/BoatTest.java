package com.ait.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.objects.Boat;


class BoatTest {
	Boat boat;
	@BeforeEach
	void setUp() {
		boat = new Boat("Cruiser", 1.23, "image", 1, "description","link");
	}

	@Test
	void testBoatConstructor() {
		assertEquals("Cruiser", boat.getType());
		assertEquals(Double.valueOf(1.23), boat.getPrice());
		assertEquals("image", boat.getImage());
		assertEquals(1, boat.getQuantity());
		assertEquals("description", boat.getDescription());
	}

	@Test
	void changeBoatType() {
		boat.setType("Boat1");
		assertEquals("Boat1", boat.getType());
	}
	@Test
	void changePrice() {
		boat.setPrice(3.25);
		assertEquals(Double.valueOf(3.25), boat.getPrice());
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
	void testBoatEditable() {
		boat.setCanEdit(true);
		assertEquals(true, boat.isCanEdit());
	}
	@Test
	void testBoatNotEditable() {
		boat.setCanEdit(false);
		assertEquals(false, boat.isCanEdit());
	}
	@Test
	void testChangeLink() {
		boat.setLink("link1");
		assertEquals("link1", boat.getLink());
	}
	@Test
	void testBoatEquals() {
		boat.equals(boat.getType());
		assertEquals(true, boat.equals("Cruiser"));
	}
	@Test
	void testBoatNotEquals() {
		boat.equals(boat.getType());
		assertEquals(false, boat.equals("Canoe"));
	}
}
