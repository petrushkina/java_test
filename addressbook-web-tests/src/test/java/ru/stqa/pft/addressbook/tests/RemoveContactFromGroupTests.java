package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;

public class RemoveContactFromGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {

        Contacts contacts = app.db().contacts();

        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }

        if (app.db().contacts().size() == 0) {
            app.goTo().addNew();
            app.contact().create(new ContactData().withLastName("Contact").withFirstName("RemovedFromGroup"));
        }

        if (app.contact().findContactWithGroup(contacts) == null) {
            app.goTo().homePage();
            app.contact().selectAll();
            app.contact().clickByAddTo();
            ;
        }
    }

    @Test
    public void testRemoveContactFromGroup() {
        app.goTo().homePage();
        Contacts contacts = app.db().contacts();
        ContactData contactWithGroup = app.contact().findContactWithGroup(contacts);
        int contactId = contactWithGroup.getId();
        GroupData group = contactWithGroup.getGroups().iterator().next();
        int groupId = group.getId();
        Groups deletedGroup = app.db().getGroupById(groupId);
        GroupData deletedGroupData = deletedGroup.iterator().next();
        app.contact().filterByGroup(groupId);
        app.contact().removeContactFromGroup(contactWithGroup.getId(), group.getId());

        Contacts contactAfter = app.db().getContactById(contactId);
        ContactData contactWithoutGroup = contactAfter.iterator().next();
        assertThat(contactWithoutGroup, CoreMatchers.equalTo(contactWithGroup.inGroup(deletedGroupData)));
    }
}
