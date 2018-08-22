
package com.ait.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.objects.PricingStructure;

class PricingStructureTest {
	PricingStructure pricingStructure;
	
	@BeforeEach
	void setup() {
		pricingStructure = new PricingStructure("Conoe", 10, 1);
	}
	
	@Test
	void testConstructor() {
		assertEquals("Conoe", pricingStructure.getType());
		assertEquals(10, pricingStructure.getAmount());

	}
	
	@Test
	void testGettersAndSetters() {
		pricingStructure.setType("Cruiser");
		assertEquals("Cruiser", pricingStructure.getType());	
		pricingStructure.setAmount(20);
		assertEquals(20, pricingStructure.getAmount());	

	}
	
	@Test
	void testCanEdit() {
		assertFalse(pricingStructure.getCanEdit());
		pricingStructure.setCanEdit(true);
		assertTrue(pricingStructure.getCanEdit());
	}
	@Test
	void testChangePercent() {
		pricingStructure.setPercent(1);
		assertEquals(1, pricingStructure.getPercent());
	}
	/*can't figure out how to test SB
	@Test
	void testToString() {
		pricingStructure.setType("type");
		pricingStructure.setAmount(100);
		pricingStructure.setDiscount(0.01);
		assertEquals("If type(s) are hired for amount day(s) or more a discount of 1% is applied.", pricingStructure.toString());
	}*/
}
