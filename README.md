Task Scheduler Application
Below is a complete Java project structure for a Task Scheduler Application that uses the Collections Framework (List, Queue, PriorityQueue) to manage tasks. It includes terminal commands to create folders/files and the full source code.

This setup provides a task list (ArrayList), a FIFO queue, and a priority queue, demonstrating core Java Collections usage in a single application.

Here is How to Compile and Run
bash
# From project root
cd task-scheduler

# Compile all Java files
javac -d out src/com/example/scheduler/model/Task.java \
          src/com/example/scheduler/service/TaskScheduler.java \
          src/com/example/scheduler/App.java

# Run the application
java -cp out com.example.scheduler.App
