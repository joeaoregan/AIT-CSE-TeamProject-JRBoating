
package com.ait.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.objects.PricingStructure;

class PricingStructureTest {
	PricingStructure pricingStructure;
	
	@BeforeEach
	void setup() {
		pricingStructure = new PricingStructure("Conoe", 10, 10);
	}
	
	@Test
	void testConstructor() {
		assertEquals("Conoe", pricingStructure.getType());
		assertEquals(10, pricingStructure.getAmount());
		//assertEquals(Double.valueOf(0.10), pricingStructure.getDiscount());
		assertEquals(10, pricingStructure.getPercent());
	}
	
	@Test
	void testGettersAndSetters() {
		pricingStructure.setType("Cruiser");
		assertEquals("Cruiser", pricingStructure.getType());	
		pricingStructure.setAmount(20);
		assertEquals(20, pricingStructure.getAmount());	
		pricingStructure.setPercent(20);
		assertEquals(20, pricingStructure.getPercent());	
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
