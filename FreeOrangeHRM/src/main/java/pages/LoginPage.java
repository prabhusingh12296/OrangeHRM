package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class LoginPage extends BasePage {

    private final By username = By.name("username");

    private final By password = By.name("password");

    private final By loginButton = By.xpath("//button[@type='submit']");

    private final By dashboardTitle = By.xpath("//h6[text()='Dashboard']");

    public void enterUsername(String usernameValue) {

        enterText(username, usernameValue);
    }

    public void enterPassword(String passwordValue) {

        enterText(password, passwordValue);
    }

    public void clickLogin() {

        click(loginButton);
    }

    public boolean isDashboardDisplayed() {

        return isDisplayed(dashboardTitle);
    }

    public void login(String usernameValue,String passwordValue) {

        enterUsername(usernameValue);
        enterPassword(passwordValue);
        clickLogin();
    }
}