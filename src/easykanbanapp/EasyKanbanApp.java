/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package easykanbanapp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class EasyKanbanApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Task> tasks = new ArrayList<>();
    private static boolean isLoggedIn = false;

   
    public static void main(String[] args) {
        System.out.println("Welcome to EasyKanban");
             login();
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    addTasks();
                    break;
                case 2:
                    System.out.println("Coming Soon");
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void login() {
        // Implement login logic here
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        // Simple check (Replace with actual authentication)
        if (username.equals("admin") && password.equals("password")) {
            isLoggedIn = true;
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid login. Try again.");
            login();
        }
    }

    private static void showMenu() {
        System.out.println("Welcome to EasyKanban");
        System.out.println("1) Add tasks");
        System.out.println("2) Show report");
        System.out.println("3) Quit");
    }

    private static void addTasks() {
        if (!isLoggedIn) {
            System.out.println("Please login first.");
            return;
        }
        System.out.println("How many tasks would you like to enter?");
        int numTasks = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        int totalHours = 0;

        for (int i = 0; i < numTasks; i++) {
            System.out.println("Enter Task Name:");
            String taskName = scanner.nextLine();
            int taskNumber = i;

            System.out.println("Enter Task Description:");
            String taskDescription = scanner.nextLine();

            System.out.println("Enter Developer First Name:");
            String devFirstName = scanner.nextLine();

            System.out.println("Enter Developer Last Name:");
            String devLastName = scanner.nextLine();

            System.out.println("Enter Task Duration in hours:");
            int taskDuration = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.println("Select Task Status (To Do, Doing, Done):");
            String taskStatus = scanner.nextLine();

            Task task = new Task(taskName, taskNumber, taskDescription, devFirstName, devLastName, taskDuration, taskStatus);

            if (!task.checkTaskDescription()) {
                System.out.println("Please enter a task description of less than 50 characters");
            } else {
                System.out.println("Task successfully captured");
                tasks.add(task);
                totalHours += task.returnTotalHours();
                System.out.println(task.printTaskDetails());
            }
        }

        System.out.println("Total duration for all tasks: " + totalHours + " hours");
    }
}

    
    

