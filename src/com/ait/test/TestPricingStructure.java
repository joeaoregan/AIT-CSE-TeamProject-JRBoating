/*
 * A00258304
 * Joe O'Regan
 * 100% coverage
 */
package com.ait.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.jrb.*;

class TestPricingStructure {
	PricingStructure pricingStructure;
	
	@BeforeEach
	void setup() {
		pricingStructure = new PricingStructure(1, "item2", 10, 0.1);
	}
	
	@Test
	void testConstructor() {
		assertEquals(1, pricingStructure.getId());
		assertEquals(10, pricingStructure.getAmount());
		//assertEquals(Double.valueOf(0.10), pricingStructure.getDiscount());
		assertEquals(0.10, pricingStructure.getDiscount());
	}
	
	@Test
	void testGettersAndSetters() {
		pricingStructure.setId(6);
		assertEquals(6, pricingStructure.getId());	
		pricingStructure.setName("item1");
		assertEquals("item1", pricingStructure.getName());	
		pricingStructure.setAmount(20);
		assertEquals(20, pricingStructure.getAmount());	
		pricingStructure.setDiscount(0.20);
		assertEquals(0.20, pricingStructure.getDiscount());	
	}
	
	@Test
	void testCanEdit() {
		//assertTrue(pricingStructure.getCanEdit());
		//pricingStructure.setCanEdit(false);
		//assertFalse(pricingStructure.getCanEdit());

		assertFalse(pricingStructure.getCanEdit());
		pricingStructure.setCanEdit(true);
		assertTrue(pricingStructure.getCanEdit());
	}
	
	//@Test
	//void testToString() {
	//	ShopBean shopBean = new ShopBean();
	//	shopBean.addBoat("item1", 100.0, "boat1.jpg");
	//	shopBean.addBoat("item2", 100.0, "boat2.jpg");
	//	assertEquals("If item2(s) are hired for 10 day(s) or more a discount of 10.0% is applied.",pricingStructure.toString());
	//}
}
