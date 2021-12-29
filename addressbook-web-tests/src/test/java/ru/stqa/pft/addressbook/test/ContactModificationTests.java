package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

    @Test
    public void testContactModification () {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().editContact();
        app.getContactHelper().fillNewContactForm(new ContactData("name", "LastName", "+79998888888", "test1@gmail.com"));
        app.getContactHelper().updateContact();
        app.getNavigationHelper().returnToHomePage();
    }
}