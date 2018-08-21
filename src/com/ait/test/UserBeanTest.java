package com.ait.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.jrb.UserBean;
import com.ait.objects.User;

class UserBeanTest {
	UserBean userBean;
	User user;

	@BeforeEach
	void setUp() throws Exception {
		userBean = new UserBean();
		user = new User(User.FRONT_DESK_STAFF, "sorcha", "asdf", "Sorcha", "Bruton", "Athlone", "0870481216", "",
				"profile.jpg", 0.0);
	}

	@Test
	void testChangeFirstName() {
		userBean.setFirstName("Jbloggs");
		assertEquals("Jbloggs", userBean.getFirstName());
	}

	@Test
	void testChangeLastname() {
		userBean.setLastName("Test");
		assertEquals("Test", userBean.getLastName());
	}

	@Test
	void testChangeUsername() {
		userBean.setUsername("Test");
		assertEquals("Test", userBean.getUsername());
	}

	@Test
	void testChangePassword() {
		userBean.setPassword("Test");
		assertEquals("Test", userBean.getPassword());
	}

	@Test
	void testChangeConfirmPassword() {
		userBean.setPasswordConfirmation("Test");
		assertEquals("Test", userBean.getPasswordConfirmation());
	}

	@Test
	void testChangeAddress() {
		userBean.setAddress("Test");
		assertEquals("Test", userBean.getAddress());
	}

	@Test
	void testChangePhone() {
		userBean.setPhone("0871234567");
		assertEquals("0871234567", userBean.getPhone());
	}

	@Test
	void testChangeType() {
		userBean.setType(2);
		assertEquals(2, userBean.getType());
	}

	@Test
	void testChangeBio() {
		userBean.setBio("test");
		assertEquals("test", userBean.getBio());
	}

	@Test
	void testChangeImage() {
		userBean.setImage("Test2");
		assertEquals("Test2", userBean.getImage());
	}

	@Test
	void testChangePricePerDay() {
		userBean.setPricePerDay(1.23);
		assertEquals(Double.valueOf(1.23), userBean.getPricePerDay());
	}

	@Test
	void testUserAdded() {
		assertEquals("USER ADDED OK", userBean.addUser(user));
	}

	@Test
	void testUserNotAdded() {
		// User sorcha = new User(User.FRONT_DESK_STAFF, "sorcha", "asdf", "asdf",
		// "Sorcha", "Bruton",
		// "Athlone", "0870481216", "", "profile.jpg", 0.0);
		assertEquals("INVALID USER", userBean.addUser(null));
	}

	@Test
	void testUsernameNotUnique() {
		userBean.addUser(user);
		assertEquals(true, userBean.checkUniqueUsername("sorcha"));
	}

	@Test
	void testUsernameUnique() {		
		User sorcha2 = new User(User.FRONT_DESK_STAFF, "sorcha", "asdf", "Sorcha", "Bruton", "Athlone", "0870481216",
				"", "profile.jpg", 0.0);
		userBean.addUser(sorcha2);
		assertEquals(false, userBean.checkUniqueUsername("sally"));
	}

	@Test
	void testChangeUserList() {
		ArrayList<User> userListTest = new ArrayList<User>();
		userBean.setUserList(userListTest);
		assertEquals(userListTest, userBean.getUserList());
	}

	@Test
	void testDisplayTypeManager() {
		assertEquals("Manager", userBean.displayType(1));
	}

	@Test
	void testDisplayTypeCustomer() {
		assertEquals("Customer", userBean.displayType(0));
	}

	@Test
	void testDisplayTypeFrontDesk() {
		assertEquals("Front Desk Staff", userBean.displayType(3));
	}

	@Test
	void testDisplayTypeSkipper() {
		assertEquals("Skipper", userBean.displayType(2));
	}

	@Test
	void testDisplayTypeInvalid() {
		assertEquals(null, userBean.displayType(5));
	}

	@Test
	void testPasswordDontMatch() {
		userBean.setPassword("asdf");
		userBean.setPasswordConfirmation("asdf1");
		assertEquals("Passwords Don't match", userBean.registerCustomerHandler());
	}

	@Test
	void testPasswordsMatch() {
		User sorcha1 = new User(User.FRONT_DESK_STAFF, "sorcha", "asdf", "Sorcha", "Bruton", "Athlone", "0870481216",
				"", "profile.jpg", 0.0);
		userBean.addUser(sorcha1);
		userBean.setPassword("asdf");
		userBean.setPasswordConfirmation("asdf");
		assertEquals("OK", userBean.registerCustomerHandler());
	}

	@Test
	void testUsernameNotUniqueCustomerHandler() {
		User sorcha1 = new User(User.FRONT_DESK_STAFF, "sorcha", "asdf", "Sorcha", "Bruton", "Athlone", "0870481216",
				"", "profile.jpg", 0.0);
		userBean.addUser(sorcha1);
		userBean.setPassword("asdf");
		userBean.setPasswordConfirmation("asdf");
		assertEquals("OK", userBean.registerCustomerHandler());
		User sorcha2 = new User(User.FRONT_DESK_STAFF, "sorcha", "asdf", "Sorcha", "Bruton", "Athlone", "0870481216",
				"", "profile.jpg", 0.0);
		userBean.addUser(sorcha2);
		userBean.setPassword("asdf");
		userBean.setPasswordConfirmation("asdf");
		assertEquals("Username Already Exists", userBean.registerCustomerHandler());
	}

	@Test
	void testUserCount() {
		ArrayList<User> userListTest = new ArrayList<User>();
		userBean.setUserList(userListTest);
		User kiev = new User(User.SKIPPER, "kiev", "asdf", "Kiev", "Reynolds", "Athlone", "0873691215", "",
				"profile.jpg", 0.0);
		userBean.addUser(kiev);
		User sorcha = new User(User.FRONT_DESK_STAFF, "sorcha", "asdf", "Sorcha", "Bruton", "Athlone", "0870481216", "",
				"profile.jpg", 0.0);
		userBean.addUser(sorcha);
		assertEquals(2, userBean.userCount());
	}

	@Test
	void testGetUserByUsername() {
		ArrayList<User> userListTest = new ArrayList<User>();
		userBean.setUserList(userListTest);
		User sorcha1 = new User(User.FRONT_DESK_STAFF, "sorcha", "asdf", "Sorcha", "Bruton", "Athlone", "0870481216",
				"", "profile.jpg", 0.0);
		userBean.addUser(sorcha1);
		assertEquals(sorcha1, userBean.getUserByUsername("sorcha"));
	}

	@Test
	void testGetUserByUsernameNotFound() {
		ArrayList<User> userListTest = new ArrayList<User>();
		userBean.setUserList(userListTest);
		assertEquals(null, userBean.getUserByUsername("sorcha"));
	}
}
