package pages.hotels;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.BrowserUtils;

import java.util.List;

public class Hotels_FilterAndList_Page extends BasePage {

	//Team 3 part stays

	@FindBy(xpath = "//h1[text()='Hotels']")
	private WebElement hotelsHeader;

	@FindBy(css = "div.lsCheckboxItem > span")
	private List<WebElement> checkBoxChoicesList;

	@FindBy(css = "div.search-btn-flight > button")
	private WebElement searchButton;

	@FindBy(css = "button.siCheckButton")
	private List<WebElement> seeAvailabilityButtonList;

	@FindBy(xpath = "//input[@class='shadow-md'][1]")
	private WebElement destinationInput;

	public String getDestinationInputText() {
		return destinationInput.getAttribute("value");
	}

	public String getHotelsHeaderText() {
		return hotelsHeader.getText();
	}

	public void clickOnCheckBoxChoices(String choice) {
		BrowserUtils.scrollDownWithPageDownButton(1);
		checkBoxChoicesList.stream()
			.filter(e -> e.getText().equalsIgnoreCase(choice))
			.findFirst()
			.get()
			.findElement(By.xpath("../input"))
			.click();
	}

	public void clickOnSearchButton() {
		BrowserUtils.scrollDownWithPageDownButton(1);
		searchButton.click();
	}

	public void clickOnSeeAvailabilityButtonByIndex(int index) {
		if (index < 3) {
			BrowserUtils.scrollUpWithPageUpButton(2);
		}
		else if (index < 5) {
			BrowserUtils.scrollUpWithPageUpButton(1);
		}
		else if (index > 7) {
			BrowserUtils.scrollDownWithPageDownButton(1);
		}
		seeAvailabilityButtonList.get(index - 1).click();
	}

}
