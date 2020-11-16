import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class TaskList {
    List<TaskItem> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public TaskItem getTaskItem(int index) {
        return tasks.get(index);
    }

    public int size() {
        return tasks.size();
    }

    public void add(TaskItem task) {
        tasks.add(task);
    }

    public void printList() {
        System.out.println("Current Tasks");
        System.out.println("____________");
        if(tasks.size()==0) {
            System.out.println("This task list is empty!");
        }
        else {
            for (int i = 0; i < tasks.size(); i++) {
                TaskItem curTask = tasks.get(i);
                if(curTask.getComplete()==true) System.out.print("X ");
                else System.out.print("O ");
                System.out.println((i + 1) + ") [" + curTask.getDueDate() + "] " + curTask.getName() + ": " + curTask.getDescription());
            }
        }
    }

    public void edit(int index, String newName, String newDescription, String newDueDate) {
        if(index<0 || index >= tasks.size()) {
            throw new IndexOutOfBoundsException("Item doesn't exist");
        }
        else {
            tasks.get(index).edit(newName, newDescription, newDueDate);
        }
    }

    public void remove(int index) {
        if(index<0 || index >= tasks.size()) {
            throw new IndexOutOfBoundsException("Item doesn't exist");
        }
        else {
            tasks.remove(index);
        }
    }

    public void setCompletionStatus(int index, boolean completionStatus) {
        if(index<0 || index >= tasks.size()) {
            throw new IndexOutOfBoundsException("Item doesn't exist");
        }
        else {
            tasks.get(index).setCompletionStatus(completionStatus);
        }
    }

    public void read(String filename) {
        try {
            File file = new File(filename);
            Scanner scanny = new Scanner(file);
            while(scanny.hasNextLine()) {
                String[] taskArray = scanny.nextLine().split(";");
                String name = taskArray[0];
                String description = taskArray[1];
                String dueDate = taskArray[2];
                add(new TaskItem(name, description, dueDate));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void write(String filename) {
        try(Formatter output = new Formatter(filename)) {
            for(int i = 0; i < tasks.size(); i++) {
                TaskItem task = tasks.get(i);
                output.format("%s;%s;%s%n", task.getName(), task.getDescription(), task.getDueDate());
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
