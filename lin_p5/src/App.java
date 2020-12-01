import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class App {
    private static Scanner scanny = new Scanner(System.in);

    public MyList list;

// APP METHODS _______________________________________________________
    private static void runAppMenu() {
        int input = -1;
        while(input!=0) {
            System.out.println();
            System.out.println("Select Your Application");
            System.out.println("____________");
            System.out.println("1) Task List");
            System.out.println("2) Contact List");
            System.out.println("0) Quit");
            input = Integer.parseInt(promptInput());
            switch (input) {
                case 1: // Task List
                    TaskApp t = new TaskApp();
                    t.runMainMenu();
                    break;
                case 2: // Contact List
                    ContactApp c = new ContactApp();
                    c.runMainMenu();
                    break;
                case 0: // Quit
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Invalid input. Please enter a number 0 - 7.");
                    break;

            }
        }
    }

    public static String promptInput() {
        System.out.print("> ");
        String input = scanny.nextLine();
        while(!verifyInputIsGood(input)) {
            System.out.print("> ");
            input = scanny.nextLine();
        }
        return input;
    }

    public static boolean verifyInputIsGood(String userInput) {
        try {
            Integer.parseInt(userInput);
            return true;
        } catch (NumberFormatException ex){
            System.out.println("Invalid input, please try again");
            return false;
        }
    }

    public void storeItem(Item task) {
        list.add(task);
    }

    public void writeItem() {
        list.write("output.txt");
    }

    public void remove() {
        try {
            list.printList();
            System.out.println("Remove which item?");
            int itemToRemove = Integer.parseInt(promptInput())-1;
            list.remove(itemToRemove);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Item doesn't exist");
        }
    }

    public void write() {
        System.out.println("Save to what file?");
        String filename = scanny.nextLine();
        list.write(filename);
    }

// ABSTRACT METHODS _______________________________________________________
    public abstract void runMainMenu();
    public abstract void runListOperationMenu();
    public abstract Item getItem();
    public abstract void edit();

    public static void main(String[] args) {
        runAppMenu();
    }
}