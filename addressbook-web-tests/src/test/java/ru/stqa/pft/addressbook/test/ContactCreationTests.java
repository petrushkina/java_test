package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{

  @Test
  public void testNewContactCreation() throws Exception {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.goTo().addNew();
    ContactData contact = new ContactData()
            .withLastName("TestLastName").withFirstName("Testname").withAddress("TestAddress")
            .withEmail("test@gmail.com").withEmail2("test2@gmail.com").withEmail3("test3@gmail.com")
            .withHomePhone("555 555").withMobilePhone("+79999999999").withWorkPhone("3333");
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}
