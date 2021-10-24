//Author Name: Taylor Anderson

//Date: 10/7/2020

//CourseID: CS 320

//Brief Description: Java based appointment contact database

import java.util.ArrayList;
import java.util.List;

public class TaskService {
	// This is the contact list
	List<Task> tasks = new ArrayList<>();
	
	// Default constructor
	public void newTask(String taskID, String taskName, String taskDesc) {
		Task task = new Task(taskID, taskName, taskDesc);
		tasks.add(task);
	}
	
	// Deletes Task
	public void deleteTask(String taskID) throws Exception {
		tasks.remove(taskSearch(taskID));
	}
	
	// Updates Task Name
	public void updateTaskName(String taskID, String taskName) throws Exception {
		taskSearch(taskID).updateTaskName(taskName);
	}
	
	// Updates Task Description
	public void updateTaskDesc(String taskID, String taskDesc) throws Exception {
		taskSearch(taskID).updateTaskDesc(taskDesc);
	}
	
	//returns array
	public List<Task> getTasks() {
		return tasks;
	}
	
	// Searches the list to match the Task ID
	private Task taskSearch(String taskID) throws Exception {
		// TODO Auto-generated method stub
		int i = 0;
		while (i < tasks.size()) {
			if (taskID.equalsIgnoreCase(tasks.get(i).getTaskID())) {
				return tasks.get(i);
			}
			i++;
		}
		throw new Exception("Not a valid task ID.");
	}
}
