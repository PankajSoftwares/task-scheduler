package com.example.scheduler.service;

import com.example.scheduler.model.Task;
import java.time.LocalDateTime;
import java.util.*;

public class TaskScheduler {
    private List<Task> taskList = new ArrayList<>();
    private Queue<Task> taskQueue = new LinkedList<>();
    private PriorityQueue<Task> priorityQueue = new PriorityQueue<>();

    // Add task to list
    public void addToList(Task task) {
        taskList.add(task);
    }

    // Add task to FIFO queue
    public void addToQueue(Task task) {
        taskQueue.offer(task);
    }

    // Add task to priority queue
    public void addToPriorityQueue(Task task) {
        priorityQueue.offer(task);
    }

    // Display tasks stored in list
    public void displayList() {
        System.out.println("=== Task List ===");
        for (Task t : taskList) {
            System.out.println(t);
        }
    }

    // Process tasks in FIFO order
    public void processQueue() {
        System.out.println("=== Processing FIFO Queue ===");
        while (!taskQueue.isEmpty()) {
            System.out.println("Processing: " + taskQueue.poll());
        }
    }

    // Process tasks in priority order
    public void processPriorityQueue() {
        System.out.println("=== Processing Priority Queue ===");
        while (!priorityQueue.isEmpty()) {
            System.out.println("Processing: " + priorityQueue.poll());
        }
    }

    // Example seed tasks
    public void seedSampleTasks() {
        addToList(new Task("Write report",
                LocalDateTime.now().plusHours(5), 2));
        addToList(new Task("Pay bills",
                LocalDateTime.now().plusDays(1), 1));
        addToQueue(new Task("Email client",
                LocalDateTime.now().plusMinutes(30), 3));
        addToQueue(new Task("Team meeting",
                LocalDateTime.now().plusHours(2), 2));
        addToPriorityQueue(new Task("Server backup",
                LocalDateTime.now().plusHours(4), 1));
        addToPriorityQueue(new Task("Code review",
                LocalDateTime.now().plusHours(3), 2));
    }
}
