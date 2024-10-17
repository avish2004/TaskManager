import java.util.ArrayList;
import java.util.Scanner;

//Task class to represent individual tasks
class Task {
    private String name;
    private boolean isCompleted;

    //Constructor to create a new task
    public Task(String name) {
        this.name = name;
        this.isCompleted = false;
    }

    //Getter for task name
    public String getName() {
        return name;
    }

    //Check if the task is completed
    public boolean isCompleted() {
        return isCompleted;
    }

    //Mark the task as completed
    public void markCompleted() {
        this.isCompleted = true;
    }

    //Convert task details to a string format
    @Override
    public String toString() {
        return (isCompleted ? "[✔]" : "[ ]") + " " + name;
    }
}

//TaskManager class to manage tasks
public class TaskManager {
    private ArrayList<Task> tasks;
    private Scanner scanner;

    //Constructor to initialize task list and scanner
    public TaskManager() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    //Method to add a new task
    public void addTask() {
        System.out.print("Enter task name: ");
        String taskName = scanner.nextLine();
        tasks.add(new Task(taskName));
        System.out.println("Task added.");
    }

    //Method to mark a task as completed
    public void completeTask() {
        System.out.println("Enter the task number to mark as completed:");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            Task task = tasks.get(taskNumber - 1);
            task.markCompleted();
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    //Method to list all tasks
    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    //Main menu to interact with the task manager
    public void menu() {
        while (true) {
            System.out.println("\n1. Add task");
            System.out.println("2. Complete task");
            System.out.println("3. List tasks");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    completeTask();
                    break;
                case 3:
                    listTasks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    //Main method to start the task manager application
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        taskManager.menu();
    }
}
