import java.util.Scanner;

public class App {
    private static Scanner scanny = new Scanner(System.in);

    private TaskList tasks;

    public App() {
        tasks = new TaskList();
    }

    private void processTasks() {
        while(shouldContinue(askShouldContinue())) {
            TaskItem task = getTaskItem();

            storeTaskItem(task);
        }

        writeTaskItem();
    }

    private boolean shouldContinue(String userInput) {
        return userInput.toLowerCase().startsWith("y");
    }

    private void writeTaskItem() {
        tasks.write("output.txt");
    }

    private void storeTaskItem(TaskItem task) {
        tasks.add(task);
    }

    private TaskItem getTaskItem() {
        TaskItem task = null;
        while(true) {
            try {
                String name = getTaskName();
                String description = getTaskDescription();
                String dueDate = getTaskDueDate();

                task = new TaskItem(name, description, dueDate);
                break;
            } catch (InvalidNameException ex) {
                System.out.println("Warning: your name was invalid, please double check it and try again");
            } catch (InvalidDescriptionException ex) {
                System.out.println("Warning: your grade was invalid, please double check it and try again");
            } catch (InvalidDueDateException ex) {
                System.out.println("Warning: your due date was invalid, please double check it and try again");
            }
        }
        return task;
    }

    private String getTaskName() {
        System.out.println("Enter a name for the task:");
        return scanny.nextLine();
    }

    private String getTaskDescription() {
        System.out.println("Enter a description for the task:");
        return scanny.nextLine();
    }

    private String getTaskDueDate() {
        System.out.println("Enter the task's due date in the form YYYY-MM-DD:");
        return scanny.nextLine();
    }

    private static String askShouldContinue() {
        System.out.println("Do you wish to enter a new task? (y/n):");
        return scanny.nextLine();
    }

    // Write a program that allows the user to read in a file of student names and grades and
    // displays that information to the console.
    public static void main(String[] args) {
        App m = new App();

        m.processTasks();
    }
}
