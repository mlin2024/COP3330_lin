import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static Scanner scanny = new Scanner(System.in);

    private TaskList tasks;

    public App() {
        tasks = new TaskList();
    }

    private void runMainMenu() {
        int input = -1;
        while(input!=0) {
            System.out.println();
            System.out.println("Main Menu");
            System.out.println("____________");
            System.out.println("1) Create a new list");
            System.out.println("2) Load an existing list");
            System.out.println("0) Quit");
            input = Integer.parseInt(promptInput());
            switch(input) {
                case 1: // Create a new list
                    tasks = new TaskList();
                    runListOperationMenu();
                    break;
                case 2: // Load an existing list
                    System.out.print("Enter the filename to load: ");
                    String filename = scanny.nextLine();
                    tasks = new TaskList();
                    tasks.read(filename);
                    runListOperationMenu();
                    break;
                case 0: // Quit
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Invalid input. Please enter a number 0 - 2.");
                    break;
            }
        }
    }

    private void runListOperationMenu() {
        int input = -1;
        while(input!=0) {
            System.out.println();
            System.out.println("List Operation Menu");
            System.out.println("____________");
            System.out.println("1) View current list");
            System.out.println("2) Add item to current list");
            System.out.println("3) Edit item in current list");
            System.out.println("4) Remove item from current list");
            System.out.println("5) Mark item as completed in current list");
            System.out.println("6) Unmark item as completed in current list");
            System.out.println("7) Save current list");
            System.out.println("0) Quit to main menu");
            input = Integer.parseInt(promptInput());
            switch(input) {
                case 1: // View current list
                    tasks.printList();
                    break;
                case 2: // Add item to current list
                    storeTaskItem(getTaskItem());
                    break;
                case 3: // Edit item in current list
                    edit();
                    break;
                case 4: // Remove item from current list
                    remove();
                    break;
                case 5: // Mark item as completed in current list
                    setComplete();
                    break;
                case 6: // Unmark item as completed in current list
                    setIncomplete();
                    break;
                case 7: // Save current list
                    write();
                    break;
                case 0: // Quit to main menu
                    break;
                default:
                    System.out.println("Invalid input. Please enter a number 0 - 7.");
                    break;
            }
        }
    }

    private static String promptInput() {
        System.out.print("> ");
        String input = scanny.nextLine();
        while(!verifyInputIsGood(input)) {
            System.out.print("> ");
            input = scanny.nextLine();
        }
        return input;
    }

    private static boolean verifyInputIsGood(String userInput) {
        try {
            Integer.parseInt(userInput);
            return true;
        } catch (NumberFormatException ex){
            System.out.println("Invalid input, please try again");
            return false;
        }
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
        System.out.print("Enter a name for the task: ");
        return scanny.nextLine();
    }

    private String getTaskDescription() {
        System.out.print("Enter a description for the task: ");
        return scanny.nextLine();
    }

    private String getTaskDueDate() {
        System.out.print("Enter the task's due date in the form YYYY-MM-DD: ");
        return scanny.nextLine();
    }

    private void edit() {
        try {
            tasks.printList();
            System.out.println("Edit which item?");
            int itemToEdit = Integer.parseInt(promptInput())-1;
            System.out.print("Enter a new name for the task: ");
            String newName = scanny.nextLine();
            System.out.print("Enter a new description for the task: ");
            String newDescription = scanny.nextLine();
            System.out.print("Enter the task's new due date in the form YYYY-MM-DD: ");
            String newDueDate = scanny.nextLine();
            tasks.edit(itemToEdit, newName, newDescription, newDueDate);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Item doesn't exist");
        }
    }

    private void remove() {
        try {
            tasks.printList();
            System.out.println("Remove which item?");
            int itemToRemove = Integer.parseInt(promptInput())-1;
            tasks.remove(itemToRemove);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Item doesn't exist");
        }
    }

    private void setComplete() {
        try {
            tasks.printList();
            System.out.println("Mark which item as complete?");
            int itemToSetComplete = Integer.parseInt(promptInput()) - 1;
            if (tasks.getTaskItem(itemToSetComplete).getComplete() == true) {
                System.out.println("Item is already marked as complete.");
            } else {
                tasks.setCompletionStatus(itemToSetComplete, true);
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Item doesn't exist");
        }
    }

    private void setIncomplete() {
        try {
            tasks.printList();
            System.out.println("Unmark which item as incomplete?");
            int itemToSetIncomplete = Integer.parseInt(promptInput()) - 1;
            if (tasks.getTaskItem(itemToSetIncomplete).getComplete() == false) {
                System.out.println("Item is not marked as complete.");
            } else {
                tasks.setCompletionStatus(itemToSetIncomplete, true);
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Item doesn't exist");
        }
    }

    private void write() {
        System.out.println("Save to what file?");
        String filename = scanny.nextLine();
        tasks.write(filename);
    }

    // Write a program that allows the user to read in a file of student names and grades and
    // displays that information to the console.
    public static void main(String[] args) {
        App m = new App();

        m.runMainMenu();
    }
}
