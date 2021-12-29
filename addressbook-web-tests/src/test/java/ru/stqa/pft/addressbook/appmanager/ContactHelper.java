package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

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

    public void editContact() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[3]/td[8]/a/img"));
    }

    public void updateContact() {
        click(By.xpath("//div[@id='content']/form/input[22]"));
    }

    public void deleteContact() {
        click(By.xpath("//div[@id='content']/form[2]/input[2]"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
        wd.findElement(By.cssSelector("div.msgbox"));
    }

    public void selectAllContact() {
        click(By.id("MassCB"));
    }
}
