package pages.flights;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class ChooseYourFare_Page extends BasePage {

	@FindBy(css = ".fare-item-inner")
	private List<WebElement> fareChoices;

	@FindBy(css = ".fw-bold.text-dark.mt-5")
	private List<WebElement> chooseYourFareTexts;

	@FindBy(xpath = "//button[@class='btn btn-blue']")
	private WebElement whosFlyingButton;

	public List<WebElement> getChooseYourFareTextsList() {
		return chooseYourFareTexts;
	}

	public void clickOnFareChoices() {
		fareChoices.get(0).click();
		fareChoices.get(5).click();

	}

	public String getChooseYourFareTexts() {
		return getChooseYourFareTextsList().get(0).getText();
	}

	public void clickOnWhosFlyingButton() {
		whosFlyingButton.click();
	}

}
