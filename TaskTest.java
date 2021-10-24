//Author Name: Taylor Anderson

//Date: 10/7/2020

//CourseID: CS 320

//Brief Description: Java based appointment contact database

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {
	// Verifies the constructor created the object correctly
	@Test
	void testTask() {
		Task task = new Task("123456789Z", "Jump", "The task is to jump when I say jump.");
		assertTrue(task.getTaskID().equals("123456789Z"));
		assertTrue(task.getTaskName().equals("Jump"));
		assertTrue(task.getTaskDesc().equals("The task is to jump when I say jump."));
	}
	
	// Checks that the Task ID isn't blank
	@Test
	void testTaskIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Jump", "The task is to jump when I say jump.");
		});
	}
	
	// Checks that the Task ID isn't too long
	@Test
	void testTaskIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("0123456789Z", "Jump", "The task is to jump when I say jump.");
		});
	}
	
	// Checks that the Task ID isn't too short
	@Test
	void testTaskIDTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678Z", "Jump", "The task is to jump when I say jump.");
		});
	}
	
	// Checks that the Task Name isn't blank
	@Test
	void testTaskNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123456789Z", null, "The task is to jump when I say jump.");
		});
	}

	// Checks that the Task Name isn't too long
	@Test
	void testTaskNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123456789Z", "Jump so high I touch the sky", "The task is to jump when I say jump.");
		});
	}
	
	// Checks that the Task Description isn't blank
	@Test
	void testTaskDescNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123456789Z", "Jump", null);
		});
	}

	// Checks that the Task Description isn't too long
	@Test
	void testTaskDescTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123456789Z", "Jump", "The task is to jump when I say jump, not because I am being forceful, but because we are playing a game and you get to go next.");
		});
	}

}
