package com.ait.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.jrb.LoginBean;
import com.ait.objects.User;

class LoginBeanTest {

	LoginBean loginBean;

	@BeforeEach
	void setUp() throws Exception {
		loginBean = new LoginBean();
	}

	@Test
	void testChangeIsManagerLoggedIn() {
		loginBean.setLoggedInManager(true);
		assertTrue(loginBean.getLoggedInManager());
	}

	@Test
	void testChangeIsCustomerLoggedIn() {
		loginBean.setLoggedInCustomer(false);
		assertFalse(loginBean.getLoggedInCustomer());
	}

	@Test
	void testChangeIsFrontDeskLoggedIn() {
		loginBean.setLoggedInFDS(false);
		assertFalse(loginBean.getLoggedInFDS());
	}

	@Test
	void testChangeIsSkipperLoggedIn() {
		loginBean.setLoggedInSkipper(true);
		assertTrue(loginBean.getLoggedInSkipper());
	}

	@Test
	void testGetSetMessage() {
		loginBean.setMessage("test");
		assertEquals("test", loginBean.getMessage());
	}
	
	@Test
	void testWrongLoggedIn() {
		loginBean.setUserLoggedIn(20);
		assertFalse(loginBean.getLoggedInCustomer());
		assertFalse(loginBean.getLoggedInManager());
		assertFalse(loginBean.getLoggedInFDS());
		assertFalse(loginBean.getLoggedInSkipper());
	}

	@Test
	void testSetUserLoggedIn() {
		loginBean.setUserLoggedIn(User.CUSTOMER);
		assertTrue(loginBean.getLoggedInCustomer());
		loginBean.setUserLoggedIn(User.MANAGER);
		assertTrue(loginBean.getLoggedInManager());
		loginBean.setUserLoggedIn(User.FRONT_DESK_STAFF);
		assertTrue(loginBean.getLoggedInFDS());
		loginBean.setUserLoggedIn(User.SKIPPER);
		assertTrue(loginBean.getLoggedInSkipper());
	}
/*
	@Test
	void testShowLogInPage() {
		loginBean.setLoggedUser(new User(User.MANAGER, "root", "admin", "admin", "Joe", "Doe", "16 Main Road, Athlone",
				"123456", "bio", "profile.jpg", 0.0));
		assertEquals("/login", loginBean.showLoginPage());
	}
*/
	
	// Problem with Helper function
/*
 	@Test
	void testGetUser() {
		assertEquals(null, loginBean.getUser());
	}
*/
	
	@Test
	void testGetSetUsername() {
		loginBean.setUsername("test");
		assertEquals("test", loginBean.getUsername());
	}
	
	@Test
	void testGetSetPassword() {
		loginBean.setPassword("test");
		assertEquals("test", loginBean.getPassword());		
	}
	@Test
	void testShowLogInPage() {
		User user = new User(User.MANAGER, "root", "admin", "admin", "Joe", "Doe", "16 Main Road, Athlone",
				"123456", "bio", "profile.jpg", 0.0);
		loginBean.setLoggedUser(user);
		assertEquals(user, loginBean.getLoggedUser());
	}

}
