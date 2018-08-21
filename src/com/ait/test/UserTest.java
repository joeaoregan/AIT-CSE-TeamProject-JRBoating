package com.ait.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.objects.User;

class UserTest {
	User user;

	@BeforeEach
	void setUp() throws Exception {
		//user = new User("Joe", "Doe", "root", "admin", "16 Main Road, Athlone", "123456", "manager");
		//user = new User("Joe", "Doe", "root", "admin", "16 Main Road, Athlone", "123456", User.MANAGER);
		

		user = new User(User.MANAGER, "root", "admin", "admin", 
				"Joe", "Doe", 
				"16 Main Road, Athlone", "123456", "bio", "profile.jpg", 0.0);
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
		assertEquals(Double.valueOf(0.0), user.getPricePerDay());
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
	void testChangeBio() {
		user.setBio("test");
		assertEquals("test", user.getBio());
	}
	@Test
	void testChangeImage() {
		user.setImage("test2");
		assertEquals("test2", user.getImage());
	}
	@Test
	void testChangePricePerDay() {
		user.setPricePerDay(1.23);
		assertEquals(Double.valueOf(1.23), user.getPricePerDay());
	}
	@Test
	void testPasswordConfirmation() {
		user.setPasswordConfirmation("test3");
		assertEquals("test3", user.getPasswordConfirmation());
	}
	@Test
	void testUserEditable() {
		user.setCanEdit(true);
		assertEquals(true, user.getCanEdit());
	}

}