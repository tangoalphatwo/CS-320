//Author Name: Taylor Anderson

//Date: 10/7/2020

//CourseID: CS 320

//Brief Description: Java based appointment contact database

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {
	// Verifies the constructor created the object correctly
	@Test
	void testContact() {
		Contact contact = new Contact("A123456789", "Johñ", "Smith", "1234567890", "123 Main St, City, ST 12345");
		assertTrue(contact.getID().equals("A123456789"));
		assertTrue(contact.getFirstName().equals("Johñ"));
		assertTrue(contact.getLastName().equals("Smith"));
		assertTrue(contact.getNumber().equals("1234567890"));
		assertTrue(contact.getAddress().equals("123 Main St, City, ST 12345"));
	}
	
	// Checks that the ID isn't blank, each test does the same for each parameter
	@Test
	void testContactIDNull() {
		 Assertions.assertThrows(IllegalArgumentException.class, () -> {
			 new Contact(null, "John", "Smith", "123456789", "123 Main St, City, ST 12345");
		 });
	}
	
	// Checks that the ID isn't too long, each test does the same for each parameter
	@Test
	void testContactIDTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("A12345678", "John", "Smith", "1234567890", "123 Main St, City, ST 12345");
		});
	}
	
	// Checks that the ID isn't too long, each test does the same for each parameter
	@Test
	void testContactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("A1234567890", "John", "Smith", "1234567890", "123 Main St, City, ST 12345");
		});
	}
	
	// Checks that the First Name isn't blank
	@Test
	void testContactfirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("A123456789", null, "Smith", "1234567890", "123 Main St, City, ST 12345");
		});
	}
	
	// Checks that the First Name isn't too long
	@Test
	void testContactfirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("A1234567890", "Johnbonjovi", "Smith", "1234567890", "123 Main St, City, ST 12345");
		});
	}
	
	// Checks that the Last Name isn't blank
	@Test
	void testContactlastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("A123456789", "John", null, "1234567890", "123 Main St, City, ST 12345");
		});
	}
	
	// Checks that the Last Name isn't too long
	@Test
	void testContactlastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("A123456789", "John", "Smithersons", "1234567890", "123 Main St, City, ST 12345");
		});
	}
	
	// Checks that the Phone Number isn't too blank
	@Test
	void testContactNumberNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("A123456789", "John", "Smith", null, "123 Main St, City, ST 12345");
		});
	}
	
	// Checks that the Phone Number isn't too short
	@Test
	void testContactNumberTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("A123456789", "John", "Smith", "123456789", "123 Main St, City, ST 12345");
		});
	}
	
	// Checks that the Phone Number isn't too long
	@Test
	void testContactNumberTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("A123456789", "John", "Smith", "12345678900", "123 Main St, City, ST 12345");
		});
	}
	
	// Checks that the Address isn't too blank
	@Test
	void testContactAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("A123456789", "John", "Smith", "1234567890", null);
		});
	}
	
	// Checks that the Address isn't too long
	@Test
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("A123456789", "John", "Smith", "1234567890", "123 Mymymain St, City, ST 12345");
		});
	}
}
