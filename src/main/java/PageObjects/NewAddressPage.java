package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewAddressPage extends MainPage {
    public NewAddressPage(WebDriver driver){
        super(driver);
    }

    @FindBy(className = "page-header")
    WebElement newAddressesHeader;

    @FindBy(name = "alias")
    WebElement aliasField;

    @FindBy(name = "firstname")
    WebElement firstNameField;

    @FindBy(name = "lastname")
    WebElement lastNameField;

    @FindBy(name = "company")
    WebElement companyField;

    @FindBy(name = "vat_number")
    WebElement vatNumberField;

    @FindBy(name = "address1")
    WebElement addressFirstField;

    @FindBy(name = "address2")
    WebElement addressSecondField;

    @FindBy(name = "city")
    WebElement cityField;

    @FindBy(name = "postcode")
    WebElement postCodeField;

    @FindBy(name = "id_country")
    WebElement countryEnterDropDown;

    @FindBy(name = "phone")
    WebElement phoneField;

    @FindBy(name = "submitAddress")
    WebElement submitAddressButton;

    public String checkTextNewAddressesHeader() {
        return newAddressesHeader.getText();
    }
    public void printNewAddressesHeaderText(){
        System.out.println("New address page header text is: " + checkTextNewAddressesHeader() + " \n");
        }


    public void fillOutAddNewAddressFormMandatoryFields(String alias, String address, String city, String postcode){

        aliasField.click();
        aliasField.click();
        aliasField.sendKeys(alias);

        addressFirstField.click();
        addressFirstField.clear();
        addressFirstField.sendKeys(address);

        cityField.click();
        cityField.clear();
        cityField.sendKeys(city);

        postCodeField.click();
        postCodeField.clear();
        postCodeField.sendKeys(postcode);

        submitAddressButton.submit();
    }
}
