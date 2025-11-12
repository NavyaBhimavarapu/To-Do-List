import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    static class Task {
        String description;
        boolean completed;

        Task(String description) {
            this.description = description;
            this.completed = false;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();
        int choice;

        while (true) {
            System.out.println("\n===== TO-DO LIST =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter task: ");
                    String desc = scanner.nextLine();
                    tasks.add(new Task(desc));
                    System.out.println("✅ Task added!");
                    break;

                case 2:
                    System.out.println("\n📋 Your Tasks:");
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks added yet.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            Task t = tasks.get(i);
                            String status = t.completed ? "✔ Completed" : "⏳ Pending";
                            System.out.println((i + 1) + ". " + t.description + "   [" + status + "]");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter task number to mark complete: ");
                    int completeIndex = scanner.nextInt() - 1;
                    if (completeIndex >= 0 && completeIndex < tasks.size()) {
                        tasks.get(completeIndex).completed = true;
                        System.out.println("🎉 Marked as completed!");
                    } else {
                        System.out.println("❌ Invalid task number");
                    }
                    break;

                case 4:
                    System.out.print("Enter task number to delete: ");
                    int deleteIndex = scanner.nextInt() - 1;
                    if (deleteIndex >= 0 && deleteIndex < tasks.size()) {
                        tasks.remove(deleteIndex);
                        System.out.println("🗑 Task deleted!");
                    } else {
                        System.out.println("❌ Invalid task number");
                    }
                    break;

                case 5:
                    System.out.println("✅ Exiting... Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice, try again");
            }
        }
    }
}
