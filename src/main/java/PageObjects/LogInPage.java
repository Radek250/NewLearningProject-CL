package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    WebDriver driver;

    public LogInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "page-header")
    WebElement logInPageHeader;

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(id = "submit-login")
    WebElement submitButton;

    public String checkTextLogInPageHeader(){
        return logInPageHeader.getText();
    }

    public void printLogInPageHeaderText(){
        System.out.println("Log in page header text is: " + checkTextLogInPageHeader() + " \n");
    }

    public void fillOutLogInForm(String email, String password){
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);

        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);

        submitButton.click();
    }

}
