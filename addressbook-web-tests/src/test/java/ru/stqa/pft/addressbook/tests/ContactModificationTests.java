package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().addNew();
            app.contact().create(new ContactData()
                    .withLastName("TestLastName").withFirstName("Testname").withAddress("TestAddress")
                    .withEmail("test@gmail.com").withEmail2("test2@gmail.com").withEmail3("test3@gmail.com")
                    .withHomePhone("555 555").withMobilePhone("+79999999999").withWorkPhone("3333").withPhone2("4524522"));
        }
    }

    @Test
    public void testContactModification () {
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        app.goTo().homePage();
        app.contact().editById(modifiedContact.getId());
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId())
                .withLastName("LastName").withFirstName("FirstName").withAddress("Address")
                .withHomePhone("22-22-22").withMobilePhone("+79998888888").withWorkPhone("800 666666").withPhone2("58 65 94")
                .withEmail("test1@gmail.com").withEmail2("2Test@test.ru").withEmail3("3Test@test.ru");
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
        verifyContactListInUi();
    }
}
