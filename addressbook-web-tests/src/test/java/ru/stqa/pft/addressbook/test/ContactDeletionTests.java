package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {
    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().getAddNew();
            app.getContactHelper().createContact(new ContactData("Testname", "TestLastName", "+79999999999", "test@gmail.com"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().editContact(before.size() - 1);
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
   }

    @Test(priority = 1)
    public void testContactDeletion1() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().getAddNew();
            app.getContactHelper().createContact(new ContactData("Testname", "TestLastName", "+79999999999", "test@gmail.com"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteSelectedContacts();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }

    @Test(priority = 2)
    public void testContactsDeletion() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().getAddNew();
            app.getContactHelper().createContact(new ContactData("Testname", "TestLastName", "+79999999999", "test@gmail.com"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectAllContact();
        app.getContactHelper().deleteSelectedContacts();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
