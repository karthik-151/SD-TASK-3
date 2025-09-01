import java.util.ArrayList;
import java.util.Scanner;

// Task class
class Task {
    int id;
    String title;
    String description;

    // Constructor
    Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}

public class TaskManager {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Create Task
    public static void createTask() {
        int taskId = tasks.size() + 1;
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        Task task = new Task(taskId, title, description);
        tasks.add(task);
        System.out.println("✅ Task created successfully!\n");
    }

    // Read Tasks
    public static void readTasks() {
        if (tasks.isEmpty()) {
            System.out.println("⚠️ No tasks available.\n");
        } else {
            System.out.println("\n📋 Task List:");
            for (Task task : tasks) {
                System.out.println("[" + task.id + "] " + task.title + " - " + task.description);
            }
            System.out.println();
        }
    }

    // Update Task
    public static void updateTask() {
        readTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Enter Task ID to update: ");
        int taskId = Integer.parseInt(scanner.nextLine());

        for (Task task : tasks) {
            if (task.id == taskId) {
                System.out.print("Enter new title: ");
                task.title = scanner.nextLine();
                System.out.print("Enter new description: ");
                task.description = scanner.nextLine();
                System.out.println("✅ Task updated successfully!\n");
                return;
            }
        }
        System.out.println("⚠️ Task not found!\n");
    }

    // Delete Task
    public static void deleteTask() {
        readTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Enter Task ID to delete: ");
        int taskId = Integer.parseInt(scanner.nextLine());

        for (Task task : tasks) {
            if (task.id == taskId) {
                tasks.remove(task);
                System.out.println("🗑️ Task deleted successfully!\n");
                return;
            }
        }
        System.out.println("⚠️ Task not found!\n");
    }

    // Menu
    public static void menu() {
        while (true) {
            System.out.println("===== Task Manager =====");
            System.out.println("1. Create Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> createTask();
                case "2" -> readTasks();
                case "3" -> updateTask();
                case "4" -> deleteTask();
                case "5" -> {
                    System.out.println("👋 Exiting Task Manager. Goodbye!");
                    return;
                }
                default -> System.out.println("❌ Invalid choice, try again.\n");
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
