package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    static WebDriver driver;

    public String currentURL;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "_desktop_user_info")
    WebElement goToSignInFormButton;

    public void getCurrentUrl(){
        currentURL = driver.getCurrentUrl();
        System.out.println("Current URL is: " + currentURL);
    }

    public void goToSignIn(){
        goToSignInFormButton.click();
    }
}
