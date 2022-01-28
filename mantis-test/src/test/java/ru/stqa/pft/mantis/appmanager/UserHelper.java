package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class UserHelper extends HelperBase {

    public UserHelper(ApplicationManager app) {
        super(app);
    }

    public void selectUser(String username) {
        click((By.xpath("//a[text()='" + username + "']")));
    }

    public void resetPassword() {
        click((By.xpath("//input[@value='Reset Password']")));
    }

    public void changeUserPassword(String username) {
        selectUser(username);
        resetPassword();
    }
}
