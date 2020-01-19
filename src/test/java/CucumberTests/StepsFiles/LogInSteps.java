package CucumberTests.StepsFiles;

import PageObjects.LogInPage;
import PageObjects.LoggedUserMainPage;
import PageObjects.MainPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LogInSteps {
    WebDriver driver;

    @Given("I open site https:\\/\\/prod-kurs.coderslab.pl")
    public void iOpenSiteHttpsProdKursCoderslabPl() {
        System.setProperty("webdriver.chrome.driver", "/home/radek/IdeaProjects/Testy2020/kursCoderslabNew/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("I click sign in button")
    public void iClickSignInButton() {
        MainPage mainPage= new MainPage(this.driver);
        mainPage.goToSignIn();
    }

    @And("I fill log in form {string} {string}")
    public void iFillLogInForm(String arg0, String arg1) {
        LogInPage logInPage = new LogInPage(this.driver);
        logInPage.fillOutLogInField(arg0);
        logInPage.fillOutPasswordField(arg1);
        logInPage.submitAForm();
    }

    @Then("I am logged in to my account")
    public void iAmLoggedInToMyAccount() {
        LoggedUserMainPage username = new LoggedUserMainPage(this.driver);
        username.loggedUserName();
        Assert.assertEquals("Automated Tester", username.loggedUserName());
    }
}
