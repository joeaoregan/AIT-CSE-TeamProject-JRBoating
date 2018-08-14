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
		user = new User("root", "admin", "admin", "Joe", "Doe", "16 Main Road, Athlone", 123456);
	}

	@Test
	void testUserConstructor() {
		assertEquals("root", user.getUsername());
		assertEquals("admin", user.getPassword());
		assertEquals("admin", user.getPasswordConfirmation());
		assertEquals("Joe", user.getFirstName());
		assertEquals("Doe", user.getLastName());
		assertEquals("16 Main Road, Athlone", user.getAddress());
		assertEquals(123456, user.getPhone());

	}

	@Test
	void testUsernameChanged() {
		user.setUsername("manager");
		assertEquals("manager", user.getUsername());
	}

	
	@Test
	void testUserPasswordsMatchTrue() {
		assertTrue(user.passwordsMatch());
	}

}
