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

    //Correct log in

    @Given("I open site https:\\/\\/prod-kurs.coderslab.pl")
    public void iOpenSiteHttpsProdKursCoderslabPl() {
        System.setProperty("webdriver.chrome.driver", "/home/radek/IdeaProjects/Testy2020/kursCoderslabNew/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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

        boolean isLogged;
        String expectedURL = "https://prod-kurs.coderslab.pl/index.php?controller=my-account";
        String currentUrl = driver.getCurrentUrl();

        System.out.println("Expected URL is: " + expectedURL);
        System.out.println("Actual URL is: " + currentUrl);

        if (expectedURL.equals(currentUrl))
            isLogged = true;
        else
            isLogged = false;

        Assert.assertTrue(isLogged);

        driver.quit();
    }
    //Incorrect log in with
    //  1) wrong email
    //  2) wrong password

    @Then("I`m not logged in to my account and I can see fail alert")
    public void iMNotLoggedInToMyAccountAndICanSeeFailAlert() {
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

// Incorrect log in with only login filled out in form

    @And("I fill out email field log in form {string}")
    public void iFillOutEmailFieldLogInForm(String arg0) {
        LogInPage logInPage = new LogInPage(this.driver);
        logInPage.fillOutLogInField(arg0);
        logInPage.submitAForm();
    }

    @Then("I am not logged in to my account")
    public void iAmNotLoggedInToMyAccount() {
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

    // Incorrect log in with only password filled out in form

    @And("I fill out password field in log in form {string}")
    public void iFillOutPasswordFieldInLogInForm(String arg0) {
        LogInPage logInPage = new LogInPage(this.driver);
        logInPage.fillOutPasswordField(arg0);
        logInPage.submitAForm();
    }

    // Incorrect log in without fill out in form

    @And("I submit form without filling out login and password fields")
    public void iSubmitFormWithoutFillingOutLoginAndPasswordFields() {
        LogInPage logInPage = new LogInPage(this.driver);
        logInPage.submitAForm();
    }
}