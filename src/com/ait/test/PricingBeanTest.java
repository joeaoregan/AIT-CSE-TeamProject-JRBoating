package com.ait.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.jrb.PricingBean;
import com.ait.objects.PricingStructure;

class PricingBeanTest {

	PricingBean pricingBean;

	@BeforeEach
	void setup() {
		pricingBean = new PricingBean();
	}

	@Test
	void testConstructor() {
		assertEquals(0, pricingBean.getAmount());
		assertEquals(Double.valueOf(0.0), pricingBean.getPrice());
		assertEquals(0, pricingBean.getPercent());
	}

	@Test
	void testSetters() {
		pricingBean.setAmount(10);
		assertEquals(10, pricingBean.getAmount());
		pricingBean.setPrice(1.25);
		assertEquals(Double.valueOf(1.25), pricingBean.getPrice());
		pricingBean.setPercent(5);
		assertEquals(5, pricingBean.getPercent());	
		pricingBean.setName("test");
		assertEquals("test", pricingBean.getName());
		
		ArrayList<PricingStructure> prices = new ArrayList<PricingStructure>();
		pricingBean.setPrices(prices);
		assertEquals(prices, pricingBean.getPrices());
	}
	
	@Test
	void testRenderTableEmpty() {
		assertEquals(false, pricingBean.renderTable());	// String not boolean
		pricingBean.addPricing("test",  10,  20);
		assertEquals(true, pricingBean.renderTable());
	}
	
	@Test
	void testSaveAction() {
		pricingBean.addPricing("test",  10,  20);
		assertEquals(null, pricingBean.saveAction());
	}
	
	@Test
	void testEditPricingStructure() {
		PricingStructure pricingStructure = new PricingStructure("item2", 10, 10);
		assertEquals(null, pricingBean.editPricingStructure(pricingStructure));
	}
	
	@Test
	void testDeletePricingStructure() {
		PricingStructure pricingStructure = new PricingStructure("item2", 10, 10);
		assertEquals(null, pricingBean.deletePricingStructure(pricingStructure));		
	}
	
	@Test
	void testAddPricing() {
		pricingBean.addPricing("test",  10,  20);
		assertEquals(1, pricingBean.getPrices().size());
	}
	@Test
	void testChangeType() {
		pricingBean.setType("type");
		assertEquals("type", pricingBean.getType());
	}
	
}
