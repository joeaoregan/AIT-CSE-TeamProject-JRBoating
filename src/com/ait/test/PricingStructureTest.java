
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
		assertFalse(pricingStructure.getCanEdit());
		pricingStructure.setCanEdit(true);
		assertTrue(pricingStructure.getCanEdit());
	}

	@Test
	void testChangePercent() {
		pricingStructure.setPercent(1);
		assertEquals(1, pricingStructure.getPercent());
	}

	@Test
	void testToString() {
		pricingStructure.setType("type");
		pricingStructure.setAmount(100);
		pricingStructure.setPercent(10);
		assertEquals("If type(s) are hired for 100 day(s) or more a discount of 10% is applied.",
				pricingStructure.toString());
	}
}
