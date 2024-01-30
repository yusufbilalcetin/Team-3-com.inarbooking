package pages.headerSection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CarRentalsTab {
    @FindBy(css = "input.h-100")
    private WebElement pickupLocationTextField;
    @FindBy(css = "div.fs-5")
    private List<WebElement> pickupLocationSuggestionList;
    @FindBy(css = "input.fs-5")
    private List<WebElement> pickupAndDropDates;
    @FindBy(css = "select.form-select")
    private List<WebElement> pickupAndDropHours;
    @FindBy(css = ".headerBtn.h-100.w-100")
    private WebElement searchCarsButton;
    public void enterLocationNameToTextField(String str){
        pickupLocationTextField.clear();
        pickupLocationTextField.sendKeys(str);
    }
    public void selectFromSuggestions(int index){
        pickupLocationSuggestionList.get(index).click();
    }
    public void clickOnSearchCarsButton(){searchCarsButton.click();}
    public void selectPickupDate(String pickup){
        pickupAndDropDates.get(0).clear();
        pickupAndDropDates.get(0).sendKeys(pickup);
    }
    public void selectDropoffDate(String dropoff){
        pickupAndDropDates.get(1).clear();
        pickupAndDropDates.get(1).sendKeys(dropoff);
    }
    public void selectDates(String pickup,String dropoff){
        selectPickupDate(pickup);
        selectDropoffDate(dropoff);
    }
    public void selectPickupHour(int index){
        Select select = new Select(pickupAndDropHours.get(0));
        select.selectByIndex(index);
    }
    public void selectDropHour(int index){
        Select select = new Select(pickupAndDropHours.get(1));
        select.selectByIndex(index);
    }
    public void selectHours(int pickup,int drop){
        selectPickupHour(pickup);
        selectDropHour(drop);
    }

}
