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
<<<<<<< HEAD
	void testConstructor() {
		assertEquals(0, pricingBean.getAmount());
		assertEquals(Double.valueOf(0.0), pricingBean.getPrice());
		assertEquals(0, pricingBean.getPercent());
	}

	@Test
=======
>>>>>>> 6ed44d560def34af08b8d9dd96ce2c8fa48e7d83
	void testSetters() {
		pricingBean.setAmount(10);
		assertEquals(10, pricingBean.getAmount());
		pricingBean.setPrice(1.25);
		assertEquals(Double.valueOf(1.25), pricingBean.getPrice());
<<<<<<< HEAD
		pricingBean.setPercent(5);
		assertEquals(5, pricingBean.getPercent());	
=======
>>>>>>> 6ed44d560def34af08b8d9dd96ce2c8fa48e7d83
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
<<<<<<< HEAD
		pricingBean.addPricing("test",  10,  20);
		assertEquals(true, pricingBean.renderTable());
=======
		//ArrayList prices= new ArrayList<PricingStructure>();
		//PricingStructure price= new PricingStructure("type", 10, 1);
		//prices.add(price);
		//assertEquals(1, prices.size());
		//assertEquals(true, pricingBean.renderTable());
>>>>>>> 6ed44d560def34af08b8d9dd96ce2c8fa48e7d83
	}
	//test False version of SaveAction?
	@Test
	void testSaveAction() {
<<<<<<< HEAD
		pricingBean.addPricing("test",  10,  20);
=======
>>>>>>> 6ed44d560def34af08b8d9dd96ce2c8fa48e7d83
		assertEquals(null, pricingBean.saveAction());
		//ArrayList prices= new ArrayList<PricingStructure>();
		//PricingStructure price= new PricingStructure("type", 10, 1);
		//price.setCanEdit(false);
		//prices.add(price);
		}
	
	@Test
	void testEditPricingStructure() {
<<<<<<< HEAD
		PricingStructure pricingStructure = new PricingStructure("item2", 10, 10);
=======
		PricingStructure pricingStructure = new PricingStructure("item2", 10, 1);
>>>>>>> 6ed44d560def34af08b8d9dd96ce2c8fa48e7d83
		assertEquals(null, pricingBean.editPricingStructure(pricingStructure));
	}
	
	@Test
	void testDeletePricingStructure() {
<<<<<<< HEAD
		PricingStructure pricingStructure = new PricingStructure("item2", 10, 10);
=======
		PricingStructure pricingStructure = new PricingStructure("item2", 10, 1);
>>>>>>> 6ed44d560def34af08b8d9dd96ce2c8fa48e7d83
		assertEquals(null, pricingBean.deletePricingStructure(pricingStructure));		
	}
	
	@Test
	void testAddPricing() {
<<<<<<< HEAD
		pricingBean.addPricing("test",  10,  20);
=======
		pricingBean.addPricing("type", 10, 1);
>>>>>>> 6ed44d560def34af08b8d9dd96ce2c8fa48e7d83
		assertEquals(1, pricingBean.getPrices().size());
	}

	
}
