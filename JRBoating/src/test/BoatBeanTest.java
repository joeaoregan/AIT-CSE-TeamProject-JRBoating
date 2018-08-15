package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Boat;
import main.BoatBean;
import main.JrBoatingBean;

class BoatBeanTest {

BoatBean boatBean;
Boat boat;
JrBoatingBean jrBoatingBean;


	@BeforeEach
	void setUp() throws Exception {
		boatBean = new BoatBean();
		jrBoatingBean= new JrBoatingBean();
	}
	@Test
	void changeBoatType() {
		boatBean.setBoatType("Boat1");
		assertEquals("Boat1", boatBean.getBoatType());
	}
	@Test
	void changeBoatID() {
		boatBean.setBoatID(555);
		assertEquals(555, boatBean.getBoatID());
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
		boat = new Boat(1234,"Cruiser",100.25,"image");
		jrBoatingBean.addBoat(boat);
		assertEquals(1,jrBoatingBean.boatCount());
	}
	@Test
	void testRemoveBoat() {
		boat = new Boat(1234,"Cruiser",100.25,"image");
		jrBoatingBean.addBoat(boat);
		assertEquals(1,jrBoatingBean.boatCount());
		jrBoatingBean.removeBoat(boat);
		assertEquals(0,jrBoatingBean.boatCount());
	}

	@Test
	void testViewBoat() {
		boat = new Boat(1234,"Cruiser",100.25,"image");
		jrBoatingBean.addBoat(boat);
		assertEquals(1,jrBoatingBean.boatCount());
		jrBoatingBean.viewBoat("Cruiser");
		assertEquals(boat,jrBoatingBean.viewBoat("Cruiser"));
	}
	
}
