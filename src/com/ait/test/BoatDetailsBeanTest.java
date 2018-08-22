package com.ait.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.jrb.BoatDetailsBean;

class BoatDetailsBeanTest {
	BoatDetailsBean boatDetailsBean;

	@BeforeEach
	void setUp() {
		boatDetailsBean= new BoatDetailsBean() ;
	}
	@Test
	void testChangeIndex() {
		boatDetailsBean.setIndex(1);
		assertEquals(1, boatDetailsBean.getIndex());
	}
	@Test
	void testChangeTitle() {
		boatDetailsBean.setTitle("Canal Barge");
		assertEquals("Canal Barge", boatDetailsBean.getTitle());
	}
	@Test
	void testPageTitle() {
		boatDetailsBean.setTitle("Canal Barge");
		assertEquals("Canal Barge", boatDetailsBean.pageTitle());
	}

	@Test
	void testCurrentBoatDetails() {
		boatDetailsBean.setIndex(0);
		assertEquals("DetailsCanalBarge", boatDetailsBean.currentBoatDetails());
	}
	
	@Test
	void testNextAndPreviousButtons() {
		assertEquals("BoatDetails", boatDetailsBean.previousButton());
		assertEquals("BoatDetails", boatDetailsBean.nextButton());
	}
}
