/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package easykanbanapp;
import java.util.regex.Pattern; 
/**
 *
 * @author RC_Student_lab
 */
public class Task {
        private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerFirstName;
    private String developerLastName;
    private int taskDuration;
    private String taskStatus;
    private String taskId;

    public Task(String taskName, int taskNumber, String taskDescription, String developerFirstName, String developerLastName, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerFirstName = developerFirstName;
        this.developerLastName = developerLastName;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskId = createTaskID();
    }

    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    public String createTaskID() {
        return (taskName.substring(0, 2) + ":" + taskNumber + ":" + developerLastName.substring(developerLastName.length() - 3)).toUpperCase();
    }

    public String printTaskDetails() {
        return String.format("Task Status: %s\nDeveloper Details: %s %s\nTask Number: %d\nTask Name: %s\nTask Description: %s\nTask ID: %s\nDuration: %d hours",
                taskStatus, developerFirstName, developerLastName, taskNumber, taskName, taskDescription, taskId, taskDuration);
    }

    public int returnTotalHours() {
        return taskDuration;
    }


    
}
