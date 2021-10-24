//Author Name: Taylor Anderson

//Date: 10/7/2020

//CourseID: CS 320

//Brief Description: Java based appointment contact database

import java.util.Date;

public class Appointment {
	// Declares the variables
	private String aptID;
	private Date aptDate;
	private String aptDesc;
	private Date today;
	
	// Constructor with calls on throwing the errors for each of the parameters 
	Appointment(String aptID, Date aptDate, String aptDesc) {
		setAptID(aptID);
		updateAptDate(aptDate);
		updateAptDesc(aptDesc);
	}
	
	// Returns the parameters for the method
	public String getAptID() {
		return aptID;
	}
	
	public Date getAptDate() {
		return aptDate;
	}
	
	public String getAptDesc() {
		return aptDesc;
	}
	
	public void setAptID(String aptID) {
		if (aptID == null) {
			throw new IllegalArgumentException("Appointment ID cannot be left blank.");
		} else if (aptID.length()<10) {
			throw new IllegalArgumentException("Appointment ID cannot be less than 10 characters.");
		} else if (aptID.length()>10) {
			throw new IllegalArgumentException("Appointment ID cannot be longer than 10 characters.");
		} else {
			this.aptID = aptID;
		}
	}
	
	public void updateAptDate(Date aptDate) {
		today = new Date();
		if (aptDate == null) {
			throw new IllegalArgumentException("Appointment date cannot be left blank.");
		} else if (aptDate.before(today)) {
			throw new IllegalArgumentException("Appointment date cannot be in the past.");
		} else {
			this.aptDate = aptDate;
		}
	}
	
	public void updateAptDesc(String aptDesc) {
		if (aptDesc == null) {
			throw new IllegalArgumentException("Task description cannot be left blank.");
		} else if (aptDesc.length()>50) {
			throw new IllegalArgumentException("Task description cannot be longer than 50 characters.");
		} else {
			this.aptDesc = aptDesc;
		}
	}

}
