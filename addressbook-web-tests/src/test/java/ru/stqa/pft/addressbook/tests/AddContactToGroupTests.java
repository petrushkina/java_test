package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        Contacts contacts = app.db().contacts();

        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }

        if (app.contact().findContactWithoutGroup(contacts) == null) {
            app.goTo().addNew();
            app.contact().create(new ContactData().withLastName("TestLastName").withFirstName("Testname"));
        }

        if (app.db().contacts().size() == 0) {
            app.goTo().addNew();
            app.contact().create(new ContactData()
                    .withLastName("TestLastName").withFirstName("Testname"));
        }
    }

    @Test
    public void testAddContactToGroup() {
        app.goTo().homePage();
        Groups groups = app.db().groups();
        Contacts contacts = app.db().contacts();
        ContactData contactWithoutGroup = app.contact().findContactWithoutGroup(contacts);
        int contactId = contactWithoutGroup.getId();
        GroupData selectedGroup = groups.iterator().next();
        app.contact().addContactToGroup(contactWithoutGroup.getId(), selectedGroup.getId());

        Contacts contactAfter = app.db().getContactById(contactId);
        ContactData contactWithGroup = contactAfter.iterator().next();
        assertThat(contactWithGroup, CoreMatchers.equalTo(contactWithoutGroup.inGroup(selectedGroup)));
    }
}
