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
	void testSetters() {
		pricingBean.setAmount(10);
		assertEquals(10, pricingBean.getAmount());
		pricingBean.setPrice(1.25);
		assertEquals(Double.valueOf(1.25), pricingBean.getPrice());
		pricingBean.setName("test");
		assertEquals("test", pricingBean.getName());
		ArrayList<PricingStructure> prices = new ArrayList<PricingStructure>();
		pricingBean.setPrices(prices);
		assertEquals(prices, pricingBean.getPrices());
		pricingBean.setType("type");
		assertEquals("type", pricingBean.getType());
		pricingBean.setPercent(1);
		assertEquals(1, pricingBean.getPercent());
	}
	//test False version of RenderTableEmpty?
	@Test
	void testRenderTableEmpty() {
		assertEquals(false, pricingBean.renderTable());	// String not boolean
		//ArrayList prices= new ArrayList<PricingStructure>();
		//PricingStructure price= new PricingStructure("type", 10, 1);
		//prices.add(price);
		//assertEquals(1, prices.size());
		//assertEquals(true, pricingBean.renderTable());
	}
	//test False version of SaveAction?
	@Test
	void testSaveAction() {
		assertEquals(null, pricingBean.saveAction());
		//ArrayList prices= new ArrayList<PricingStructure>();
		//PricingStructure price= new PricingStructure("type", 10, 1);
		//price.setCanEdit(false);
		//prices.add(price);
		}
	
	@Test
	void testEditPricingStructure() {
		PricingStructure pricingStructure = new PricingStructure("item2", 10, 1);
		assertEquals(null, pricingBean.editPricingStructure(pricingStructure));
	}
	
	@Test
	void testDeletePricingStructure() {
		PricingStructure pricingStructure = new PricingStructure("item2", 10, 1);
		assertEquals(null, pricingBean.deletePricingStructure(pricingStructure));		
	}
	
	@Test
	void testAddPricing() {
		pricingBean.addPricing("type", 10, 1);
		assertEquals(1, pricingBean.getPrices().size());
	}

	
}
