package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {
    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().getAddNew();
            app.getContactHelper().createContact(new ContactData("Testname", "TestLastName", "+79999999999", "test@gmail.com"));
        }
        app.getContactHelper().editContact();
        app.getContactHelper().deleteContact();
   }

    @Test(priority = 1)
    public void testContactDeletion1() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().getAddNew();
            app.getContactHelper().createContact(new ContactData("Testname", "TestLastName", "+79999999999", "test@gmail.com"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
    }

    @Test(priority = 2)
    public void testContactsDeletion() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().getAddNew();
            app.getContactHelper().createContact(new ContactData("Testname", "TestLastName", "+79999999999", "test@gmail.com"));
        }
        app.getContactHelper().selectAllContact();
        app.getContactHelper().deleteSelectedContacts();
    }
}
