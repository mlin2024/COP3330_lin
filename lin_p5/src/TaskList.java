import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class TaskList extends MyList {
// TASKLIST METHODS _______________________________________________________
    public void setCompletionStatus(int index, boolean completionStatus) {
        if(index<0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Item doesn't exist");
        }
        else {
            ((TaskItem)list.get(index)).setCompletionStatus(completionStatus);
        }
    }

// ABSTRACT METHODS _______________________________________________________
    @Override
    public TaskItem getItem(int index) {
        return (TaskItem)list.get(index);
    }

    @Override
    public void printList() {
        System.out.println("Current Tasks");
        System.out.println("____________");
        if(list.size()==0) {
            System.out.println("This task list is empty!");
        }
        else {
            for (int i = 0; i < list.size(); i++) {
                TaskItem curTask = (TaskItem) list.get(i);
                if(curTask.getComplete()==true) System.out.print("X ");
                else System.out.print("O ");
                System.out.println((i + 1) + ") [" + curTask.getDueDate() + "] " + curTask.getName() + ": " + curTask.getDescription());
            }
        }
    }

    @Override
    public void edit(int index, String[] args) {
        String newName = args[0];
        String newDescription = args[1];
        String newDueDate = args[2];
        if(index<0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Item doesn't exist");
        }
        else {
            ((TaskItem)list.get(index)).edit(args);
        }
    }

    @Override
    public void read(String filename) {
        try {
            File file = new File(filename);
            Scanner scanny = new Scanner(file);
            while(scanny.hasNextLine()) {
                String name = scanny.nextLine();
                String description = scanny.nextLine();
                String dueDate = scanny.nextLine();
                String completionStatus = scanny.nextLine();
                add(new TaskItem(name, description, dueDate, completionStatus.equals("true") ? true : false));
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
                TaskItem task = (TaskItem)list.get(i);
                output.format("%s%n%s%n%s%n%s%n", task.getName(), task.getDescription(), task.getDueDate(), task.getComplete() ? "true" : "false");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
