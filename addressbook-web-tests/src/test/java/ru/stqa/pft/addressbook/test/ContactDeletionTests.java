package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().editContact();
        app.getContactHelper().deleteContact();
    }

    @Test(priority = 1)
    public void testContactDeletion1() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
    }

    @Test(priority = 2)
    public void testContactsDeletion() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectAllContact();
        app.getContactHelper().deleteSelectedContacts();
    }
}
