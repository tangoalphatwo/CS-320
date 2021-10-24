//Author Name: Taylor Anderson

//Date: 10/7/2020

//CourseID: CS 320

//Brief Description: Java based appointment contact database

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppointmentService {
	// This is the contact list
	List<Appointment> apts = new ArrayList<>();
	
	// Default constructor
	public void newApt(String aptID, Date aptDate, String aptDesc) {
		Appointment apt = new Appointment(aptID, aptDate, aptDesc);
		apts.add(apt);
	}
	
	// Deletes appointment
	public void deleteApt(String aptID) throws Exception {
		apts.remove(aptSearch(aptID));
	}
	
	// Update appointment date
	public void updateAptDate(String aptID, Date aptDate) throws Exception {
		aptSearch(aptID).updateAptDate(aptDate);
	}
	
	// Update appointment description
	public void updateAptDesc(String aptID, String aptDesc) throws Exception {
		aptSearch(aptID).updateAptDesc(aptDesc);
	}
	
	//returns array
	public List<Appointment> getAppointments() {
		return apts;
	}

	// Searches the list to match the appointment ID
	private Appointment aptSearch(String aptID) throws Exception {
		// TODO Auto-generated method stub
		int i = 0;
		while (i < apts.size()) {
			if (aptID.equalsIgnoreCase(apts.get(i).getAptID())) {
				return apts.get(i);
			}
			i++;
		}
		throw new Exception("Not a valid appointment ID.");
	}
	
}
