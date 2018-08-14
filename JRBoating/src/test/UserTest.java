
package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.User;

class UserTest {
	User user;

	@BeforeEach
	void setUp() throws Exception {
		user = new User("root", "admin", "Joe", "Doe", "16 Main Road, Athlone", "123456", "manager");
	}

	@Test
	void testUserConstructor() {
		assertEquals("root", user.getUsername());
		assertEquals("admin", user.getPassword());
		assertEquals("Joe", user.getFirstName());
		assertEquals("Doe", user.getLastName());
		assertEquals("16 Main Road, Athlone", user.getAddress());
		assertEquals("123456", user.getPhone());
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
		user.setUserType("frontDesk");
		assertEquals("frontDesk", user.getUserType());
	}
	
}
