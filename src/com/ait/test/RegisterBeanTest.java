package com.ait.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.jrb.RegisterBean;
import com.ait.objects.User;

class RegisterBeanTest {
	RegisterBean registerBean;

	@BeforeEach
	void setUp() {
		registerBean = new RegisterBean();
	}
	
	@Test
	void testConstructor() {
		assertEquals(null, registerBean.getNewUser());
		assertEquals(User.CUSTOMER, registerBean.getType());
		assertEquals("", registerBean.getUsername());
		assertEquals("", registerBean.getPassword());
		assertEquals("", registerBean.getFirstName());
		assertEquals("", registerBean.getLastName());
		assertEquals("", registerBean.getAddress());
		assertEquals("", registerBean.getPhone());
		assertEquals("", registerBean.getBio());
		assertEquals("profile.jpg", registerBean.getImage());
		assertEquals(0.0, registerBean.getPricePerDay());
		assertEquals("", registerBean.getMessage());
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
	
	@Test
	void testChangeMessage() {
		registerBean.setMessage("test");
		assertEquals("test", registerBean.getMessage());
	}

	@Test
	void testGetObscuredPassord() {
		registerBean.setPassword("Test");
		assertEquals("T...t", registerBean.getObscuredPassword());
	}

	@Test
	void testRegister2() {
		assertEquals("/customer/RegistrationVerify.xhtml", registerBean.register2());
	}

	@Test
	void testChangeImage() {
		registerBean.setImage("image");
		assertEquals("image", registerBean.getImage());
	}

	@Test
	void testChangePricePerDay() {
		registerBean.setPricePerDay(12.56);
		assertEquals(12.56, registerBean.getPricePerDay());
	}

	@Test
	void testNewUser() {
		User user = new User(User.MANAGER, "root", "admin", "Joe", "Doe", "16 Main Road, Athlone", "123456", "bio",
				"profile.jpg", 40.0);
		registerBean.setNewUser(user);
		assertEquals(user, registerBean.getNewUser());
	}

	@Test
	void testChangeBio() {
		registerBean.setBio("bio");
		assertEquals("bio", registerBean.getBio());
	}
}
