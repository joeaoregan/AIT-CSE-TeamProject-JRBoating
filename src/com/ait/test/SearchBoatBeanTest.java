package com.ait.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.jrb.SearchBoatBean;
import com.ait.objects.Boat;

class SearchBoatBeanTest {
	SearchBoatBean searchBoatBean;
	Boat boat;

	@BeforeEach
	void setUp() {
		searchBoatBean= new SearchBoatBean();
		boat = new Boat("Cruiser", 1.23, "image", 1, "description","link");
	}
	@Test
	void changeBoat() {
		searchBoatBean.setBoat(boat);
		assertEquals(boat, searchBoatBean.getBoat());
	}
	@Test
	void testChangeTypeSearched() {
		searchBoatBean.setTypeSearched("type searched");
		assertEquals("type searched", searchBoatBean.getTypeSearched());
	}
	@Test
	void testChangeMessage() {
		searchBoatBean.setMessage("message");
		assertEquals("message", searchBoatBean.getMessage());
	}
	
}
