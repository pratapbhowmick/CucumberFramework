package stepDefinitions;

import org.openqa.selenium.WebDriver;

import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.ConfigReader;

public class LoginTest {
	WebDriver driver=DriverFactory.getDriver();

    LoginPage loginPage = new LoginPage(driver);

    @Given("user navigates to login page")
    public void userNavigatesToLoginPage() {
        driver.get(ConfigReader.getProperty("url"));
    }

    @When("user enters username {string} and password {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("clicks on login button")
    public void clicksOnLoginButton() {
        loginPage.clickLogin();
    }

    @Then("user should see the homepage")
    public void userShouldSeeTheHomepage() {
        // Add assertion logic
    }
}
