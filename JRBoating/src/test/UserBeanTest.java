package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.UserBean;

class UserBeanTest {
	UserBean userBean;

	@BeforeEach
	void setUp() throws Exception {
		userBean = new UserBean();
	}

	@Test
	void testChangeFirstname() {
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
		userBean.setUserType("Test");
		assertEquals("Test", userBean.getUserType());
	}

	@Test
	void testChangePhoneNumber() {
		userBean.setPhoneNumber("123456");
		assertEquals("123456", userBean.getPhoneNumber());
	}

	@Test
	void testChangeIsManagerLoggedIn() {
		userBean.setManagerLoddgedIn(true);
		assertTrue(userBean.isManagerLoddgedIn());
	}

	@Test
	void testChangeIsCustomerLoggedIn() {
		userBean.setCustomerLoggedIn(false);
		assertFalse(userBean.isCustomerLoggedIn());
	}

	@Test
	void testChangeIsFrontDeskLoggedIn() {
		userBean.setFrontDeskLoggedIn(false);
		assertFalse(userBean.isFrontDeskLoggedIn());
	}

	@Test
	void testChangeIsSkipperLoggedIn() {
		userBean.setSkipperLoggedIn(true);
		assertTrue(userBean.isSkipperLoggedIn());
	}

	@Test
	void testRegisterUserEmptyUsername() {
		userBean.setUsername("");
		userBean.setFirstName("Jbloggs");
		userBean.setLastName("Test");
		userBean.setPassword("Test");
		userBean.setPasswordConfirmation("Test");
		userBean.setAddress("Test");
		userBean.setPhoneNumber("123456");
		assertEquals("All input must be filled", userBean.registerCustomer());
	}

	
	@Test
	void testRegisterUserEmptyFirstName() {
		userBean.setUsername("Test");
		userBean.setFirstName("");
		userBean.setLastName("Test");
		userBean.setPassword("Test");
		userBean.setPasswordConfirmation("Test");
		userBean.setAddress("Test");
		userBean.setPhoneNumber("123456");
		assertEquals("All input must be filled", userBean.registerCustomer());
	}
	
	@Test
	void testRegisterUserEmptyLastName() {
		userBean.setUsername("Test");
		userBean.setFirstName("Jbloggs");
		userBean.setLastName("");
		userBean.setPassword("Test");
		userBean.setPasswordConfirmation("Test");
		userBean.setAddress("Test");
		userBean.setPhoneNumber("123456");
		assertEquals("All input must be filled", userBean.registerCustomer());
	}
	
	@Test
	void testRegisterUserEmptyPassword() {
		userBean.setUsername("Test");
		userBean.setFirstName("Jbloggs");
		userBean.setLastName("Test");
		userBean.setPassword("");
		userBean.setPasswordConfirmation("Test");
		userBean.setAddress("Test");
		userBean.setPhoneNumber("123456");
		assertEquals("All input must be filled", userBean.registerCustomer());
	}
	@Test
	void testRegisterUserEmptyPasswordConfirmation() {
		userBean.setUsername("Test");
		userBean.setFirstName("Jbloggs");
		userBean.setLastName("Test");
		userBean.setPassword("Test");
		userBean.setPasswordConfirmation("");
		userBean.setAddress("Test");
		userBean.setPhoneNumber("123456");
		assertEquals("All input must be filled", userBean.registerCustomer());
	}
	@Test
	void testRegisterUserEmptyAddress() {
		userBean.setUsername("Test");
		userBean.setFirstName("Jbloggs");
		userBean.setLastName("Test");
		userBean.setPassword("Test");
		userBean.setPasswordConfirmation("Test");
		userBean.setAddress("");
		userBean.setPhoneNumber("123456");
		assertEquals("All input must be filled", userBean.registerCustomer());
	}
	
	@Test
	void testRegisterUserEmptyPhoneNumber() {
		userBean.setUsername("Test");
		userBean.setFirstName("Jbloggs");
		userBean.setLastName("Test");
		userBean.setPassword("Test");
		userBean.setPasswordConfirmation("Test");
		userBean.setAddress("Test");
		userBean.setPhoneNumber("");
		assertEquals("All input must be filled", userBean.registerCustomer());
	}
	
	
	
//=======
//
//	@Test
//	void testUserLoginTrueManagerLogged() {
//		userBean.setManagerLoddgedIn(true);
//		assertTrue(userBean.userLogin());
//>>>>>>> branch 'master' of https://a00212817@bitbucket.org/boating/jrboating.git
//	}
//
//	@Test
//	void testUserLoginFalse() {
//		userBean.setManagerLoddgedIn(false);
//		userBean.setCustomerLoggedIn(false);
//		userBean.setFrontDeskLoggedIn(false);
//		userBean.setSkipperLoggedIn(false);
//		assertFalse(userBean.userLogin());
//	}
//	
//	@Test
//	void testUserLoginTrueCustomerLoggedIn() {
//		userBean.setCustomerLoggedIn(true);
//		assertTrue(userBean.userLogin());
//	}
//	
//	@Test
//	void testUserLoginTrueFrontDeskLoggedIn() {
//		userBean.setFrontDeskLoggedIn(true);
//		assertTrue(userBean.userLogin());
//	}
//	
//	@Test
//	void testUserLoginTrueSkipperLoggedIn() {
//		userBean.setSkipperLoggedIn(true);
//		assertTrue(userBean.userLogin());
//	}
}
