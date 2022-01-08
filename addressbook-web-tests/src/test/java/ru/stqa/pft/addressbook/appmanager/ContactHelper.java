package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

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

   public void edit() {
       click(By.xpath("//img[@alt='Edit']"));
    }

    public void editById(int id) {
        wd.findElement(By.xpath("//a[@href='edit.php?id="+ id +"']")).click();
    }

    public void update() {
        click(By.xpath("//div[@id='content']/form/input[22]"));
    }

    public void delete() {
        click(By.xpath("//div[@id='content']/form[2]/input[2]"));
    }

    public void select(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void selectById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void deleteSelected() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
        wd.findElement(By.cssSelector("div.msgbox"));
    }

    public void selectAll() {
        click(By.id("MassCB"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void create(ContactData contact) {
        fillNewContactForm(contact);
        submitContactCreation();
        contactCache = null;
        returnToHomePage();
    }

    public void modify(ContactData contact) {
        fillNewContactForm(contact);
        update();
        contactCache = null;
        returnToHomePage();
    }

    public void deleteContact(int index) {
        select(index);
        deleteSelected();
    }

    public void deleteContact(ContactData deletedContact) {
        selectById(deletedContact.getId());
        deleteSelected();
        contactCache = null;
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String name = element.findElement(By.xpath("./td[3]")).getText();
            String lastName = element.findElement(By.xpath("./td[2]")).getText();
            contacts.add(new ContactData().withId(id).withName(name).withLastName(lastName).withNumber(null).withEmail(null));
        }
        return contacts;
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String name = element.findElement(By.xpath("./td[3]")).getText();
            String lastName = element.findElement(By.xpath("./td[2]")).getText();
            contactCache.add(new ContactData().withId(id).withName(name).withLastName(lastName).withNumber(null).withEmail(null));
        }
        return contactCache;
    }
}
