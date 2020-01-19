package CucumberTests.StepsFiles;

import PageObjects.LogInPage;
import PageObjects.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class EmptyPasswordFieldSteps {
    WebDriver driver;

    @Given("I open the site https:\\/\\/prod-kurs.coderslab.pl")
    public void iOpenTheSiteHttpsProdKursCoderslabPl() {
        System.setProperty("webdriver.chrome.driver", "/home/radek/IdeaProjects/Testy2020/kursCoderslabNew/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("I click a sign in button on main page")
    public void iClickASignInButtonOnMainPage() {
        MainPage mainPage= new MainPage(this.driver);
        mainPage.goToSignIn();
    }

    @And("I fill out password field in log in form {string}")
    public void iFillOutPasswordFieldInLogInForm(String arg0) {
        LogInPage logInPage = new LogInPage(this.driver);
        logInPage.fillOutPasswordField(arg0);
        logInPage.submitAForm();
    }

    @Then("I am not logged into my account")
    public void iAmNotLoggedIntoMyAccount() {

    }


}
