package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Boat;


class BoatTest {
	Boat boat;
	@BeforeEach
	void setUp() {
		boat = new Boat(123, "Cruiser", 1.23, "image");
	}

	@Test
	void testBoatConstructor() {
		assertEquals(123, boat.getBoatID());
		assertEquals("Cruiser", boat.getBoatType());
		assertEquals(1.23, 1.23);
	}
	@Test
	void changeBoatID() {
		boat.setBoatID(555);
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

}
