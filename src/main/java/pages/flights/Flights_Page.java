package pages.flights;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class Flights_Page extends BasePage {

	@FindBy(xpath = "//div[@class='listResultTabs w-100'][1]")
	private List<WebElement> ticketSelectionList;

	@FindBy(css = ".w-100")
	private List<WebElement> fligtPageTexts;

	@FindBy(css = "button.flight-button.text-center")
	private List<WebElement> seeAvailabilityButtons;

	@FindBy(css = "button.flight-button.text-center")
	private List<WebElement> selectTicketButtons;

	@FindBy(css = "button.flight-button.text-center")
	private List<WebElement> selectReturnTicketButtons;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	private WebElement searchButton;

	public String getFlightPageText() {
		return fligtPageTexts.get(1).getText();
	}

	public void clickOnCheapestTab() {
		ticketSelectionList.get(0).click();
	}

	public void clickOnSeeAvailabilityButton() {
		seeAvailabilityButtons.get(0).click();
	}

	public void clickOnSelectTicketButton() {
		selectTicketButtons.get(0).click();
	}

	public void clickOnSelectReturnTicketButton() {
		selectReturnTicketButtons.get(0).click();
	}

	public void clickOnSearcButton() {
		actions.moveToElement(searchButton).build().perform();
		searchButton.click();
	}

}
