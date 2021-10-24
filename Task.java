//Author Name: Taylor Anderson

//Date: 10/7/2020

//CourseID: CS 320

//Brief Description: Java based appointment contact database

public class Task {
	// Declares the variables
	private String taskID;
	private String taskName;
	private String taskDesc;
	
	// Constructor with calls on throwing the errors for each of the parameters 
	Task(String taskID, String taskName, String taskDesc) {
		setTaskID(taskID);
		updateTaskName(taskName);
		updateTaskDesc(taskDesc);
	}
	
	// Returns the parameters for the method
	public String getTaskID() {
		return taskID;
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	public String getTaskDesc() {
		return taskDesc;
	}
	
	// Creates the TaskID then checks the parameters and returns the exception if not valid for each of the arguments
	public void setTaskID(String taskID) {
		if (taskID == null) {
			throw new IllegalArgumentException("Task ID cannot be left blank.");
		} else if (taskID.length()<10) {
			throw new IllegalArgumentException("Task ID cannot be less than 10 characters.");
		} else if (taskID.length()>10) {
			throw new IllegalArgumentException("Task ID cannot be longer than 10 characters.");
		} else {
			this.taskID = taskID;
		}
	}
	
	// Creates and updates the task name then checks the parameters and returns the exception if not valid for each of the arguments
	public void updateTaskName(String taskName) {
		if (taskName == null) {
			throw new IllegalArgumentException("Task name cannot be left blank.");
		} else if (taskName.length()>20) {
			throw new IllegalArgumentException("Task name cannot be longer than 20 characters.");
		} else {
			this.taskName = taskName;
		}
	}
	
	// Creates and updates the task description then checks the parameters and returns the exception if not valid for each of the arguments
	public void updateTaskDesc(String taskDesc) {
		if (taskDesc == null) {
			throw new IllegalArgumentException("Task description cannot be left blank.");
		} else if (taskDesc.length()>50) {
			throw new IllegalArgumentException("Task description cannot be longer than 50 characters.");
		} else {
			this.taskDesc = taskDesc;
		}
	}
	
}
