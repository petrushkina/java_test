package ru.stqa.pft.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod

    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.goTo().addNew();
            app.contact().create(new ContactData()
                    .withLastName("TestLastName").withFirstName("Testname").withAddress("TestAddress")
                    .withEmail("test@gmail.com").withEmail2("test2@gmail.com").withEmail3("test3@gmail.com")
                    .withHomePhone("555 555").withMobilePhone("+79999999999").withWorkPhone("3333"));
        }
    }

    @Test
    public void testContactDeletion1() {
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().deleteContact(deletedContact);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size() - 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(deletedContact)));
    }


    @Test(enabled = false)
    public void testContactDeletion() {
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().editById(deletedContact.getId());
        app.contact().delete();
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size() - 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(deletedContact)));

   }

    @Test(enabled = false)
    public void testContactsDeletion() {
        List<ContactData> before = app.contact().list();
        app.contact().selectAll();
        app.contact().deleteSelected();
        app.goTo().homePage();
        List<ContactData> after = app.contact().list();
        assertEquals(after.size(), (before.size() - before.size()));

        before.remove(before.size() - before.size());
        assertEquals(before,after);
    }
}
