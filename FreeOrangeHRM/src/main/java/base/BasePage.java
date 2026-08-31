package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverManager;
import utils.ConfigReader;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePage() {

        this.driver = DriverManager.getDriver();

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(ConfigReader.get("explicitWait"))));
    }

    protected WebElement waitForVisibility(By locator) {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator));
    }

    protected void click(By locator) {

        waitForClickable(locator).click();
    }

    protected void enterText(By locator,String text) {

        WebElement element = waitForVisibility(locator);

        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {

        return waitForVisibility(locator).getText();
    }

    protected boolean isDisplayed(By locator) {

        try {

            return waitForVisibility(locator).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }
}