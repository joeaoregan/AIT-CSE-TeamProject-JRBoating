package com.ait.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.objects.User;

class UserTest {
	User user;

	@BeforeEach
	void setUp() throws Exception {
		user = new User(User.MANAGER, "root", "admin", "admin", 
				"Joe", "Doe", 
				"16 Main Road, Athlone", "123456", "bio", "profile.jpg", 40.0);
	}

	@Test
	void testUserConstructor() {
		assertEquals("root", user.getUsername());
		assertEquals("admin", user.getPassword());
		assertEquals("Joe", user.getFirstName());
		assertEquals("Doe", user.getLastName());
		assertEquals("16 Main Road, Athlone", user.getAddress());
		assertEquals("123456", user.getPhone());
		assertEquals("bio", user.getBio());
		assertEquals("profile.jpg", user.getImage());
		assertEquals(40.0, user.getPricePerDay(),0.00002);
		
		
	}

	@Test
	void testUsernameChanged() {
		user.setUsername("manager");
		assertEquals("manager", user.getUsername());
	}

	@Test
	void testPasswordChanged() {
		user.setPassword("pass");
		assertEquals("pass", user.getPassword());
	}

	@Test
	void testPasswordConfirmationChanged() {
		user.setPasswordConfirmation("any");
		assertEquals("any", user.getPasswordConfirmation());
	}
	
	@Test
	void testFirstNameChanged() {
		user.setFirstName("David");
		assertEquals("David", user.getFirstName());
	}

	@Test 
	void testLastNameChanged() {
		user.setLastName("David");
		assertEquals("David", user.getLastName());
	}

	@Test
	void testAddressChanged() {
		user.setAddress("1 Athlone Street, Athlone");
		assertEquals("1 Athlone Street, Athlone", user.getAddress());
	}

	@Test
	void testPhoneChanged() {
		user.setPhone("67890");
		assertEquals("67890", user.getPhone());
	}

	@Test
	void testTypeChanged() {
		user.setType(user.CUSTOMER);
		assertEquals(user.CUSTOMER, user.getType());
	}
	@Test
	void testBioChanged() {
		user.setBio("bioTest");
		assertEquals("bioTest", user.getBio());
	}

	@Test
	void testImageChanged() {
		user.setImage("boat1.jpg");
		assertEquals("boat1.jpg", user.getImage());
	}
	
	@Test
	void testPricePerDayChanged() {
		user.setPricePerDay(50.0);
		assertEquals(50.0, user.getPricePerDay(),0.00002);
	}
	
	@Test
	void testCanEditChanged() {
		user.setCanEdit(true);
		assertEquals(true, user.getCanEdit());
	}
	
	
}