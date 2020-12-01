public class ContactItem extends Item {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

// CONTACTITEM METHODS _______________________________________________________
    public ContactItem(String firstName, String lastName, String phoneNumber, String email) {
        if(atLeastOneFilledIn(firstName, lastName, phoneNumber, email)) {
            this.firstName = firstName;
            this.lastName = lastName;
            if (phoneNumber.length() > 0) {
                if (isPhoneNumberValid(phoneNumber)) {
                    this.phoneNumber = phoneNumber;
                } else {
                    throw new InvalidPhoneNumberException("Phone number is not valid; must be in the form xxx-xxx-xxxx");
                }
            }
            if (email.length() > 0) {
                if (isEmailValid(email)) {
                    this.email = email;
                } else {
                    throw new InvalidEmailException("Email is not valid; must be in the form x@y.z");
                }
            }
        }
        else {
            throw new InvalidContactException("You must fill in at least one field for this contact.");
        }
    }

    private boolean atLeastOneFilledIn(String firstName, String lastName, String phoneNumber, String email) {
        return (firstName.length()!=0 || lastName.length()!=0 || phoneNumber.length()!=0 || email.length()!=0);
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        return (phoneNumber.matches("\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d"));
    }

    private boolean isEmailValid(String email) {
        return (email.matches("(\\w+)@(\\w+).(\\w+)"));
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

// ABSTRACT METHODS _______________________________________________________
    @Override
    public void edit(String[] args) {
        String newFirstName = args[0];
        String newLastName = args[1];
        String newPhoneNumber = args[2];
        String newEmail = args[3];
        new ContactItem(newFirstName, newLastName, newPhoneNumber, newEmail);
        this.firstName = newFirstName;
        this.lastName = newLastName;
        this.phoneNumber = newPhoneNumber;
        this.email = newEmail;
    }
}

class InvalidContactException extends IllegalArgumentException {
    public InvalidContactException(String msg) {
        super(msg);
    }
}

class InvalidPhoneNumberException extends IllegalArgumentException {
    public InvalidPhoneNumberException(String msg) {
        super(msg);
    }
}

class InvalidEmailException extends IllegalArgumentException {
    public InvalidEmailException(String msg) {
        super(msg);
    }
}