import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactApp extends App {
    private static Scanner scanny = new Scanner(System.in);

// CONTACTAPP METHODS _______________________________________________________
    public ContactApp() {
        list = new ContactList();
    }

    private String getContactFirstName() {
        System.out.print("Enter the contact's first name (leave blank if unknown): ");
        return scanny.nextLine();
    }

    private String getContactLastName() {
        System.out.print("Enter the contact's last name (leave blank if unknown): ");
        return scanny.nextLine();
    }

    private String getContactPhoneNumber() {
        System.out.print("Enter the contact's phone number in the form xxx-xxx-xxxx (leave blank if unknown): ");
        return scanny.nextLine();
    }

    private String getContactEmail() {
        System.out.print("Enter the contact's email in the form x@y.z (leave blank if unknown): ");
        return scanny.nextLine();
    }

// ABSTRACT METHODS _______________________________________________________
    @Override
    public void runMainMenu() {
        int input = -1;
        while(input!=0) {
            System.out.println();
            System.out.println("Contact List Application Main Menu");
            System.out.println("____________");
            System.out.println("1) Create a new list");
            System.out.println("2) Load an existing list");
            System.out.println("0) Quit");
            input = Integer.parseInt(promptInput());
            switch(input) {
                case 1: // Create a new list
                    list = new ContactList();
                    runListOperationMenu();
                    break;
                case 2: // Load an existing list
                    System.out.print("Enter the filename to load: ");
                    String filename = scanny.nextLine();
                    list = new ContactList();
                    list.read(filename);
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

    @Override
    public void runListOperationMenu() {
        int input = -1;
        while(input!=0) {
            System.out.println();
            System.out.println("List Operation Menu");
            System.out.println("____________");
            System.out.println("1) View current list");
            System.out.println("2) Add item to current list");
            System.out.println("3) Edit item in current list");
            System.out.println("4) Remove item from current list");
            System.out.println("5) Save current list");
            System.out.println("0) Quit to main menu");
            input = Integer.parseInt(promptInput());
            switch(input) {
                case 1: // View current list
                    list.printList();
                    break;
                case 2: // Add item to current list
                    storeItem(getItem());
                    System.out.println("Your contact was added to the list.");
                    break;
                case 3: // Edit item in current list
                    edit();
                    break;
                case 4: // Remove item from current list
                    remove();
                    break;
                case 5: // Save current list
                    write();
                    break;
                case 0: // Quit to main menu
                    break;
                default:
                    System.out.println("Invalid input. Please enter a number 0 - 5.");
                    break;
            }
        }
    }

    @Override
    public Item getItem() {
        ContactItem contact = null;
        while(true) {
            try {
                String firstName = getContactFirstName();
                String lastName = getContactLastName();
                String phoneNumber = getContactPhoneNumber();
                String email = getContactEmail();

                contact = new ContactItem(firstName, lastName, phoneNumber, email);
                break;
            } catch (InvalidContactException ex) {
                System.out.println("Warning: creating contact failed, you must fill in at least one field for this contact.");
            } catch (InvalidPhoneNumberException ex) {
                System.out.println("Warning: your phone number was invalid, please double check it and try again");
            } catch (InvalidEmailException ex) {
                System.out.println("Warning: your email was invalid, please double check it and try again");
            }
        }
        return contact;
    }

    @Override
    public void edit() {
        try {
            list.printList();
            System.out.println("Edit which item?");
            int itemToEdit = Integer.parseInt(promptInput())-1;
            System.out.print("Enter a new first name for the contact: ");
            String newFirstName = scanny.nextLine();
            System.out.print("Enter a new last name for the contact: ");
            String newLastName = scanny.nextLine();
            System.out.print("Enter a new phone number for the contact: ");
            String newPhoneNumber = scanny.nextLine();
            System.out.print("Enter a new email for the contact: ");
            String newEmail = scanny.nextLine();

            list.edit(itemToEdit, new String[]{newFirstName, newLastName, newPhoneNumber, newEmail});
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Item doesn't exist");
        }
    }
}