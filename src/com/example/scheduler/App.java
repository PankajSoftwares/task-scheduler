package com.example.scheduler;

import com.example.scheduler.model.Task;
import com.example.scheduler.service.TaskScheduler;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TaskScheduler scheduler = new TaskScheduler();
    private static final DateTimeFormatter fmt =
    DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    // private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static void main(String[] args) {
        System.out.println("=== Task Scheduler ===");
        scheduler.seedSampleTasks();

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    addNewTask();
                    break;
                case "2":
                    scheduler.displayList();
                    break;
                case "3":
                    scheduler.processQueue();
                    break;
                case "4":
                    scheduler.processPriorityQueue();
                    break;
                case "5":
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add Task");
        System.out.println("2. Show All Tasks (List)");
        System.out.println("3. Process FIFO Queue");
        System.out.println("4. Process Priority Queue");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addNewTask() {
        try {
            System.out.print("Task name: ");
            String name = scanner.nextLine();
            // System.out.print("Due date (yyyy-MM-dd HH:mm): ");
            System.out.print("Due date (dd-MM-yyyy HH:mm): ");
            LocalDateTime due = LocalDateTime.parse(scanner.nextLine(), fmt);
            System.out.print("Priority (1=High): ");
            int pr = Integer.parseInt(scanner.nextLine());

            Task task = new Task(name, due, pr);
            scheduler.addToList(task);
            scheduler.addToQueue(task);
            scheduler.addToPriorityQueue(task);
            System.out.println("Task added successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
