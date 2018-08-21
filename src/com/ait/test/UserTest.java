package com.ait.test;

import static org.junit.Assert.assertEquals;
<<<<<<< HEAD

import static org.junit.Assert.assertTrue;
=======
>>>>>>> branch 'master' of https://sorchabruton@bitbucket.org/aitcse4/jrboating-master.git

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import com.ait.objects.User;

class UserTest {

	User user;

	@BeforeEach

	void setUp() throws Exception {
<<<<<<< HEAD

=======
>>>>>>> branch 'master' of https://sorchabruton@bitbucket.org/aitcse4/jrboating-master.git
		user = new User(User.MANAGER, "root", "admin", "admin", "Joe", "Doe", "16 Main Road, Athlone", "123456", "bio",
<<<<<<< HEAD

				"profile.jpg", 40.0);

=======
				"profile.jpg", 40.0);
>>>>>>> branch 'master' of https://sorchabruton@bitbucket.org/aitcse4/jrboating-master.git
	}



	@Test

	void testUserConstructor() {

		assertEquals("root", user.getUsername());

		assertEquals("admin", user.getPassword());

		assertEquals("Joe", user.getFirstName());

		assertEquals("Doe", user.getLastName());

		assertEquals("16 Main Road, Athlone", user.getAddress());

		assertEquals("123456", user.getPhone());
<<<<<<< HEAD

=======
>>>>>>> branch 'master' of https://sorchabruton@bitbucket.org/aitcse4/jrboating-master.git
		assertEquals("bio", user.getBio());

		assertEquals("profile.jpg", user.getImage());
<<<<<<< HEAD

		assertEquals(40.0, user.getPricePerDay(), 0.00002);

=======
		assertEquals(40.0, user.getPricePerDay(), 0.00002);
>>>>>>> branch 'master' of https://sorchabruton@bitbucket.org/aitcse4/jrboating-master.git
		assertEquals(User.MANAGER, user.getType());
<<<<<<< HEAD

=======
>>>>>>> branch 'master' of https://sorchabruton@bitbucket.org/aitcse4/jrboating-master.git
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

<<<<<<< HEAD


=======
>>>>>>> branch 'master' of https://sorchabruton@bitbucket.org/aitcse4/jrboating-master.git
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
<<<<<<< HEAD

=======
>>>>>>> branch 'master' of https://sorchabruton@bitbucket.org/aitcse4/jrboating-master.git
	void testTypeChanged() {
<<<<<<< HEAD

		user.setType(user.CUSTOMER);

		assertEquals(user.CUSTOMER, user.getType());

=======
		user.setType(User.CUSTOMER);
		assertEquals(User.CUSTOMER, user.getType());
	}

	@Test
	void testBioChanged() {
		user.setBio("bioTest");
		assertEquals("bioTest", user.getBio());
>>>>>>> branch 'master' of https://sorchabruton@bitbucket.org/aitcse4/jrboating-master.git
	}



	@Test
<<<<<<< HEAD

	void testBioChanged() {

		user.setBio("bioTest");

		assertEquals("bioTest", user.getBio());

	}



	@Test

=======
>>>>>>> branch 'master' of https://sorchabruton@bitbucket.org/aitcse4/jrboating-master.git
	void testImageChanged() {

		user.setImage("boat1.jpg");

		assertEquals("boat1.jpg", user.getImage());

	}

<<<<<<< HEAD


	@Test

=======
	@Test
>>>>>>> branch 'master' of https://sorchabruton@bitbucket.org/aitcse4/jrboating-master.git
	void testCanEditChanged() {

		user.setCanEdit(true);

		assertEquals(true, user.getCanEdit());

	}

<<<<<<< HEAD


	@Test

	void testUserBiographyChanged() {

=======
	@Test
	void testUserBiographyChanged() {
>>>>>>> branch 'master' of https://sorchabruton@bitbucket.org/aitcse4/jrboating-master.git
		user.setBio("biography");

		assertEquals("biography", user.getBio());

	}

<<<<<<< HEAD


=======
>>>>>>> branch 'master' of https://sorchabruton@bitbucket.org/aitcse4/jrboating-master.git
	@Test
<<<<<<< HEAD

	void testUserImageChanged() {

=======
	void testUserImageChanged() {
>>>>>>> branch 'master' of https://sorchabruton@bitbucket.org/aitcse4/jrboating-master.git
		user.setImage("profile.jpg");

		assertEquals("profile.jpg", user.getImage());

	}

<<<<<<< HEAD


=======
>>>>>>> branch 'master' of https://sorchabruton@bitbucket.org/aitcse4/jrboating-master.git
	@Test
<<<<<<< HEAD

	void testUserSkipperPricePerDayChanged() {

=======
	void testUserSkipperPricePerDayChanged() {
>>>>>>> branch 'master' of https://sorchabruton@bitbucket.org/aitcse4/jrboating-master.git
		user.setPricePerDay(100.0);
<<<<<<< HEAD

		assertEquals(Double.valueOf(100.0), user.getPricePerDay(), 0.00002);

=======
		assertEquals(Double.valueOf(100.0), user.getPricePerDay(), 0.00002);
>>>>>>> branch 'master' of https://sorchabruton@bitbucket.org/aitcse4/jrboating-master.git
	}

<<<<<<< HEAD


=======
>>>>>>> branch 'master' of https://sorchabruton@bitbucket.org/aitcse4/jrboating-master.git
}