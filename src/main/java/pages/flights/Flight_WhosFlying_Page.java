package pages.flights;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import utils.BrowserUtils;

import java.util.List;

public class Flight_WhosFlying_Page extends BasePage {

	@FindBy(xpath = "//div[contains(text(),\"Who's flying?\")]")
	private WebElement whosFlyingText;

	@FindBy(css = ".w-100>input")
	private WebElement eMailInputField;

	@FindBy(css = ".w-75>input")
	private WebElement phoneNumberInputField;

	@FindBy(css = ".w-25>select")
	private List<WebElement> phoneCodeDropdownMenu;

	@FindBy(css = ".form-check-input")
	private WebElement checkBoxForFreeMessages;

	@FindBy(css = ".w-50>input")
	private List<WebElement> firstNameLastNameFields;

	@FindBy(css = ".w-50>select")
	private WebElement genderDropdownMenu;

	@FindBy(css = ".w-50>div:nth-child(2)>div>select")
	private List<WebElement> setDateDropDownMenus;

	@FindBy(xpath = "//span[contains(text(),'Select Extras')]")
	private WebElement selectExtrasButton;

	public String getWhosFlyingText() {
		return whosFlyingText.getText();
	}

	public void enterEmail(String string) {
		eMailInputField.sendKeys(string);
	}

	public void enterPhoneNumberInputField(String string) {
		phoneNumberInputField.sendKeys(string);
	}

	public void enterNameInputField(String string) {
		firstNameLastNameFields.get(0).sendKeys(string);
	}

	public void enterLastNameInputField(String string) {
		firstNameLastNameFields.get(1).sendKeys(string);
	}

	public void choosePhoneCode() {
		Select select = new Select(phoneCodeDropdownMenu.get(0));
		select.selectByVisibleText("+1 (US)");
	}

	public void selectGender(String string) {
		actions.moveToElement(genderDropdownMenu).build().perform();
		Select select = new Select(genderDropdownMenu);
		select.selectByVisibleText(string);
	}

	public void setYearFromDropDownMenu(String string) {
		Select select = new Select(setDateDropDownMenus.get(0));
		select.selectByVisibleText(string);

	}

	public void setMonthFromDropDownMenu(String string) {
		Select select = new Select(setDateDropDownMenus.get(1));
		select.selectByVisibleText(string);

	}

	public void setDayFromDropDownMenu(String string) {
		Select select = new Select(setDateDropDownMenus.get(2));
		select.selectByVisibleText(string);

	}

	public void clickOnSelectExtrasButton() {
		selectExtrasButton.click();
	}

	public void clickOnCheckBoxForFreeMessages() {
		checkBoxForFreeMessages.click();
	}

}
