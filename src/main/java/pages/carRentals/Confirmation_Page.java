package pages.carRentals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Confirmation_Page {
    @FindBy(css = ".fs-2 .fw-bold")
    private WebElement location;
    @FindBy(css = ".fs-3.fw-bold")
    private WebElement carModel;
    @FindBy(css = ".text-muted")
    private List<WebElement> dates;//1st check-in 2nd check-out 3rd total days
    @FindBy(css = ".btn-danger")
    private WebElement closeButton;
    @FindBy(css = ".w-100.d-flex button")
    private WebElement printTextButton;
    public void clickOnCloseButton(){
        closeButton.click();
    }
    public void clickOnPrintTextButton(){
        printTextButton.click();
    }
}
