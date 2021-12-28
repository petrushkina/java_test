package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class NewCreationContact extends TestBase{

  @Test
  public void testNewContactCreation() throws Exception {
    getAddNew();
    fillNewContactForm(new ContactData("Testname", "TestLastName", "+79999999999", "test@gmail.com"));
    submitContactCreation();
    returnToHomePage();
  }
}
