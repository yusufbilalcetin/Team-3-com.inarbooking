package pages.carRentals;

import io.cucumber.java.eo.Se;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Billing_Page {
    @FindBy(id = "firstName")
    private WebElement nameTextField;
    @FindBy(id = "lastName")
    private WebElement lastNameTextField;
    @FindBy(css = "select[name='phoneCountry']")
    private WebElement phoneCountryCode;
    @FindBy(css = "select[name='phone']")
    private WebElement phoneTextField;
    @FindBy(id = "country")
    private WebElement countryTextField;
    @FindBy(id = "address")
    private WebElement addressTextField;
    @FindBy(id = "city")
    private WebElement cityTextField;
    @FindBy(id = "postalCode")
    private WebElement postalCodeTextField;
    @FindBy(css = ".form-check input.fs-4")
    private List<WebElement> businesBookingOrNotRadioButtons;
    @FindBy(css = "input[placeholder=\"Cardholder's Name\"]")
    private WebElement cardholderNameTextField;
    @FindBy(css = "input[placeholder='**** **** **** ****']")
    private WebElement cardNumberField;
    @FindBy(css = "input[placeholder='MM/YY or MMYY']")
    private WebElement expirationDateField;
    @FindBy(css = "input[placeholder='CVV/CVC ( 3 or 4 number length)']")
    private WebElement cvvCodeField;
    @FindBy(css = ".form-check input.fs-4")
    private List<WebElement> markettingEmailsCheckboxes;
    @FindBy(css = ".btn-danger")
    private WebElement backButton;
    @FindBy(css = ".btn-blue")
    private WebElement bookNowButton;
    public void setName(String name){
        nameTextField.clear();
        nameTextField.sendKeys(name);
    }
    public void setLastName(String lastName){
        lastNameTextField.clear();
        lastNameTextField.sendKeys();
    }
    public void selectCountryCode(int countryCodeIndex){
        Select select= new Select(phoneCountryCode);
        select.selectByIndex(countryCodeIndex);
    }
    public void setPhoneNumber(String phoneNumber){
        phoneTextField.clear();
        phoneTextField.sendKeys(phoneNumber);
    }
    public void setCountry(String country){
        countryTextField.clear();
        countryTextField.sendKeys(country);
    }
    public void setAddress(String address){
        addressTextField.clear();
        addressTextField.sendKeys(address);
    }
    public void setCity(String city){
        cityTextField.clear();
        cityTextField.sendKeys(city);
    }
    public void setPostalCode(String postalCode){
        postalCodeTextField.clear();
        postalCodeTextField.sendKeys(postalCode);
    }
    public void setBusinessOrNot(int index){
        businesBookingOrNotRadioButtons.get(index).click();
    }
    public void setBillingAddressInformation(String name,String lastName,int countryCodeIndex,String phoneNumber,String country,String address,String city,String postalCode,int isBusiness){
        setName(name);
        setLastName(lastName);
        selectCountryCode(countryCodeIndex);
        setPhoneNumber(phoneNumber);
        setCountry(country);
        setAddress(address);
        setCity(city);
        setPostalCode(postalCode);
        setBusinessOrNot(isBusiness);
    }
    public void setCardholderName(String name){
        cardholderNameTextField.clear();
        cardholderNameTextField.sendKeys(name);
    }
    public void setCardNumber(String cardNumber){
        cardNumberField.clear();
        cardNumberField.sendKeys(cardNumber);
    }
    public void setExpirationDate(String expirationDate){
        expirationDateField.clear();
        expirationDateField.sendKeys(expirationDate);
    }
    public void setCvvCode(String cvvCode){
        cvvCodeField.clear();
        cvvCodeField.sendKeys(cvvCode);
    }
    public void setCardInformation(String cardHolderName,String cardNumber,String expirationDate,String cvvCode){
        setCardholderName(cardHolderName);
        setCardNumber(cardNumber);
        setExpirationDate(expirationDate);
        setCvvCode(cvvCode);
    }
    public void clickOnBackButton(){
        backButton.click();
    }
    public void clickOnBookNowButton(){
        bookNowButton.click();
    }
}
