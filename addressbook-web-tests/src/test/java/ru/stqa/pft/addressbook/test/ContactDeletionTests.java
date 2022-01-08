package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;
import java.util.Set;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod

    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.goTo().addNew();
            app.contact().create(new ContactData().withName("Testname").withLastName("TestLastName").withNumber("+79999999999").withEmail("test@gmail.com"));
        }
    }

    @Test
    public void testContactDeletion1() {
        Set<ContactData> before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().deleteContact(deletedContact);
        app.goTo().homePage();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletedContact);
        Assert.assertEquals(before, after);
    }


    @Test(enabled = false)
    public void testContactDeletion() {
        Set<ContactData> before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        int index = before.size() - 1;
        app.contact().edit();
        app.contact().delete();
        app.goTo().homePage();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletedContact);
        Assert.assertEquals(before, after);
   }

    @Test(enabled = false)
    public void testContactsDeletion() {
        List<ContactData> before = app.contact().list();
        app.contact().selectAll();
        app.contact().deleteSelected();
        app.goTo().homePage();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), (before.size() - before.size()));

        before.remove(before.size() - before.size());
        Assert.assertEquals(before,after);
    }
}
