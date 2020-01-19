package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends MainPage {
    public LogInPage(WebDriver driver){
        super(driver);
    }

    @FindBy(className = "page-header")
    WebElement logInPageHeader;

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(id = "submit-login")
    WebElement submitButton;

    @FindBy(className = "help-block")
    WebElement authenticationFailedAlert;

    public String checkTextLogInPageHeader(){
        return logInPageHeader.getText();
    }

    public void printLogInPageHeaderText(){
        System.out.println("Log in page header text is: " + checkTextLogInPageHeader() + " \n");
    }

    public void fillOutLogInField(String email){
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void fillOutPasswordField(String password){

        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void submitAForm(){
        submitButton.click();
    }

    public String authenticationFailedText(){
        return authenticationFailedAlert.getText();
    }

    public void authenticationFailedPrintText(){
        System.out.println("You are not logged because of: " + authenticationFailedText());
    }
}
