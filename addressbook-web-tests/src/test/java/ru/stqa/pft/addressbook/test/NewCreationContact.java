package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class NewCreationContact extends TestBase{

  @Test
  public void testNewContactCreation() throws Exception {
    app.getNavigationHelper().getAddNew();
    app.getContactHelper().createContact(new ContactData("Testname", "TestLastName", "+79999999999", "test@gmail.com"));
  }
}
