package CucumberTests.StepsFiles;

import PageObjects.LogInPage;
import PageObjects.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WrongLoginDataSteps {
    WebDriver driver;

    @Given("I open https:\\/\\/prod-kurs.coderslab.pl")
    public void iOpenHttpsProdKursCoderslabPl() {
        System.setProperty("webdriver.chrome.driver", "/home/radek/IdeaProjects/Testy2020/kursCoderslabNew/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @When("I click on sign in button")
    public void iClickOnSignInButton() {
        MainPage mainPage= new MainPage(this.driver);
        mainPage.goToSignIn();
    }



    @And("I fill log in form with {string} {string}")
    public void iFillLogInFormWith(String arg0, String arg1) {
        LogInPage logInPage = new LogInPage(this.driver);
        logInPage.fillOutLogInField(arg0);
        logInPage.fillOutPasswordField(arg1);
        logInPage.submitAForm();
    }


    @Then("I`m not logged in to my account")
    public void iMNotLoggedInToMyAccount() {
        LogInPage authenticationFailed = new LogInPage(this.driver);
        authenticationFailed.authenticationFailedText();
        authenticationFailed.authenticationFailedPrintText();
        Assert.assertEquals("Authentication failed.", authenticationFailed.authenticationFailedText());

        boolean isNotLogged;
        String expectedURL = "https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account";
        String currentUrl = driver.getCurrentUrl();

        System.out.println("Expected URL is: " + expectedURL);
        System.out.println("Actual URL is: " + currentUrl);

        if (expectedURL.equals(currentUrl))
            isNotLogged = true;
        else
            isNotLogged = false;

        Assert.assertTrue(isNotLogged);

        driver.quit();
    }
}
