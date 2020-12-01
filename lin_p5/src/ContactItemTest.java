import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {

    @Test
    public void creationFailsWithAllBlankValues() {
        assertThrows(InvalidContactException.class,
                ()-> {
                    new ContactItem("", "", "", "");
                });
    }

    @Test
    public void creationFailsWithInvalidPhoneNumber() {
        assertThrows(InvalidPhoneNumberException.class,
                ()-> {
                    new ContactItem("John", "Doe", "1111111111", "john@example.com");
                });
    }

    @Test
    public void creationFailsWithInvalidEmail() {
        assertThrows(InvalidEmailException.class,
                ()-> {
                    new ContactItem("John", "Doe", "111-111-1111", "john@example");
                });
    }

    @Test
    public void creationSucceedsWithBlankFirstName() {
        assertDoesNotThrow(
                ()-> {
                    new ContactItem("", "Doe", "111-111-1111", "john@example.com");
                });
        ContactItem john = new ContactItem("", "Doe", "111-111-1111", "john@example.com");
        assertEquals("", john.getFirstName());
    }

    @Test
    public void creationSucceedsWithBlankLastName() {
        assertDoesNotThrow(
                ()-> {
                    new ContactItem("John", "", "111-111-1111", "john@example.com");
                });
        ContactItem john = new ContactItem("John", "", "111-111-1111", "john@example.com");
        assertEquals("", john.getLastName());
    }

    @Test
    public void creationSucceedsWithBlankPhone() {
        assertDoesNotThrow(
                ()-> {
                    new ContactItem("John", "Doe", "", "john@example.com");
                });
        ContactItem john = new ContactItem("John", "Doe", "", "john@example.com");
        assertEquals("", john.getPhoneNumber());
    }

    @Test
    public void creationSucceedsWithBlankEmail() {
        assertDoesNotThrow(
                ()-> {
                    new ContactItem("John", "Doe", "111-111-1111", "");
                });
        ContactItem john = new ContactItem("John", "Doe", "111-111-1111", "");
        assertEquals("", john.getEmail());
    }

    @Test
    public void creationSucceedsWithNonBlankValues() {
        assertDoesNotThrow(
                ()-> {
                    new ContactItem("John", "Doe", "111-111-1111", "john@example.com");
                });
        ContactItem john = new ContactItem("John", "Doe", "111-111-1111", "john@example.com");
        assertEquals("John", john.getFirstName());
        assertEquals("Doe", john.getLastName());
        assertEquals("111-111-1111", john.getPhoneNumber());
        assertEquals("john@example.com", john.getEmail());
    }

    @Test
    public void editingFailsWithAllBlankValues() {
        assertThrows(InvalidContactException.class,
                ()-> {
                    ContactItem john = new ContactItem("", "", "", "");
                    john.edit(new String[]{"", "", "", ""});
                });
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        assertDoesNotThrow(
                ()-> {
                    ContactItem john = new ContactItem("John", "Doe", "111-111-1111", "john@example.com");
                    john.edit(new String[]{"", "Doe", "111-111-1111", "john@example.com"});
                });
        ContactItem john = new ContactItem("John", "Doe", "111-111-1111", "john@example.com");
        String oldFirstName = john.getFirstName();
        john.edit(new String[]{"", "Doe", "111-111-1111", "john@example.com"});
        String newFirstName = john.getFirstName();
        assertEquals("", newFirstName);
        assertNotEquals(oldFirstName, newFirstName);
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        assertDoesNotThrow(
                ()-> {
                    ContactItem john = new ContactItem("John", "Doe", "111-111-1111", "john@example.com");
                    john.edit(new String[]{"John", "", "111-111-1111", "john@example.com"});
                });
        ContactItem john = new ContactItem("John", "Doe", "111-111-1111", "john@example.com");
        String oldLastName = john.getLastName();
        john.edit(new String[]{"John", "", "111-111-1111", "john@example.com"});
        String newLastName = john.getLastName();
        assertEquals("", newLastName);
        assertNotEquals(oldLastName, newLastName);
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        assertDoesNotThrow(
                ()-> {
                    ContactItem john = new ContactItem("John", "Doe", "111-111-1111", "john@example.com");
                    john.edit(new String[]{"John", "Doe", "", "john@example.com"});
                });
        ContactItem john = new ContactItem("John", "Doe", "111-111-1111", "john@example.com");
        String oldPhoneNumber = john.getPhoneNumber();
        john.edit(new String[]{"John", "Doe", "", "john@example.com"});
        String newPhoneNumber = john.getPhoneNumber();
        assertEquals("", newPhoneNumber);
        assertNotEquals(oldPhoneNumber, newPhoneNumber);
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        assertDoesNotThrow(
                ()-> {
                    ContactItem john = new ContactItem("John", "Doe", "111-111-1111", "john@example.com");
                    john.edit(new String[]{"John", "Doe", "111-111-1111", ""});
                });
        ContactItem john = new ContactItem("John", "Doe", "111-111-1111", "john@example.com");
        String oldEmail = john.getEmail();
        john.edit(new String[]{"John", "Doe", "111-111-1111", ""});
        String newEmail = john.getEmail();
        assertEquals("", newEmail);
        assertNotEquals(oldEmail, newEmail);
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        assertDoesNotThrow(
                ()-> {
                    ContactItem john = new ContactItem("John", "Doe", "111-111-1111", "john@example.com");
                    john.edit(new String[]{"Jane", "Smith", "222-222-2222", "jane@this.com"});
                });
        ContactItem john = new ContactItem("John", "Doe", "111-111-1111", "john@example.com");

        String oldFirstName = john.getFirstName();
        String oldLastName = john.getLastName();
        String oldPhoneNumber = john.getPhoneNumber();
        String oldEmail = john.getEmail();

        john.edit(new String[]{"Jane", "Smith", "222-222-2222", "jane@this.com"});

        String newFirstName = john.getFirstName();
        String newLastName = john.getLastName();
        String newPhoneNumber = john.getPhoneNumber();
        String newEmail = john.getEmail();

        assertNotEquals(oldFirstName, newFirstName);
        assertNotEquals(oldLastName, newLastName);
        assertNotEquals(oldPhoneNumber, newPhoneNumber);
        assertNotEquals(oldEmail, newEmail);
    }

    @Test
    public void testToString() {
        ContactItem john = new ContactItem("John", "Doe", "111-111-1111", "john@example.com");
        String johnToString = john.toString();
        assertEquals("John Doe 111-111-1111 john@example.com", johnToString);
    }
}