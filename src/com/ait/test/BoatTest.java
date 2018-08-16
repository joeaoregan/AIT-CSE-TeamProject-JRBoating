package com.ait.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.jrb.Boat;


class BoatTest {
	Boat boat;
	@BeforeEach
	void setUp() {
		boat = new Boat("D1234", "Cruiser", 1.23, "image", 1);
	}

	@Test
	void testBoatConstructor() {
		assertEquals(123, boat.getBoatID());
		assertEquals("Cruiser", boat.getBoatType());
		assertEquals(Double.valueOf(1.23), boat.getPrice());
		assertEquals(1, boat.getQuantity());
	}
	@Test
	void changeBoatID() {
		boat.setBoatID("D1234");
		assertEquals(555, boat.getBoatID());
	}
	@Test
	void changeBoatType() {
		boat.setBoatType("Boat1");
		assertEquals("Boat1", boat.getBoatType());
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


}
