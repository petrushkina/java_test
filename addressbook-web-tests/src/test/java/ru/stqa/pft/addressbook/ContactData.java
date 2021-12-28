package ru.stqa.pft.addressbook;

public class ContactData {
    private final String name;
    private final String lastName;
    private final String number;
    private final String email;

    public ContactData(String name, String lastName, String number, String email) {
        this.name = name;
        this.lastName = lastName;
        this.number = number;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }
}
