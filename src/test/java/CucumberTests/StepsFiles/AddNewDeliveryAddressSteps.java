package CucumberTests.StepsFiles;

import PageObjects.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AddNewDeliveryAddressSteps {
    WebDriver driver;

    @Given("I open a site prod-kurs.coderslab.pl")
    public void i_open_a_site_https_prod_kurs_coderslab_pl() {
        System.setProperty("webdriver.chrome.driver", "/home/radek/IdeaProjects/Testy2020/kursCoderslabNew/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("I click log in button")
    public void iClickLogInButton() {
        MainPage mainPage= new MainPage(this.driver);
        mainPage.getCurrentUrl();
        Assert.assertEquals("https://prod-kurs.coderslab.pl/index.php", mainPage.currentURL);

        mainPage.goToSignIn();

        LogInPage logInPage = new LogInPage(this.driver);
        logInPage.checkTextLogInPageHeader();
        logInPage.printLogInPageHeaderText();

        Assert.assertEquals("Log in to your account", logInPage.checkTextLogInPageHeader());
    }

    @And("I fill log in form by {string} {string}")
    public void iFillLogInFormBy(String arg0, String arg1) {
        LogInPage logInPage = new LogInPage(this.driver);
        logInPage.fillOutLogInField(arg0);
        logInPage.fillOutPasswordField(arg1);
        logInPage.submitAForm();

    }

    @And("I click Addresses button")
    public void iClickAddressesButton() {
        LoggedUserMainPage username = new LoggedUserMainPage(this.driver);

        username.loggedUserName();
        username.printToconsoleGetTextOfUserName();

        Assert.assertEquals("Automated Tester", username.loggedUserName());

        username.clickAddressesButton();

        AddressesPage checkAddressesHeaderText = new AddressesPage(this.driver);
        checkAddressesHeaderText.checkTextYourAddressesHeader();
        checkAddressesHeaderText.printYourAddressesHeaderText();

        Assert.assertEquals("Your addresses", checkAddressesHeaderText.checkTextYourAddressesHeader());
    }

    @And("I click Create new address button")
    public void iClickCreateNewAddressButton() {
        AddressesPage createNewAddress = new AddressesPage(this.driver);
        createNewAddress.clickCreateNewAddressButton();

        NewAddressPage newAddressPage = new NewAddressPage(this.driver);
        newAddressPage.checkTextNewAddressesHeader();
        newAddressPage.printNewAddressesHeaderText();

        Assert.assertEquals("New address", newAddressPage.checkTextNewAddressesHeader());
    }

    @And("I fill the form by {string} {string} {string} {string}")
    public void iFillTheFormBy(String arg0, String arg1, String arg2, String arg3) {
        NewAddressPage newAddressPage = new NewAddressPage(this.driver);
        newAddressPage.fillOutAddNewAddressFormMandatoryFields(arg0, arg1, arg2, arg3);

    }

    @Then("I have new address added to my addresses")
    public void iHaveNewAddressAddedToMyAddresses() {
        AddressesPage checkAddNewAddressSuccessAlert = new AddressesPage(this.driver);
        checkAddNewAddressSuccessAlert.checkNewAddressSuccessAlert();
        checkAddNewAddressSuccessAlert.printSuccessAlertText();

        Assert.assertEquals("Address successfully added!",
                checkAddNewAddressSuccessAlert.checkNewAddressSuccessAlert());

      driver.quit();
    }
}
