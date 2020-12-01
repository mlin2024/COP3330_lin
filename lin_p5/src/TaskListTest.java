import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {
    @Test
    public void addingTaskItemsIncreasesSize() {
        TaskList tasks = new TaskList();
        int oldSize = tasks.size();
        tasks.add(new TaskItem("a", "aaa", "2020-11-16", false));
        int newSize = tasks.size();

        assertEquals(oldSize+1, newSize);
    }

    @Test
    public void completingTaskItemChangesStatus() {
        TaskList tasks = new TaskList();
        tasks.add(new TaskItem("a", "aaa", "2020-11-16", false));
        boolean oldCompletionStatus = tasks.getItem(0).getComplete();
        tasks.setCompletionStatus(0, true);
        boolean newCompletionStatus = tasks.getItem(0).getComplete();

        assertNotEquals(oldCompletionStatus, newCompletionStatus);
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class,
                ()-> {
                    TaskList tasks = new TaskList();
                    tasks.add(new TaskItem("a", "aaa", "2020-11-16", false));
                    tasks.setCompletionStatus(1, true);
                });
    }

    @Test
    public void editingTaskItemChangesValues() {
        TaskList tasks = new TaskList();
        tasks.add(new TaskItem("a", "aaa", "2020-11-16", false));
        tasks.getItem(0).edit(new String[]{"b", "bbb", "2019-11-16"});
        assertEquals("b", tasks.getItem(0).getName());
        assertEquals("bbb", tasks.getItem(0).getDescription());
        assertEquals("2019-11-16", tasks.getItem(0).getDueDate());
    }

    @Test
    public void editingTaskItemDescriptionChangesValue() {
        TaskList tasks = new TaskList();
        tasks.add(new TaskItem("a", "aaa", "2020-11-16", false));
        tasks.getItem(0).edit(new String[]{"a", "bbb", "2020-11-16"});
        assertEquals("bbb", tasks.getItem(0).getDescription());
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class,
                ()-> {
                    TaskList tasks = new TaskList();
                    tasks.add(new TaskItem("a", "aaa", "2020-11-16", false));
                    tasks.getItem(1).edit(new String[]{"a", "bbb", "2020-11-16"});
                });
    }

    @Test
    public void editingTaskItemDueDateChangesValue() {
        TaskList tasks = new TaskList();
        tasks.add(new TaskItem("a", "aaa", "2020-11-16", false));
        tasks.getItem(0).edit(new String[]{"a", "aaa", "2019-11-16"});
        assertEquals("2019-11-16", tasks.getItem(0).getDueDate());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class,
                ()-> {
                    TaskList tasks = new TaskList();
                    tasks.add(new TaskItem("a", "aaa", "2020-11-16", false));
                    tasks.getItem(1).edit(new String[]{"a", "aaa", "2019-11-16"});
                });
    }

    @Test
    public void editingTaskItemTitleChangesValue() {
        TaskList tasks = new TaskList();
        tasks.add(new TaskItem("a", "aaa", "2020-11-16", false));
        tasks.getItem(0).edit(new String[]{"b", "aaa", "2020-11-16"});
        assertEquals("b", tasks.getItem(0).getName());
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class,
                ()-> {
                    TaskList tasks = new TaskList();
                    tasks.add(new TaskItem("a", "aaa", "2020-11-16", false));
                    tasks.getItem(1).edit(new String[]{"b", "aaa", "2020-11-16"});
                });
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class,
                ()-> {
                    TaskList tasks = new TaskList();
                    tasks.add(new TaskItem("a", "aaa", "2020-11-16", false));
                    tasks.getItem(1).getDescription();
                });
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
        assertDoesNotThrow(
                ()-> {
                    TaskList tasks = new TaskList();
                    tasks.add(new TaskItem("a", "aaa", "2020-11-16", false));
                    tasks.getItem(0).getDescription();
                });

        TaskList tasks = new TaskList();
        tasks.add(new TaskItem("a", "aaa", "2020-11-16", false));
        String gottenDescription = tasks.getItem(0).getDescription();
        assertEquals("aaa", gottenDescription);
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class,
                ()-> {
                    TaskList tasks = new TaskList();
                    tasks.add(new TaskItem("a", "aaa", "2020-11-16", false));
                    tasks.getItem(1).getDueDate();
                });
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() {
        assertDoesNotThrow(
                ()-> {
                    TaskList tasks = new TaskList();
                    tasks.add(new TaskItem("a", "aaa", "2020-11-16", false));
                    tasks.getItem(0).getDueDate();
                });

        TaskList tasks = new TaskList();
        tasks.add(new TaskItem("a", "aaa", "2020-11-16", false));
        String gottenDueDate = tasks.getItem(0).getDueDate();
        assertEquals("2020-11-16", gottenDueDate);
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class,
                ()-> {
                    TaskList tasks = new TaskList();
                    tasks.add(new TaskItem("a", "aaa", "2020-11-16", false));
                    tasks.getItem(1).getName();
                });
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() {
        assertDoesNotThrow(
                ()-> {
                    TaskList tasks = new TaskList();
                    tasks.add(new TaskItem("a", "aaa", "2020-11-16", false));
                    tasks.getItem(0).getName();
                });

        TaskList tasks = new TaskList();
        tasks.add(new TaskItem("a", "aaa", "2020-11-16", false));
        String gottenName = tasks.getItem(0).getName();
        assertEquals("a", gottenName);
    }

    @Test
    public void newTaskListIsEmpty() {
        TaskList tasks = new TaskList();
        assertEquals(0, tasks.size());
    }

    @Test
    public void removingTaskItemsDecreasesSize() {
        TaskList tasks = new TaskList();
        tasks.add(new TaskItem("a", "aaa", "2020-11-16", false));
        int oldSize = tasks.size();
        tasks.remove(0);
        int newSize = tasks.size();
        assertEquals(oldSize-1, newSize);
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class,
                ()-> {
                    TaskList tasks = new TaskList();
                    tasks.add(new TaskItem("a", "aaa", "2020-11-16", false));
                    tasks.remove(1);
                });
    }

    @Test
    public void savedTaskListCanBeLoaded() {
        assertDoesNotThrow(
                ()-> {
                    TaskList tasks = new TaskList();
                    tasks.add(new TaskItem("a", "aaa", "2020-11-16", false));
                    tasks.read("test.txt");
                });
    }

    @Test
    public void uncompletingTaskItemChangesStatus() {
        TaskList tasks = new TaskList();
        tasks.add(new TaskItem("a", "aaa", "2020-11-16", false));
        tasks.setCompletionStatus(0, true);
        boolean oldCompletionStatus = tasks.getItem(0).getComplete();
        tasks.setCompletionStatus(0, false);
        boolean newCompletionStatus = tasks.getItem(0).getComplete();
        assertNotEquals(oldCompletionStatus, newCompletionStatus);
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class,
                ()-> {
                    TaskList tasks = new TaskList();
                    tasks.add(new TaskItem("a", "aaa", "2020-11-16", false));
                    tasks.setCompletionStatus(1, false);
                });
    }

    @Test
    public void taskListCanBeWrittenToFile() {
        assertDoesNotThrow(
                ()-> {
                    TaskList tasks = new TaskList();
                    tasks.add(new TaskItem("a", "aaa", "2020-11-16", false));
                    tasks.write("test.txt");
                });
    }

    @Test
    public void importingAndExportingIsCorrect() {
        TaskList tasks = new TaskList();
        tasks.add(new TaskItem("a", "aaa", "2020-11-16", false));
        String oldName = tasks.getItem(0).getName();
        String oldDescription = tasks.getItem(0).getDescription();
        String oldDueDate = tasks.getItem(0).getDueDate();
        tasks.write("test.txt");
        TaskList newTasks = new TaskList();
        newTasks.read("test.txt");
        assertEquals(oldName, newTasks.getItem(0).getName());
        assertEquals(oldDescription, newTasks.getItem(0).getDescription());
        assertEquals(oldDueDate, newTasks.getItem(0).getDueDate());
    }
}