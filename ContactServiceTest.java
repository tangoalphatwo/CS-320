//Author Name: Taylor Anderson

//Date: 10/7/2020

//CourseID: CS 320

//Brief Description: Java based appointment contact database

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	// Tests adding a new contact
	@Test
	void testNewContact() {
		ContactService cs = new ContactService();
		cs.newContact("A123456789", "John", "Smith", "1234567890", "123 Main St, City, ST 12345");
		
		assertEquals("A123456789", cs.getContacts().get(0).getID());
		assertEquals("John", cs.getContacts().get(0).getFirstName());
		assertEquals("Smith", cs.getContacts().get(0).getLastName());
		assertEquals("1234567890", cs.getContacts().get(0).getNumber());
		assertEquals("123 Main St, City, ST 12345", cs.getContacts().get(0).getAddress());
	}
	
	// Tests adding multiple contacts
	@Test
	void testMultiNewContact() {
		ContactService cs1 = new ContactService();
		cs1.newContact("A123456789", "John", "Smith", "1234567890", "123 Main St, City, ST 12345");
		ContactService cs2 = new ContactService();
		cs2.newContact("B123456789", "Jane", "Doe", "0987654321", "456 Main St, City, ST 12345");
		
		assertEquals("A123456789", cs1.getContacts().get(0).getID());
		assertEquals("John", cs1.getContacts().get(0).getFirstName());
		assertEquals("Smith", cs1.getContacts().get(0).getLastName());
		assertEquals("1234567890", cs1.getContacts().get(0).getNumber());
		assertEquals("123 Main St, City, ST 12345", cs1.getContacts().get(0).getAddress());
		
		assertEquals("B123456789", cs2.getContacts().get(0).getID());
		assertEquals("Jane", cs2.getContacts().get(0).getFirstName());
		assertEquals("Doe", cs2.getContacts().get(0).getLastName());
		assertEquals("0987654321", cs2.getContacts().get(0).getNumber());
		assertEquals("456 Main St, City, ST 12345", cs2.getContacts().get(0).getAddress());
	}
	
	// Tests deleting a contact
	@Test
	void testDeleteContact() {
		ContactService cs = new ContactService();
		cs.newContact("A123456789", "John", "Smith", "1234567890", "123 Main St, City, ST 12345");
		
		Assertions.assertThrows(Exception.class, () -> cs.deleteContact("C123456789"));
		
		assertAll(() -> cs.deleteContact(cs.getContacts().get(0).getID()));
	}
	
	// Tests updating the First Name
	@Test
	void testUpdateFirstName() throws Exception {
		ContactService cs = new ContactService();
		cs.newContact("A123456789", "John", "Smith", "1234567890", "123 Main St, City, ST 12345");

		Assertions.assertThrows(IllegalArgumentException.class, () -> cs.updateContactFirstName("A123456789", "Johnbonjovi"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> cs.updateContactFirstName("A123456789", null));
	
		cs.updateContactFirstName("A123456789", "Jacob");
		assertEquals("Jacob", cs.getContacts().get(0).getFirstName());
	}
	
	// Tests updating the Last Name
	@Test
	void testUpdateLastName() throws Exception {
		ContactService cs = new ContactService();
		cs.newContact("A123456789", "John", "Smith", "1234567890", "123 Main St, City, ST 12345");

		Assertions.assertThrows(IllegalArgumentException.class, () -> cs.updateContactLastName("A123456789", "Smithersons"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> cs.updateContactLastName("A123456789", null));
		
		cs.updateContactLastName("A123456789", "Jones");
		assertEquals("Jones", cs.getContacts().get(0).getLastName());
	}

	// Tests updating the Phone Number
	@Test
	void testUpdateNumber() throws Exception {
		ContactService cs = new ContactService();
		cs.newContact("A123456789", "John", "Smith", "1234567890", "123 Main St, City, ST 12345");

		Assertions.assertThrows(IllegalArgumentException.class, () -> cs.updateContactNumber("A123456789", "12345678"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> cs.updateContactNumber("A123456789", "12345678900"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> cs.updateContactNumber("A123456789", null));
		
		cs.updateContactNumber("A123456789", "9999999999");
		assertEquals("9999999999", cs.getContacts().get(0).getNumber());
	}
	
	// Tests updating the Address
	@Test
	void testUpdateAddress() throws Exception {
		ContactService cs = new ContactService();
		cs.newContact("A123456789", "John", "Smith", "1234567890", "123 Main St, City, ST 12345");

		Assertions.assertThrows(IllegalArgumentException.class, () -> cs.updateContactAddress("A123456789", "123 Mymymain Street, State, USA"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> cs.updateContactAddress("A123456789", null));
		
		cs.updateContactAddress("A123456789", "789 Main St, City, ST 12345");
		assertEquals("789 Main St, City, ST 12345", cs.getContacts().get(0).getAddress());
	}
}
