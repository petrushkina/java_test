package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillNewContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getName());
        type(By.name("lastname"), contactData.getLastName());
        click(By.xpath("//div[@id='content']/form/label[9]"));
        type(By.name("mobile"), contactData.getNumber());
        type(By.name("email"),contactData.getEmail());
    }

    public void editContact(int index) {
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    }

    public void updateContact() {
        click(By.xpath("//div[@id='content']/form/input[22]"));
    }

    public void deleteContact() {
        click(By.xpath("//div[@id='content']/form[2]/input[2]"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
        wd.findElement(By.cssSelector("div.msgbox"));
    }

    public void selectAllContact() {
        click(By.id("MassCB"));
    }


    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void createContact(ContactData contact) {
        fillNewContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String name = element.findElement(By.xpath("./td[3]")).getText();
            String lastName = element.findElement(By.xpath("./td[2]")).getText();
            ContactData contact = new ContactData(id, name, lastName,  null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
