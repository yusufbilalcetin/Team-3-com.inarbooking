package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

/**
 * The BasePage class serves as the base class for all page classes in the test automation
 * framework. It provides common functionality and initialization for web pages.
 */
public class BasePage {

	protected final WebDriver DRIVER = DriverManager.getDriver();

	protected Actions actions = new Actions(DRIVER);

	protected WebDriverWait wait = new WebDriverWait(DRIVER, Duration.ofSeconds(10));

	/**
	 * Constructor for the BasePage class. It initializes the page objects using
	 * PageFactory and sets the implicit wait timeout.
	 */
	public BasePage() {
		PageFactory.initElements(DRIVER, this);
		DRIVER.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}