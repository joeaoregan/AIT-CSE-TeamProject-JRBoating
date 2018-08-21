package com.ait.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.jrb.RegisterBean;

class RegisterBeanTest {
	RegisterBean registerBean;

	@BeforeEach
	void setUp() {
		registerBean = new RegisterBean();
	}
	@Test
	void testChangeFirstName() {
		registerBean.setFirstName("Sorcha");
		assertEquals("Sorcha", registerBean.getFirstName());
	}
	@Test
	void testChangeUsername() {
		registerBean.setUsername("SorchaB");
		assertEquals("SorchaB", registerBean.getUsername());
	}
	@Test
	void testChangeLastName() {
		registerBean.setLastName("Bruton");
		assertEquals("Bruton", registerBean.getLastName());
	}
	@Test
	void testChangePassword() {
		registerBean.setPassword("pword");
		assertEquals("pword", registerBean.getPassword());
	}
	@Test
	void testChangeAddress() {
		registerBean.setAddress("Athlone");
		assertEquals("Athlone", registerBean.getAddress());
	}
	@Test
	void testChangePhone() {
		registerBean.setPhone("0871234567");
		assertEquals("0871234567", registerBean.getPhone());
	}
	@Test
	void testChangeType() {
		registerBean.setType(2);
		assertEquals(2, registerBean.getType());
	}
}
