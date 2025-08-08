package com.example.scheduler.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task implements Comparable<Task> {

    private String name;
    private LocalDateTime dueDate;
    private int priority; // 1 = highest, larger numbers = lower priority

    public Task(String name, LocalDateTime dueDate, int priority) {
        this.name = name;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Task other) {
        // First compare by due date
        int dateComparison = this.dueDate.compareTo(other.dueDate);
        if (dateComparison != 0) {
            return dateComparison;
        }
        // If due dates are same, compare by priority
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        // Use day–month–year format
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return String.format("%s (Due: %s, Priority: %d)",
                name,
                dueDate.format(fmt),
                priority);
    }

    // @Override
    // public String toString() {
    //     DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    //     return String.format("%s (Due: %s, Priority: %d)",
    //             name, dueDate.format(fmt), priority);
    // }
}
