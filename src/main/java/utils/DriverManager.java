package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.HashMap;
import config.ConfigurationManager;

/**
 * Singleton class for managing WebDriver instances.
 */

public class DriverManager {

	private static final ThreadLocal<WebDriver> DRIVER_POOL = new ThreadLocal<>();

	private DriverManager() {
		// Private constructor to prevent instantiation
	}

	/**
	 * Retrieves the WebDriver instance for the current thread. If the instance doesn't
	 * exist, it creates a new one based on the configured browser.
	 * @return the WebDriver instance
	 */
	public synchronized static WebDriver getDriver() {

		if (DRIVER_POOL.get() == null) {

			String browser = ConfigurationManager.getProperty("browser").toLowerCase();

			switch (browser) {
				case "chrome" -> {
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.addArguments("--start-maximized");
					chromeOptions.addArguments("--allow-running-insecure-content");
					chromeOptions.addArguments("--ignore-certificate-errors");
					// chromeOptions.setAcceptInsecureCerts(true);
					String downloadPath = System.getProperty("user.dir") + File.separator + "Downloads";
					HashMap<String, Object> chromePrefs = new HashMap<>();
					chromePrefs.put("download.default_directory", downloadPath);
					chromeOptions.setExperimentalOption("prefs", chromePrefs);
					DRIVER_POOL.set(new ChromeDriver(chromeOptions));
				}
				case "firefox" -> {
					FirefoxOptions firefoxOptions = new FirefoxOptions();
					// firefoxOptions.addArguments("--start-maximized");
					firefoxOptions.addArguments("--allow-running-insecure-content");
					firefoxOptions.addArguments("--ignore-certificate-errors");
					DRIVER_POOL.set(new FirefoxDriver());
				}
				case "edge" -> {
					EdgeOptions edgeOptions = new EdgeOptions();
					edgeOptions.addArguments("--start-maximized");
					edgeOptions.addArguments("--allow-running-insecure-content");
					edgeOptions.addArguments("--ignore-certificate-errors");
					DRIVER_POOL.set(new EdgeDriver(edgeOptions));
				}
				default -> throw new RuntimeException("Wrong browser name !");
			}
		}
		return DRIVER_POOL.get();
	}

	/**
	 * Closes the WebDriver instance and removes it from the pool.
	 */
	public static void closeDriver() {
		if (DRIVER_POOL != null) {
			DRIVER_POOL.get().quit();
			DRIVER_POOL.remove();
		}
	}

}
