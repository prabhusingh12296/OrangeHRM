package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import driver.DriverManager;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginStepDefinition {

    private pages.LoginPage loginPage;

    @Given("user is on the OrangeHRM login page")
    public void userIsOnLoginPage() {

        DriverManager.getDriver()
                .get(ConfigReader.get("url"));

        loginPage = new LoginPage();
    }

    @When("user enters username {string}")
    public void userEntersUsername(String username) {

        loginPage.enterUsername(username);
    }

    @When("user enters password {string}")
    public void userEntersPassword(String password) {

        loginPage.enterPassword(password);
    }

    @When("user clicks on login button")
    public void userClicksLoginButton() {

        loginPage.clickLogin();
    }

    @Then("OrangeHRM dashboard should be displayed")
    public void dashboardShouldBeDisplayed() {

        Assert.assertTrue(
                loginPage.isDashboardDisplayed(),
                "Dashboard was not displayed.");
    }
}