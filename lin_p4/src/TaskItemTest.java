import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() {
        assertThrows(InvalidDueDateException.class,
                ()-> {
            new TaskItem("a", "aaa", "11/16/2020");
        });
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {
        assertThrows(InvalidNameException.class,
                ()-> {
                    new TaskItem("", "aaa", "2020-11-16");
                });
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        assertDoesNotThrow(
                ()-> {
                    new TaskItem("a", "aaa", "2020-11-16");
                });
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        assertDoesNotThrow(
                ()-> {
                    new TaskItem("a", "aaa", "2020-11-16");
                });
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() {
        assertThrows(InvalidDueDateException.class,
                ()-> {
                    TaskItem task = new TaskItem("a", "aaa", "2020-11-16");
                    task.edit("a", "aaa", "11/16/2020");
                });
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {
        assertDoesNotThrow(
                ()-> {
                    TaskItem task = new TaskItem("a", "aaa", "2020-11-16");
                    task.edit("a", "aaa", "2019-11-16");
                });
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() {
        assertThrows(InvalidNameException.class,
                ()-> {
                    TaskItem task = new TaskItem("a", "aaa", "2020-11-16");
                    task.edit("", "aaa", "2020-11-16");
                });
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {
        assertDoesNotThrow(
                ()-> {
                    TaskItem task = new TaskItem("a", "aaa", "2020-11-16");
                    task.edit("b", "aaa", "2020-11-16");
                });
    }
}