package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressesPage extends MainPage {

    public AddressesPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@class, 'addresses-footer')]/a")
    WebElement createNewAddressButton;

    @FindBy(id = "notifications")
    WebElement newAddressSuccessAlert;

    @FindBy(className = "page-header")
    WebElement yourAddressesHeader;

    public String checkTextYourAddressesHeader(){
        return yourAddressesHeader.getText();
    }

    public void clickCreateNewAddressButton(){
        createNewAddressButton.click();
    }

    public String checkNewAddressSuccessAlert(){
        return newAddressSuccessAlert.getText();
    }

    public void printYourAddressesHeaderText(){
        System.out.println("Addresses page header text is: " + checkTextYourAddressesHeader() + " \n");
    }

    public void printSuccessAlertText(){
        System.out.println("Text of success alert after creating new delivery address is: "
                            + checkNewAddressSuccessAlert());
    }


}
