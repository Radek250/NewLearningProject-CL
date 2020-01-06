package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedUserMainPage extends MainPage {
    public LoggedUserMainPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[@class='account']")
    WebElement userName;
    @FindBy(id = "addresses-link")
    WebElement addressesButton;

    public String loggedUserName(){
        return userName.getText();
    }

    public void printToconsoleGetTextOfUserName(){
        System.out.println("You are logged as: " + loggedUserName());
    }

    public void clickAddressesButton(){

        addressesButton.click();
    }
}
