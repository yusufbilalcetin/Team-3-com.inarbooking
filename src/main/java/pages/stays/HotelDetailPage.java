package pages.stays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.hotels.Hotel_DetailPage;

import java.util.ArrayList;
import java.util.List;

public class HotelDetailPage extends BasePage {

	private static final Logger LOGGER = LogManager.getLogger(Hotel_DetailPage.class);

	@FindBy(css = "div.most-popular-facilities > div > span")
	private List<WebElement> mostPopularFacilitiesList;

	@FindBy(css = "div.booking-hotel-properties > div > span:nth-child(2)")
	private List<WebElement> hotelPropertiesList;

	@FindBy(xpath = "//button[text()='Reserve or Book Now!']")
	private List<WebElement> reserveOrBookNowPageButton;

	@FindBy(css = ".hotelTitle")
	private WebElement hotelNameTitle;

	@FindBy(css = ".fs-5")
	private WebElement hotelPrice;

	public boolean validateTheFacilitiesOrProperties(String facilityOrProperty) {
		List<WebElement> mergedList = new ArrayList<>(mostPopularFacilitiesList);
		mergedList.addAll(hotelPropertiesList);
		boolean isFound = mergedList.stream().anyMatch(e -> e.getText().equalsIgnoreCase(facilityOrProperty));
		LOGGER.info("The facility or property " + facilityOrProperty + " is found : " + isFound);
		return isFound;
	}

	public void clickReserveOrBookNowButton(int index) {
		reserveOrBookNowPageButton.get(index - 1).click();
	}

	public String getHotelNameText() {
		return hotelNameTitle.getText();
	}

	public String getHotelPrice() {
		return hotelPrice.getText();
	}

}
