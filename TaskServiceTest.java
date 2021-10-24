//Author Name: Taylor Anderson

//Date: 10/7/2020

//CourseID: CS 320

//Brief Description: Java based appointment contact database

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskServiceTest {

	// Tests adding a new task
	@Test
	void testNewTask() {
		TaskService ts = new TaskService();
		ts.newTask("123456789Z", "Jump", "The task is to jump when I say jump.");
		
		assertEquals("123456789Z", ts.getTasks().get(0).getTaskID());
		assertEquals("Jump", ts.getTasks().get(0).getTaskName());
		assertEquals("The task is to jump when I say jump.", ts.getTasks().get(0).getTaskDesc());
	}
	
	// Tests deleting a task
	@Test
	void testDeleteTask() {
		TaskService ts = new TaskService();
		ts.newTask("123456789Z", "Jump", "The task is to jump when I say jump.");
		
		Assertions.assertThrows(Exception.class, () -> ts.deleteTask("123456789Y"));
		
		assertAll(() -> ts.deleteTask(ts.getTasks().get(0).getTaskID()));
	}
	
	// Tests updating the Task Name
	@Test
	void testUpdateTaskName() throws Exception {
		TaskService ts = new TaskService();
		ts.newTask("123456789Z", "Jump", "The task is to jump when I say jump.");

		Assertions.assertThrows(IllegalArgumentException.class, () -> ts.updateTaskName("123456789Z", "Jump so high I touch the sky"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> ts.updateTaskName("123456789Z", null));

		ts.updateTaskName("123456789Z", "Run");
		assertEquals("Run", ts.getTasks().get(0).getTaskName());
	}
	
	// Tests updating the Task Description
	@Test
	void testUpdateTaskDesc() throws Exception {
		TaskService ts = new TaskService();
		ts.newTask("123456789Z", "Jump", "The task is to jump when I say jump.");
		


		Assertions.assertThrows(IllegalArgumentException.class, () -> ts.updateTaskDesc("123456789Z", "The task is to jump when I say jump, not because I am being forceful, but because we are playing a game and you get to go next."));
		Assertions.assertThrows(IllegalArgumentException.class, () -> ts.updateTaskDesc("123456789Z", null));
		
		ts.updateTaskDesc("123456789Z", "The task is to jump as high as you can.");
		assertEquals("The task is to jump as high as you can.", ts.getTasks().get(0).getTaskDesc());
	}

}
