package CucumberTests.StepsFiles;

import PageObjects.LogInPage;
import PageObjects.LoggedUserMainPage;
import PageObjects.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class EmptyLoginFieldSteps {
    WebDriver driver;

    @Given("I open a site https:\\/\\/prod-kurs.coderslab.pl")
    public void iOpenASiteHttpsProdKursCoderslabPl() {
        System.setProperty("webdriver.chrome.driver", "/home/radek/IdeaProjects/Testy2020/kursCoderslabNew/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("I click sign in button on main page")
    public void iClickSignInButtonOnMainPage() {
        MainPage mainPage= new MainPage(this.driver);
        mainPage.goToSignIn();
    }

    @And("I fill out email field log in form {string}")
    public void iFillOutEmailFieldLogInForm(String arg0) {
        LogInPage logInPage = new LogInPage(this.driver);
        logInPage.fillOutLogInField(arg0);
        logInPage.submitAForm();
    }

    @Then("I am not logged in to my account")
    public void iAmNotLoggedInToMyAccount() {

    }



}
