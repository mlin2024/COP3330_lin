import java.time.DateTimeException;
import java.time.LocalDate;

public class TaskItem extends Item {
    private String name;
    private String description;
    private String dueDate;
    private boolean complete;

// TASKITEM METHODS _______________________________________________________
    public TaskItem(String name, String description, String dueDate, boolean completionStatus) {
        if(isNameValid(name)) {
            this.name = name;
        } else {
            throw new InvalidNameException("Name is not valid; must be at least 1 character long");
        }

        if(isDescriptionValid(description)) {
            this.description = description;
        } else {
            throw new InvalidDescriptionException("Description is not valid; must be at least 0 characters long");
        }

        if(isDueDateValid(dueDate)) {
            this.dueDate = dueDate;
        } else {
            throw new InvalidDueDateException("Due date is not valid; must be in the form YYYY-MM-DD");
        }

        this.complete = completionStatus;
    }

    private boolean isNameValid(String name) {
        return name.length() > 0;
    }

    private boolean isDescriptionValid(String description) {
        return description.length() >= 0;
    }

    private boolean isDueDateValid(String dueDate) {
        String[] dueDateArray = dueDate.split("-");

        if(dueDateArray.length!=3) {
            return false;
        }

        if(dueDateArray[0].length()!=4
                || dueDateArray[1].length()!=2
                || dueDateArray[2].length()!=2) {
            return false;
        }

        int year = Integer.parseInt(dueDateArray[0]);
        int month = Integer.parseInt(dueDateArray[1]);
        int day = Integer.parseInt(dueDateArray[2]);
        try {
            LocalDate date = LocalDate.of(year, month, day);
        }
        catch (DateTimeException e) {
            return false;
        }
        return true;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public boolean getComplete() {
        return this.complete;
    }

    public void setCompletionStatus(boolean completionStatus) {
        this.complete = completionStatus;
    }

// ABSTRACT METHODS _______________________________________________________
    @Override
    public void edit(String[] args) {
        String newName = args[0];
        String newDescription = args[1];
        String newDueDate = args[2];
        new TaskItem(newName, newDescription, newDueDate, this.complete);
        this.name = newName;
        this.description = newDescription;
        this.dueDate = newDueDate;
    }
}
class InvalidNameException extends IllegalArgumentException {
    public InvalidNameException(String msg) {
        super(msg);
    }
}

class InvalidDescriptionException extends IllegalArgumentException {
    public InvalidDescriptionException(String msg) {
        super(msg);
    }
}

class InvalidDueDateException extends IllegalArgumentException {
    public InvalidDueDateException(String msg) {
        super(msg);
    }
}