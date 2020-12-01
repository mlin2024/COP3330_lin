import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {

    @Test
    public void addingItemsIncreasesSize() {
        ContactList contacts = new ContactList();
        int oldSize = contacts.size();
        contacts.add(new ContactItem("John", "Doe", "111-111-1111", "john@example.com"));
        int newSize = contacts.size();

        assertEquals(oldSize+1, newSize);
    }

    @Test
    public void editingItemsFailsWithAllBlankValues() {
        assertThrows(InvalidContactException.class,
                ()-> {
                    ContactList contacts = new ContactList();
                    contacts.add(new ContactItem("John", "Doe", "111-111-1111", "john@example.com"));
                    contacts.edit(0, new String[]{"", "", "", ""});
                });
    }

    @Test
    public void editingItemsFailsWithInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class,
                ()-> {
                    ContactList contacts = new ContactList();
                    contacts.add(new ContactItem("John", "Doe", "111-111-1111", "john@example.com"));
                    contacts.edit(1, new String[]{"John", "Doe", "222-222-2222", "john@example.com"});
                });
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        assertDoesNotThrow(
                ()-> {
                    ContactList contacts = new ContactList();
                    contacts.add(new ContactItem("John", "Doe", "111-111-1111", "john@example.com"));
                    contacts.edit(0, new String[]{"", "Doe", "111-111-1111", "john@example.com"});
                });
        ContactList contacts = new ContactList();
        contacts.add(new ContactItem("John", "Doe", "111-111-1111", "john@example.com"));
        String oldFirstName = ((ContactItem)(contacts.getItem(0))).getFirstName();
        contacts.edit(0, new String[]{"", "Doe", "111-111-1111", "john@example.com"});
        String newFirstName = ((ContactItem)(contacts.getItem(0))).getFirstName();
        assertEquals("", newFirstName);
        assertNotEquals(oldFirstName, newFirstName);
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        assertDoesNotThrow(
                ()-> {
                    ContactList contacts = new ContactList();
                    contacts.add(new ContactItem("John", "Doe", "111-111-1111", "john@example.com"));
                    contacts.edit(0, new String[]{"John", "", "111-111-1111", "john@example.com"});
                });
        ContactList contacts = new ContactList();
        contacts.add(new ContactItem("John", "Doe", "111-111-1111", "john@example.com"));
        String oldLastName = ((ContactItem)(contacts.getItem(0))).getLastName();
        contacts.edit(0, new String[]{"John", "", "111-111-1111", "john@example.com"});
        String newLastName = ((ContactItem)(contacts.getItem(0))).getLastName();
        assertEquals("", newLastName);
        assertNotEquals(oldLastName, newLastName);
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        assertDoesNotThrow(
                ()-> {
                    ContactList contacts = new ContactList();
                    contacts.add(new ContactItem("John", "Doe", "111-111-1111", "john@example.com"));
                    contacts.edit(0, new String[]{"John", "Doe", "", "john@example.com"});
                });
        ContactList contacts = new ContactList();
        contacts.add(new ContactItem("John", "Doe", "111-111-1111", "john@example.com"));
        String oldPhoneNumber = ((ContactItem)(contacts.getItem(0))).getPhoneNumber();
        contacts.edit(0, new String[]{"John", "Doe", "", "john@example.com"});
        String newPhoneNumber = ((ContactItem)(contacts.getItem(0))).getPhoneNumber();
        assertEquals("", newPhoneNumber);
        assertNotEquals(oldPhoneNumber, newPhoneNumber);
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        assertDoesNotThrow(
                ()-> {
                    ContactList contacts = new ContactList();
                    contacts.add(new ContactItem("John", "Doe", "111-111-1111", "john@example.com"));
                    contacts.edit(0, new String[]{"John", "Doe", "111-111-1111", ""});
                });
        ContactList contacts = new ContactList();
        contacts.add(new ContactItem("John", "Doe", "111-111-1111", "john@example.com"));
        String oldEmail = ((ContactItem)(contacts.getItem(0))).getEmail();
        contacts.edit(0, new String[]{"John", "Doe", "111-111-1111", ""});
        String newEmail = ((ContactItem)(contacts.getItem(0))).getEmail();
        assertEquals("", newEmail);
        assertNotEquals(oldEmail, newEmail);
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        assertDoesNotThrow(
                ()-> {
                    ContactList contacts = new ContactList();
                    contacts.add(new ContactItem("John", "Doe", "111-111-1111", "john@example.com"));
                    contacts.edit(0, new String[]{"Jane", "Smith", "222-222-2222", "jane@this.com"});
                });
        ContactList contacts = new ContactList();
        contacts.add(new ContactItem("John", "Doe", "111-111-1111", "john@example.com"));

        String oldFirstName = ((ContactItem)(contacts.getItem(0))).getFirstName();
        String oldLastName = ((ContactItem)(contacts.getItem(0))).getLastName();
        String oldPhoneNumber = ((ContactItem)(contacts.getItem(0))).getPhoneNumber();
        String oldEmail = ((ContactItem)(contacts.getItem(0))).getEmail();

        contacts.edit(0, new String[]{"Jane", "Smith", "222-222-2222", "jane@this.com"});

        String newFirstName = ((ContactItem)(contacts.getItem(0))).getFirstName();
        String newLastName = ((ContactItem)(contacts.getItem(0))).getLastName();
        String newPhoneNumber = ((ContactItem)(contacts.getItem(0))).getPhoneNumber();
        String newEmail = ((ContactItem)(contacts.getItem(0))).getEmail();

        assertNotEquals(oldFirstName, newFirstName);
        assertNotEquals(oldLastName, newLastName);
        assertNotEquals(oldPhoneNumber, newPhoneNumber);
        assertNotEquals(oldEmail, newEmail);
    }

    @Test
    public void editingFailsWithInvalidPhoneNumber() {
        assertThrows(InvalidPhoneNumberException.class,
                ()-> {
                    ContactList contacts = new ContactList();
                    contacts.add(new ContactItem("John", "Doe", "111-111-1111", "john@example.com"));
                    contacts.edit(0, new String[]{"John", "Doe", "2222222222", "john@example.com"});
                });
    }

    @Test
    public void editingFailsWithInvalidEmail() {
        assertThrows(InvalidEmailException.class,
                ()-> {
                    ContactList contacts = new ContactList();
                    contacts.add(new ContactItem("John", "Doe", "111-111-1111", "john@example.com"));
                    contacts.edit(0, new String[]{"John", "Doe", "111-111-1111", "john@example"});
                });
    }

    @Test
    public void newListIsEmpty() {
        ContactList contacts = new ContactList();
        assertEquals(0, contacts.size());
    }

    @Test
    public void removingItemsDecreasesSize() {
        ContactList contacts = new ContactList();
        contacts.add(new ContactItem("John", "Doe", "111-111-1111", "john@example.com"));
        int oldSize = contacts.size();
        contacts.remove(0);
        int newSize = contacts.size();
        assertEquals(oldSize-1, newSize);
    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class,
                ()-> {
                    ContactList contacts = new ContactList();
                    contacts.add(new ContactItem("John", "Doe", "111-111-1111", "john@example.com"));
                    contacts.remove(1);
                });
    }

    @Test
    public void savedContactListCanBeLoaded() {
        assertDoesNotThrow(
                ()-> {
                    ContactList contacts = new ContactList();
                    contacts.add(new ContactItem("John", "Doe", "111-111-1111", "john@example.com"));
                    contacts.read("test.txt");
                });
    }

    @Test
    public void listCanBeWrittenToFile() {
        assertDoesNotThrow(
                ()-> {
                    ContactList contacts = new ContactList();
                    contacts.add(new ContactItem("John", "Doe", "111-111-1111", "john@example.com"));
                    contacts.write("test.txt");
                });
    }

    @Test
    public void importingAndExportingIsCorrect() {
        ContactList contacts = new ContactList();
        contacts.add(new ContactItem("John", "Doe", "111-111-1111", "john@example.com"));

        String oldFirstName = ((ContactItem)(contacts.getItem(0))).getFirstName();
        String oldLastName = ((ContactItem)(contacts.getItem(0))).getLastName();
        String oldPhoneNumber = ((ContactItem)(contacts.getItem(0))).getPhoneNumber();
        String oldEmail = ((ContactItem)(contacts.getItem(0))).getEmail();

        contacts.write("test.txt");
        TaskList newTasks = new TaskList();
        newTasks.read("test.txt");

        String newFirstName = ((ContactItem)(contacts.getItem(0))).getFirstName();
        String newLastName = ((ContactItem)(contacts.getItem(0))).getLastName();
        String newPhoneNumber = ((ContactItem)(contacts.getItem(0))).getPhoneNumber();
        String newEmail = ((ContactItem)(contacts.getItem(0))).getEmail();

        assertEquals(oldFirstName, newFirstName);
        assertEquals(oldLastName, newLastName);
        assertEquals(oldPhoneNumber, newPhoneNumber);
        assertEquals(oldEmail, newEmail);
    }
}