package com.ait.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.objects.User;

class UserTest {
	User user;

	@BeforeEach
	void setUp() throws Exception {
		user = new User(User.MANAGER, "root", "admin", "Joe", "Doe", "16 Main Road, Athlone", "123456", "bio",
				"profile.jpg", 40.0);
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
		assertEquals(40.0, user.getPricePerDay(), 0.00002);
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
	void testTypeChanged() {
		user.setType(User.CUSTOMER);
		assertEquals(User.CUSTOMER, user.getType());
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
	void testCanEditChanged() {
		user.setCanEdit(true);
		assertEquals(true, user.getCanEdit());
	}

	@Test
	void testUserBiographyChanged() {
		user.setBio("biography");
		assertEquals("biography", user.getBio());
	}
	@Test
	void testUserImageChanged() {
		user.setImage("profile.jpg");
		assertEquals("profile.jpg", user.getImage());
	}
	@Test
	void testUserSkipperPricePerDayChanged() {
		user.setPricePerDay(100.0);
		assertEquals(Double.valueOf(100.0), user.getPricePerDay(), 0.00002);
	}
}