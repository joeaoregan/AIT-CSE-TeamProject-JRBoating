package com.ait.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.jrb.UserBean;
import com.ait.objects.User;

class UserBeanTest {
	UserBean userBean;

	@BeforeEach
	void setUp() throws Exception {
		userBean = new UserBean();
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
	void testChangeUserType() {
		userBean.setType(User.CUSTOMER);
		assertEquals(User.CUSTOMER, userBean.getType());
	}

	@Test
	void testChangePhoneNumber() {
		userBean.setPhone("123456");
		assertEquals("123456", userBean.getPhone());
	}
<<<<<<< HEAD
	

	// MOVED TO LOGIN BEAN
=======
<<<<<<< HEAD
>>>>>>> branch 'master' of https://sorchabruton@bitbucket.org/aitcse4/jrboating-master.git
/*
	@Test
	void testChangeIsManagerLoggedIn() {
		UserBean.setManagerLoggedIn(true);
		assertTrue(UserBean.isManagerLoddgedIn());
	}

	@Test
	void testChangeIsCustomerLoggedIn() {
		UserBean.setCustomerLoggedIn(false);
		assertFalse(userBean.isCustomerLoggedIn());
	}

	@Test
	void testChangeIsFrontDeskLoggedIn() {
		userBean.setFrontDeskLoggedIn(false);
		assertFalse(userBean.isFrontDeskLoggedIn());
	}

	@Test
	void testChangeIsSkipperLoggedIn() {
		UserBean.setSkipperLoggedIn(true);
		assertTrue(userBean.isSkipperLoggedIn());
	}

//	@Test
//
//	void testCustomerRegister() {
//		userBean.setUsername("Test");
//		userBean.setFirstName("Jbloggs");
//		userBean.setLastName("Test");
//		userBean.setPassword("Test");
//		userBean.setPasswordConfirmation("Test");
//		userBean.setAddress("Test");
//		userBean.setPhoneNumber("Test");
//		assertEquals("OK", userBean.registerCustomerHandler());
//		
//	}

	@Test
	void testUserLoginAsManager() {
		userBean.setlUsername("root");
		userBean.setlPassword("admin");		
		assertEquals("manager", userBean.userLogin());
	}
	
	@Test
	void testUserLoginAsManagerWrongPassword() {
		userBean.setlUsername("root");
		userBean.setlPassword("password");		
		assertEquals("error", userBean.userLogin());
	}
	

	@Test
	void testUserLoginAsFrontDesk() {
		userBean.setlUsername("fd");
		assertEquals("frontdesk", userBean.userLogin());
	}
	@Test
	void testUserLoginAsCustomer() {
		userBean.setlUsername("any");
		assertEquals("customer", userBean.userLogin());
	}

	@Test
	void testUserLoginAsSkipper() {
		userBean.setlUsername("sk");
		assertEquals("skipper", userBean.userLogin());
	}*/

=======
>>>>>>> branch 'master' of https://elaine12@bitbucket.org/aitcse4/jrboating-master.git
}
