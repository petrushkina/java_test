package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class SessionHelper extends HelperBase {

    public SessionHelper(ApplicationManager app) {
        super(app);
    }

    public void auth(String username, String password) {
        wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
        type(By.name("username"),username);
        click(By.xpath("//input[@value='Login']"));
        type(By.id("password"),password);
        click(By.xpath("//input[@value='Login']"));
    }
}
