import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() {
        assertThrows(InvalidDueDateException.class,
                ()-> {
                    new TaskItem("a", "aaa", "11/16/2020", false);
                });
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {
        assertThrows(InvalidNameException.class,
                ()-> {
                    new TaskItem("", "aaa", "2020-11-16", false);
                });
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        assertDoesNotThrow(
                ()-> {
                    new TaskItem("a", "aaa", "2020-11-16", false);
                });
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        assertDoesNotThrow(
                ()-> {
                    new TaskItem("a", "aaa", "2020-11-16", false);
                });
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() {
        assertThrows(InvalidDueDateException.class,
                ()-> {
                    TaskItem task = new TaskItem("a", "aaa", "2020-11-16", false);
                    task.edit(new String[]{"a", "aaa", "11/16/2020"});
                });
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {
        assertDoesNotThrow(
                ()-> {
                    TaskItem task = new TaskItem("a", "aaa", "2020-11-16", false);
                    task.edit(new String[]{"a", "aaa", "2019-11-16"});
                });
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() {
        assertThrows(InvalidNameException.class,
                ()-> {
                    TaskItem task = new TaskItem("a", "aaa", "2020-11-16", false);
                    task.edit(new String[]{"", "aaa", "2020-11-16"});
                });
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {
        assertDoesNotThrow(
                ()-> {
                    TaskItem task = new TaskItem("a", "aaa", "2020-11-16", false);
                    task.edit(new String[]{"b", "aaa", "2020-11-16"});
                });
    }
}