package com.ait.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.objects.User;

class UserTest {
	User user;

	@BeforeEach
	void setUp() throws Exception {
		user = new User(User.MANAGER, "root", "admin", "admin", "Joe", "Doe", "16 Main Road, Athlone", "123456", "bio",
				"profile.jpg", 0.0);
	}

	@Test
	void testUserConstructor() {
		assertEquals("root", user.getUsername());
		assertEquals("admin", user.getPassword());
		assertEquals("Joe", user.getFirstName());
		assertEquals("Doe", user.getLastName());
		assertEquals("16 Main Road, Athlone", user.getAddress());
		assertEquals("123456", user.getPhone());
		assertEquals(User.MANAGER, user.getType());
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
	void testUserTypeChanged() {
		user.setType(User.FRONT_DESK_STAFF);
		assertEquals(User.FRONT_DESK_STAFF, user.getType());
	}

	@Test
	void testUserBiography() {
		user.setBio("biography");
		assertEquals("biography", user.getBio());
	}
	
	@Test
	void testUserImage() {
		user.setImage("profile.jpg");
		assertEquals("profile.jpg", user.getImage());
	}
	
	@Test
	void testUserPasswordConfirmation() {
		user.setPasswordConfirmation("password");
		assertEquals("password", user.getPasswordConfirmation());
	}
	
	@Test
	void testUserSkipperPricePerDay() {
		user.setPricePerDay(100.0);
		assertEquals(Double.valueOf(100.0), user.getPricePerDay());
	}
	
	@Test
	void testUserCanEdit() {
		user.setCanEdit(true);
		assertTrue(user.getCanEdit());
	}
}