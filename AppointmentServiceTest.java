//Author Name: Taylor Anderson

//Date: 10/7/2020

//CourseID: CS 320

//Brief Description: Java based appointment contact database

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.Calendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {
	// Tests adding a new task
	@Test
	void testNewAppointment() {
		AppointmentService apt = new AppointmentService();
		apt.newApt("ABCDEFGHIJ", new Date(2022, Calendar.JANUARY, 1), "The appointment is set for a fun time.");
		
		assertEquals("ABCDEFGHIJ", apt.getAppointments().get(0).getAptID());
		assertEquals(new Date(2022, Calendar.JANUARY, 1), apt.getAppointments().get(0).getAptDate());
		assertEquals("The appointment is set for a fun time.", apt.getAppointments().get(0).getAptDesc());
	}
	
	// Tests deleting a task
	@Test
	void testDeleteAppointment() {
		AppointmentService apt = new AppointmentService();
		apt.newApt("ABCDEFGHIJ", new Date(2022, Calendar.JANUARY, 1), "The appointment is set for a fun time.");
		
		Assertions.assertThrows(Exception.class, () -> apt.deleteApt("ABCDEFGHI"));
		
		assertAll(() -> apt.deleteApt(apt.getAppointments().get(0).getAptID()));
	}
	
	// Tests updating the Task Name
	@Test
	void testUpdateAptDate() throws Exception {
		AppointmentService apt = new AppointmentService();
		apt.newApt("ABCDEFGHIJ", new Date(2022, Calendar.JANUARY, 1), "The appointment is set for a fun time.");

		Assertions.assertThrows(IllegalArgumentException.class, () -> apt.updateAptDate("ABCDEFGHIJ", new Date(0)));
		
		apt.updateAptDate("ABCDEFGHIJ", new Date(2022, Calendar.JANUARY, 2));
		assertEquals(new Date(2022, Calendar.JANUARY, 2), apt.getAppointments().get(0).getAptDate());
	}
	
	// Tests updating the Task Description
	@Test
	void testUpdateAptDesc() throws Exception {
		AppointmentService apt = new AppointmentService();
		apt.newApt("ABCDEFGHIJ", new Date(2022, Calendar.JANUARY, 1), "The appointment is set for a fun time.");

		Assertions.assertThrows(IllegalArgumentException.class, () -> apt.updateAptDesc("ABCDEFGHIJ", "The appointment is set for a fun time, but it isn't for a long time."));
		Assertions.assertThrows(IllegalArgumentException.class, () -> apt.updateAptDesc("ABCDEFGHIJ", null));
		
		apt.updateAptDesc("ABCDEFGHIJ", "The appointment is set for a long time.");
		assertEquals("The appointment is set for a long time.", apt.getAppointments().get(0).getAptDesc());
	}

}
