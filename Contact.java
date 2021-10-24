//Author Name: Taylor Anderson

//Date: 10/7/2020

//CourseID: CS 320

//Brief Description: Java based appointment contact database

public class Contact {
	// Declares the variables
	private String contactID;
	private String firstName;
	private String lastName;
	private String Number;
	private String Address;
	
	// Default constructor
	Contact(String contactID, String firstName, String lastName, String Number, String Address) {
		// Updates the parameters based on the exception handling
		updateContactID(contactID);
		updateContactFirstName(firstName);
		updateContactLastName(lastName);
		updateContactNumber(Number);
		updateContactAddress(Address);
	}
	
	// Returns the parameters for the method
	public String getID() {
		return contactID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getNumber() {
		return Number;
	}
	
	public String getAddress() {
		return Address;
	}

	// Checks the parameters and returns the exception if not valid for each of the arguments
	public void updateContactID(String contactID) {
		// TODO Auto-generated method stub
		if (contactID == null) {
			throw new IllegalArgumentException("ID cannot be left blank.");
		} else if (contactID.length()<10) {
			throw new IllegalArgumentException("ID cannot be less than 10 characters.");
		} else if (contactID.length()>10) {
			throw new IllegalArgumentException("ID cannot be longer than 10 characters.");
		} else {
			this.contactID = contactID;
		}
	}
	
	// Checks the parameters and returns the exception if not valid for each of the arguments
	public void updateContactFirstName(String firstName) {
		// TODO Auto-generated method stub
		if (firstName == null) {
			throw new IllegalArgumentException("First name cannot be left blank.");
		} else if (firstName.length()>10) {
			throw new IllegalArgumentException("First name cannot be longer than 10 characters.");
		} else {
			this.firstName = firstName;
		}
	}

	// Checks the parameters and returns the exception if not valid for each of the arguments
	public void updateContactLastName(String lastName) {
		// TODO Auto-generated method stub
		if (lastName == null) {
			throw new IllegalArgumentException("Last name cannot be left blank.");
		} else if (lastName.length()>10) {
			throw new IllegalArgumentException("Last name cannot be longer than 10 characters.");
		} else {
			this.lastName = lastName;
		}
	}

	// Checks the parameters and returns the exception if not valid for each of the arguments
	public void updateContactNumber(String Number) {
		// TODO Auto-generated method stub
		if (Number == null) {
			throw new IllegalArgumentException("Phone number cannot be left blank.");
		} else if (Number.length()<10) {
			throw new IllegalArgumentException("Phone number cannot be less than 10 characters.");
		} else if (Number.length()>10) {
			throw new IllegalArgumentException("Phone number cannot be longer than 10 characters.");
		} else {
			this.Number = Number;
		}
	}

	// Checks the parameters and returns the exception if not valid for each of the arguments
	public void updateContactAddress(String Address) {
		// TODO Auto-generated method stub
		if (Address == null) {
			throw new IllegalArgumentException("Address cannot be left blank.");
		} else if (Address.length()>30) {
			throw new IllegalArgumentException("Address cannot be longer than 30 characters.");
		} else {
			this.Address = Address;
		}
	}
}
