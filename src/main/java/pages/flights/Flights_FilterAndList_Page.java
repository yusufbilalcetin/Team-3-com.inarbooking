package pages.flights;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import utils.BrowserUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Flights_FilterAndList_Page extends BasePage {

    @FindBy(xpath = "//h1[text()='Flights']")
    private WebElement flightsHeader;

    @FindBy(xpath = "(//select)")
    private List<WebElement> selects;

    @FindBy(css = ".searchItem")
    private List<WebElement> flightCards;

    @FindBy(css = ".headerListItem > span")
    private List<WebElement> tablist;

    public void clickOnFlightsTab() {
        tablist.get(1).click();
    }

    public String getFlightsHeaderText() {
        return flightsHeader.getText();
    }

    public String getDepartureCountrySelectText() {
        Select select = new Select(selects.get(0));
        return select.getFirstSelectedOption().getText();
    }

    public String getArrivalCountrySelectText() {
        Select select = new Select(selects.get(1));
        return select.getFirstSelectedOption().getText();
    }

    public boolean isAllFlightsDepartureCountryCorrect(String departureCountry) {
        return flightCards.stream()
                .allMatch(flight -> flight.findElement(By.xpath(".//div[2]/div/div[1]/span[2]"))
                        .getText()
                        .contains(departureCountry));
    }

    public boolean isAllFlightsArrivalCountryCorrect(String arrivalCountry) {
        return flightCards.stream()
                .allMatch(flight -> flight.findElement(By.xpath(".//div[2]/div/div[3]/span[2]"))
                        .getText()
                        .contains(arrivalCountry));
    }

}
