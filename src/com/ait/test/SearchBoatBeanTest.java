package com.ait.test;
import com.ait.jrb.BoatBean;
import com.ait.jrb.Helper;
import com.ait.jrb.SearchBoatBean;
import com.ait.objects.Boat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SearchBoatBeanTest {
	SearchBoatBean searchBoatBean;
	Boat boat;
	
	@BeforeEach
	void setUp() throws Exception {
		searchBoatBean = new SearchBoatBean();
		boat = new Boat("Cruiser", 100.25, "image", 1, "description","link");
		
	}

	@Test
	void testSearchBoatBean() {
		assertEquals(null,searchBoatBean.getBoat());
		assertEquals("false",searchBoatBean.getRendered());
	}

/*	@Test
	void testChangeBoat() {
		//Boat boat = new Boat("Cruiser", 100.25, "image", 1, "description","link");
		assertEquals(null,searchBoatBean.getBoat());
	}*/
	
	/*@Test
	void testSearchHandler() {
		boat = new Boat("Cruiser", 100.25, "image", 1, "description","link");
		BoatBean boatBean = new BoatBean();
		//boatBean.addNewBoat(boat);
		boatBean = Helper.getBean("boatBean", BoatBean.class);
		assertEquals("BOAT FOUND",searchBoatBean.searchBoat("Cruiser"));
		assertEquals("/customer/SearchVerify.xhtml",searchBoatBean.searchHandler());
	}*/
	
	@Test
	void testSearchBoat() {
		boat = new Boat("Cruiser", 100.25, "image", 1, "description","link");
		BoatBean boatBean = new BoatBean();
		boatBean.addNewBoat(boat);
		assertEquals("BOAT FOUND",searchBoatBean.searchBoat("Cruiser"));
		//assertEquals("false",searchBoatBean.getRendered());
	}
	
	@Test
	void testSearchBoatNotFound() {
		BoatBean boatBean = new BoatBean();
		assertEquals("BOAT NOT FOUND",searchBoatBean.searchBoat("A Boat"));
	}
	
	
	@Test
	void testBoatChanged() {
		boat = new Boat("Cruiser", 100.25, "image", 1, "description","link");
		searchBoatBean.setBoat(boat);
		assertEquals(boat, searchBoatBean.getBoat());
	}
	
	@Test
	void testBoatTypeSearchedChanged() {
		searchBoatBean.setTypeSearched("Canoe");
		assertEquals("Canoe", searchBoatBean.getTypeSearched());
	}
	
	@Test
	void testMessageChanged() {
		searchBoatBean.setMessage("Test");
		assertEquals("Test", searchBoatBean.getMessage());
	}
	
	@Test
	void testRenderedChanged() {
		searchBoatBean.setRendered("Test");
		assertEquals("Test", searchBoatBean.getRendered());
	}
	
}
