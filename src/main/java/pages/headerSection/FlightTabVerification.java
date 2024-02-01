package pages.headerSection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.List;
import java.util.stream.IntStream;

public class FlightTabVerification extends BasePage {

    @FindBy(css = ".headerListItem")
    private WebElement flightTab;

    @FindBy(css = ".headerTitle")
    private WebElement getfindYourNextFlightMessage;

    @FindBy(css = ".headerSearch > div")
    private List<WebElement> headerSearch;

    @FindBy(css = ".me-3")
    private List<WebElement> flightType;

    @FindBy(css = ".headerSearchInput")
    private List<WebElement> searchBarInputFields;

    @FindBy(css = ".rdrDateDisplay > span > input")
    private List<WebElement> dateAndPassengers;

    @FindBy(css = ".rdrNextPrevButton ")
    private List<WebElement> prevNextButtons;

    @FindBy(xpath = "//*[@id='root']//div[3]//span/input")
    private List<WebElement> datepick;

    @FindBy(css = ".headerSearch > div > button")
    private WebElement searchButton;

    @FindBy(css = ".rdrDays > button")
    private List<WebElement> allDatesOnDatePicker;

    @FindBy(css = ".optionCounter > button")
    private List<WebElement> optionCounterButtonForAdultAndChildren;

    @FindBy(css = ".lsItem-flights:nth-child(2) select")
    private WebElement originCountryDropdown;

    @FindBy(css = ".lsItem-flights:nth-child(3) select")
    private WebElement destinationCountryDropdown;

    @FindBy(css = ".lsItem-flights:nth-child(5) input")
    private List<WebElement> returnDateVerify;

    @FindBy(css = ".lsItem-flights:nth-child(4) input")
    private List<WebElement> departureDateverify;

    @FindBy(css = ".w-100")
    private List<WebElement> verifyFlightPage;

    public void clickOntheFlightTab() {
        flightTab.click();
    }

    public String getfindYourNextFlightMessage() {
        return getfindYourNextFlightMessage.getText();
    }

    public void chooseRoundTrip() {
        flightType.get(0).click();
    }

    public void chooseOneWay() {
        flightType.get(1).click();
    }

    public void chooseClass(String className) {
        Select select = new Select(searchBarInputFields.get(0));
        select.selectByVisibleText(className);
    }

    public void chooseDepartureCountry(String departure) {
        Select select = new Select(searchBarInputFields.get(1));
        select.selectByVisibleText(departure);
    }

    public void chooseArrivalCountry(String arrival) {
        Select select = new Select(searchBarInputFields.get(2));
        select.selectByVisibleText(arrival);
    }

    public void clickOnPrevButton() {
        prevNextButtons.get(0).click();
    }

    public void clickOnNextButton() {
        prevNextButtons.get(1).click();
    }

    public void clickOnDateField() {
        headerSearch.get(2).click();
    }

    public void chooseDate(int date) {
        List<WebElement> activeDays = allDatesOnDatePicker.stream()
                .filter(day -> !day.getAttribute("class").contains("rdrDayPassive"))
                .toList();
        activeDays.get(date - 1).click();
    }

    public void clickOnReturnDateField(String string) {
        dateAndPassengers.get(1).sendKeys(string);
    }

    public void clickOnPassengersField() {
        headerSearch.get(3).click();
    }

    public void negativeButtonForAdult(int clickCount) {
        IntStream.range(0, clickCount).forEach(i -> optionCounterButtonForAdultAndChildren.get(0).click());
    }

    public void positiveButtonForAdult(int clickCount) {
        IntStream.range(0, clickCount - 1).forEach(i -> optionCounterButtonForAdultAndChildren.get(1).click());
    }

    public void negativeButtonForchildren(int clickCount) {
        IntStream.range(0, clickCount).forEach(i -> optionCounterButtonForAdultAndChildren.get(2).click());
    }

    public void positiveButtonForchildren(int clickCount) {
        IntStream.range(0, clickCount).forEach(i -> optionCounterButtonForAdultAndChildren.get(3).click());
    }

    public String getSearchFlightsButtonText() {
        return dateAndPassengers.get(4).getText();
    }

    public void clickOnSearchFlightButton() {
        headerSearch.get(4).click();
    }

    public String getOriginCountry() {
        Select select = new Select(originCountryDropdown);
        return select.getFirstSelectedOption().getText();
    }

    public String getDestinationCountry() {
        Select select = new Select(destinationCountryDropdown);
        return select.getFirstSelectedOption().getText();
    }

    public String getVerifyDate(String date) {
        return departureDateverify.get(0).getAttribute("value");
    }

    public String setVerifyFlightPage() {
        return verifyFlightPage.get(0).getText();
    }

}