//Author Name: Taylor Anderson

//Date: 10/7/2020

//CourseID: CS 320

//Brief Description: Java based appointment contact database

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.Calendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppointmentTest {
	// Verifies the constructor created the object correctly
		@Test
		void testAppointment() {
			Appointment apt = new Appointment("ABCDEFGHIJ", new Date(2022, Calendar.JANUARY, 1), "The appointment is set for a fun time.");
			assertTrue(apt.getAptID().equals("ABCDEFGHIJ"));
			assertTrue(apt.getAptDate().equals(new Date(2022, Calendar.JANUARY, 1)));
			assertTrue(apt.getAptDesc().equals("The appointment is set for a fun time."));
		}
		
		// Checks that the Appointment ID isn't blank
		@Test
		void testAptIDNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Appointment(null, new Date(2022, Calendar.JANUARY, 1), "The task is to jump when I say jump.");
			});
		}
		
		// Checks that the Appointment ID isn't too long
		@Test
		void testAptIDTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Appointment("ABCDEFGHIJK", new Date(2022, Calendar.JANUARY, 1), "The task is to jump when I say jump.");
			});
		}
		
		// Checks that the Appointment ID isn't too short
		@Test
		void testAptIDTooShort() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Appointment("ABCDEFGHI", new Date(2022, Calendar.JANUARY, 1), "The task is to jump when I say jump.");
			});
		}
		
		// Checks that the Appointment Description isn't blank
		@Test
		void testAptDateNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Appointment("ABCDEFGHIJ", null, "The task is to jump when I say jump.");
			});
		}

		// Checks that the Appointment Description isn't too long
		@Test
		void testAptDatePast() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Appointment("ABCDEFGHIJ", new Date(0), "The task is to jump when I say jump.");
			});
		}
		
		// Checks that the Appointment Description isn't blank
		@Test
		void testAptDescNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Appointment("ABCDEFGHIJ", new Date(2022, Calendar.JANUARY, 1), null);
			});
		}

		// Checks that the Appointment Description isn't too long
		@Test
		void testTaskNameTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Appointment("ABCDEFGHIJ", new Date(2022, Calendar.JANUARY, 1), "The appointment is set for a fun time, but it isn't for a long time.");
			});
		}

}
