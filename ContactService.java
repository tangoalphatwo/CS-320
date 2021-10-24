//Author Name: Taylor Anderson

//Date: 10/7/2020

//CourseID: CS 320

//Brief Description: Java based appointment contact database

import java.util.ArrayList;
import java.util.List;

public class ContactService {
	// This is the contact list
	List<Contact> contacts = new ArrayList<>();
	
	// Default constructor
	public void newContact(String ID, String firstName, String lastName, String Number, String Address) {
		Contact contact = new Contact(ID, firstName, lastName, Number, Address);
		contacts.add(contact);
	}

	// Deletes Contact
	public void deleteContact(String ID) throws Exception {
		contacts.remove(search(ID));
	}
	
	// Updates First Name parameter
	public void updateContactFirstName(String ID, String firstName) throws Exception {
		search(ID).updateContactFirstName(firstName);
	}
	
	// Updates Last Name parameter
	public void updateContactLastName(String ID, String lastName) throws Exception {
		search(ID).updateContactLastName(lastName);
	}
	
	// Updates Phone Number parameter
	public void updateContactNumber(String ID, String Number) throws Exception {
		search(ID).updateContactNumber(Number);
	}
	
	// Updates Address parameter
	public void updateContactAddress(String ID, String Address) throws Exception {
		search(ID).updateContactAddress(Address);
	}
	
	//returns array
	public List<Contact> getContacts() {
		return contacts;
	}
	
	// Searches the list to match the ID
	private Contact search(String ID) throws Exception {
		// TODO Auto-generated method stub
		int i = 0;
		while (i < contacts.size()) {
			if (ID.equalsIgnoreCase(contacts.get(i).getID())) {
				return contacts.get(i);
			}
			i++;
		}
		throw new Exception("Not a valid ID.");
	}
	
}
