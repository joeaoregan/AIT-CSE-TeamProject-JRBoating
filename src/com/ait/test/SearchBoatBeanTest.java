package com.ait.test;
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
	void testSearchBoatBeanConstructor() {
		assertEquals(null,searchBoatBean.getBoat());
		assertEquals("",searchBoatBean.getTypeSearched());
		assertEquals("",searchBoatBean.getMessage());
		assertEquals("false",searchBoatBean.getRendered());
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
