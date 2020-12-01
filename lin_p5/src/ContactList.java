import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class ContactList extends MyList {
// CONTACTLIST METHODS _______________________________________________________


// ABSTRACT METHODS _______________________________________________________
    @Override
    public Item getItem(int index) {
        return (ContactItem)list.get(index);
    }

    @Override
    public void printList() {
        System.out.println("Current Contacts");
        System.out.println("____________");
        if(list.size()==0) {
            System.out.println("This contacts list is empty!");
        }
        else {
            for (int i = 0; i < list.size(); i++) {
                ContactItem curContact = (ContactItem) list.get(i);
                System.out.println((i + 1) + ") Name: "+curContact.getFirstName()+" "+curContact.getLastName());
                System.out.println("Phone number: "+curContact.getPhoneNumber());
                System.out.println("Email: "+curContact.getEmail());
            }
        }
    }

    @Override
    public void edit(int index, String[] args) {
        String newFirstName = args[0];
        String newLastName = args[1];
        String newPhoneNumber = args[2];
        String newEmail = args[3];
        if(index<0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Item doesn't exist");
        }
        else {
            ((ContactItem)list.get(index)).edit(args);
        }
    }

    @Override
    public void read(String filename) {
        try {
            File file = new File(filename);
            Scanner scanny = new Scanner(file);
            while(scanny.hasNextLine()) {
                String firstName = scanny.nextLine();
                String lastName = scanny.nextLine();
                String phoneNumber = scanny.nextLine();
                String email = scanny.nextLine();
                add(new ContactItem(firstName, lastName, phoneNumber, email));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void write(String filename) {
        try(Formatter output = new Formatter(filename)) {
            for(int i = 0; i < list.size(); i++) {
                ContactItem task = (ContactItem)list.get(i);
                output.format("%s%n%s%n%s%n%s%n", task.getFirstName(), task.getLastName(), task.getPhoneNumber(), task.getEmail());
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}