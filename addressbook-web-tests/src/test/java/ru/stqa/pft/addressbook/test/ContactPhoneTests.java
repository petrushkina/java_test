package ru.stqa.pft.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
            app.goTo().homePage();
            if (app.contact().all().size() == 0) {
                app.goTo().addNew();
                app.contact().create(new ContactData().withLastName("TestLastName").withFirstName("Testname").withAddress("TestAddress")
                        .withEmail("test@gmail.com").withEmail2("test2@gmail.com").withEmail3("test3@gmail.com")
                        .withHomePhone("555 555").withMobilePhone("+79999999999").withWorkPhone("3333"));
            }
        }

    @Test
    public void testContactPhones() {
       app.goTo().homePage();
       ContactData contact = app.contact().all().iterator().next();
       ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
       assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
   }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
   }
}
