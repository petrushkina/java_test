package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager app) {
        super(app);
    }

    public void manageUsersPage() {
        click(By.xpath("//li[6]/a/span"));
        click(By.xpath("//a[contains(text(),'Manage Users')]"));
    }
}

