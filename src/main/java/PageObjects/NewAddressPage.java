package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAddressPage {
    WebDriver driver;

    public NewAddressPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
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


    public void fillOutAddNewAddressFormMandatoryFields(String address, String city, String postcode){
        addressFirstField.click();
        addressFirstField.clear();
        addressFirstField.sendKeys(address);

        cityField.click();
        cityField.clear();
        cityField.sendKeys(city);

        postCodeField.click();
        postCodeField.clear();
        postCodeField.sendKeys(postcode);
    }

    public void submitNewAddressForm(){
        submitAddressButton.submit();
    }

    //    Dodałem osobną metodę do submit po to żeby można było decydować czy chcę uzupełniać jedynie mandatory pola czy także
    //            optional
    //    Póki co stworzyłem jedynie metodę na wypełnienia mandatory pól w formularzu


}
